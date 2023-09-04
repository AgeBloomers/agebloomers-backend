package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.domain.Elders;
import com.example.agebloomersbackend.domain.Parents;
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
public class ParentsService {
    private ParentsRepository parentsRepository;
    private BabysitterMatchRepository babysitterMatchRepository;
    private RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    public ParentsService(ParentsRepository parentsRepository, BabysitterMatchRepository babysitterMatchRepository, RegisterDetailsRepository registerDetailsRepository) {
        this.parentsRepository = parentsRepository;
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
        Parents parents = parentsRepository.findById(parentId).orElse(null);
        if (parents == null) {
            return null;
        }

        List<Object[]> registerDetails = registerDetailsRepository.findByParentId(parentId);

        Map<String, Object> result = new HashMap<>();
        result.put("parents", parents);
        result.put("registerDetails", registerDetails);

        return result;
    }
}
