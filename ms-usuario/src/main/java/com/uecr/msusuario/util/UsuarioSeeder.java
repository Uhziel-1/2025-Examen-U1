package com.uecr.msusuario.util;

import com.uecr.msusuario.entity.Usuario;
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
            Usuario usuario1 = new Usuario(null, "Juan Pérez", "Alumno", "Activo", "Ingeniería de Sistemas");
            Usuario usuario2 = new Usuario(null, "María López", "Alumno", "Activo", "Administración de Empresas");
            Usuario usuario3 = new Usuario(null, "Carlos Sánchez", "Docente", "Activo", "Ingeniería Industrial");
            Usuario usuario4 = new Usuario(null, "Ana Torres", "Alumno", "Inactivo", "Derecho");
            Usuario usuario5 = new Usuario(null, "Luis García", "Docente", "Activo", "Arquitectura");
            Usuario usuario6 = new Usuario(null, "Sofía Ramírez", "Alumno", "Activo", "Contabilidad");
            Usuario usuario7 = new Usuario(null, "Diego Fernández", "Alumno", "Activo", "Medicina");
            Usuario usuario8 = new Usuario(null, "Laura Mendoza", "Alumno", "Inactivo", "Psicología");

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