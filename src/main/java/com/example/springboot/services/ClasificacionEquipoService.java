package com.example.springboot.services;


import com.example.springboot.models.ClasificacionEquipo;
import com.example.springboot.repositories.ClasificacionEquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasificacionEquipoService {

    @Autowired
    private ClasificacionEquipoRepository clasificacionEquipoRepository;

    public Optional<ClasificacionEquipo> findClasificacionEquipoById(Long id) {
        return clasificacionEquipoRepository.findById(id);
    }

    public List<ClasificacionEquipo> findAllClasificacionesEquipos() {
        return clasificacionEquipoRepository.findAll();
    }

    public ClasificacionEquipo saveClasificacionEquipo(ClasificacionEquipo clasificacionEquipo) {
        return clasificacionEquipoRepository.save(clasificacionEquipo);
    }

    public void deleteClasificacionEquipoById(Long id) {
        clasificacionEquipoRepository.deleteById(id);
    }
}

