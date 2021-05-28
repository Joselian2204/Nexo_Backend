package com.ucb.Nexo_Backend.dto;

public class AdministratorRequest {
    private Integer idAdministrator;
    private String password;
    private String email;
    private String token;

    public AdministratorRequest() {
    }

    public Integer getIdAdministrator() {
        return idAdministrator;
    }

    public void setIdAdministrator(Integer idAdministrator) {
        this.idAdministrator = idAdministrator;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AdministratorRequest{" +
                "idAdministrator=" + idAdministrator +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
