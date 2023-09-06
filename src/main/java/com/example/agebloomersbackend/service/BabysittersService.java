package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.domain.Elders;
import com.example.agebloomersbackend.domain.Parents;
import com.example.agebloomersbackend.repository.BabysittersRepository;
import com.example.agebloomersbackend.repository.BabysitterMatchRepository;
import com.example.agebloomersbackend.repository.ParentsRepository;
import com.example.agebloomersbackend.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BabysittersService {
    private BabysittersRepository babysittersRepository;
    private ParentsRepository parentsRepository;
    private BabysitterMatchRepository babysitterMatchRepository;
    private RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    public BabysittersService(BabysittersRepository babysittersRepository, BabysitterMatchRepository babysitterMatchRepository, RegisterDetailsRepository registerDetailsRepository, ParentsRepository parentsRepository) {
        this.babysittersRepository = babysittersRepository;
        this.parentsRepository = parentsRepository;
        this.babysitterMatchRepository = babysitterMatchRepository;
        this.registerDetailsRepository = registerDetailsRepository;
    }

    public List<Babysitters> getAllBabysitters() {
        List<Long> babysittersIdsInBabysitterMatch = getBabysittersIdsInBabysitterMatch();
        return babysittersRepository.findAll().stream()
                .filter(babysitters -> !babysittersIdsInBabysitterMatch.contains(babysitters.getId()))
                .collect(Collectors.toList());
    }
    public List<Long> getBabysittersIdsInBabysitterMatch() {
        return babysitterMatchRepository.findAllBabysitterIds();
    }

    public Babysitters createBabysitter(Babysitters babysitters) {
        return babysittersRepository.save(babysitters);
    }

    public Babysitters findBabysitterByNameAndPassword(String name, String password) {
        return babysittersRepository.findByNameAndPassword(name, password);
    }

    public Object getBabysitterDetails(Long babysitterId) {
        // 본인
        Babysitters babysitters = babysittersRepository.findById(babysitterId).orElse(null);
        if (babysitters == null)    return null;

        List<Object[]> registerDetails_babysitters = registerDetailsRepository.findByBabysitterId(babysitterId);

        Map<String, Object> result = new HashMap<>();
        result.put("babysitters", babysitters);
        result.put("registerDetails_babysitters", registerDetails_babysitters);
        System.out.println(babysitterId);
        System.out.println(result);

        // 매칭된 상대방 찾기
        Long parentId = babysitterMatchRepository.findParentIdsByBabysitterId(babysitterId);

        if (parentId != null) {
            // 상대방
            Parents parents = parentsRepository.findById(parentId).orElse(null);
            if (parentId == null) return null;

            List<Object[]> registerDetails_parents = registerDetailsRepository.findByParentId(parentId);

            Map<String, Object> othersResult = new HashMap<>();
            othersResult.put("parents", parents);
            othersResult.put("registerDetails_parents", registerDetails_parents);
            System.out.println(parentId);

            // selfResult와 othersResult 합침
            result.putAll(othersResult);

        }

        return result;
    }
}
