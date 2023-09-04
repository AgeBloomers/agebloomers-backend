package com.example.agebloomersbackend.controller;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.domain.Caregivers;
import com.example.agebloomersbackend.domain.Elders;
import com.example.agebloomersbackend.domain.Parents;
import com.example.agebloomersbackend.service.CareInfoManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/careinfo")
public class CareInfoManageController {

    private CareInfoManageService careInfoManageService; // CareInfoManageService는 사람 정보를 다루는 서비스 클래스

    @Autowired
    public CareInfoManageController(CareInfoManageService careInfoManageService) {
        this.careInfoManageService = careInfoManageService;
    }

    @PostMapping("/babysitters")
    public ResponseEntity<Babysitters> createBabysitter(@RequestBody Babysitters babysitters) {
        Babysitters createdBabysitters = careInfoManageService.createBabysitter(babysitters);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBabysitters);
    }


    @PostMapping("/parents")
    public ResponseEntity<Parents> createParent(@RequestBody Parents parents) {
        Parents createdParents = careInfoManageService.createParent(parents);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdParents);
    }

    @PostMapping("/caregivers")
    public ResponseEntity<Caregivers> createCaregiver(@RequestBody Caregivers caregivers) {
        Caregivers createdCaregivers = careInfoManageService.createCaregiver(caregivers);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCaregivers);
    }

    @PostMapping("/elders")
    public ResponseEntity<Elders> createElder(@RequestBody Elders elders) {
        Elders createdElders = careInfoManageService.createElder(elders);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdElders);
    }

    @DeleteMapping("/delete/{type}/{id}")
    public List<String> deleteCareInfoByIdAndType(
            @PathVariable Long id,
            @PathVariable String type
    ) {
        return careInfoManageService.deleteCareInfoByIdAndType(id, type);
    }

}
