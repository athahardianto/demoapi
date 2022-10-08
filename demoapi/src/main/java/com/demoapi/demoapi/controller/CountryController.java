package com.demoapi.demoapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demoapi.demoapi.service.CountryService;
import com.demoapi.demoapi.model.Country;

@RestController
@RequestMapping("/country")
public class CountryController {
    
    private CountryService countryService;
    
    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAll(){
        return countryService.getAll();
    }

    @GetMapping("/{id}") 
    public Country getById(@PathVariable Long id){
        return countryService.getById(id);
    }

    @PostMapping
    public Country Create(@RequestBody Country country){
        return countryService.create(country);
    }

    @PutMapping("/{id}")
    public Country Update(@PathVariable Long id,@RequestBody Country country){
        return countryService.update(id,country);
    }

    @DeleteMapping("/{id}")
    public Country Delete(@PathVariable Long id){
        return countryService.delete(id);
    }

    
}
