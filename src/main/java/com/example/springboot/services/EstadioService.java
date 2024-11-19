package com.example.springboot.services;


import com.example.springboot.models.Estadio;
import com.example.springboot.repositories.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadioService {

    @Autowired
    private EstadioRepository estadioRepository;

    public Optional<Estadio> findEstadioById(Long id) {
        return estadioRepository.findById(id);
    }

    public List<Estadio> findAllEstadios() {
        return estadioRepository.findAll();
    }

    public Estadio saveEstadio(Estadio estadio) {
        return estadioRepository.save(estadio);
    }

    public void deleteEstadioById(Long id) {
        estadioRepository.deleteById(id);
    }
}

