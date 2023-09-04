package com.example.agebloomersbackend.controller;

import com.example.agebloomersbackend.domain.Elders;
import com.example.agebloomersbackend.service.EldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elders")
public class EldersController {
    private final EldersService eldersService;

    @Autowired
    public EldersController(EldersService eldersService) {
        this.eldersService = eldersService;
    }

    @PostMapping
    public ResponseEntity<Elders> createElder(@RequestBody Elders elders) {
        Elders createdElders = eldersService.createElder(elders);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdElders);
    }

    @GetMapping
    public ResponseEntity<List<Elders>> getAllElders() {
        List<Elders> eldersList = eldersService.getAllElders();
        return ResponseEntity.ok(eldersList);
    }
}