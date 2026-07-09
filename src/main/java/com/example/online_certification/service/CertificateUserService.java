package com.example.online_certification.service;

import java.util.List;

import com.example.online_certification.model.CertificateUser;

public interface CertificateUserService {

    CertificateUser registerUser(CertificateUser user);

    CertificateUser loginUser(String email, String password);

    List<CertificateUser> getAllUsers();

    CertificateUser getUserById(Long id);
}