package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.*;
import com.example.agebloomersbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareInfoManageService {
    private BabysittersRepository babysittersRepository;
    private ParentsRepository parentsRepository;
    private CaregiversRepository caregiversRepository;
    private EldersRepository eldersRepository;
    private RegisterDetailsRepository registerDetailsRepository;
//    private careInfoRepository careInfoRepository;

    @Autowired
    public CareInfoManageService(BabysittersRepository babysittersRepository, ParentsRepository parentsRepository,
                                 CaregiversRepository caregiversRepository, EldersRepository eldersRepository,
                                 RegisterDetailsRepository registerDetailsRepository) {
        this.babysittersRepository = babysittersRepository;
        this.parentsRepository = parentsRepository;
        this.caregiversRepository = caregiversRepository;
        this.eldersRepository = eldersRepository;
        this.registerDetailsRepository = registerDetailsRepository;
//        this.careInfoRepository = careInfoRepository;
    }

    // 등록
    public String uploadCareInfo(String type, CareInfoManage careInfoManage) {
        switch (type) {
            case "Babysitters":
                Babysitters newbabysitters = new Babysitters();
                RegisterDetails newBDetails = new RegisterDetails();
                newbabysitters.setName(careInfoManage.getName());
                newbabysitters.setAge(careInfoManage.getAge());
                newbabysitters.setGender(careInfoManage.getGender());
                newbabysitters.setAddress(careInfoManage.getAddress());
                newbabysitters.setContact(careInfoManage.getContact());
                newbabysitters.setEmail(careInfoManage.getEmail());
                newbabysitters.setPassword(careInfoManage.getPassword());
                babysittersRepository.save(newbabysitters);

                Long babysitterId = newbabysitters.getId();
                newBDetails.setBabysitterId(babysitterId);
                newBDetails.setRegisterDate(careInfoManage.getRegisterDate());
                newBDetails.setComment(careInfoManage.getComment());
                newBDetails.setStartTime(careInfoManage.getStartTime());
                newBDetails.setEndTime(careInfoManage.getEndTime());
                registerDetailsRepository.save(newBDetails);
                return type;
//                break;

            case "Caregivers":
                Caregivers newcaregivers = new Caregivers();
                RegisterDetails newCDetails = new RegisterDetails();
                newcaregivers.setName(careInfoManage.getName());
                newcaregivers.setAge(careInfoManage.getAge());
                newcaregivers.setGender(careInfoManage.getGender());
                newcaregivers.setAddress(careInfoManage.getAddress());
                newcaregivers.setContact(careInfoManage.getContact());
                newcaregivers.setEmail(careInfoManage.getEmail());
                newcaregivers.setPassword(careInfoManage.getPassword());
                caregiversRepository.save(newcaregivers);

                Long caregiverId = newcaregivers.getId();
                newCDetails.setCaregiverId(caregiverId);
                newCDetails.setRegisterDate(careInfoManage.getRegisterDate());
                newCDetails.setComment(careInfoManage.getComment());
                newCDetails.setStartTime(careInfoManage.getStartTime());
                newCDetails.setEndTime(careInfoManage.getEndTime());
                registerDetailsRepository.save(newCDetails);
                return type;

            case "Parents":
                Parents newparents = new Parents();
                RegisterDetails newPDetails = new RegisterDetails();
                newparents.setName(careInfoManage.getName());
                newparents.setAge(careInfoManage.getAge());
                newparents.setGender(careInfoManage.getGender());
                newparents.setAddress(careInfoManage.getAddress());
                newparents.setContact(careInfoManage.getContact());
                newparents.setEmail(careInfoManage.getEmail());
                newparents.setPassword(careInfoManage.getPassword());
                parentsRepository.save(newparents);

                Long parentId = newparents.getId();
                newPDetails.setParentId(parentId);
                newPDetails.setRegisterDate(careInfoManage.getRegisterDate());
                newPDetails.setComment(careInfoManage.getComment());
                newPDetails.setStartTime(careInfoManage.getStartTime());
                newPDetails.setEndTime(careInfoManage.getEndTime());
                registerDetailsRepository.save(newPDetails);
                return type;

            case "Elders":
                Elders newelders = new Elders();
                RegisterDetails newEDetails = new RegisterDetails();
                newelders.setName(careInfoManage.getName());
                newelders.setAge(careInfoManage.getAge());
                newelders.setGender(careInfoManage.getGender());
                newelders.setAddress(careInfoManage.getAddress());
                newelders.setContact(careInfoManage.getContact());
                newelders.setEmail(careInfoManage.getEmail());
                newelders.setPassword(careInfoManage.getPassword());
                eldersRepository.save(newelders);

                Long elderId = newelders.getId();
                newEDetails.setElderId(elderId);
                newEDetails.setRegisterDate(careInfoManage.getRegisterDate());
                newEDetails.setComment(careInfoManage.getComment());
                newEDetails.setStartTime(careInfoManage.getStartTime());
                newEDetails.setEndTime(careInfoManage.getEndTime());
                registerDetailsRepository.save(newEDetails);
                return type;

            default:
                return null;
        }
    }

    // 삭제
    public List<String> deleteCareInfoByIdAndType(Long id, String type) {
        switch (type) {
            case "Babysitters":
                Babysitters babysitters = babysittersRepository.findById(id).orElse(null);
                babysittersRepository.delete(babysitters);
                break;
            case "Caregivers":
                Caregivers caregivers = caregiversRepository.findById(id).orElse(null);
                caregiversRepository.delete(caregivers);
                break;
            case "Elders":
                Elders elders = eldersRepository.findById(id).orElse(null);
                eldersRepository.delete(elders);
                break;
            case "Parents":
                Parents parents = parentsRepository.findById(id).orElse(null);
                parentsRepository.delete(parents);
                break;
            default:
                return List.of();
        }
        return List.of();
    }

    // 수정
    public String updateCareInfo(Long id, String type, CareInfoManage careInfoManage) {
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
                return "베이비시터 수정 성공";
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
                return "요양보호사 수정 성공";
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
                return "부모 수정 성공";
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
                return "노인 수정 성공";
            default:
                return null;
        }
    }
}
