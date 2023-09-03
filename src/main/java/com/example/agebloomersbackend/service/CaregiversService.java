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

        // CaregiverMatch 테이블에서 caregivers_id 가져옴
        List<Long> caregiversIdsInCaregiverMatch = getCaregiversIdsInCaregiverMatch();

        // Caregivers 테이블에서 해당 caregivers_id와 id가 동일하지 않은 모든 레코드를 선택
        return caregiversRepository.findAll().stream()
                .filter(caregivers -> !caregiversIdsInCaregiverMatch.contains(caregivers.getId()))
                .collect(Collectors.toList());
    }

    public List<Long> getCaregiversIdsInCaregiverMatch() {
        // caregiver_matches 테이블의 caregiver_id 컬럼 값 조회
        return caregiverMatchRepository.findAllCaregiverIds();
    }

    public Caregivers createCaregiver(Caregivers caregiver) {
        return caregiversRepository.save(caregiver);
    }
}