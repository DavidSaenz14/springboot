package com.example.springboot.controllers;


import com.example.springboot.models.ClasificacionEquipo;
import com.example.springboot.services.ClasificacionEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clasificacion")
@CrossOrigin("*")
public class ClasificacionEquipoController {

    @Autowired
    private ClasificacionEquipoService clasificacionEquipoService;

    @GetMapping("/{id}")
    public Optional<ClasificacionEquipo> getClasificacionEquipo(@PathVariable Long id) {
        return clasificacionEquipoService.findClasificacionEquipoById(id);
    }

    @GetMapping
    public List<ClasificacionEquipo> getAllClasificacionesEquipos() {
        return clasificacionEquipoService.findAllClasificacionesEquipos();
    }

    @PostMapping
    public ClasificacionEquipo createClasificacionEquipo(@RequestBody ClasificacionEquipo clasificacionEquipo) {
        return clasificacionEquipoService.saveClasificacionEquipo(clasificacionEquipo);
    }

    @PutMapping("/{id}")
    public ClasificacionEquipo updateClasificacionEquipo(@PathVariable Long id, @RequestBody ClasificacionEquipo clasificacionEquipo) {
        clasificacionEquipo.setId(id);
        return clasificacionEquipoService.saveClasificacionEquipo(clasificacionEquipo);
    }

    @DeleteMapping("/{id}")
    public void deleteClasificacionEquipo(@PathVariable Long id) {
        clasificacionEquipoService.deleteClasificacionEquipoById(id);
    }
}

