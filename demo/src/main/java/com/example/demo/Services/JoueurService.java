package com.example.demo.Services;

import com.example.demo.entities.Joueur;
import com.example.demo.repository.JoueurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoueurService {
    @Autowired
    private JoueurRepo joueurRepo;
    public Joueur SaveJoueur(Joueur joueur){
        return joueurRepo.save(joueur);
    }

}
