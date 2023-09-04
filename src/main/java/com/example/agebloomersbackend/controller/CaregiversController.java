package com.example.agebloomersbackend.controller;

import com.example.agebloomersbackend.domain.Caregivers;
import com.example.agebloomersbackend.service.CaregiversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/caregivers")
public class CaregiversController {
    private final CaregiversService caregiversService;

    @Autowired
    public CaregiversController(CaregiversService caregiversService) {
        this.caregiversService = caregiversService;
    }

    @PostMapping
    public ResponseEntity<Caregivers> createCaregiver(@RequestBody Caregivers caregivers) {
        Caregivers createdCaregivers = caregiversService.createCaregiver(caregivers);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCaregivers);
    }

    @GetMapping
    public ResponseEntity<List<Caregivers>> getAllCaregivers() {
        List<Caregivers> caregiversList = caregiversService.getAllCaregivers();
        return ResponseEntity.ok(caregiversList);
    }
}
