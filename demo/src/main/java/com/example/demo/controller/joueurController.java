package com.example.demo.controller;

import com.example.demo.entities.Joueur;
import com.example.demo.repository.JoueurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/jouers")
public class joueurController {
    @Autowired
    private JoueurRepo joueurRepo;

    // Add Joueur
    @PostMapping("/joueur")
    public Joueur addJoueur(@RequestBody Joueur joueur) {
        return joueurRepo.save(joueur);
    }

    // Get all Joueurs
    @GetMapping("/joueurs")
    public List<Joueur> getAllJoueurs() {
        return joueurRepo.findAll();
    }

    // Get Joueur by ID
    @GetMapping("/joueurs/{id}")
    public ResponseEntity<Joueur> getJoueurById(@PathVariable Long id) {
        Optional<Joueur> joueur = joueurRepo.findById(id);
        return joueur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Joueur by ID
    @DeleteMapping("/joueurs/{id}")
    public ResponseEntity<?> deleteJoueur(@PathVariable Long id) {
        if (!joueurRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        joueurRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Update Joueur by ID
    @PutMapping("/joueurs/{id}")
    public ResponseEntity<Joueur> updateJoueur(@PathVariable Long id, @RequestBody Joueur updatedJoueur) {
        if (!joueurRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedJoueur.setIdJoueur(id);
        Joueur savedJoueur = joueurRepo.save(updatedJoueur);
        return ResponseEntity.ok(savedJoueur);
    }
    @GetMapping("/equipe/ATL MADRID")
    public List<Joueur> getJoueursOfATLMadrid() {
        return joueurRepo.findByEquipeNomEquipe("ATL MADRID");
    }


}
