package com.example.demo.controller;

import com.example.demo.entities.Matches;
import com.example.demo.repository.MatchsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchsRepo matchRepo;

    // Add Matches
    @PostMapping("/match")
    public Matches addMatch(@RequestBody Matches match) {
        return matchRepo.save(match);
    }

    // Get all Matches
    @GetMapping("/matches")
    public List<Matches> getAllMatches() {
        return matchRepo.findAll();
    }

    // Get Matches by ID
    @GetMapping("/matches/{id}")
    public ResponseEntity<Matches> getMatchById(@PathVariable Long id) {
        Optional<Matches> match = matchRepo.findById(id);
        return match.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Matches by ID
    @DeleteMapping("/matches/{id}")
    public ResponseEntity<?> deleteMatch(@PathVariable Long id) {
        if (!matchRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        matchRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Update Matches by ID
    @PutMapping("/matches/{id}")
    public ResponseEntity<Matches> updateMatch(@PathVariable Long id, @RequestBody Matches updatedMatch) {
        if (!matchRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedMatch.setIdMatch(id);
        Matches savedMatch = matchRepo.save(updatedMatch);
        return ResponseEntity.ok(savedMatch);
    }

    @GetMapping("/matche")
    public List<Matches> getMatchesByDate(@RequestParam("date") String dateString) {


            LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));


            return matchRepo.findByDateMatch(date);

    }

    @DeleteMapping("/delete-passed-matches")
    public ResponseEntity<?> deletePassedMatches() {
        // Get current date
        LocalDate currentDate = LocalDate.now();

        // Find all matches with a date before the current date
        List<Matches> passedMatches = matchRepo.findByDateMatchBefore(currentDate);

        // Delete the passed matches
        matchRepo.deleteAll(passedMatches);

        return ResponseEntity.ok().build();

}
    @GetMapping("/date/28-02-2021")
    public List<Matches> getMatchesOn28022021() {
        LocalDate date = LocalDate.of(2021, 2, 28);
        return matchRepo.findByDateMatch(date);
    }
}
