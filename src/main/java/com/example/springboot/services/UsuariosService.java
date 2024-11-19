package com.example.springboot.services;

import com.example.springboot.models.Usuarios;
import com.example.springboot.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosService {

    @Autowired

    private final UsuariosRepository usuariosRepository;

    // Inyección de dependencias a través del constructor
    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    // Método para obtener todos los usuarios
    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    // Método para obtener un usuario por ID
    public Usuarios getUsuarioPorId(Long id) {
        return usuariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    // Método para crear un nuevo usuario
    public Usuarios crearUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    // Método para actualizar un usuario existente
    public Usuarios actualizarUsuario(Long id, Usuarios usuarioActualizado) {
        return usuariosRepository.findById(id)
                .map(usuario -> {
                    usuario.setNombre(usuarioActualizado.getNombre());
                    usuario.setCorreoElectronico(usuarioActualizado.getCorreoElectronico());
                    usuario.setContraseña(usuarioActualizado.getContraseña());
                    usuario.setRol(usuarioActualizado.getRol());
                    return usuariosRepository.save(usuario);
                })
                .orElseGet(() -> {
                    usuarioActualizado.setId(id);
                    return usuariosRepository.save(usuarioActualizado);
                });
    }

    // Método para eliminar un usuario por ID
    public void eliminarUsuario(Long id) {
        usuariosRepository.deleteById(id);
    }
}