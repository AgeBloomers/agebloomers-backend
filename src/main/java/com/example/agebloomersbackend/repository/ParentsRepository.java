package com.example.agebloomersbackend.repository;

import com.example.agebloomersbackend.domain.Parents;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ParentsRepository extends JpaRepository<Parents, Long> {
    Parents findByNameAndPassword(String name, String password);
}
