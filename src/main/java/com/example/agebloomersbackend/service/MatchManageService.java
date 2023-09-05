package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.*;
import com.example.agebloomersbackend.repository.BabysitterMatchRepository;
import com.example.agebloomersbackend.repository.CaregiverMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchManageService {
    private BabysitterMatchRepository babysitterMatchRepository;
    private CaregiverMatchRepository caregiverMatchRepository;

    @Autowired
    public MatchManageService(BabysitterMatchRepository babysitterMatchRepository,
                              CaregiverMatchRepository caregiverMatchRepository) {
        this.babysitterMatchRepository = babysitterMatchRepository;
        this.caregiverMatchRepository = caregiverMatchRepository;
    }

    public List<Object> updateCaregiverMatch(Long registrantId, String type, Boolean status) {
        switch (type) {
            case "Caregivers":
                List<CaregiverMatch> Cmatches = caregiverMatchRepository.findByTypeAndCaregiverId(type, registrantId);

                if (!Cmatches.isEmpty()) {
                    for (CaregiverMatch match : Cmatches) {
                        // status : 0 -> 레코드 삭제, 1 -> Completed로 업데이트
                        if (status) {
                            match.setStatus("Completed");
                            caregiverMatchRepository.save(match);
                        } else{
                            caregiverMatchRepository.delete(match);
                        }
                    }
                }
                break;
            case "Elders":
                List<CaregiverMatch> Ematches = caregiverMatchRepository.findByTypeAndElderId(type, registrantId);

                if (!Ematches.isEmpty()) {
                    for (CaregiverMatch match : Ematches) {
                        if (status) {
                            match.setStatus("Completed");
                            caregiverMatchRepository.save(match);
                        } else{
                            caregiverMatchRepository.delete(match);
                        }
                    }
                }
                break;
            case "Babysitters":
                List<BabysitterMatch> Bmatches = babysitterMatchRepository.findByTypeAndBabysitterId(type, registrantId);

                if (!Bmatches.isEmpty()) {
                    for (BabysitterMatch match : Bmatches) {
                        if (status) {
                            match.setStatus("Completed");
                            babysitterMatchRepository.save(match);
                        } else{
                            babysitterMatchRepository.delete(match);
                        }
                    }
                }
                break;
            case "Parents":
                List<BabysitterMatch> Pmatches = babysitterMatchRepository.findByTypeAndParentId(type, registrantId);

                if (!Pmatches.isEmpty()) {
                    for (BabysitterMatch match : Pmatches) {
                        if (status) {
                            match.setStatus("Completed");
                            babysitterMatchRepository.save(match);
                        } else{
                            babysitterMatchRepository.delete(match);
                        }
                    }
                }
                break;
            default:
                return List.of();
        }
        return List.of();
    }
}
