package com.uecr.msprestamo.controller;

import com.uecr.msprestamo.entity.Prestamo;
import com.uecr.msprestamo.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public ResponseEntity<List<Prestamo>> findAll() {
        return ResponseEntity.ok().body(prestamoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(prestamoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Prestamo> create(@RequestBody Prestamo prestamo) {
        return ResponseEntity.ok().body(prestamoService.save(prestamo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> update(@PathVariable Integer id, @RequestBody Prestamo prestamo) {
        return ResponseEntity.ok().body(prestamoService.save(prestamo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        prestamoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
