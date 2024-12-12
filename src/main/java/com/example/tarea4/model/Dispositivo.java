package com.example.tarea4.model;

import jakarta.persistence.*;
import com.example.tarea4.model.converters.EstadoDispositivoConverter;
import com.example.tarea4.model.converters.TipoDispositivoConverter;


@Entity
@Table(name = "dispositivo")
public class Dispositivo {

    // Id del dispositivo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación con la tabla de contacto
    @ManyToOne
    @JoinColumn(name = "contacto_id", nullable = false)
    private Contacto contacto;

    // Nombre del dispositivo
    @Column(name = "nombre", length = 80, nullable = false)
    private String nombre;

    // Descripción del dispositivo
    @Column(name = "descripcion", length = 300)
    private String descripcion;

    // Tipo de dispositivo
    @Column(name = "tipo", nullable = false)
    @Convert(converter = TipoDispositivoConverter.class)
    private TipoDispositivo tipo;

    // Años de uso del dispositivo
    @Column(name = "anos_uso", nullable = false)
    private int anosUso;

    // Estado del dispositivo
    @Column(name = "estado", nullable = false)
    @Convert(converter = EstadoDispositivoConverter.class)
    private EstadoDispositivo estado;

    // Contador de me gusta del dispositivo
    @Column(name = "contador_megusta")
    private int contadorMegusta;

    // Contador de no me gusta del dispositivo
    @Column(name = "contador_nomegusta")
    private int contadorNomegusta;

    // Constructor por defecto
    public Dispositivo() {
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoDispositivo getTipo() {
        return tipo;
    }

    public void setTipo(TipoDispositivo tipo) {
        this.tipo = tipo;
    }

    public int getAnosUso() {
        return anosUso;
    }

    public void setAnosUso(int anosUso) {
        this.anosUso = anosUso;
    }

    public EstadoDispositivo getEstado() {
        return estado;
    }

    public void setEstado(EstadoDispositivo estado) {
        this.estado = estado;
    }

    public int getContadorMegusta() {
        return contadorMegusta;
    }

    public void setContadorMegusta(int contadorMegusta) {
        this.contadorMegusta = contadorMegusta;
    }

    public int getContadorNomegusta() {
        return contadorNomegusta;
    }

    public void setContadorNomegusta(int contadorNomegusta) {
        this.contadorNomegusta = contadorNomegusta;
    }
}
