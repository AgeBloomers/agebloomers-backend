package com.example.agebloomersbackend.repository;

import com.example.agebloomersbackend.domain.Elders;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EldersRepository extends JpaRepository<Elders, Long> {
    Elders findByNameAndPassword(String name, String password);
}
