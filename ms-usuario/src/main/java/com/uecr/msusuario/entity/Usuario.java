package com.uecr.msusuario.entity;

import com.uecr.msusuario.enumerate.EstadoUsuario;
import com.uecr.msusuario.enumerate.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;
    @Enumerated(EnumType.STRING)
    private EstadoUsuario estado;
    private String carrera;
}
