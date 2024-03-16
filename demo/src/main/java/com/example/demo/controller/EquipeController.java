package com.example.demo.controller;

import com.example.demo.entities.Equipe;
import com.example.demo.repository.EquipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipe") // Base URL for this controller
public class EquipeController {

    @Autowired
    private EquipeRepo equipeRepo;
    ////////////////Create

    @PostMapping("/equipes") // Endpoint URL for adding an Equipe
    public Equipe addEquipe(@RequestBody Equipe equipe) {
        // Save the Equipe to the database
        return equipeRepo.save(equipe);
    }
    ///////READ
    @GetMapping("/find")
    public List<Equipe> findAllEquipes() {
        return equipeRepo.findAll();
    }


    ////////////////////DELET

    @DeleteMapping("/equipes/{id}")
    public ResponseEntity<?> deleteEquipe(@PathVariable Long id) {
        equipeRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

////update
    @PutMapping("/equipes/{id}") // Endpoint URL for updating an Equipe by ID
    public ResponseEntity<Equipe> updateEquipe(@PathVariable Long id, @RequestBody Equipe updatedEquipe) {
        // Check if Equipe exists

        // Set the ID for the updated Equipe
        updatedEquipe.setIdEquipe(id);
        // Update Equipe in the database
        Equipe savedEquipe = equipeRepo.save(updatedEquipe);
        return ResponseEntity.ok(savedEquipe);
    }
    @GetMapping("/Maroc")
    public List<Equipe>getAllEquipMaroc(){
        return equipeRepo.findByPays("Maroc");
    }
}
