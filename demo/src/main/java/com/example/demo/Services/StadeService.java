package com.example.demo.Services;

import com.example.demo.entities.Stade;
import com.example.demo.repository.StadeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StadeService {
    @Autowired
    StadeRepo stadeRepo;
    public Stade saveStade(Stade stade){
        return stadeRepo.save(stade);
    }
}
