package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Caregivers;
import com.example.agebloomersbackend.domain.Elders;
import com.example.agebloomersbackend.repository.CaregiverMatchRepository;
import com.example.agebloomersbackend.repository.CaregiversRepository;
import com.example.agebloomersbackend.repository.EldersRepository;
import com.example.agebloomersbackend.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EldersService {
    private EldersRepository eldersRepository;
    private CaregiversRepository caregiversRepository;
    private CaregiverMatchRepository caregiverMatchRepository;
    private RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    public EldersService(EldersRepository eldersRepository, CaregiverMatchRepository caregiverMatchRepository, RegisterDetailsRepository registerDetailsRepository, CaregiversRepository caregiversRepository) {
        this.eldersRepository = eldersRepository;
        this.caregiversRepository = caregiversRepository;
        this.caregiverMatchRepository = caregiverMatchRepository;
        this.registerDetailsRepository = registerDetailsRepository;
    }

    public List<Elders> getAllElders() {
        List<Long> eldersIdsInElderMatch = getEldersIdsInElderMatch();

        return eldersRepository.findAll().stream()
                .filter(elders -> !eldersIdsInElderMatch.contains(elders.getId()))
                .collect(Collectors.toList());
    }

    public List<Long> getEldersIdsInElderMatch() { return caregiverMatchRepository.findAllElderIds();}

    public Elders createElder(Elders elder) {
        return eldersRepository.save(elder);
    }

    public Elders findElderByNameAndPassword(String name, String password) {
        return eldersRepository.findByNameAndPassword(name,password);
    }

    public Object getElderDetails(Long elderId) {
        // 본인
        Elders elders = eldersRepository.findById(elderId).orElse(null);
        if (elders == null)     return null;

        List<Object[]> registerDetails_elders = registerDetailsRepository.findByElderId(elderId);

        Map<String, Object> selfResult = new HashMap<>();
        selfResult.put("elders", elders);
        selfResult.put("registerDetails_elders", registerDetails_elders);
        System.out.println(elderId);
        System.out.println(selfResult);

        // 매칭된 상대방 찾기
        Long caregiverId = caregiverMatchRepository.findCaregiverIdsByElderId(elderId);

        // 상대방
        Caregivers caregivers = caregiversRepository.findById(caregiverId).orElse(null);
        if (caregiverId == null) return null;

        List<Object[]> registerDetails_caregivers = registerDetailsRepository.findByCaregiverId(caregiverId);

        Map<String, Object> othersResult = new HashMap<>();
        selfResult.put("caregivers", caregivers);
        selfResult.put("registerDetails_caregivers", registerDetails_caregivers);
        System.out.println(caregiverId);
        System.out.println(selfResult);

        // selfResult와 othersResult 합침
        Map<String, Object> result = new HashMap<>();
        result.putAll(selfResult);
        result.putAll(othersResult);

        return result;
    }
}
