package com.example.springboot.repositories;


import com.example.springboot.models.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {

}

