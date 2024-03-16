package com.example.demo.Services;

import com.example.demo.entities.MatchEquipe;
import com.example.demo.repository.MatchEquipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MatchEquipeService {
    @Autowired
    MatchEquipeRepo matchEquipeRepo ;
    public MatchEquipe matchEquipe (MatchEquipe matchEquipe){
        return matchEquipeRepo.save(matchEquipe);
    }

}
