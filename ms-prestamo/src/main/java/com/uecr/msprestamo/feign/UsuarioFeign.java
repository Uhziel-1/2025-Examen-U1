package com.uecr.msprestamo.feign;

import com.uecr.msprestamo.dto.LibroDto;
import com.uecr.msprestamo.dto.UsuarioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "uecr-usuario-service", path = "/usuarios")
public interface UsuarioFeign {
    @GetMapping("/{id}")
    ResponseEntity<UsuarioDto> getLibro(@PathVariable Integer id);
}