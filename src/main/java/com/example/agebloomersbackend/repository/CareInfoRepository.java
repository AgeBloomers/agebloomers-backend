package com.example.agebloomersbackend.repository;

import com.example.agebloomersbackend.domain.CareInfoManage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareInfoRepository extends JpaRepository<CareInfoManage, Long> {

}
