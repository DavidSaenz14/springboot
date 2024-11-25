package com.example.springboot.controllers;


import com.example.springboot.models.Equipo;
import com.example.springboot.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipos")
@CrossOrigin("origins = "https://tfg-futbol.vercel.app")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping("/{id}")
    public Optional<Equipo> getEquipo(@PathVariable Long id) {
        return equipoService.findEquipoById(id);
    }

    @GetMapping
    public List<Equipo> getAllEquipos() {
        return equipoService.findAllEquipos();
    }

    @PostMapping
    public Equipo createEquipo(@RequestBody Equipo equipo) {
        return equipoService.saveEquipo(equipo);
    }

    @PutMapping("/{id}")
    public Equipo updateEquipo(@PathVariable Long id, @RequestBody Equipo equipo) {
        equipo.setId(id);
        return equipoService.saveEquipo(equipo);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipo(@PathVariable Long id) {
        equipoService.deleteEquipoById(id);
    }
}

