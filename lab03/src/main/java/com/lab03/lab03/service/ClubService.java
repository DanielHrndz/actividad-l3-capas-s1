package com.lab03.lab03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab03.lab03.model.Club;
import com.lab03.lab03.repository.ClubRepository;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;

    public Club addClub(Club club) {
        if (clubRepository.existsByName(club.getName())) {
            throw new RuntimeException("Club already exists");
        }
        return clubRepository.save(club);
    }


    // obtener todos
        public List<Club> getAllClubs(){
        return clubRepository.findAll();
    }


    // obtener club por pais
    public Club getClub(String country){
        Optional<Club> optionalClub = clubRepository.findByCountry(country);
        if (optionalClub.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        return new Club(optionalClub.get().getId(), optionalClub.get().getName(), optionalClub.get().getCuntry(), optionalClub.get().getCoach, optionalClub.get().get);

    }

}