package com.ucb.Nexo_Backend.repository;

import com.ucb.Nexo_Backend.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, String> {
}
