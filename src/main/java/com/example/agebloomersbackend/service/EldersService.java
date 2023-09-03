package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Caregivers;
import com.example.agebloomersbackend.domain.Elders;
import com.example.agebloomersbackend.repository.CaregiversRepository;
import com.example.agebloomersbackend.repository.EldersRepository;
import com.example.agebloomersbackend.repository.ParentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EldersService {
    private EldersRepository eldersRepository;

    @Autowired
    public EldersService(EldersRepository eldersRepository) {
        this.eldersRepository = eldersRepository;
    }

    public List<Elders> getAllElders() {
        return eldersRepository.findAll();
    }
    public Elders createElder(Elders elder) {
        return eldersRepository.save(elder);
    }
}
