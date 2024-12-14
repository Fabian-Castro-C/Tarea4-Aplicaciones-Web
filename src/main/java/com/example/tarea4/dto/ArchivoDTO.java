package com.example.tarea4.dto;

public class ArchivoDTO {

    private Long id; // ID del archivo
    private String rutaArchivo;
    private String nombreDispositivo;
    private String emailContacto;

    // Constructor
    public ArchivoDTO(Long id, String rutaArchivo, String nombreDispositivo, String emailContacto) {
        this.id = id;
        this.rutaArchivo = rutaArchivo;
        this.nombreDispositivo = nombreDispositivo;
        this.emailContacto = emailContacto;
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

    public String getNombreDispositivo() {
        return nombreDispositivo;
    }

    public void setNombreDispositivo(String nombreDispositivo) {
        this.nombreDispositivo = nombreDispositivo;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }
}