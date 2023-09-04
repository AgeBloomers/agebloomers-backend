package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.CaregiverMatch;
import com.example.agebloomersbackend.repository.CaregiverMatchRepository;
import com.example.agebloomersbackend.repository.CaregiversRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CaregiverMatchService {
    private CaregiverMatchRepository caregiverMatchRepository;

    @Autowired
    public CaregiverMatchService(CaregiverMatchRepository caregiverMatchRepository) {
        this.caregiverMatchRepository = caregiverMatchRepository;
    }

    public CaregiverMatch createCaregiverMatch(String proposer, Long caregiverId, Long elderId) {
        CaregiverMatch match = new CaregiverMatch();
        match.setProposer(proposer);
        match.setCaregiverId(caregiverId);
        match.setElderId(elderId);
        match.setStatus("Pending");
        match.setMatchDate(new Date());

        return caregiverMatchRepository.save(match);
    }
}
