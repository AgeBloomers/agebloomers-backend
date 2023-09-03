package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.domain.Caregivers;
import com.example.agebloomersbackend.repository.BabysittersRepository;
import com.example.agebloomersbackend.repository.CaregiversRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaregiversService {
    private CaregiversRepository caregiversRepository;

    @Autowired
    public CaregiversService(CaregiversRepository caregiversRepository) {
        this.caregiversRepository = caregiversRepository;
    }

    public List<Caregivers> getAllCaregivers() {
        return caregiversRepository.findAll();
    }

    public Caregivers createCaregiver(Caregivers caregiver) {
        return caregiversRepository.save(caregiver);
    }
}