package com.example.springboot.controllers;

import com.example.springboot.models.Equipo;
import com.example.springboot.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipos")
@CrossOrigin("*")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> getEquipo(@PathVariable Long id) {
        Optional<Equipo> equipo = equipoService.findEquipoById(id);
        if (equipo.isPresent()) {
            return ResponseEntity.ok(equipo.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Equipo>> getAllEquipos() {
        List<Equipo> equipos = equipoService.findAllEquipos();
        if (!equipos.isEmpty()) {
            return ResponseEntity.ok(equipos);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Equipo> createEquipo(@RequestBody Equipo equipo) {
        Equipo savedEquipo = equipoService.saveEquipo(equipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEquipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> updateEquipo(@PathVariable Long id, @RequestBody Equipo equipo) {
        equipo.setId(id);
        Equipo updatedEquipo = equipoService.saveEquipo(equipo);
        return ResponseEntity.ok(updatedEquipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable Long id) {
        if (!equipoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        equipoService.deleteEquipoById(id);
        return ResponseEntity.ok().build();
    }
}
