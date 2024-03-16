package com.example.demo.controller;

import com.example.demo.entities.Stade;
import com.example.demo.repository.StadeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stades")
public class StadeController {

    @Autowired
    private StadeRepo stadeRepo;

    // Add Stade
    @PostMapping("/stade")
    public Stade addStade(@RequestBody Stade stade) {
        return stadeRepo.save(stade);
    }

    // Get all Stades
    @GetMapping("/stades")
    public List<Stade> getAllStades() {
        return stadeRepo.findAll();
    }

    // Get Stade by ID
    @GetMapping("/stades/{id}")
    public ResponseEntity<Stade> getStadeById(@PathVariable Long id) {
        Optional<Stade> stade = stadeRepo.findById(id);
        return stade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Stade by ID
    @DeleteMapping("/stades/{id}")
    public ResponseEntity<?> deleteStade(@PathVariable Long id) {
        if (!stadeRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        stadeRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Update Stade by ID
    @PutMapping("/stades/{id}")
    public ResponseEntity<Stade> updateStade(@PathVariable Long id, @RequestBody Stade updatedStade) {
        if (!stadeRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedStade.setIdStade(id);
        Stade savedStade = stadeRepo.save(updatedStade);
        return ResponseEntity.ok(savedStade);
    }
}
