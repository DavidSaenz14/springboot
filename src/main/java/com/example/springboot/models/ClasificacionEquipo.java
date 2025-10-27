package com.example.springboot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "clasificacion_equipos")
public class ClasificacionEquipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Equipo en lugar de usar Long idEquipo
    @ManyToOne
    @JoinColumn(name = "id_equipo")
    @JsonIgnore   // 👈 Ocultamos el objeto completo en el JSON
    private Equipo equipo;

    @Column(name = "posicion")
    private int posicion;

    @Column(name = "puntos")
    private int puntos;

    @Column(name = "partidos_jugados")
    private int partidosJugados;

    @Column(name = "partidos_ganados")
    private int partidosGanados;

    @Column(name = "partidos_empatados")
    private int partidosEmpatados;

    @Column(name = "partidos_perdidos")
    private int partidosPerdidos;

    @Column(name = "goles_a_favor")
    private int golesAFavor;

    @Column(name = "goles_en_contra")
    private int golesEnContra;

    // Constructor vacío necesario para JPA
    public ClasificacionEquipo() {
    }

    // Constructor con todos los campos (ahora recibe un Equipo en lugar de idEquipo)
    public ClasificacionEquipo(Equipo equipo, int posicion, int puntos, int partidosJugados, int partidosGanados,
                               int partidosEmpatados, int partidosPerdidos, int golesAFavor, int golesEnContra) {
        this.equipo = equipo;
        this.posicion = posicion;
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
        this.partidosGanados = partidosGanados;
        this.partidosEmpatados = partidosEmpatados;
        this.partidosPerdidos = partidosPerdidos;
        this.golesAFavor = golesAFavor;
        this.golesEnContra = golesEnContra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }

    public void setGolesAFavor(int golesAFavor) {
        this.golesAFavor = golesAFavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }

    public void setGolesEnContra(int golesEnContra) {
        this.golesEnContra = golesEnContra;
    }

    // 👇 Getter adicional para mostrar solo el nombre del equipo en el JSON
    @Transient
    public String getNombreEquipo() {
        return (equipo != null) ? equipo.getNombre() : null;
    }
}
