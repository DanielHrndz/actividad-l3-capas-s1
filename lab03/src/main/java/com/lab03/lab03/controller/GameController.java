package com.lab03.lab03.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab03.lab03.model.Club;
import com.lab03.lab03.service.ClubService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String postMethodName(@RequestBody String entity) {
        // TODO: process POST request

        return entity;
    }

    // Obtener todos los videojuegos
    @GetMapping("/clubs/search")
    public ResponseEntity<List<Club>> getAllClubs(){
        return ResponseEntity.ok(clubService.getAllClubs());
    }
    


    // Obtener clubes por país
    @GetMapping("/clubs/country/{country}")
    public ResponseEntity<Club> getClubByCountry(@RequestParam("country") String country) {
        return ResponseEntity.ok(clubService.getClub(country));
    }

}
