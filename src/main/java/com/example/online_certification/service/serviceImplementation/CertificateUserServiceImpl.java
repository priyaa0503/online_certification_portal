package com.example.online_certification.service.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_certification.model.CertificateUser;
import com.example.online_certification.repository.CertificateUserRepository;
import com.example.online_certification.service.CertificateUserService;

@Service
public class CertificateUserServiceImpl implements CertificateUserService {

    @Autowired
    private CertificateUserRepository repository;

    @Override
    public CertificateUser registerUser(CertificateUser user) {

        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("STUDENT");
        }

        return repository.save(user);
    }

    @Override
    public CertificateUser loginUser(String email, String password) {

        Optional<CertificateUser> optionalUser = repository.findByEmail(email);

        if (optionalUser.isPresent()) {

            CertificateUser user = optionalUser.get();

            if (user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public List<CertificateUser> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public CertificateUser getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }
}