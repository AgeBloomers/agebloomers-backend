package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.*;
import com.example.agebloomersbackend.repository.*;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CareInfoManageService {
    private BabysittersRepository babysittersRepository;
    private ParentsRepository parentsRepository;
    private CaregiversRepository caregiversRepository;
    private EldersRepository eldersRepository;
//    private careInfoRepository careInfoRepository;

    @Autowired
    public CareInfoManageService(BabysittersRepository babysittersRepository, ParentsRepository parentsRepository,
                                 CaregiversRepository caregiversRepository, EldersRepository eldersRepository) {
        this.babysittersRepository = babysittersRepository;
        this.parentsRepository = parentsRepository;
        this.caregiversRepository = caregiversRepository;
        this.eldersRepository = eldersRepository;
//        this.careInfoRepository = careInfoRepository;
    }

    // 등록
    public Babysitters createBabysitter(Babysitters babysitters) {
        return babysittersRepository.save(babysitters);
    }

    public Caregivers createCaregiver(Caregivers caregiver) {
        return caregiversRepository.save(caregiver);
    }

    public Elders createElder(Elders elder) {
        return eldersRepository.save(elder);
    }

    public Parents createParent(Parents parent) {
        return parentsRepository.save(parent);
    }

    // 삭제
    public List<String> deleteCareInfoByIdAndType(Long id, String type) {
        switch (type) {
            case "Babysitters":
                Babysitters babysitters = babysittersRepository.findById(id).orElse(null);
                babysittersRepository.delete(babysitters);
            case "Caregivers":
                Caregivers caregivers = caregiversRepository.findById(id).orElse(null);
                caregiversRepository.delete(caregivers);
            case "Elders":
                Elders elders = eldersRepository.findById(id).orElse(null);
                eldersRepository.delete(elders);
            case "Parents":
                Parents parents = parentsRepository.findById(id).orElse(null);
                parentsRepository.delete(parents);
            default:
                return List.of();
        }
    }

    // 수정
    public List<String> updateCareInfo(Long id, String type, CareInfo careInfo) {
        switch (type) {
            case "Parents":
                Parents parents = parentsRepository.findById(id).orElse(null);
                parents.setName(careInfo.getName());
                parents.setAge(careInfo.getAge());
                parents.setGender(careInfo.getGender());
                parents.setAddress(careInfo.getAddress());
                parents.setContact(careInfo.getContact());
                parents.setEmail(careInfo.getEmail());
                parents.setPassword(careInfo.getPassword());
                parentsRepository.save(parents);
            default:
                return List.of();
        }
    }
}
