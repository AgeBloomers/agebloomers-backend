package com.example.agebloomersbackend.controller;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.service.BabysittersService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/babysitters")
public class BabysittersController {
    private final BabysittersService babysittersService;

    @Autowired
    public BabysittersController(BabysittersService babysittersService) {
        this.babysittersService = babysittersService;
    }

    @GetMapping
    @Operation(summary = "베이비시터 신청자 리스트 정보 조회 API")
    public ResponseEntity<List<Babysitters>> getAllBabysitters() {
        List<Babysitters> babysittersList = babysittersService.getAllBabysitters();
        return ResponseEntity.ok(babysittersList);
    }

//    @PostMapping
//    @Operation(summary = "베이비시터 신청 API")
//    public ResponseEntity<Babysitters> createBabysitter(@RequestBody Babysitters babysitters) {
//        Babysitters createdBabysitters = babysittersService.createBabysitter(babysitters);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdBabysitters);
//    }
}
