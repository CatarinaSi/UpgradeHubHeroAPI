package com.example.bootcamp.controller;

import com.example.bootcamp.model.SuperPower;
import com.example.bootcamp.service.SuperPowerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class SuperPowerController {

    SuperPowerService superPowerServ;

    public SuperPowerController(SuperPowerService superPowerServ) {
        this.superPowerServ = superPowerServ;
    }

    @GetMapping("/superpowers")
    public List<SuperPower> getSuperpowers() {
        return superPowerServ.findAll();
    }

    @GetMapping("/superpowers/{id}")
    public SuperPower getSuperPowerById(@PathVariable(name = "id") Long id) {
        return superPowerServ.findById(id);
    }

    @PostMapping("/superpowers")
    public SuperPower addSuperpower(@RequestBody SuperPower superPower) {
        return superPowerServ.save(superPower);
    }

}

