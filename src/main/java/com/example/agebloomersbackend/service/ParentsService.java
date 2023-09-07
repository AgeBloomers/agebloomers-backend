package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.domain.Elders;
import com.example.agebloomersbackend.domain.Parents;
import com.example.agebloomersbackend.repository.BabysitterMatchRepository;
import com.example.agebloomersbackend.repository.BabysittersRepository;
import com.example.agebloomersbackend.repository.ParentsRepository;
import com.example.agebloomersbackend.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ParentsService {
    private ParentsRepository parentsRepository;
    private BabysittersRepository babysittersRepository;
    private BabysitterMatchRepository babysitterMatchRepository;
    private RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    public ParentsService(ParentsRepository parentsRepository, BabysittersRepository babysittersRepository, BabysitterMatchRepository babysitterMatchRepository, RegisterDetailsRepository registerDetailsRepository) {
        this.parentsRepository = parentsRepository;
        this.babysittersRepository = babysittersRepository;
        this.babysitterMatchRepository = babysitterMatchRepository;
        this.registerDetailsRepository = registerDetailsRepository;
    }

    public List<Parents> getAllParents() {
        List<Long> parentsIdsInParentMatch = getParentsIdsInParentMatch();

        return parentsRepository.findAll().stream()
                .filter(parents -> !parentsIdsInParentMatch.contains(parents.getId()))
                .collect(Collectors.toList());
    }

    public List<Long> getParentsIdsInParentMatch() { return babysitterMatchRepository.findAllParentIds(); }

    public Parents createParent(Parents parent) {
        return parentsRepository.save(parent);
    }

    public Parents findParentByNameAndPassword(String name, String password) {
        return parentsRepository.findByNameAndPassword(name, password);
    }

    public Object getParentDetails(Long parentId) {

        // 본인
        Parents parents = parentsRepository.findById(parentId).orElse(null);
        if (parents == null) return null;

        List<Object[]> registerDetails_parents = registerDetailsRepository.findByParentId(parentId);

        Map<String, Object> result = new HashMap<>();
        result.put("parents", parents);
        result.put("registerDetails_parents", registerDetails_parents);
        System.out.println(parentId);
        System.out.println(result);

        // 매칭된 상대방 찾기
        Long babysitterId = babysitterMatchRepository.findBabysitterIdsByParentId(parentId);

        if (babysitterId != null) {
            // 상대방
            Babysitters babysitters = babysittersRepository.findById(babysitterId).orElse(null);
            if (babysitters == null) return null;

            List<Object[]> registerDetails_babysitters = registerDetailsRepository.findByBabysitterId(babysitterId);

            Map<String, Object> othersResult = new HashMap<>();
            othersResult.put("babysitters", babysitters);
            othersResult.put("registerDetails_babysitters", registerDetails_babysitters);

            // selfResult와 othersResult 합침
            result.putAll(othersResult);
        }

        return result;
    }
}
