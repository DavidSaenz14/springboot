package com.example.springboot.controllers;

import com.example.springboot.models.Equipo;
import com.example.springboot.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipos")
@CrossOrigin(origins = "https://tfg-futbol.vercel.app") // Reemplaza "*" por el dominio permitido
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    // Obtener un equipo por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getEquipo(@PathVariable Long id) {
        Optional<Equipo> equipo = equipoService.findEquipoById(id);
        if (equipo.isPresent()) {
            return ResponseEntity.ok(equipo.get()); // Respuesta con JSON válido
        } else {
            return ResponseEntity.status(404).body("{\"error\":\"Equipo no encontrado\"}");
        }
    }

    // Obtener todos los equipos
    @GetMapping
    public ResponseEntity<List<Equipo>> getAllEquipos() {
        List<Equipo> equipos = equipoService.findAllEquipos();
        return ResponseEntity.ok(equipos); // Respuesta con JSON válido
    }

    // Crear un equipo
    @PostMapping
    public ResponseEntity<Equipo> createEquipo(@RequestBody Equipo equipo) {
        Equipo nuevoEquipo = equipoService.saveEquipo(equipo);
        return ResponseEntity.status(201).body(nuevoEquipo); // Respuesta con JSON válido
    }

    // Actualizar un equipo por ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEquipo(@PathVariable Long id, @RequestBody Equipo equipo) {
        if (!equipoService.findEquipoById(id).isPresent()) {
            return ResponseEntity.status(404).body("{\"error\":\"Equipo no encontrado\"}");
        }
        equipo.setId(id);
        Equipo equipoActualizado = equipoService.saveEquipo(equipo);
        return ResponseEntity.ok(equipoActualizado);
    }

    // Eliminar un equipo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEquipo(@PathVariable Long id) {
        if (!equipoService.findEquipoById(id).isPresent()) {
            return ResponseEntity.status(404).body("{\"error\":\"Equipo no encontrado\"}");
        }
        equipoService.deleteEquipoById(id);
        return ResponseEntity.status(204).build(); // No content
    }
}
