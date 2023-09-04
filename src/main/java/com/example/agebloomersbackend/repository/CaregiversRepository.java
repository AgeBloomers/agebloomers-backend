package com.example.agebloomersbackend.repository;

import com.example.agebloomersbackend.domain.Caregivers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaregiversRepository extends JpaRepository<Caregivers, Long> {
    Caregivers findByNameAndPassword(String name, String password);
}
