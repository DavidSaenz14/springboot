package com.example.springboot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "competiciones")
public class Competicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "temporada")
    private int temporada;

    // Relación con equipos
    @OneToMany(mappedBy = "competicion", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("competicion") // Evitamos ciclos
    private List<Equipo> equipos = new ArrayList<>();

    // Relación con partidos
    @OneToMany(mappedBy = "competicion", cascade = CascadeType.ALL)
    @JsonIgnore // Evitamos ciclos con los partidos
    private List<Partido> partidos = new ArrayList<>();

    public Competicion() {}

    public Competicion(String nombre, String tipo, String pais, int temporada) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.pais = pais;
        this.temporada = temporada;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public int getTemporada() { return temporada; }
    public void setTemporada(int temporada) { this.temporada = temporada; }

    public List<Equipo> getEquipos() { return equipos; }
    public void setEquipos(List<Equipo> equipos) { this.equipos = equipos; }

    public List<Partido> getPartidos() { return partidos; }
    public void setPartidos(List<Partido> partidos) { this.partidos = partidos; }

    // 👇 Getter transitorio para Angular: lista solo con nombres de equipos
    @Transient
    public List<String> getNombresEquipos() {
        return equipos.stream().map(Equipo::getNombre).toList();
    }
}
