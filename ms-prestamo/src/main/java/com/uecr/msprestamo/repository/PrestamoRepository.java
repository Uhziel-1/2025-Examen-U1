package com.uecr.msprestamo.repository;

import com.uecr.msprestamo.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
    @Query("SELECT COUNT(p) FROM Prestamo p WHERE p.idUsuario = :usuarioId")
    Integer countByUsuarioId(@Param("usuarioId") Integer usuarioId);
}
