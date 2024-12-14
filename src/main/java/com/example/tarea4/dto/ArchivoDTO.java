package com.example.tarea4.dto;

public class ArchivoDTO {

    private String rutaArchivo;
    private String nombreDispositivo;
    private String emailContacto;

    // Constructor
    public ArchivoDTO(String rutaArchivo, String nombreDispositivo, String emailContacto) {
        this.rutaArchivo = rutaArchivo;
        this.nombreDispositivo = nombreDispositivo;
        this.emailContacto = emailContacto;
    }

    // Getters y Setters
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