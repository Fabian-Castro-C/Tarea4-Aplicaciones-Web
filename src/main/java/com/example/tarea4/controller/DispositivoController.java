package com.example.tarea4.controller;

import com.example.tarea4.model.Dispositivo;
import com.example.tarea4.repository.DispositivoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/dispositivos")
public class DispositivoController {

    private final DispositivoRepository dispositivoRepository;

    public DispositivoController(DispositivoRepository dispositivoRepository) {
        this.dispositivoRepository = dispositivoRepository;
    }

    // Endpoint para obtener todos los dispositivos
    @GetMapping
    public ResponseEntity<Iterable<Dispositivo>> getAllDispositivos() {
        return ResponseEntity.ok(dispositivoRepository.findAll());
    }

    // Endpoint para incrementar el me gusta de un dispositivo
    @PostMapping("/{id}/like")
    public ResponseEntity<Dispositivo> incrementarMeGusta(@PathVariable Long id) {
        Optional<Dispositivo> dispositivoOpt = dispositivoRepository.findById(id);

        if (dispositivoOpt.isPresent()) {
            Dispositivo dispositivo = dispositivoOpt.get();
            dispositivo.setContadorMegusta(dispositivo.getContadorMegusta() + 1);
            dispositivoRepository.save(dispositivo);
            return ResponseEntity.ok(dispositivo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para incrementar el no me gusta de un dispositivo
    @PostMapping("/{id}/dislike")
    public ResponseEntity<Dispositivo> incrementarNoMeGusta(@PathVariable Long id) {
        Optional<Dispositivo> dispositivoOpt = dispositivoRepository.findById(id);

        if (dispositivoOpt.isPresent()) {
            Dispositivo dispositivo = dispositivoOpt.get();
            dispositivo.setContadorNomegusta(dispositivo.getContadorNomegusta() + 1);
            dispositivoRepository.save(dispositivo);
            return ResponseEntity.ok(dispositivo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para decrementar el me gusta de un dispositivo
    @PostMapping("/{id}/unlike")
    public ResponseEntity<Dispositivo> decrementarMeGusta(@PathVariable Long id) {
        Optional<Dispositivo> dispositivoOpt = dispositivoRepository.findById(id);

        if (dispositivoOpt.isPresent()) {
            Dispositivo dispositivo = dispositivoOpt.get();
            dispositivo.setContadorMegusta(dispositivo.getContadorMegusta() - 1);
            dispositivoRepository.save(dispositivo);
            return ResponseEntity.ok(dispositivo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para decrementar el no me gusta de un dispositivo
    @PostMapping("/{id}/undislike")
    public ResponseEntity<Dispositivo> decrementarNoMeGusta(@PathVariable Long id) {
        Optional<Dispositivo> dispositivoOpt = dispositivoRepository.findById(id);

        if (dispositivoOpt.isPresent()) {
            Dispositivo dispositivo = dispositivoOpt.get();
            dispositivo.setContadorNomegusta(dispositivo.getContadorNomegusta() - 1);
            dispositivoRepository.save(dispositivo);
            return ResponseEntity.ok(dispositivo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
