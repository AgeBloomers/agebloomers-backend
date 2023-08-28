package com.example.agebloomersbackend.repository;

import com.example.agebloomersbackend.domain.Babysitters;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BabysittersRepository extends JpaRepository<Babysitters, Long> {
}
