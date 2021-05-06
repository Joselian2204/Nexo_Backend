package com.ucb.Nexo_Backend.repository;


import com.ucb.Nexo_Backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, String>{
    public List<User> findByIdUser(String id);
}


