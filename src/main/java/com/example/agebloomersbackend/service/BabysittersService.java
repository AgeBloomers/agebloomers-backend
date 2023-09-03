package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.repository.BabysittersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BabysittersService {
    @Autowired
    private BabysittersRepository babysittersRepository;

    @Autowired
    public BabysittersService(BabysittersRepository babysittersRepository) {
        this.babysittersRepository = babysittersRepository;
    }

    public List<Babysitters> getAllBabysitters() {
        return babysittersRepository.findAll();
    }

    public Babysitters createBabysitter(Babysitters babysitters) {
        return babysittersRepository.save(babysitters);
    }
}
