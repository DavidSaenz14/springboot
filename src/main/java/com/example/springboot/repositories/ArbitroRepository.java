package com.example.springboot.repositories;


import com.example.springboot.models.Arbitro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbitroRepository extends JpaRepository<Arbitro, Long> {
    // Puedes agregar métodos personalizados según sea necesario
}
