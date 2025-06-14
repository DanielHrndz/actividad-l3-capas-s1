package com.lab03.lab03.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab03.lab03.dto.ClubRequest;
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
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    public List<Club> getClubsByCountry(String country) {
        List<Club> clubs = clubRepository.findByCountry(country.trim());
        if (clubs.isEmpty()) {
            throw new RuntimeException("No clubs found in the specified country");
        }
        return clubs;
    }

}