package com.uecr.mslibro.util;

import com.uecr.mslibro.entity.Libro;
import com.uecr.mslibro.repository.LibroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LibroSeeder implements CommandLineRunner {

    private final LibroRepository libroRepository;

    public LibroSeeder(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public void run(String... args) {
        if (libroRepository.count() == 0) {
            Libro libro1 = new Libro(null, "Cien años de soledad", "Gabriel García Márquez", "Editorial Sudamericana", "978-0307474728", 5, "Novela");
            Libro libro2 = new Libro(null, "1984", "George Orwell", "Secker & Warburg", "978-0451524935", 3, "Ciencia Ficción");
            Libro libro3 = new Libro(null, "El Principito", "Antoine de Saint-Exupéry", "Reynal & Hitchcock", "978-0156012195", 7, "Literatura Infantil");
            Libro libro4 = new Libro(null, "Orgullo y prejuicio", "Jane Austen", "T. Egerton", "978-0141439518", 4, "Romance");
            Libro libro5 = new Libro(null, "Don Quijote de la Mancha", "Miguel de Cervantes", "Francisco de Robles", "978-0060934347", 6, "Clásico");
            Libro libro6 = new Libro(null, "Los juegos del hambre", "Suzanne Collins", "Scholastic Press", "978-0439023481", 10, "Distopía");
            Libro libro7 = new Libro(null, "Harry Potter y la piedra filosofal", "J.K. Rowling", "Bloomsbury", "978-0747532699", 8, "Fantasía");
            Libro libro8 = new Libro(null, "Crónica de una muerte anunciada", "Gabriel García Márquez", "Editorial Oveja Negra", "978-0307387141", 2, "Novela Corta");

            libroRepository.save(libro1);
            libroRepository.save(libro2);
            libroRepository.save(libro3);
            libroRepository.save(libro4);
            libroRepository.save(libro5);
            libroRepository.save(libro6);
            libroRepository.save(libro7);
            libroRepository.save(libro8);

            System.out.println("Datos de libros insertados correctamente.");
        } else {
            System.out.println("Los libros ya existen, no se insertaron datos.");
        }
    }
}