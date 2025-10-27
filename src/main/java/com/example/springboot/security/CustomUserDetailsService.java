package com.example.springboot.security;

import com.example.springboot.models.Usuarios;
import com.example.springboot.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuariosRepository usuariosRepository;

    @Autowired
    public CustomUserDetailsService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String correoElectronico) throws UsernameNotFoundException {
        Usuarios usuario = usuariosRepository.findByCorreoElectronico(correoElectronico)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con correo: " + correoElectronico));

        // ⚠️ No fuerces siempre ROLE_ADMIN, usar el rol que viene de la BD
        String rolUsuario = usuario.getRol();
        if (rolUsuario == null || rolUsuario.isBlank()) {
            rolUsuario = "USER"; // rol por defecto
        }

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + rolUsuario.toUpperCase());

        return new User(
                usuario.getCorreoElectronico(),
                usuario.getContrasena(),
                Collections.singletonList(authority)
        );
    }
}
