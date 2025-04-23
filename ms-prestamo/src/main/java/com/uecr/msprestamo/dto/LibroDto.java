package com.uecr.msprestamo.dto;

import lombok.Data;

@Data
public class LibroDto {
    private Integer id;
    private String titulo;
    private String autor;
    private String editorial;
    private String isbn;
    private Integer copiasDisponibles;
    private String categoria;
}
