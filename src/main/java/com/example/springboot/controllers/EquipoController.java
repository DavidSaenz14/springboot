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

    /**
     * Obtiene un equipo por su ID.
     *
     * @param id ID del equipo.
     * @return ResponseEntity con el equipo encontrado o un error.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Equipo> getEquipo(@PathVariable Long id) {
        Optional<Equipo> equipo = equipoService.findEquipoById(id);
        if (equipo.isPresent()) {
            return ResponseEntity.ok(equipo.get());  // Devuelve el equipo con un código 200
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);  // Devuelve un código 404 si no se encuentra el equipo
        }
    }

    /**
     * Obtiene todos los equipos.
     *
     * @return ResponseEntity con la lista de equipos o un mensaje si no hay equipos.
     */
    @GetMapping
    public ResponseEntity<List<Equipo>> getAllEquipos() {
        List<Equipo> equipos = equipoService.findAllEquipos();
        if (!equipos.isEmpty()) {
            return ResponseEntity.ok(equipos);  // Devuelve todos los equipos con un código 200
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(null);  // Devuelve un código 204 si no hay equipos
        }
    }

    /**
     * Crea o actualiza un equipo.
     *
     * @param equipo Objeto Equipo a crear o actualizar.
     * @return ResponseEntity con el equipo creado.
     */
    @PostMapping
    public ResponseEntity<Equipo> createEquipo(@RequestBody Equipo equipo) {
        Equipo savedEquipo = equipoService.saveEquipo(equipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEquipo);  // Devuelve el equipo creado con código 201
    }

    /**
     * Actualiza un equipo.
     *
     * @param id ID del equipo a actualizar.
     * @param equipo Datos del equipo a actualizar.
     * @return ResponseEntity con el equipo actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Equipo> updateEquipo(@PathVariable Long id, @RequestBody Equipo equipo) {
        equipo.setId(id);  // Establece el ID en el objeto equipo
        Equipo updatedEquipo = equipoService.saveEquipo(equipo);
        return ResponseEntity.ok(updatedEquipo);  // Devuelve el equipo actualizado con código 200
    }

    /**
     * Elimina un equipo por su ID.
     *
     * @param id ID del equipo a eliminar.
     * @return ResponseEntity con el estado de la operación.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable Long id) {
        if (!equipoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Devuelve un código 404 si no se encuentra el equipo
        }
        equipoService.deleteEquipoById(id);
        return ResponseEntity.ok().build();  // Devuelve un código 200 si se elimina correctamente
    }
}
