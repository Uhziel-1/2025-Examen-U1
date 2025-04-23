package com.uecr.msprestamo.repository;

import com.uecr.msprestamo.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
}
