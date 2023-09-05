package com.example.agebloomersbackend.controller;

        import com.example.agebloomersbackend.domain.*;
        import com.example.agebloomersbackend.service.CareInfoManageService;
        import com.example.agebloomersbackend.service.MatchManageService;
        import lombok.RequiredArgsConstructor;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MatchManageController {

    private MatchManageService matchManageService;

    @Autowired
    public MatchManageController(MatchManageService matchManageService) {
        this.matchManageService = matchManageService;
    }

//    @PutMapping("/edit/matchingstatus")
//    public ResponseEntity<String> updateBMatchStatus(
//            @PathVariable Long applicant_id,
//            @PathVariable Long registrant_id,
//            @PathVariable String type,
//            @PathVariable Boolean status
//    ) {
//        try {
//            matchManageService.updateBMatchStatus(applicant_id, registrant_id, type, status);
//            return new ResponseEntity<>("정보 수정 성공", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("정보 수정 오류", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
