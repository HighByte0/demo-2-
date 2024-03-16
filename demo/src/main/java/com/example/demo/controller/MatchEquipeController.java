package com.example.demo.controller;

import com.example.demo.entities.MatchEquipe;
import com.example.demo.repository.MatchEquipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/match-equipes")
public class MatchEquipeController {

    @Autowired
    private MatchEquipeRepo matchEquipeRepo;

    // Add MatchEquipe
    @PostMapping("/match-equipe")
    public MatchEquipe addMatchEquipe(@RequestBody MatchEquipe matchEquipe) {
        return matchEquipeRepo.save(matchEquipe);
    }

    // Get all MatchEquipes
    @GetMapping("/match-equipes")
    public List<MatchEquipe> getAllMatchEquipes() {
        return matchEquipeRepo.findAll();
    }

    // Get MatchEquipe by ID
    @GetMapping("/match-equipes/{id}")
    public ResponseEntity<MatchEquipe> getMatchEquipeById(@PathVariable Long id) {
        Optional<MatchEquipe> matchEquipe = matchEquipeRepo.findById(id);
        return matchEquipe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete MatchEquipe by ID
    @DeleteMapping("/match-equipes/{id}")
    public ResponseEntity<?> deleteMatchEquipe(@PathVariable Long id) {
        if (!matchEquipeRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        matchEquipeRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Update MatchEquipe by ID
    @PutMapping("/match-equipes/{id}")
    public ResponseEntity<MatchEquipe> updateMatchEquipe(@PathVariable Long id, @RequestBody MatchEquipe updatedMatchEquipe) {
        if (!matchEquipeRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedMatchEquipe.setIdMatchEquipe(id);
        MatchEquipe savedMatchEquipe = matchEquipeRepo.save(updatedMatchEquipe);
        return ResponseEntity.ok(savedMatchEquipe);
    }
}
