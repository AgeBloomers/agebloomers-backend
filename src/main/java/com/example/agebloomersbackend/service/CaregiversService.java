package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Caregivers;
import com.example.agebloomersbackend.domain.Elders;
import com.example.agebloomersbackend.repository.CaregiversRepository;
import com.example.agebloomersbackend.repository.CaregiverMatchRepository;
import com.example.agebloomersbackend.repository.EldersRepository;
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
    private EldersRepository eldersRepository;
    private CaregiverMatchRepository caregiverMatchRepository;
    private RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    public CaregiversService(CaregiversRepository caregiversRepository, CaregiverMatchRepository caregiverMatchRepository, RegisterDetailsRepository registerDetailsRepository, EldersRepository eldersRepository) {
        this.caregiversRepository = caregiversRepository;
        this.eldersRepository = eldersRepository;
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
        // 본인
        Caregivers caregivers = caregiversRepository.findById(caregiverId).orElse(null);
        if (caregivers == null)     return null;

        List<Object[]> registerDetails = registerDetailsRepository.findByCaregiverId(caregiverId);

        Map<String, Object> selfResult = new HashMap<>();
        selfResult.put("caregivers", caregivers);
        selfResult.put("registerDetails", registerDetails);
        System.out.println(caregiverId);
        System.out.println(selfResult);

        // 매칭된 상대방 찾기
        Long elderId = caregiverMatchRepository.findElderIdsByCaregiverId(caregiverId);

        // 상대방
        Elders elders = eldersRepository.findById(elderId).orElse(null);
        if (elderId == null) return null;

        List<Object[]> registerDetails_elders = registerDetailsRepository.findByElderId(elderId);

        Map<String, Object> othersResult = new HashMap<>();
        othersResult.put("elders", elders);
        othersResult.put("registerDetails_elders", registerDetails_elders);
        System.out.println(elderId);
        System.out.println(othersResult);

        // selfResult와 othersResult 합침
        Map<String, Object> result = new HashMap<>();
        result.putAll(selfResult);
        result.putAll(othersResult);

        return result;
    }
}