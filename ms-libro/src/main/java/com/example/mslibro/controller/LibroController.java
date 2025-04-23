package com.example.mslibro.controller;

import com.example.mslibro.entity.Libro;
import com.example.mslibro.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> findAll() {
        return ResponseEntity.ok().body(libroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(libroService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Libro> create(@RequestBody Libro libro) {
        return ResponseEntity.ok().body(libroService.save(libro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> update(@PathVariable Integer id, @RequestBody Libro libro) {
        return ResponseEntity.ok().body(libroService.save(libro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        libroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
