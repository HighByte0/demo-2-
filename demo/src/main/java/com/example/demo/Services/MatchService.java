package com.example.demo.Services;

import com.example.demo.entities.Matches;
import com.example.demo.repository.MatchsRepo;
import org.springframework.beans.factory.annotation.Autowired;



public class MatchService {
    @Autowired
    MatchsRepo matchRepo;
    public Matches saveMatch(Matches match){
        return matchRepo.save(match);
    }
}


