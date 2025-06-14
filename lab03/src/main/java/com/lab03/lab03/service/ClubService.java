package com.lab03.lab03.service;

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

    public Club getClub(String country) {
        return clubRepository.findByName(country)
                .orElseThrow(() -> new RuntimeException("Club not found"));
    }
}