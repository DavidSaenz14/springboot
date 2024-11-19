package com.example.springboot.services;


import com.example.springboot.models.Jugador;
import com.example.springboot.repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public Optional<Jugador> findJugadorById(Long id) {
        return jugadorRepository.findById(id);
    }

    public List<Jugador> findAllJugadores() {
        return jugadorRepository.findAll();
    }

    public Jugador saveJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public void deleteJugadorById(Long id) {
        jugadorRepository.deleteById(id);
    }
}
