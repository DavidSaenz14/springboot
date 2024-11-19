package com.example.springboot.services;


import com.example.springboot.models.Partido;
import com.example.springboot.repositories.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public Optional<Partido> findPartidoById(Long id) {
        return partidoRepository.findById(id);
    }

    public List<Partido> findAllPartidos() {
        return partidoRepository.findAll();
    }

    public Partido savePartido(Partido partido) {
        return partidoRepository.save(partido);
    }

    public void deletePartidoById(Long id) {
        partidoRepository.deleteById(id);
    }
}

