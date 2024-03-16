package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJoueur;

    private String nomJoueur;
    private String nationalite;
    private String poste;
    @ManyToOne
    @JoinColumn(name = "idEquipe")
    private Equipe equipe;
}
