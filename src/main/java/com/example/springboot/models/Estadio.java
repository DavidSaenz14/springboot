package com.example.springboot.models;


import jakarta.persistence.*;

@Entity
@Table(name = "estadios")
public class Estadio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "capacidad")
    private int capacidad;

    @Column(name = "direccion")
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    // Constructor vacío necesario para JPA
    public Estadio() {
    }

    // Constructor con todos los campos

    public Estadio(Long id, String nombre, String ciudad, int capacidad, String direccion, Equipo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.direccion = direccion;
        this.equipo = equipo;
    }


    // Getters y setters

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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}

