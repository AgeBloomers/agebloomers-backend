package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.domain.Parents;
import com.example.agebloomersbackend.repository.BabysitterMatchRepository;
import com.example.agebloomersbackend.repository.ParentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParentsService {
    private ParentsRepository parentsRepository;
    private BabysitterMatchRepository babysitterMatchRepository;

    @Autowired
    public ParentsService(ParentsRepository parentsRepository, BabysitterMatchRepository babysitterMatchRepository) {
        this.parentsRepository = parentsRepository;
        this.babysitterMatchRepository = babysitterMatchRepository;
    }

    public List<Parents> getAllParents() {
        // BabysitterMatch 테이블에서 babysitters_id를 가져옵니다.
        List<Long> parentsIdsInParentMatch = getParentsIdsInParentMatch();

        // Babysitters 테이블에서 해당 babysitters_id와 id가 동일하지 않은 모든 레코드를 선택합니다.
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
}
