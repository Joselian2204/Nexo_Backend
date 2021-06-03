package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PharmacyRepository extends JpaRepository<Pharmacy,Integer> {
    public List<Pharmacy> findByStatus(int status);
}
