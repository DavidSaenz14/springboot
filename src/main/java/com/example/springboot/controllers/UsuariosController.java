package com.example.springboot.controllers;

import com.example.springboot.models.Usuarios;
import com.example.springboot.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    // Método GET para listar todos los usuarios
    @GetMapping
    public List<Usuarios> getAllUsuarios() {
        return usuariosService.getAllUsuarios();
    }

    // Método GET para obtener un usuario por ID
    @GetMapping("/{id}")
    public Usuarios getUsuarioPorId(@PathVariable Long id) {
        return usuariosService.getUsuarioPorId(id);
    }

    // Método POST para crear un nuevo usuario
    @PostMapping
    public Usuarios crearUsuario(@RequestBody Usuarios usuario) {
        return usuariosService.crearUsuario(usuario);
    }

    // Método PUT para actualizar un usuario existente
    @PutMapping("/{id}")
    public Usuarios actualizarUsuario(@PathVariable Long id, @RequestBody Usuarios usuarioActualizado) {
        return usuariosService.actualizarUsuario(id, usuarioActualizado);
    }

    // Método DELETE para eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuariosService.eliminarUsuario(id);
    }
}