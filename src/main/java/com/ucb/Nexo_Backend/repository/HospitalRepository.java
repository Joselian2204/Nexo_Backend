package com.ucb.Nexo_Backend.repository;
import com.ucb.Nexo_Backend.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
    public List<Hospital> findByStatus(int status);

}
