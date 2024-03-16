package com.example.demo.Services;

import com.example.demo.entities.Equipe;
import com.example.demo.repository.EquipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipeService {
    @Autowired
    EquipeRepo equipeRepo;
    public Equipe SaveEquip(Equipe equipe){
        return equipeRepo.save(equipe);
    }

}
