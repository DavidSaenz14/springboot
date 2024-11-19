package com.example.springboot.controllers;


import com.example.springboot.models.Competicion;
import com.example.springboot.services.CompeticionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/competiciones")
@CrossOrigin("*")
public class CompeticionController {

    @Autowired
    private CompeticionService competicionService;

    @GetMapping("/{id}")
    public Optional<Competicion> getCompeticion(@PathVariable Long id) {
        return competicionService.findCompeticionById(id);
    }

    @GetMapping
    public List<Competicion> getAllCompeticiones() {
        return competicionService.findAllCompeticiones();
    }

    @PostMapping
    public Competicion createCompeticion(@RequestBody Competicion competicion) {
        return competicionService.saveCompeticion(competicion);
    }

    @PutMapping("/{id}")
    public Competicion updateCompeticion(@PathVariable Long id, @RequestBody Competicion competicion) {
        competicion.setId(id);
        return competicionService.saveCompeticion(competicion);
    }

    @DeleteMapping("/{id}")
    public void deleteCompeticion(@PathVariable Long id) {
        competicionService.deleteCompeticionById(id);
    }
}

