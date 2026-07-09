package com.example.online_certification.service.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_certification.model.CertificateRequest;
import com.example.online_certification.repository.CertificateRequestRepository;
import com.example.online_certification.service.CertificateService;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateRequestRepository repository;

    @Override
    public CertificateRequest addRequest(CertificateRequest request) {

        if (request.getStatus() == null || request.getStatus().isEmpty()) {
            request.setStatus("PENDING");
        }

        return repository.save(request);
    }

    @Override
    public List<CertificateRequest> getAllRequests() {
        return repository.findAll();
    }

    @Override
    public CertificateRequest approveRequest(Long id) {

        CertificateRequest request = repository.findById(id).orElse(null);

        if (request != null) {
            request.setStatus("APPROVED");
            return repository.save(request);
        }

        return null;
    }
}