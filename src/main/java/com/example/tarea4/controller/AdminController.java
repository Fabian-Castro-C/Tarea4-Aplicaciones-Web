package com.example.tarea4.controller;

import com.example.tarea4.model.Archivo;
import com.example.tarea4.repository.ArchivoRepository;
import com.example.tarea4.repository.LogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final ArchivoRepository archivoRepository;
    private final LogRepository logRepository;

    public AdminController(ArchivoRepository archivoRepository, LogRepository logRepository) {
        this.archivoRepository = archivoRepository;
        this.logRepository = logRepository;
    }

    // Endpoint para listar todas las imágenes protegidas
    @GetMapping("/imagenes")
    public ResponseEntity<?> obtenerImagenesAdmin() {
        return ResponseEntity.ok(archivoRepository.findAll());
    }

    // Endpoint para eliminar una imagen
    @DeleteMapping("/imagenes/{id}")
    public ResponseEntity<?> eliminarImagen(@PathVariable Long id, @RequestParam String motivo) {
        // Validar el motivo para evitar caracteres peligrosos
        if (motivo.length() > 200) {
            return ResponseEntity.badRequest().body("El motivo excede el límite de 200 caracteres.");
        }

        String motivoLimpio = motivo.replaceAll("<", "&lt;").replaceAll(">", "&gt;"); // Escapar HTML

        return archivoRepository.findById(id).map(archivo -> {
            // Eliminar el archivo
            archivoRepository.deleteById(id);

            // Registrar en el log
            String mensaje = "Eliminado archivo " + id + " por usuario admin. Motivo: " + motivoLimpio;
            logRepository.save(new com.example.tarea4.model.Log(mensaje));

            return ResponseEntity.ok("Imagen eliminada con éxito");
        }).orElse(ResponseEntity.notFound().build());
    }
}