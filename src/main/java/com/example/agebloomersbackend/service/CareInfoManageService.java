package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.domain.Caregivers;
import com.example.agebloomersbackend.domain.Elders;
import com.example.agebloomersbackend.domain.Parents;
import com.example.agebloomersbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CareInfoManageService {
    private BabysittersRepository babysittersRepository;
    private ParentsRepository parentsRepository;
    private CaregiversRepository caregiversRepository;
    private EldersRepository eldersRepository;

    @Autowired
    public CareInfoManageService(BabysittersRepository babysittersRepository, ParentsRepository parentsRepository,
                                 CaregiversRepository caregiversRepository, EldersRepository eldersRepository) {
        this.babysittersRepository = babysittersRepository;
        this.parentsRepository = parentsRepository;
        this.caregiversRepository = caregiversRepository;
        this.eldersRepository = eldersRepository;
    }

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
}
