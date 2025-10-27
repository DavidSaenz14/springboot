package com.example.springboot.services;

import com.example.springboot.models.Usuarios;
import com.example.springboot.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Constructor con inyección de repositorio
    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    // Obtener todos los usuarios
    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    // Obtener usuario por ID
    public Usuarios getUsuarioPorId(Long id) {
        return usuariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    // Crear nuevo usuario con contraseña cifrada
    public Usuarios crearUsuario(Usuarios usuario) {
        // Verificar duplicados antes de guardar
        if (usuariosRepository.findByCorreoElectronico(usuario.getCorreoElectronico()).isPresent()) {
            throw new RuntimeException("El correo ya está en uso.");
        }
        if (usuariosRepository.findByNombre(usuario.getNombre()).isPresent()) {
            throw new RuntimeException("El nombre de usuario ya está en uso.");
        }

        // Cifrar la contraseña
        String encodedPassword = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(encodedPassword);

        return usuariosRepository.save(usuario);
    }

    // Actualizar usuario existente con cifrado de contraseña si cambia
    public Usuarios actualizarUsuario(Long id, Usuarios usuarioActualizado) {
        return usuariosRepository.findById(id)
                .map(usuario -> {
                    usuario.setNombre(usuarioActualizado.getNombre());
                    usuario.setCorreoElectronico(usuarioActualizado.getCorreoElectronico());
                    if (!usuarioActualizado.getContrasena().equals(usuario.getContrasena())) {
                        String encodedPassword = passwordEncoder.encode(usuarioActualizado.getContrasena());
                        usuario.setContrasena(encodedPassword);
                    }
                    usuario.setRol(usuarioActualizado.getRol());
                    return usuariosRepository.save(usuario);
                })
                .orElseGet(() -> {
                    usuarioActualizado.setId(id);
                    String encodedPassword = passwordEncoder.encode(usuarioActualizado.getContrasena());
                    usuarioActualizado.setContrasena(encodedPassword);
                    return usuariosRepository.save(usuarioActualizado);
                });
    }

    // Eliminar usuario por ID
    public void eliminarUsuario(Long id) {
        usuariosRepository.deleteById(id);
    }

    // Buscar usuario por correo electrónico
    public Optional<Usuarios> findByCorreoElectronico(String correoElectronico) {
        return usuariosRepository.findByCorreoElectronico(correoElectronico);
    }

    // Buscar usuario por nombre
    public Optional<Usuarios> findByNombre(String nombre) {
        return usuariosRepository.findByNombre(nombre);
    }
}
