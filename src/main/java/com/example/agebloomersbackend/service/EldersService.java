package com.example.agebloomersbackend.service;

import com.example.agebloomersbackend.domain.Elders;
import com.example.agebloomersbackend.repository.EldersRepository;

public class EldersService {
    private EldersRepository eldersRepository;
    public Elders createElder(Elders elder) {
        return eldersRepository.save(elder);
    }
}
