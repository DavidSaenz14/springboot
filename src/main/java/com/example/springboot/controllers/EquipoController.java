package com.example.springboot.controllers;

import com.example.springboot.models.Equipo;
import com.example.springboot.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipos")
@CrossOrigin("*")
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

    @PreAuthorize("hasRole('ADMIN')")  // Solo ADMIN puede crear
    @PostMapping
    public Equipo createEquipo(@RequestBody Equipo equipo) {
        return equipoService.saveEquipo(equipo);
    }

    @PreAuthorize("hasRole('ADMIN')")  // Solo ADMIN puede actualizar
    @PutMapping("/{id}")
    public Equipo updateEquipo(@PathVariable Long id, @RequestBody Equipo equipo) {
        equipo.setId(id);
        return equipoService.saveEquipo(equipo);
    }

    @PreAuthorize("hasRole('ADMIN')")  // Solo ADMIN puede borrar
    @DeleteMapping("/{id}")
    public void deleteEquipo(@PathVariable Long id) {
        equipoService.deleteEquipoById(id);
    }
}
