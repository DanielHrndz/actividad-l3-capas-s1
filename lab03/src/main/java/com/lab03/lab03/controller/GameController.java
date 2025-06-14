package com.lab03.lab03.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab03.lab03.dto.ClubRequest;
import com.lab03.lab03.model.Club;
import com.lab03.lab03.service.ClubService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class GameController {

    @Autowired
    private ClubService clubService;

    // Registrar un club
    @PostMapping("/clubs")
    public ResponseEntity<?> club(@RequestBody ClubRequest request) {
        try {
            Club club = new Club();
            club.setName(request.getName());
            club.setCountry(request.getCountry());
            club.setCoach(request.getCoach());
            club.setTitles(request.getTitles());

            Club savedclub = clubService.addClub(club);
            return ResponseEntity.ok(savedclub);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    // Obtener todos los videojuegos
    @GetMapping("/clubs/search")
    public ResponseEntity<List<Club>> getAllClubs() {
        return ResponseEntity.ok(clubService.getAllClubs());
    }

    @GetMapping("/clubs/country/{country}")
    public ResponseEntity<List<Club>> getClubsByCountry(@PathVariable("country") String country) {
        try {
            List<Club> clubs = clubService.getClubsByCountry(country);
            return ResponseEntity.ok(clubs);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
