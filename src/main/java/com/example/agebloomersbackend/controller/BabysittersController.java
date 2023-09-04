package com.example.agebloomersbackend.controller;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.service.BabysittersService;
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
    public ResponseEntity<List<Babysitters>> getAllBabysitters() {
        List<Babysitters> babysittersList = babysittersService.getAllBabysitters();
        return ResponseEntity.ok(babysittersList);
    }

    @PostMapping
    public ResponseEntity<Babysitters> createBabysitter(@RequestBody Babysitters babysitters) {
        Babysitters createdBabysitters = babysittersService.createBabysitter(babysitters);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBabysitters);
    }
}
