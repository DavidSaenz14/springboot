package com.example.springboot.controllers;
import com.example.springboot.models.Partido;
import com.example.springboot.services.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partidos")
@CrossOrigin("*")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping("/{id}")
    public Optional<Partido> getPartido(@PathVariable Long id) {
        return partidoService.findPartidoById(id);
    }

    @GetMapping
    public List<Partido> getAllPartidos() {
        return partidoService.findAllPartidos();
    }

    @PostMapping
    public Partido createPartido(@RequestBody Partido partido) {
        return partidoService.savePartido(partido);
    }

    @PutMapping("/{id}")
    public Partido updatePartido(@PathVariable Long id, @RequestBody Partido partido) {
        partido.setId(id);
        return partidoService.savePartido(partido);
    }

    @DeleteMapping("/{id}")
    public void deletePartido(@PathVariable Long id) {
        partidoService.deletePartidoById(id);
    }
}