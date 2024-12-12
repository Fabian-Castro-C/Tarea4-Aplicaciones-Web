package com.example.tarea4.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "contacto")
public class Contacto {

    // Id del contacto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del contacto
    @Column(name = "nombre", length = 80, nullable = false)
    private String nombre;

    // Email del contacto
    @Column(name = "email", length = 30, nullable = false)
    private String email;

    // Teléfono del contacto
    @Column(name = "telefono", length = 15, nullable = false)
    private String telefono;

    // Constructor por defecto
    public Contacto() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
