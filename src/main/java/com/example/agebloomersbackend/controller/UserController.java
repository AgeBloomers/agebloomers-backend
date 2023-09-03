package com.example.agebloomersbackend.controller;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.domain.Caregivers;
import com.example.agebloomersbackend.domain.Elders;
import com.example.agebloomersbackend.domain.Parents;
import com.example.agebloomersbackend.service.BabysittersService;
import com.example.agebloomersbackend.service.CaregiversService;
import com.example.agebloomersbackend.service.EldersService;
import com.example.agebloomersbackend.service.ParentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private BabysittersService babysittersService;
    private ParentsService parentsService;
    private CaregiversService caregiversService;
    private EldersService eldersService;

    @Autowired
    public UserController(BabysittersService babysittersService, ParentsService parentsService, CaregiversService caregiversService, EldersService eldersService) {
        this.babysittersService = babysittersService;
        this.parentsService = parentsService;
        this.caregiversService = caregiversService;
        this.eldersService = eldersService;
    }

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

    @PostMapping("/elders")
    public ResponseEntity<Elders> createElder(@RequestBody Elders elders) {
        Elders createdElders = eldersService.createElder(elders);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdElders);
    }

    @GetMapping("/babysitters")
    public ResponseEntity<List<Babysitters>> getAllBabysitters() {
        List<Babysitters> babysittersList = babysittersService.getAllBabysitters();
        return ResponseEntity.ok(babysittersList);
    }

    @GetMapping("/parents")
    public ResponseEntity<List<Parents>> getAllParents() {
        List<Parents> parentsList = parentsService.getAllParents();
        return ResponseEntity.ok(parentsList);
    }

}
