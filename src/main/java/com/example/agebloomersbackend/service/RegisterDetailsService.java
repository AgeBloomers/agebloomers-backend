package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.RegisterDetails;
import com.example.agebloomersbackend.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterDetailsService {
    private RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    public RegisterDetailsService(RegisterDetailsRepository registerDetailsRepository) {
        this.registerDetailsRepository = registerDetailsRepository;
    }

    public List<Object[]> getRegisterDetailsByIdAndType(Long id, String type) {
        switch (type) {
            case "babysitters":
                return registerDetailsRepository.findByBabysitterId(id);
            case "caregivers":
                return registerDetailsRepository.findByCaregiverId(id);
            case "elders":
                return registerDetailsRepository.findByElderId(id);
            case "parents":
                return registerDetailsRepository.findByParentId(id);
            default:
                return List.of();
        }
    }
}
