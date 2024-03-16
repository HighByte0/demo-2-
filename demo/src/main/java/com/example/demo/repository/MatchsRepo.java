package com.example.demo.repository;

import com.example.demo.entities.Matches;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MatchsRepo extends JpaRepository<Matches, Long> {
    List<Matches> findByDateMatch(LocalDate dateMatch);



    List<Matches> findByDateMatchBefore(LocalDate currentDate);
}
