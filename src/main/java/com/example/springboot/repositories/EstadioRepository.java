package com.example.springboot.repositories;


import com.example.springboot.models.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadioRepository extends JpaRepository<Estadio, Long> {

}

