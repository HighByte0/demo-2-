package com.example.demo.Services;

import com.example.demo.entities.Arbitre;
import com.example.demo.repository.ArbitreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArbitreService {
    @Autowired
    ArbitreRepo arbitreRepo;
    public Arbitre saveArbitre(Arbitre arbitre){
        return arbitreRepo.save(arbitre);

    }

}
