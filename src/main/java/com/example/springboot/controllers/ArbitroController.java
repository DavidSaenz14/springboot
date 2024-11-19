package com.example.springboot.controllers;


import com.example.springboot.models.Arbitro;
import com.example.springboot.services.ArbitroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/arbitros")
@CrossOrigin("*")
public class ArbitroController {

    @Autowired
    private ArbitroService arbitroService;

    @GetMapping("/{id}")
    public Optional<Arbitro> getArbitro(@PathVariable Long id) {
        return arbitroService.findArbitroById(id);
    }

    @GetMapping
    public List<Arbitro> getAllArbitros() {
        return arbitroService.findAllArbitros();
    }

    @PostMapping
    public Arbitro createArbitro(@RequestBody Arbitro arbitro) {
        return arbitroService.saveArbitro(arbitro);
    }

    @PutMapping("/{id}")
    public Arbitro updateArbitro(@PathVariable Long id, @RequestBody Arbitro arbitro) {
        arbitro.setId(id);
        return arbitroService.saveArbitro(arbitro);
    }

    @DeleteMapping("/{id}")
    public void deleteArbitro(@PathVariable Long id) {
        arbitroService.deleteArbitroById(id);
    }
}

