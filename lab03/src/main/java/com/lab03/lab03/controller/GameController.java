package com.lab03.lab03.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class GameController {

    // Registrar un club
   @PostMapping("api/clubs")
   public String postMethodName(@RequestBody String entity) {
       //TODO: process POST request
       
       return entity;
   }
   
   // Obtener todos los videojuegos
    @GetMapping("api/clubs/search")
    public String getMethodName(@RequestParam String param) {
        // TODO
        return new String();
    }

    // Obtener clubes por país
    @GetMapping("api/clubs/country/{country}")
 public ResponseEntity<Club> getClub(@PathVariable("country") String country){
        // TODO
        return ResponseEntity.ok(clubService.getClub(country));
    }
    
    
    
}
