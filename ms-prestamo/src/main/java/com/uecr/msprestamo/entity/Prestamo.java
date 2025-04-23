package com.uecr.msprestamo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idLibro;
    @Transient
    private LibroDto libroDto;
    private Integer idUsuario;
    @Transient
    private UsuarioDto usuarioDto;
    @CreationTimestamp
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;
}
