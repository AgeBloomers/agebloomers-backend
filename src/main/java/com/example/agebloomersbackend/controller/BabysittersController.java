package com.example.agebloomersbackend.controller;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.service.BabysittersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/babysitters")
public class BabysittersController {
    private final BabysittersService babysittersService;

    @Autowired
    public BabysittersController(BabysittersService babysittersService) {
        this.babysittersService = babysittersService;
    }

    @GetMapping("/login")
    public ResponseEntity<Babysitters> login(@RequestParam String name, @RequestParam String password) {
        Babysitters babysitter = babysittersService.findBabysitterByNameAndPassword(name, password);
        if (babysitter != null) {
            return ResponseEntity.ok(babysitter);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
