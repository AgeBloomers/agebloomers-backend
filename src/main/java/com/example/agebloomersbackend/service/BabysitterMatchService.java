package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.BabysitterMatch;
import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.domain.Parents;
import com.example.agebloomersbackend.repository.BabysitterMatchRepository;
import com.example.agebloomersbackend.repository.BabysittersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BabysitterMatchService {
    private BabysitterMatchRepository babysitterMatchRepository;

    @Autowired
    public BabysitterMatchService(BabysitterMatchRepository babysitterMatchRepository) {
        this.babysitterMatchRepository = babysitterMatchRepository;
    }

    public BabysitterMatch createBabysitterMatch(String proposer, Long babysitterId, Long parentId) {
        BabysitterMatch match = new BabysitterMatch();
        match.setProposer(proposer);
        match.setBabysitterId(babysitterId);
        match.setParentId(parentId);
        match.setStatus("Pending");
        match.setMatchDate(new Date());

        return babysitterMatchRepository.save(match);
    }

}
