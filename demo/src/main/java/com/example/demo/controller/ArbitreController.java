package com.example.demo.controller;


import com.example.demo.entities.Arbitre;
import com.example.demo.repository.ArbitreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/arbitres")
public class ArbitreController {
    @Autowired
    private ArbitreRepo arbitreRepo;

    // Add Arbitre
    @PostMapping("/arbitre")
    public Arbitre addArbitre(@RequestBody Arbitre arbitre) {
        return arbitreRepo.save(arbitre);
    }

    // Get all Arbitres
    @GetMapping("/arbitres")
    public List<Arbitre> getAllArbitres() {
        return arbitreRepo.findAll();
    }

    // Get Arbitre by ID
    @GetMapping("/arbitres/{id}")
    public ResponseEntity<Arbitre> getArbitreById(@PathVariable Long id) {
        Optional<Arbitre> arbitre = arbitreRepo.findById(id);
        return arbitre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Arbitre by ID
    @DeleteMapping("/arbitres/{id}")
    public ResponseEntity<?> deleteArbitre(@PathVariable Long id) {

        arbitreRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Update Arbitre by ID
    @PutMapping("/arbitres/{id}")
    public ResponseEntity<Arbitre> updateArbitre(@PathVariable Long id, @RequestBody Arbitre updatedArbitre) {
        if (!arbitreRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedArbitre.setIdArbitre(id);
        Arbitre savedArbitre = arbitreRepo.save(updatedArbitre);
        return ResponseEntity.ok(savedArbitre);
    }
}

