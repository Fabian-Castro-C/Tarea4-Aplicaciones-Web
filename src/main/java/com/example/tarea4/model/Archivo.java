package com.example.tarea4.model;

import jakarta.persistence.*;

@Entity
@Table(name = "archivo")
public class Archivo {

    // Id del archivo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ruta del archivo
    @Column(name = "ruta_archivo", nullable = false, length = 255)
    private String rutaArchivo;

    // Nombre del archivo
    @Column(name = "nombre_archivo", nullable = false, length = 100)
    private String nombreArchivo;

    // Relación con la tabla dispositivo
    @ManyToOne
    @JoinColumn(name = "dispositivo_id", nullable = false)
    private Dispositivo dispositivo;

    // Constructor por defecto
    public Archivo() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
}