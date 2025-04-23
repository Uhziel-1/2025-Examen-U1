package com.example.mslibro.service;

import com.example.mslibro.entity.Libro;

import java.util.List;

public interface LibroService {
    List<Libro> findAll();
    Libro findById(int id);
    Libro save(Libro libro);
    Libro update(int id,Libro libro);
    void delete(int id);
}
