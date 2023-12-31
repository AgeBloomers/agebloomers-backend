package com.example.agebloomersbackend.repository;

import com.example.agebloomersbackend.domain.BabysitterMatch;
import com.example.agebloomersbackend.domain.CaregiverMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface CaregiverMatchRepository extends JpaRepository<CaregiverMatch, Long> {
    @Query("SELECT bm.caregiver.id FROM CaregiverMatch bm")
    List<Long> findAllCaregiverIds();

    @Query("SELECT bm.elder.id FROM CaregiverMatch bm")
    List<Long> findAllElderIds();

    @Query("SELECT cm.elder.id FROM CaregiverMatch cm WHERE cm.caregiver.id = :caregiverId")
    Long findElderIdsByCaregiverId(@Param("caregiverId") Long caregiverId);

    @Query("SELECT cm.caregiver.id FROM CaregiverMatch cm WHERE cm.elder.id = :elderId")
    Long findCaregiverIdsByElderId(@Param("elderId") Long elderId);

    // 매칭 상태 수정 관련
    // type 값이 있는 레코드 중 registrant_id를 가진 레코드 찾기
    @Query("SELECT cm FROM CaregiverMatch cm WHERE cm.proposer = :type AND cm.caregiver.id = :registrantId")
    List<CaregiverMatch> findByTypeAndCaregiverId(String type, Long registrantId);

    @Query("SELECT cm FROM CaregiverMatch cm WHERE cm.proposer = :type AND cm.elder.id = :registrantId")
    List<CaregiverMatch> findByTypeAndElderId(String type, Long registrantId);

}
