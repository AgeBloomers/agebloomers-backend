package com.example.agebloomersbackend.repository;

import com.example.agebloomersbackend.domain.BabysitterMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BabysitterMatchRepository extends JpaRepository<BabysitterMatch, Long> {
    @Query("SELECT bm.babysitter.id FROM BabysitterMatch bm")
    List<Long> findAllBabysitterIds();

    @Query("SELECT bm.parent.id FROM BabysitterMatch bm")
    List<Long> findAllParentIds();

    @Query("SELECT bm.babysitter.id FROM BabysitterMatch bm WHERE bm.parent.id = :parentId")
    Long findBabysitterIdsByParentId(@Param("parentId") Long parentId);

    @Query("SELECT bm.parent.id FROM BabysitterMatch bm WHERE bm.babysitter.id = :babysitterId")
    Long findParentIdsByBabysitterId(@Param("babysitterId") Long babysitterId);

    // 매칭 상태 수정 관련
    // type 값이 있는 레코드 중 registrant_id를 가진 레코드 찾기
    @Query("SELECT bm FROM BabysitterMatch bm WHERE bm.proposer = :type AND bm.babysitter.id = :registrantId")
    List<BabysitterMatch> findByTypeAndBabysitterId(String type, Long registrantId);

    @Query("SELECT bm FROM BabysitterMatch bm WHERE bm.proposer = :type AND bm.parent.id = :registrantId")
    List<BabysitterMatch> findByTypeAndParentId(String type, Long registrantId);


}
