package com.example.springboot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "partidos")
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipo_local_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jugadores"})
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visitante_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jugadores"})
    private Equipo equipoVisitante;

    @Column(name = "goles_local")
    private int golesLocal;

    @Column(name = "goles_visitante")
    private int golesVisitante;

    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    @ManyToOne
    @JoinColumn(name = "estadio_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "partidos"})
    private Estadio estadio;

    @ManyToOne
    @JoinColumn(name = "arbitro_principal_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "partidos"})
    private Arbitro arbitroPrincipal;

    @ManyToOne
    @JoinColumn(name = "competicion_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "equipos"})
    private Competicion competicion;

    public Partido() {}

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Equipo getEquipoLocal() { return equipoLocal; }
    public void setEquipoLocal(Equipo equipoLocal) { this.equipoLocal = equipoLocal; }

    public Equipo getEquipoVisitante() { return equipoVisitante; }
    public void setEquipoVisitante(Equipo equipoVisitante) { this.equipoVisitante = equipoVisitante; }

    public int getGolesLocal() { return golesLocal; }
    public void setGolesLocal(int golesLocal) { this.golesLocal = golesLocal; }

    public int getGolesVisitante() { return golesVisitante; }
    public void setGolesVisitante(int golesVisitante) { this.golesVisitante = golesVisitante; }

    public Date getFechaHora() { return fechaHora; }
    public void setFechaHora(Date fechaHora) { this.fechaHora = fechaHora; }

    public Estadio getEstadio() { return estadio; }
    public void setEstadio(Estadio estadio) { this.estadio = estadio; }

    public Arbitro getArbitroPrincipal() { return arbitroPrincipal; }
    public void setArbitroPrincipal(Arbitro arbitroPrincipal) { this.arbitroPrincipal = arbitroPrincipal; }

    public Competicion getCompeticion() { return competicion; }
    public void setCompeticion(Competicion competicion) { this.competicion = competicion; }

    // Getters para nombres que se incluirán en JSON
    @JsonProperty("nombreEquipoLocal")
    public String getNombreEquipoLocal() {
        return (equipoLocal != null) ? equipoLocal.getNombre() : "Sin equipo";
    }

    @JsonProperty("nombreEquipoVisitante")
    public String getNombreEquipoVisitante() {
        return (equipoVisitante != null) ? equipoVisitante.getNombre() : "Sin equipo";
    }

    @JsonProperty("nombreEstadio")
    public String getNombreEstadio() {
        return (estadio != null) ? estadio.getNombre() : "Sin estadio";
    }

    @JsonProperty("nombreArbitro")
    public String getNombreArbitro() {
        return (arbitroPrincipal != null) ? arbitroPrincipal.getNombre() : "Sin árbitro";
    }

    @JsonProperty("nombreCompeticion")
    public String getNombreCompeticion() {
        return (competicion != null) ? competicion.getNombre() : "Sin competición";
    }
}
