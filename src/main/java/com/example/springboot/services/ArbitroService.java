package com.example.springboot.services;


import com.example.springboot.models.Arbitro;
import com.example.springboot.repositories.ArbitroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArbitroService {

    @Autowired
    private ArbitroRepository arbitroRepository;

    public Optional<Arbitro> findArbitroById(Long id) {
        return arbitroRepository.findById(id);
    }

    public List<Arbitro> findAllArbitros() {
        return arbitroRepository.findAll();
    }

    public Arbitro saveArbitro(Arbitro arbitro) {
        return arbitroRepository.save(arbitro);
    }

    public void deleteArbitroById(Long id) {
        arbitroRepository.deleteById(id);
    }
}
