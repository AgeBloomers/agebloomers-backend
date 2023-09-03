package com.example.agebloomersbackend.repository;

import com.example.agebloomersbackend.domain.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails, Long>{

    @Query("SELECT rd.registerDate, rd.comment, rd.startTime, rd.endTime, rd.babysitter.id FROM RegisterDetails rd WHERE rd.babysitter.id = :id")
    List<Object[]> findByBabysitterId(@Param("id") Long id);

    List<Object[]> findByCaregiverId(Long id);

    List<Object[]> findByElderId(Long id);

    List<Object[]> findByParentId(Long id);
}
