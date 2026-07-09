package com.example.online_certification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.online_certification.model.CertificateRequest;
import com.example.online_certification.service.CertificateUserService;
import com.example.online_certification.service.CertificateService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ApiController {

    @Autowired
    private CertificateService service;
    @PostMapping("/addRequest")
    public CertificateRequest addRequest(@RequestBody CertificateRequest request) {
        return service.addRequest(request);
    }
    @GetMapping("/getAllRequests")
    public List<CertificateRequest> getAllRequests() {
        return service.getAllRequests();
    }
    @PutMapping("/approveRequest/{id}")
    public CertificateRequest approveRequest(@PathVariable Long id) {
        return service.approveRequest(id);
    }
}