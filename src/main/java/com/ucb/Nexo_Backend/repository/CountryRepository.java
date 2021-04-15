package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}
