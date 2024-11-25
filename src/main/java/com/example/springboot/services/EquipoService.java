package com.example.springboot.services;

import com.example.springboot.models.Equipo;
import com.example.springboot.repositories.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional // Garantiza la consistencia en las operaciones de escritura
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    /**
     * Encuentra un equipo por su ID.
     *
     * @param id ID del equipo.
     * @return ResponseEntity con el equipo encontrado o un mensaje de error si no existe.
     */
    public ResponseEntity<Object> findEquipoById(Long id) {
        Optional<Equipo> equipo = equipoRepository.findById(id);
        if (equipo.isPresent()) {
            return ResponseEntity.ok(equipo.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Equipo no encontrado\"}");
        }
    }

    /**
     * Obtiene una lista de todos los equipos.
     *
     * @return ResponseEntity con la lista de equipos o un mensaje si no hay datos.
     */
    public ResponseEntity<Object> findAllEquipos() {
        List<Equipo> equipos = equipoRepository.findAll();
        if (!equipos.isEmpty()) {
            return ResponseEntity.ok(equipos);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("{\"message\": \"No hay equipos disponibles\"}");
        }
    }

    /**
     * Guarda o actualiza un equipo en la base de datos.
     *
     * @param equipo Objeto Equipo a guardar.
     * @return ResponseEntity con el equipo guardado o un mensaje de error.
     */
    public ResponseEntity<Object> saveEquipo(Equipo equipo) {
        if (equipo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"El equipo no puede ser nulo\"}");
        }
        Equipo savedEquipo = equipoRepository.save(equipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEquipo);
    }

    /**
     * Elimina un equipo por su ID.
     *
     * @param id ID del equipo a eliminar.
     * @return ResponseEntity con el estado de la operación.
     */
    public ResponseEntity<Object> deleteEquipoById(Long id) {
        if (!equipoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"El equipo con el ID " + id + " no existe\"}");
        }
        equipoRepository.deleteById(id);
        return ResponseEntity.ok("{\"message\": \"Equipo eliminado correctamente\"}");
    }
}
