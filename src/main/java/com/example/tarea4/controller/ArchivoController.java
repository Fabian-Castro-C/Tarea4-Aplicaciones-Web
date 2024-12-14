package com.example.tarea4.controller;

import com.example.tarea4.model.Archivo;
import com.example.tarea4.repository.ArchivoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tarea4.dto.ArchivoDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/archivos")
public class ArchivoController {

    private final ArchivoRepository archivoRepository;

    public ArchivoController(ArchivoRepository archivoRepository) {
        this.archivoRepository = archivoRepository;
    }

    // Obtener todas las imágenes ordenadas por fecha de creación del contacto
    @GetMapping
    public ResponseEntity<List<ArchivoDTO>> obtenerArchivosOrdenadosPorContacto() {
        List<Archivo> archivos = archivoRepository.findAll();

        // Ordenar los archivos por fecha de creación del contacto
        List<ArchivoDTO> respuesta = archivos.stream()
                .sorted((a1, a2) -> a2.getDispositivo()
                        .getContacto()
                        .getFechaCreacion()
                        .compareTo(a1.getDispositivo().getContacto().getFechaCreacion()))
                .map(archivo -> new ArchivoDTO(
                        archivo.getId(),
                        archivo.getRutaArchivo(),
                        archivo.getDispositivo().getNombre(),
                        archivo.getDispositivo().getContacto().getEmail()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(respuesta);
    }
}