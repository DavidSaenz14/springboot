package com.example.springboot.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "jugadores")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "posicion")
    private String posicion;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @Column(name = "altura")
    private int altura;

    @Column(name = "peso")
    private int peso;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    @JsonIgnore
    private Equipo equipo;

    // Constructor vacío necesario para JPA
    public Jugador() {
    }

    // Constructor con todos los campos excepto el equipo
    public Jugador(String nombre, int edad, String posicion, String nacionalidad, int altura, int peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.nacionalidad = nacionalidad;
        this.altura = altura;
        this.peso = peso;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    // Getters y setters
}

