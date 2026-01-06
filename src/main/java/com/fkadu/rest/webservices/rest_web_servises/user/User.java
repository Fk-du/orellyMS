package com.fkadu.rest.webservices.rest_web_servises.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class User {
    private Long id;
    @Size(min = 2, max = 50)
    private String username;

    private String discription;
    @Past
    private LocalDateTime dateOfBirth;

    public User() {
    }
    public User(Long id, String username, String discription, LocalDateTime dateOfBirth) {

        this.id = id;
        this.username = username;
        this.discription = discription;
        this.dateOfBirth = dateOfBirth;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getDiscription() {
        return discription;
    }
    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
