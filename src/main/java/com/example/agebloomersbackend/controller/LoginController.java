package com.example.agebloomersbackend.controller;

import com.example.agebloomersbackend.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Base64;

@RestController
@RequestMapping("/api")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @Transactional
    @PostMapping("/login/{name}/{password}")
    @Operation(summary = "로그인 및 마이페이지 조회 API")
    public ResponseEntity<Object> login(@PathVariable String name,
                                        @PathVariable String password) {

        byte[] decodedBytes = Base64.getDecoder().decode(password);
        String decodedPassword = new String(decodedBytes);

        Object user = loginService.login(name, decodedPassword);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}