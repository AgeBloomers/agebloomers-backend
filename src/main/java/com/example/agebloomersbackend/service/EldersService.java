package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Elders;
import com.example.agebloomersbackend.repository.CaregiverMatchRepository;
import com.example.agebloomersbackend.repository.EldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EldersService {
    private EldersRepository eldersRepository;
    private CaregiverMatchRepository caregiverMatchRepository;

    @Autowired
    public EldersService(EldersRepository eldersRepository, CaregiverMatchRepository caregiverMatchRepository) {
        this.eldersRepository = eldersRepository;
        this.caregiverMatchRepository = caregiverMatchRepository;
    }

    public List<Elders> getAllElders() {
        // CaregiverMatch 테이블에서 caregivers_id 가져옴
        List<Long> eldersIdsInElderMatch = getEldersIdsInElderMatch();

        // Caregivers 테이블에서 해당 caregivers_id와 id가 동일하지 않은 모든 레코드를 선택
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
}
