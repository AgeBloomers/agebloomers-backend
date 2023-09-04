package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.repository.BabysittersRepository;
import com.example.agebloomersbackend.repository.BabysitterMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BabysittersService {
    private BabysittersRepository babysittersRepository;
    private BabysitterMatchRepository babysitterMatchRepository;

    @Autowired
    public BabysittersService(BabysittersRepository babysittersRepository, BabysitterMatchRepository babysitterMatchRepository) {
        this.babysittersRepository = babysittersRepository;
        this.babysitterMatchRepository = babysitterMatchRepository;
    }

    public List<Babysitters> getAllBabysitters() {
        List<Long> babysittersIdsInBabysitterMatch = getBabysittersIdsInBabysitterMatch();
        return babysittersRepository.findAll().stream()
                .filter(babysitters -> !babysittersIdsInBabysitterMatch.contains(babysitters.getId()))
                .collect(Collectors.toList());
    }
    public List<Long> getBabysittersIdsInBabysitterMatch() {
        return babysitterMatchRepository.findAllBabysitterIds();
    }


    public Babysitters createBabysitter(Babysitters babysitters) {
        return babysittersRepository.save(babysitters);
    }
}
