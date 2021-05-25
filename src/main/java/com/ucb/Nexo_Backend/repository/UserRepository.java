package com.ucb.Nexo_Backend.repository;


import com.ucb.Nexo_Backend.models.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<Administrator, String>{
    public List<Administrator> findByIdUser(int id);
}


