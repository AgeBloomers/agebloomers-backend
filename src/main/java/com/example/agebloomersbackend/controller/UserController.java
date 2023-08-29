package com.example.agebloomersbackend.controller;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.domain.Caregivers;
import com.example.agebloomersbackend.domain.Parents;
import com.example.agebloomersbackend.service.BabysittersService;
import com.example.agebloomersbackend.service.CaregiversService;
import com.example.agebloomersbackend.service.ParentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private BabysittersService babysittersService;
    private ParentsService parentsService;
    private CaregiversService caregiversService;

    @PostMapping("/babysitters")
    public ResponseEntity<Babysitters> createBabysitter(@RequestBody Babysitters babysitters) {
        Babysitters createdBabysitters = babysittersService.createBabysitter(babysitters);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBabysitters);
    }

    @PostMapping("/parents")
    public ResponseEntity<Parents> createParent(@RequestBody Parents parents) {
        Parents createdParents = parentsService.createParent(parents);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdParents);
    }

    @PostMapping("/caregivers")
    public ResponseEntity<Caregivers> createCaregiver(@RequestBody Caregivers caregivers) {
        Caregivers createdCaregivers = caregiversService.createCaregiver(caregivers);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCaregivers);
    }
}
