package com.example.agebloomersbackend.controller;

import com.example.agebloomersbackend.domain.BabysitterMatch;
import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.domain.Parents;
import com.example.agebloomersbackend.service.BabysitterMatchService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
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
public class BabysitterMatchController {
    private BabysitterMatchService babysitterMatchService;

    @Autowired
    public BabysitterMatchController(BabysitterMatchService babysitterMatchService) {
        this.babysitterMatchService = babysitterMatchService;
    }

    @Transactional
    @PostMapping("/babysitter_match")
    @Operation(summary = "베이비시터-부모 매칭 신청 API")
    public ResponseEntity<BabysitterMatch> createBabysitterMatch(
            @RequestParam String proposer,
            @RequestParam Long babysitterId,
            @RequestParam Long parentId
    ) {
        BabysitterMatch createdMatch = babysitterMatchService.createBabysitterMatch(proposer, babysitterId, parentId);

        return new ResponseEntity<>(createdMatch, HttpStatus.CREATED);
    }
}
