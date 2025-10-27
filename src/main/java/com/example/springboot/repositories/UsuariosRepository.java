package com.example.springboot.repositories;

import com.example.springboot.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    // Buscar usuario por correo electrónico (para login y validaciones)
    Optional<Usuarios> findByCorreoElectronico(String correoElectronico);

    // Buscar usuario por nombre (para validar duplicados en el registro)
    Optional<Usuarios> findByNombre(String nombre);
}
