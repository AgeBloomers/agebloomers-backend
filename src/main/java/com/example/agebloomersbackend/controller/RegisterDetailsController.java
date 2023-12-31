package com.example.agebloomersbackend.controller;

import com.example.agebloomersbackend.domain.RegisterDetails;
import com.example.agebloomersbackend.service.RegisterDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RegisterDetailsController {
    private RegisterDetailsService registerDetailsService;

    @Autowired
    public RegisterDetailsController(RegisterDetailsService registerDetailsService) {
        this.registerDetailsService = registerDetailsService;
    }

    @GetMapping("/detail/{type}/{id}")
    @Operation(summary = "특정 인물 정보 조회 API")
    public List<Object[]> getRegisterDetailsByIdAndType(
            @PathVariable Long id,
            @PathVariable String type
    ) {
        System.out.println("특정 인물 정보 조회 완료");
        return registerDetailsService.getRegisterDetailsByIdAndType(id, type);
    }
}
