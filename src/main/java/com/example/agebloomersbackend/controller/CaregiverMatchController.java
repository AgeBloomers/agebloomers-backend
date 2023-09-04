package com.example.agebloomersbackend.controller;

import com.example.agebloomersbackend.domain.CaregiverMatch;
import com.example.agebloomersbackend.service.CaregiverMatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CaregiverMatchController {
    private CaregiverMatchService caregiverMatchService;

    @Autowired
    public CaregiverMatchController(CaregiverMatchService caregiverMatchService) {
        this.caregiverMatchService = caregiverMatchService;
    }

    @PostMapping("/caregiver_match")
    public ResponseEntity<CaregiverMatch> createCaregiverMatch(
            @RequestParam String proposer,
            @RequestParam Long caregiverId,
            @RequestParam Long elderId
    ) {
        CaregiverMatch createMatch = caregiverMatchService.createCaregiverMatch(proposer, caregiverId, elderId);

        return new ResponseEntity<>(createMatch, HttpStatus.CREATED);
    }
}
