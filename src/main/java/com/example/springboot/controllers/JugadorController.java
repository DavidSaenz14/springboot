package com.example.springboot.controllers;


import com.example.springboot.models.Jugador;
import com.example.springboot.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jugadores")
@CrossOrigin("*")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping("/{id}")
    public Optional<Jugador> getJugador(@PathVariable Long id) {
        return jugadorService.findJugadorById(id);
    }

    @GetMapping
    public List<Jugador> getAllJugadores() {
        return jugadorService.findAllJugadores();
    }

    @PostMapping
    public Jugador createJugador(@RequestBody Jugador jugador) {
        return jugadorService.saveJugador(jugador);
    }

    @PutMapping("/{id}")
    public Jugador updateJugador(@PathVariable Long id, @RequestBody Jugador jugador) {
        jugador.setId(id);
        return jugadorService.saveJugador(jugador);
    }

    @DeleteMapping("/{id}")
    public void deleteJugador(@PathVariable Long id) {
        jugadorService.deleteJugadorById(id);
    }
}

