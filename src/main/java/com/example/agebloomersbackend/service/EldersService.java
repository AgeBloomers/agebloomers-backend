package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Elders;
import com.example.agebloomersbackend.repository.CaregiverMatchRepository;
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
    private CaregiverMatchRepository caregiverMatchRepository;
    private RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    public EldersService(EldersRepository eldersRepository, CaregiverMatchRepository caregiverMatchRepository, RegisterDetailsRepository registerDetailsRepository) {
        this.eldersRepository = eldersRepository;
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
        Elders elders = eldersRepository.findById(elderId).orElse(null);
        if (elders == null) {
            return null;
        }

        List<Object[]> registerDetails = registerDetailsRepository.findByElderId(elderId);

        Map<String, Object> result = new HashMap<>();
        result.put("elders", elders);
        result.put("registerDetails", registerDetails);

        return result;
    }
}
