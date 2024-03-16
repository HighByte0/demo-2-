package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // Correct import statement for @Id
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatch;

    private Date dateMatch;

    private String heureMatch;

    // Constructors, getters, setters, and other methods...
}
