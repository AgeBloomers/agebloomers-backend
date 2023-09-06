package com.example.agebloomersbackend.repository;

import com.example.agebloomersbackend.domain.Babysitters;
import com.example.agebloomersbackend.domain.CareInfoManage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BabysittersRepository extends JpaRepository<Babysitters, Long> {
    Babysitters findByNameAndPassword(String name, String password);
}
