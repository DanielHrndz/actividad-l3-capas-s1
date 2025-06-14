package com.lab03.lab03.repository;

import com.lab03.lab03.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findByName(String name);

    boolean existsByName(String name);

    public List<Club> findByCountry(String country);
}
