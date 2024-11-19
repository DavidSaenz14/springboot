package com.example.springboot.models;


import jakarta.persistence.*;

@Entity
@Table(name = "competiciones")
public class Competicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "pais")
    private String pais;

    @Column(name = "temporada")
    private int temporada;

    // Constructor vacío necesario para JPA
    public Competicion() {
    }

    // Constructor con todos los campos
    public Competicion(String nombre, String tipo, String pais, int temporada) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.pais = pais;
        this.temporada = temporada;
    }

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }
    // Getters y setters
}
