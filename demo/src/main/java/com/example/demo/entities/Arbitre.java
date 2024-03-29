package com.example.demo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Arbitre {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArbitre;
    private String nom;
}
