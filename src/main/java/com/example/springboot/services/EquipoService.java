package com.example.springboot.services;


import com.example.springboot.models.Equipo;
import com.example.springboot.repositories.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public Optional<Equipo> findEquipoById(Long id) {
        return equipoRepository.findById(id);
    }

    public List<Equipo> findAllEquipos() {
        return equipoRepository.findAll();
    }

    public Equipo saveEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public void deleteEquipoById(Long id) {
        equipoRepository.deleteById(id);
    }
}
