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
        if (babysitter != null && result == null) {
            result = babysittersService.getBabysitterDetails(babysitter.getId());
            System.out.println("babysitter called");
        }
        System.out.println("베이비시터 result~");
        System.out.println(result);

        Caregivers caregiver = caregiversService.findCaregiverByNameAndPassword(name, password);
        if (caregiver != null && result == null) {
            result = caregiversService.getCaregiverDetails(caregiver.getId());
            System.out.println("cargiver called");
        }
        System.out.println("케어기버 result~");
        System.out.println(result);

        Elders elder = eldersService.findElderByNameAndPassword(name, password);
        if (elder != null && result == null) {
            result = eldersService.getElderDetails(elder.getId());
            System.out.println("elder called");
        }
        System.out.println("노인 result~");
        System.out.println(result);

        Parents parent = parentsService.findParentByNameAndPassword(name, password);
        if (parent != null && result == null) {
            result = parentsService.getParentDetails(parent.getId());
            System.out.println("parent called");
        }
        System.out.println("부모 result~");
        System.out.println(result);

        System.out.println("total result~");
        System.out.println(result);
        return result;
    }
}
