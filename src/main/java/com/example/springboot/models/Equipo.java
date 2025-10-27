package com.example.springboot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;


    @Column(name = "entrenador")
    private String entrenador;

    @Column(name = "fundacion_year")
    private int fundacionYear;

    @Column(name = "estadio")
    private String estadio;

    // Relación con jugadores
    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("equipo") // 👈 permite serializar equipo dentro de jugador
    private List<Jugador> jugadores;

    // Relación con competicion
    @ManyToOne
    @JoinColumn(name = "competicion_id")
    private Competicion competicion;

    // Constructores
    public Equipo() { this.jugadores = new ArrayList<>(); }

    public Equipo(String nombre, String liga, String entrenador, int fundacionYear, String estadio) {
        this.nombre = nombre;

        this.entrenador = entrenador;
        this.fundacionYear = fundacionYear;
        this.estadio = estadio;
        this.jugadores = new ArrayList<>();
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }



    public String getEntrenador() { return entrenador; }
    public void setEntrenador(String entrenador) { this.entrenador = entrenador; }

    public int getFundacionYear() { return fundacionYear; }
    public void setFundacionYear(int fundacionYear) { this.fundacionYear = fundacionYear; }

    public String getEstadio() { return estadio; }
    public void setEstadio(String estadio) { this.estadio = estadio; }

    public List<Jugador> getJugadores() { return jugadores; }
    public void setJugadores(List<Jugador> jugadores) { this.jugadores = jugadores; }

    public Competicion getCompeticion() { return competicion; }
    public void setCompeticion(Competicion competicion) { this.competicion = competicion; }

    @Transient
    public String getNombreCompeticion() {
        return (competicion != null) ? competicion.getNombre() : null;
    }
}
