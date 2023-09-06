package com.example.agebloomersbackend.controller;

import com.example.agebloomersbackend.domain.*;
import com.example.agebloomersbackend.service.CareInfoManageService;
import io.swagger.v3.oas.annotations.Operation;
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

    // 등록
    @PostMapping("/upload/{type}")
    @Operation(summary = "자신 정보 등록 API")
    public ResponseEntity<String> updateCareInfo(
            @PathVariable String type,
            @RequestBody CareInfoManage careInfoManage
    ) {
        try {
            careInfoManageService.uploadCareInfo(type, careInfoManage);
            return new ResponseEntity<>("정보 등록 성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("정보 등록 오류", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 삭제
    @DeleteMapping("/delete/{type}/{id}")
    @Operation(summary = "자신 정보 삭제 API")
    public List<String> deleteCareInfoByIdAndType(
            @PathVariable Long id,
            @PathVariable String type
    ) {
        return careInfoManageService.deleteCareInfoByIdAndType(id, type);
    }

    // 수정
    @PutMapping("/edit/{type}/{id}")
    @Operation(summary = "자신 정보 수정 조회 API")
    public ResponseEntity<String> updateCareInfo(
            @PathVariable Long id,
            @PathVariable String type,
            @RequestBody CareInfoManage careInfoManage
    ) {
        try {
            careInfoManageService.updateCareInfo(id, type, careInfoManage);
            return new ResponseEntity<>("정보 수정 성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("정보 수정 오류", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
