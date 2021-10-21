package com.example.bootcamp.controller;

import com.example.bootcamp.exception.HeroNotFound;
import com.example.bootcamp.model.Hero;
import com.example.bootcamp.service.HeroService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class HeroController {

    HeroService heroServ;

    public HeroController(HeroService heroServ) {
        this.heroServ = heroServ;
    }

    @GetMapping("/heroes")
    public List<Hero> getHeroes() {
        return heroServ.findAll();
    }

    @GetMapping("/heroes/{id}")
    public Hero getHeroById(@PathVariable(name = "id") Long id) throws HeroNotFound {
        return heroServ.findById(id);
    }

    @PostMapping("/heroes")
    public Hero addHero(@RequestBody @Valid Hero hero){
        return heroServ.save(hero);
    }
}