package com.ucb.Nexo_Backend.services;


import com.ucb.Nexo_Backend.dto.AdministratorRequest;
import com.ucb.Nexo_Backend.models.Administrator;
import com.ucb.Nexo_Backend.models.Transaction;
import com.ucb.Nexo_Backend.repository.AdministratorRepository;
import com.ucb.Nexo_Backend.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.List;

@Service
public class AdministratorService {
    private AdministratorRepository admiRepo;
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    public AdministratorService(AdministratorRepository repo){
        this.admiRepo = repo;
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    class SignInFailed extends RuntimeException {
        public SignInFailed(String message) {
            super(message);
        }
    }

    public AdministratorRequest SignIn(AdministratorRequest administratorRequest, Transaction transaction){

        Administrator admiInfo=admiRepo.findByEmail(administratorRequest.getEmail());
        System.out.println("Ya entre");
        if(admiInfo!=null){
            if(encoder.matches(administratorRequest.getPassword(),admiInfo.getPassword())){
                Util jwtUtil=new Util();
                String token = jwtUtil.getJWTToken(administratorRequest);
                administratorRequest.setToken(token);
                administratorRequest.setIdAdministrator(admiInfo.getIdAdministrator());
                return administratorRequest;
            }
            else{

                throw new SignInFailed("Datos incorrectas");
            }
        }
        else{
            throw new SignInFailed("Administrador no enontrado");
        }
    }

}


