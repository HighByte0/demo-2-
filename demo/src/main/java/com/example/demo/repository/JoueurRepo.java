package com.example.demo.repository;

import com.example.demo.entities.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoueurRepo extends JpaRepository<Joueur,Long> {
    List<Joueur> findByEquipeNomEquipe(String nomEquipe);

}
