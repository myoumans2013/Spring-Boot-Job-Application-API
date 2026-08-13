package com.youmanscode.jobapplicationtrackerapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

// database tables for user
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public User() {

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
