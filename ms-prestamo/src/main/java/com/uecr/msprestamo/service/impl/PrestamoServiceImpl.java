package com.uecr.msprestamo.service.impl;

import com.uecr.msprestamo.entity.Prestamo;
import com.uecr.msprestamo.feign.LibroFeign;
import com.uecr.msprestamo.feign.UsuarioFeign;
import com.uecr.msprestamo.repository.PrestamoRepository;
import com.uecr.msprestamo.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {

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

        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo update(int id, Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public void delete(int id) {
        prestamoRepository.deleteById(id);
    }
}
