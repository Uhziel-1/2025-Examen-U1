package com.uecr.msprestamo.service.impl;

import com.uecr.msprestamo.entity.Prestamo;
import com.uecr.msprestamo.repository.PrestamoRepository;
import com.uecr.msprestamo.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> findAll() {
        return prestamoRepository.findAll();
    }

    @Override
    public Prestamo findById(int id) {
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
