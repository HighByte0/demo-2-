package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class MatchEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatchEquipe;

    @ManyToOne
    @JoinColumn(name = "idMatch")
    private Matches match;

    @ManyToOne
    @JoinColumn(name = "idEquipe")
    private Equipe equipe;

}
