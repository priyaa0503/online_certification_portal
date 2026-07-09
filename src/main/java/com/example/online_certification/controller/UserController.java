package com.example.online_certification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.online_certification.model.CertificateUser;
import com.example.online_certification.service.CertificateUserService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    @Autowired
    private CertificateUserService service;

    @PostMapping("/register")
    public CertificateUser registerUser(@RequestBody CertificateUser user) {
        return service.registerUser(user);
    }

    @PostMapping("/login")
    public CertificateUser loginUser(@RequestBody CertificateUser user) {
        return service.loginUser(user.getEmail(), user.getPassword());
    }

    @GetMapping("/getAllUsers")
    public List<CertificateUser> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public CertificateUser getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }
}