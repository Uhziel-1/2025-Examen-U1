package com.uecr.mslibro.repository;

import com.uecr.mslibro.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
