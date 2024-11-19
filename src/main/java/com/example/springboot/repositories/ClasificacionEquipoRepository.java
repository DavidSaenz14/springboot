package com.example.springboot.repositories;


import com.example.springboot.models.ClasificacionEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasificacionEquipoRepository extends JpaRepository<ClasificacionEquipo, Long> {

}
