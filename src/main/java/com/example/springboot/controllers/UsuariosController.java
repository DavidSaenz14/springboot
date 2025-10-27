package com.example.springboot.controllers;

import com.example.springboot.models.Usuarios;
import com.example.springboot.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    // GET: listar todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuarios>> getAllUsuarios() {
        List<Usuarios> usuarios = usuariosService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    // GET: obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getUsuarioPorId(@PathVariable Long id) {
        try {
            Usuarios usuario = usuariosService.getUsuarioPorId(id);
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // POST: crear un nuevo usuario
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuarios usuario) {
        try {
            Usuarios nuevoUsuario = usuariosService.crearUsuario(usuario);
            return ResponseEntity.ok(nuevoUsuario);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // PUT: actualizar usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Long id, @RequestBody Usuarios usuarioActualizado) {
        try {
            Usuarios actualizado = usuariosService.actualizarUsuario(id, usuarioActualizado);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // DELETE: eliminar usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuariosService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    // GET opcional: verificar si existe usuario o correo
    @GetMapping("/check")
    public ResponseEntity<Boolean> checkUserExists(@RequestParam String username, @RequestParam String email) {
        boolean exists = usuariosService.findByNombre(username).isPresent() ||
                usuariosService.findByCorreoElectronico(email).isPresent();
        return ResponseEntity.ok(exists);
    }
}
