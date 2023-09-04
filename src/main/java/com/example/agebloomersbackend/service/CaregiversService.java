package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Caregivers;
import com.example.agebloomersbackend.repository.CaregiversRepository;
import com.example.agebloomersbackend.repository.CaregiverMatchRepository;
import com.example.agebloomersbackend.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CaregiversService {
    private CaregiversRepository caregiversRepository;
    private CaregiverMatchRepository caregiverMatchRepository;
    private RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    public CaregiversService(CaregiversRepository caregiversRepository, CaregiverMatchRepository caregiverMatchRepository, RegisterDetailsRepository registerDetailsRepository) {
        this.caregiversRepository = caregiversRepository;
        this.caregiverMatchRepository = caregiverMatchRepository;
        this.registerDetailsRepository = registerDetailsRepository;
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

    public Object getCaregiverDetails(Long caregiverId) {
        Caregivers caregivers = caregiversRepository.findById(caregiverId).orElse(null);
        if (caregivers == null) {
            return null;
        }

        List<Object[]> registerDetails = registerDetailsRepository.findByCaregiverId(caregiverId);

        Map<String, Object> result = new HashMap<>();
        result.put("caregivers", caregivers);
        result.put("registerDetails", registerDetails);

        return result;
    }
}