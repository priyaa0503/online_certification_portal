package com.example.online_certification.service;

import java.util.List;

import com.example.online_certification.model.CertificateRequest;

public interface CertificateService {

    CertificateRequest addRequest(CertificateRequest request);

    List<CertificateRequest> getAllRequests();

    CertificateRequest approveRequest(Long id);
}