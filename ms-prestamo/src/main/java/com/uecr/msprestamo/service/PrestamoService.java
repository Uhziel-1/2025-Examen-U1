package com.uecr.msprestamo.service;

import com.uecr.msprestamo.entity.Prestamo;

import java.util.List;

public interface PrestamoService {
    List<Prestamo> findAll();
    Prestamo findById(int id);
    Prestamo save(Prestamo prestamo);
    Prestamo update(int id,Prestamo prestamo);
    void delete(int id);
}
