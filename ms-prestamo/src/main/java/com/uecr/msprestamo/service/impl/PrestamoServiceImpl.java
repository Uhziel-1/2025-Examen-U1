package com.uecr.msprestamo.service.impl;

import com.uecr.msprestamo.dto.LibroDto;
import com.uecr.msprestamo.entity.Prestamo;
import com.uecr.msprestamo.feign.LibroFeign;
import com.uecr.msprestamo.feign.UsuarioFeign;
import com.uecr.msprestamo.repository.PrestamoRepository;
import com.uecr.msprestamo.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    int cantidadPrestamos = 2;

    @Autowired
    private PrestamoRepository prestamoRepository;
    @Autowired
    private LibroFeign libroFeign;
    @Autowired
    private UsuarioFeign usuarioFeign;

    @Override
    public List<Prestamo> findAll() {
        return prestamoRepository.findAll();
    }

    @Override
    public Prestamo findById(int id) {
        Prestamo prestamo = prestamoRepository.findById(id).get();
        prestamo.setLibroDto(libroFeign.getLibro(prestamo.getIdLibro()).getBody());
        prestamo.setUsuarioDto(usuarioFeign.getUsuario(prestamo.getIdUsuario()).getBody());
        return prestamoRepository.findById(id).get();
    }

    @Override
    public Prestamo save(Prestamo prestamo) {
        prestamo.setLibroDto(libroFeign.getLibro(prestamo.getIdLibro()).getBody());
        prestamo.setUsuarioDto(usuarioFeign.getUsuario(prestamo.getIdUsuario()).getBody());

        if (prestamo.getLibroDto().getCopiasDisponibles() <= 0) {
            System.out.println("No hay copias disponibles para el libro: " + prestamo.getLibroDto().getTitulo());
            throw new IllegalStateException("No hay copias disponibles para el préstamo.");
        }
        if (!"ACTIVO".equalsIgnoreCase(prestamo.getUsuarioDto().getEstado())) {
            System.out.println("El usuario no está activo: " + prestamo.getUsuarioDto().getNombre());
            throw new IllegalStateException("El usuario no está habilitado para realizar préstamos.");
        }
        if (prestamoRepository.countByUsuarioId(prestamo.getIdUsuario()) >= cantidadPrestamos) {
            System.out.println("El usuario no puede pedir un prestamo, ya tiene: "
                    + prestamoRepository.countByUsuarioId(prestamo.getIdUsuario()) + " prestamos.");
            throw new IllegalStateException("El usuario no puede pedir un prestamo.");
        }
        LibroDto libroDto = prestamo.getLibroDto();
        libroDto.setCopiasDisponibles(libroDto.getCopiasDisponibles() - 1);
        libroFeign.updateLibro(prestamo.getIdLibro(), libroDto);
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo update(int id, Prestamo prestamo) {
        Prestamo existente = prestamoRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Prestamo no encontrado" + id));
        return prestamoRepository.save(prestamo);
    }

    @Override
    public void delete(int id) {
        prestamoRepository.deleteById(id);
    }
}
