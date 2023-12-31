package com.example.agebloomersbackend.controller;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.domain.Parents;
import com.example.agebloomersbackend.service.ParentsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parents")
public class ParentsController {
    private final ParentsService parentsService;

    @Autowired
    public ParentsController(ParentsService parentsService) {
        this.parentsService = parentsService;
    }

    @GetMapping
    @Operation(summary = "부모 신청자 리스트 정보 조회 API")
    public ResponseEntity<List<Parents>> getAllParents() {
        List<Parents> parentsList = parentsService.getAllParents();
        return ResponseEntity.ok(parentsList);
    }

//    @PostMapping
//    @Operation(summary = "부모 신청 API")
//    public ResponseEntity<Parents> createParent(@RequestBody Parents parents) {
//        Parents createdParents = parentsService.createParent(parents);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdParents);
//    }

}