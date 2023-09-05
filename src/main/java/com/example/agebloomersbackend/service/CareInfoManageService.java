package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.*;
import com.example.agebloomersbackend.repository.*;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    public List<String> uploadCareInfo(String type, CareInfoManage careInfoManage) {
        switch (type) {
            case "Babysitters":
                Babysitters newbabysitters = new Babysitters();
                newbabysitters.setName(careInfoManage.getName());
                newbabysitters.setAge(careInfoManage.getAge());
                newbabysitters.setGender(careInfoManage.getGender());
                newbabysitters.setAddress(careInfoManage.getAddress());
                newbabysitters.setContact(careInfoManage.getContact());
                newbabysitters.setEmail(careInfoManage.getEmail());
                newbabysitters.setPassword(careInfoManage.getPassword());
                babysittersRepository.save(newbabysitters);
                break;
            case "Caregivers":
                Caregivers newcaregivers = new Caregivers();
                newcaregivers.setName(careInfoManage.getName());
                newcaregivers.setAge(careInfoManage.getAge());
                newcaregivers.setGender(careInfoManage.getGender());
                newcaregivers.setAddress(careInfoManage.getAddress());
                newcaregivers.setContact(careInfoManage.getContact());
                newcaregivers.setEmail(careInfoManage.getEmail());
                newcaregivers.setPassword(careInfoManage.getPassword());
                caregiversRepository.save(newcaregivers);
                break;
            case "Parents":
                Parents newparents = new Parents();
                newparents.setName(careInfoManage.getName());
                newparents.setAge(careInfoManage.getAge());
                newparents.setGender(careInfoManage.getGender());
                newparents.setAddress(careInfoManage.getAddress());
                newparents.setContact(careInfoManage.getContact());
                newparents.setEmail(careInfoManage.getEmail());
                newparents.setPassword(careInfoManage.getPassword());
                parentsRepository.save(newparents);
                break;
            case "Elders":
                Elders newelders = new Elders();
                newelders.setName(careInfoManage.getName());
                newelders.setAge(careInfoManage.getAge());
                newelders.setGender(careInfoManage.getGender());
                newelders.setAddress(careInfoManage.getAddress());
                newelders.setContact(careInfoManage.getContact());
                newelders.setEmail(careInfoManage.getEmail());
                newelders.setPassword(careInfoManage.getPassword());
                eldersRepository.save(newelders);
                break;
            default:
                return List.of();
        }
        return List.of();
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
    public List<String> updateCareInfo(Long id, String type, CareInfoManage careInfoManage) {
        switch (type) {
            case "Babysitters":
                Babysitters babysitters = babysittersRepository.findById(id).orElse(null);
                babysitters.setName(careInfoManage.getName());
                babysitters.setAge(careInfoManage.getAge());
                babysitters.setGender(careInfoManage.getGender());
                babysitters.setAddress(careInfoManage.getAddress());
                babysitters.setContact(careInfoManage.getContact());
                babysitters.setEmail(careInfoManage.getEmail());
                babysitters.setPassword(careInfoManage.getPassword());
                babysittersRepository.save(babysitters);
                break;
            case "Caregivers":
                Caregivers caregivers = caregiversRepository.findById(id).orElse(null);
                caregivers.setName(careInfoManage.getName());
                caregivers.setAge(careInfoManage.getAge());
                caregivers.setGender(careInfoManage.getGender());
                caregivers.setAddress(careInfoManage.getAddress());
                caregivers.setContact(careInfoManage.getContact());
                caregivers.setEmail(careInfoManage.getEmail());
                caregivers.setPassword(careInfoManage.getPassword());
                caregiversRepository.save(caregivers);
                break;
            case "Parents":
                Parents parents = parentsRepository.findById(id).orElse(null);
                parents.setName(careInfoManage.getName());
                parents.setAge(careInfoManage.getAge());
                parents.setGender(careInfoManage.getGender());
                parents.setAddress(careInfoManage.getAddress());
                parents.setContact(careInfoManage.getContact());
                parents.setEmail(careInfoManage.getEmail());
                parents.setPassword(careInfoManage.getPassword());
                parentsRepository.save(parents);
                break;
            case "Elders":
                Elders elders = eldersRepository.findById(id).orElse(null);
                elders.setName(careInfoManage.getName());
                elders.setAge(careInfoManage.getAge());
                elders.setGender(careInfoManage.getGender());
                elders.setAddress(careInfoManage.getAddress());
                elders.setContact(careInfoManage.getContact());
                elders.setEmail(careInfoManage.getEmail());
                elders.setPassword(careInfoManage.getPassword());
                eldersRepository.save(elders);
                break;
            default:
                return List.of();
        }
        return List.of();
    }
}
