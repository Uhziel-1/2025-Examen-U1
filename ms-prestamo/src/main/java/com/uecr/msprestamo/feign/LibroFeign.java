package com.uecr.msprestamo.feign;

import com.uecr.msprestamo.dto.LibroDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "uecr-libro-service", path = "/libros")
public interface LibroFeign {
    @GetMapping("/{id}")
    ResponseEntity<LibroDto> getLibro(@PathVariable Integer id);
}
