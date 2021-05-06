package com.ucb.Nexo_Backend.services;


import com.ucb.Nexo_Backend.models.User;
import com.ucb.Nexo_Backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    private UserRepository repo;
    @Autowired
    public void setRepo(UserRepository repo){
        this.repo = repo;
    }
    public List<User>  getByUserId(String id_user){
        return repo.findByIdUser(id_user);
    }

}


