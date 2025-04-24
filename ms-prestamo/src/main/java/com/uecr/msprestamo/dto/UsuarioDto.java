package com.uecr.msprestamo.dto;

import lombok.Data;

@Data
public class UsuarioDto {
    private Integer id;
    private String nombre;
    private String email;
    private String tipo;
    private String estado;
    private String carrera;
}
