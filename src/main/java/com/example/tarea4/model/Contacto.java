package com.example.tarea4.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contacto")
public class Contacto {

    // Id del contacto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Nombre del contacto
    @Column(name = "nombre", length = 80, nullable = false)
    private String nombre;

    // Email del contacto
    @Column(name = "email", length = 30, nullable = false)
    private String email;

    // Teléfono del contacto
    @Column(name = "telefono", length = 15, nullable = false)
    private String telefono;

    // Fecha de creación
    @Column(name = "fecha_creacion", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreacion;

    // Constructor por defecto
    public Contacto() {
    }

    // Constructor para inicializar fecha de creación
    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}