package com.example.springboot.models;


import jakarta.persistence.*;

@Entity
@Table(name = "arbitros")
public class Arbitro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "experiencia")
    private int experiencia;

    // Constructor vacío necesario para JPA
    public Arbitro() {
    }

    // Constructor con todos los campos
    public Arbitro(String nombre, String nacionalidad, String categoria, int experiencia) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.categoria = categoria;
        this.experiencia = experiencia;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    // Getters y setters
}

