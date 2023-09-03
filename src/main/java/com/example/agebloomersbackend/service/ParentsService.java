package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.domain.Parents;
import com.example.agebloomersbackend.repository.BabysittersRepository;
import com.example.agebloomersbackend.repository.ParentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentsService {
    private ParentsRepository parentsRepository;

    @Autowired
    public ParentsService(ParentsRepository parentsRepository) {
        this.parentsRepository = parentsRepository;
    }

    public List<Parents> getAllParents() {
        return parentsRepository.findAll();
    }

    public Parents createParent(Parents parent) {
        return parentsRepository.save(parent);
    }
}
