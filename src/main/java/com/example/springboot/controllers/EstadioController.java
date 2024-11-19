package com.example.springboot.controllers;


import com.example.springboot.models.Estadio;
import com.example.springboot.services.EstadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estadios")
@CrossOrigin("*")
public class EstadioController {

    @Autowired
    private EstadioService estadioService;

    @GetMapping("/{id}")
    public Optional<Estadio> getEstadio(@PathVariable Long id) {
        return estadioService.findEstadioById(id);
    }

    @GetMapping
    public List<Estadio> getAllEstadios() {
        return estadioService.findAllEstadios();
    }

    @PostMapping
    public Estadio createEstadio(@RequestBody Estadio estadio) {
        return estadioService.saveEstadio(estadio);
    }

    @PutMapping("/{id}")
    public Estadio updateEstadio(@PathVariable Long id, @RequestBody Estadio estadio) {
        estadio.setId(id);
        return estadioService.saveEstadio(estadio);
    }

    @DeleteMapping("/{id}")
    public void deleteEstadio(@PathVariable Long id) {
        estadioService.deleteEstadioById(id);
    }
}
