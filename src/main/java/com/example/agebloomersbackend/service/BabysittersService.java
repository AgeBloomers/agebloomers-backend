package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.domain.Elders;
import com.example.agebloomersbackend.repository.BabysittersRepository;
import com.example.agebloomersbackend.repository.BabysitterMatchRepository;
import com.example.agebloomersbackend.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BabysittersService {
    private BabysittersRepository babysittersRepository;
    private BabysitterMatchRepository babysitterMatchRepository;
    private RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    public BabysittersService(BabysittersRepository babysittersRepository, BabysitterMatchRepository babysitterMatchRepository, RegisterDetailsRepository registerDetailsRepository) {
        this.babysittersRepository = babysittersRepository;
        this.babysitterMatchRepository = babysitterMatchRepository;
        this.registerDetailsRepository = registerDetailsRepository;
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

    public Babysitters findBabysitterByNameAndPassword(String name, String password) {
        return babysittersRepository.findByNameAndPassword(name, password);
    }

    public Object getBabysitterDetails(Long babysitterId) {
        Babysitters babysitters = babysittersRepository.findById(babysitterId).orElse(null);
        if (babysitters == null) {
            return null;
        }

        List<Object[]> registerDetails = registerDetailsRepository.findByBabysitterId(babysitterId);

        Map<String, Object> result = new HashMap<>();
        result.put("babysitters", babysitters);
        result.put("registerDetails", registerDetails);

        return result;
    }
}
