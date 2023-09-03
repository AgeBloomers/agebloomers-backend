package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.repository.BabysittersRepository;
import com.example.agebloomersbackend.repository.BabysitterMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BabysittersService {
    private BabysittersRepository babysittersRepository;
    private BabysitterMatchRepository babysitterMatchRepository;

    @Autowired
    public BabysittersService(BabysittersRepository babysittersRepository, BabysitterMatchRepository babysitterMatchRepository) {
        this.babysittersRepository = babysittersRepository;
        this.babysitterMatchRepository = babysitterMatchRepository;
    }

    public List<Babysitters> getAllBabysitters() {

        // BabysitterMatch 테이블에서 babysitters_id를 가져옵니다.
        List<Long> babysittersIdsInBabysitterMatch = getBabysittersIdsInBabysitterMatch();

        // Babysitters 테이블에서 해당 babysitters_id와 id가 동일하지 않은 모든 레코드를 선택합니다.
        return babysittersRepository.findAll().stream()
                .filter(babysitters -> !babysittersIdsInBabysitterMatch.contains(babysitters.getId()))
                .collect(Collectors.toList());
    }
    public List<Long> getBabysittersIdsInBabysitterMatch() {
        // babysitter_matches 테이블의 babysitter_id 컬럼 값을 조회합니다.
        return babysitterMatchRepository.findAllBabysitterIds();
    }


    public Babysitters createBabysitter(Babysitters babysitters) {
        return babysittersRepository.save(babysitters);
    }
}
