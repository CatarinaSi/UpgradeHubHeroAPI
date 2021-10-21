package com.example.bootcamp.service;

import com.example.bootcamp.model.SuperPower;
import com.example.bootcamp.repository.SuperPowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperPowerService {

    private final SuperPowerRepository superPowerRepo;

    public SuperPowerService(SuperPowerRepository superPowerRepo) {
        this.superPowerRepo = superPowerRepo;
    }
    public List<SuperPower> findAll() {
        return superPowerRepo.findAll();
    }

    public SuperPower findById(Long id) {
        Optional<SuperPower> superPower = superPowerRepo.findById(id);
        if (superPower.isPresent()) superPower.get();
        return null;
    }

    public SuperPower save(SuperPower superPower) {
        return superPowerRepo.save(superPower);
    }
}
