package com.uecr.msusuario.util;

import com.uecr.msusuario.entity.Usuario;
import com.uecr.msusuario.enumerate.EstadoUsuario;
import com.uecr.msusuario.enumerate.TipoUsuario;
import com.uecr.msusuario.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UsuarioSeeder implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;

    public UsuarioSeeder(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) {
        if (usuarioRepository.count() == 0) {
            Usuario usuario1 = new Usuario(null, "Juan Pérez", "juan.perez@gmail.com", TipoUsuario.ALUMNO, EstadoUsuario.ACTIVO, "Ingeniería de Sistemas");
            Usuario usuario2 = new Usuario(null, "María López", "maria.lopez@gmail.com", TipoUsuario.ALUMNO, EstadoUsuario.ACTIVO, "Administración de Empresas");
            Usuario usuario3 = new Usuario(null, "Carlos Sánchez", "carlos.sanchez@gmail.com", TipoUsuario.DOCENTE, EstadoUsuario.ACTIVO, "Ingeniería Industrial");
            Usuario usuario4 = new Usuario(null, "Ana Torres", "ana.tarres@gmail.com", TipoUsuario.ALUMNO, EstadoUsuario.INACTIVO, "Derecho");
            Usuario usuario5 = new Usuario(null, "Luis García", "luis.garcia@gmail.com", TipoUsuario.DOCENTE, EstadoUsuario.ACTIVO, "Arquitectura");
            Usuario usuario6 = new Usuario(null, "Sofía Ramírez", "sofia.ramirez@gmail.com", TipoUsuario.ALUMNO, EstadoUsuario.ACTIVO, "Contabilidad");
            Usuario usuario7 = new Usuario(null, "Diego Fernández", "diego.fernandez@gmail.com", TipoUsuario.ALUMNO, EstadoUsuario.ACTIVO, "Medicina");
            Usuario usuario8 = new Usuario(null, "Laura Mendoza", "laura.mendoza@gmail.com", TipoUsuario.ALUMNO, EstadoUsuario.INACTIVO, "Psicología");

            usuarioRepository.save(usuario1);
            usuarioRepository.save(usuario2);
            usuarioRepository.save(usuario3);
            usuarioRepository.save(usuario4);
            usuarioRepository.save(usuario5);
            usuarioRepository.save(usuario6);
            usuarioRepository.save(usuario7);
            usuarioRepository.save(usuario8);

            System.out.println("Datos de usuarios insertados correctamente.");
        } else {
            System.out.println("Los usuarios ya existen, no se insertaron datos.");
        }
    }
}