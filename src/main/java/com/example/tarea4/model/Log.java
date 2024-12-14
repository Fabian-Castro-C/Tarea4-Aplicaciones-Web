package com.example.tarea4.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log")
public class Log {

    // Id del log
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Fecha del log
    @Column(name = "fecha", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha;

    // Mensaje del log
    @Column(name = "mensaje", nullable = false, length = 300)
    private String mensaje;

    // Constructor por defecto
    public Log() {
    }

    // Constructor con mensaje
    public Log(String mensaje) {
        this.mensaje = mensaje;
        this.fecha = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}