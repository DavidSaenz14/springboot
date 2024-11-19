package com.example.springboot.repositories;


import com.example.springboot.models.Competicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompeticionRepository extends JpaRepository<Competicion, Long> {

}

