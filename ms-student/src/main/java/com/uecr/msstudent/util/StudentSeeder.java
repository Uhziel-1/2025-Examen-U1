package com.uecr.msstudent.util;

import com.uecr.msstudent.entity.Student;
import com.uecr.msstudent.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentSeeder implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public StudentSeeder(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) {
        if (studentRepository.count() == 0) {
            Student student1 = new Student(null, "Juan Pérez", "Ingeniería de Sistemas", "12345678A", "activo", "2024-I");
            Student student2 = new Student(null, "María López", "Arquitectura", "98765432B", "activo", "2023-II");
            Student student3 = new Student(null, "Carlos Gómez", "Derecho", "11223344C", "inactivo", "2025-I");
            // Agrega más estudiantes iniciales si lo deseas

            studentRepository.save(student1);
            studentRepository.save(student2);
            studentRepository.save(student3);

            System.out.println("Datos de estudiantes insertados correctamente.");
        } else {
            System.out.println("Los estudiantes ya existen, no se insertaron datos.");
        }
    }
}