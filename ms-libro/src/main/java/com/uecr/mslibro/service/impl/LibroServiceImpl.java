package com.uecr.mslibro.service.impl;

import com.uecr.mslibro.entity.Libro;
import com.uecr.mslibro.repository.LibroRepository;
import com.uecr.mslibro.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public Libro findById(int id) {
        return libroRepository.findById(id).get();
    }

    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro update(int id, Libro libro) {
        Libro existente = libroRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Libro no encontrado" + id));
        return libroRepository.save(libro);
    }

    @Override
    public void delete(int id) {
        libroRepository.deleteById(id);
    }
}
