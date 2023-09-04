package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Caregivers;
import com.example.agebloomersbackend.repository.CaregiversRepository;
import com.example.agebloomersbackend.repository.CaregiverMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaregiversService {
    private CaregiversRepository caregiversRepository;
    private CaregiverMatchRepository caregiverMatchRepository;

    @Autowired
    public CaregiversService(CaregiversRepository caregiversRepository, CaregiverMatchRepository caregiverMatchRepository) {
        this.caregiversRepository = caregiversRepository;
        this.caregiverMatchRepository = caregiverMatchRepository;
    }

    public List<Caregivers> getAllCaregivers() {
        List<Long> caregiversIdsInCaregiverMatch = getCaregiversIdsInCaregiverMatch();
        return caregiversRepository.findAll().stream()
                .filter(caregivers -> !caregiversIdsInCaregiverMatch.contains(caregivers.getId()))
                .collect(Collectors.toList());
    }

    public List<Long> getCaregiversIdsInCaregiverMatch() {
        return caregiverMatchRepository.findAllCaregiverIds();
    }

    public Caregivers createCaregiver(Caregivers caregiver) {
        return caregiversRepository.save(caregiver);
    }

    public Caregivers findCaregiverByNameAndPassword(String name, String password) {
        return caregiversRepository.findByNameAndPassword(name, password);
    }
}