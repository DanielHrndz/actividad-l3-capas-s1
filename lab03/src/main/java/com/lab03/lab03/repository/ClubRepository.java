package com.lab03.lab03.repository;

import com.lab03.lab03.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Integer> {
    Optional<Club> findByName(String name);
    boolean existsByName(String anme);

    Optional<Club> findByCountry(String country);
}