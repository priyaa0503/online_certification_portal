package com.example.online_certification.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.online_certification.model.CertificateUser;

@Repository
public interface CertificateUserRepository extends JpaRepository<CertificateUser, Long> {

    Optional<CertificateUser> findByEmail(String email);

    boolean existsByEmail(String email);

}