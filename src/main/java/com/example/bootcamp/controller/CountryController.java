package com.example.bootcamp.controller;

import com.example.bootcamp.model.Country;
import com.example.bootcamp.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Validated
public class CountryController {

    CountryService countrySer;

    public CountryController(CountryService countrySer) {
        this.countrySer = countrySer;
    }


    @GetMapping("/getCountries")
    public List<Country> getCountries() {
        return countrySer.findAll();
    }

    @GetMapping("/getCountryById/{id}")
    public Optional<Country> getCountryById(@PathVariable(value = "id") Long id) {
        return countrySer.findById(id);
    }

    @PostMapping(value = "/createCountry", consumes = "application/json", produces = "application/json")
    public Country createCountry(@RequestBody Country country) {
        Country newCountry = Country.builder().name(country.getName()).build();
        countrySer.save(newCountry);
        return newCountry;
    }

    @PutMapping(value = "updateCountries/{id}", consumes = "application/json", produces = "application/json")
    public Country updateCountry(@PathVariable(value = "id") Long id, @RequestBody Country country) {
        System.out.println(id);
        Optional<Country> countryToBeUpdated = countrySer.findById(id);
        if (countryToBeUpdated.isPresent()) {
            countryToBeUpdated.get().setName(country.getName());
            countrySer.save(countryToBeUpdated.get());
            return countryToBeUpdated.get();
        } else {
            ResponseEntity.badRequest().body("Country not found");
            return null;
        }
    }

    @DeleteMapping(value = "/deleteCountry/{id}")
    public void deleteCountry(@PathVariable(value = "id") Long id)  {
        countrySer.deleteById(id);
    }
}

