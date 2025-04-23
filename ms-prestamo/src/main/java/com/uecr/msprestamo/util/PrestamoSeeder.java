package com.uecr.msprestamo.util;

import com.uecr.msprestamo.entity.Prestamo;
import com.uecr.msprestamo.repository.PrestamoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PrestamoSeeder implements CommandLineRunner {

    private final PrestamoRepository prestamoRepository;

    public PrestamoSeeder(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @Override
    public void run(String... args) {
        if (prestamoRepository.count() == 0) {
            Prestamo prestamo1 = new Prestamo(null, 1, 1, null, LocalDateTime.now().plusDays(15));
            Prestamo prestamo2 = new Prestamo(null, 2, 2, null, LocalDateTime.now().plusDays(10));
            Prestamo prestamo3 = new Prestamo(null, 3, 3, null, LocalDateTime.now().plusDays(7));
            Prestamo prestamo4 = new Prestamo(null, 4, 4, null, LocalDateTime.now().plusDays(20));
            Prestamo prestamo5 = new Prestamo(null, 5, 5, null, LocalDateTime.now().plusDays(14));
            Prestamo prestamo6 = new Prestamo(null, 6, 6, null, LocalDateTime.now().plusDays(12));
            Prestamo prestamo7 = new Prestamo(null, 7, 7, null, LocalDateTime.now().plusDays(9));
            Prestamo prestamo8 = new Prestamo(null, 8, 8, null, LocalDateTime.now().plusDays(18));

            prestamoRepository.save(prestamo1);
            prestamoRepository.save(prestamo2);
            prestamoRepository.save(prestamo3);
            prestamoRepository.save(prestamo4);
            prestamoRepository.save(prestamo5);
            prestamoRepository.save(prestamo6);
            prestamoRepository.save(prestamo7);
            prestamoRepository.save(prestamo8);

            System.out.println("Datos de préstamos insertados correctamente.");
        } else {
            System.out.println("Los préstamos ya existen, no se insertaron datos.");
        }
    }
}