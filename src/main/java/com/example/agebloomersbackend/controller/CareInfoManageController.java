package com.example.agebloomersbackend.controller;

import com.example.agebloomersbackend.domain.*;
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

    @PostMapping("/upload/{type}")
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

    @DeleteMapping("/delete/{type}/{id}")
    public List<String> deleteCareInfoByIdAndType(
            @PathVariable Long id,
            @PathVariable String type
    ) {
        return careInfoManageService.deleteCareInfoByIdAndType(id, type);
    }

    @PutMapping("/edit/{type}/{id}")
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
