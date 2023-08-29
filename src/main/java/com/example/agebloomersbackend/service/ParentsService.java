package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Parents;
import com.example.agebloomersbackend.repository.ParentsRepository;
import org.springframework.stereotype.Service;

@Service
public class ParentsService {
    private ParentsRepository parentsRepository;

    public Parents createParent(Parents parent) {
        return parentsRepository.save(parent);
    }
}
