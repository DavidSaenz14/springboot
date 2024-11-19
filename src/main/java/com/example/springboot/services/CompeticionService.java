package com.example.springboot.services;


import com.example.springboot.models.Competicion;
import com.example.springboot.repositories.CompeticionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompeticionService {

    @Autowired
    private CompeticionRepository competicionRepository;

    public Optional<Competicion> findCompeticionById(Long id) {
        return competicionRepository.findById(id);
    }

    public List<Competicion> findAllCompeticiones() {
        return competicionRepository.findAll();
    }

    public Competicion saveCompeticion(Competicion competicion) {
        return competicionRepository.save(competicion);
    }

    public void deleteCompeticionById(Long id) {
        competicionRepository.deleteById(id);
    }
}

