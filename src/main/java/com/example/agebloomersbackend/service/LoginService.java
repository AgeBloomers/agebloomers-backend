package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.domain.Caregivers;
import com.example.agebloomersbackend.domain.Elders;
import com.example.agebloomersbackend.domain.Parents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final BabysittersService babysittersService;
    private final CaregiversService caregiversService;
    private final EldersService eldersService;
    private final ParentsService parentsService;

    @Autowired
    public LoginService(BabysittersService babysittersService, CaregiversService caregiversService,
                        EldersService eldersService, ParentsService parentsService) {
        this.babysittersService = babysittersService;
        this.caregiversService = caregiversService;
        this.eldersService = eldersService;
        this.parentsService = parentsService;
    }

    public Object login(String name, String password) {
        Object result = null;

        Babysitters babysitter = babysittersService.findBabysitterByNameAndPassword(name, password);
        if (babysitter != null) {
            result = babysittersService.getBabysitterDetails(babysitter.getId());
        }

        Caregivers caregiver = caregiversService.findCaregiverByNameAndPassword(name, password);
        if (caregiver != null) {
            result = caregiversService.getCaregiverDetails(caregiver.getId());
        }

        Elders elder = eldersService.findElderByNameAndPassword(name, password);
        if (elder != null) {
            result = eldersService.getElderDetails(elder.getId());
        }

        Parents parent = parentsService.findParentByNameAndPassword(name, password);
        if (parent != null) {
            result = parentsService.getParentDetails(parent.getId());
        }

        return result;
    }
}
