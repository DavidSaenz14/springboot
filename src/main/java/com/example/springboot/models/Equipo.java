package com.example.springboot.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "liga")
    private String liga;

    @Column(name = "entrenador")
    private String entrenador;

    @Column(name = "fundacion_year")
    private int fundacionYear;

    @Column(name = "estadio")
    private String estadio;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<Jugador> jugadores;

    // Constructor vacío necesario para JPA
    public Equipo() {
        this.jugadores = new ArrayList<>();
    }

    // Constructor con todos los campos
    public Equipo(String nombre, String liga, String entrenador, int fundacionYear, String estadio) {
        this.nombre = nombre;
        this.liga = liga;
        this.entrenador = entrenador;
        this.fundacionYear = fundacionYear;
        this.estadio = estadio;
        this.jugadores = new ArrayList<>();
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

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public int getFundacionYear() {
        return fundacionYear;
    }

    public void setFundacionYear(int fundacionYear) {
        this.fundacionYear = fundacionYear;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    // Getters y setters
}

