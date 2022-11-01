package com.demoapi.demoapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demoapi.demoapi.service.CountryService;
import com.demoapi.demoapi.model.Country;
import com.demoapi.demoapi.model.Region;

@RestController
@RequestMapping("/country")
public class CountryController {
    
    private CountryService countryService;
    
    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<Country>> getAll(){
        return new ResponseEntity(countryService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}") 
    public ResponseEntity<Country> getById(@PathVariable Long id){
        return new ResponseEntity(countryService.getById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Country> Create(@RequestBody Country country){
        return new ResponseEntity(countryService.create(country), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> Update(@PathVariable Long id,@RequestBody Country country){
        return new ResponseEntity(countryService.update(id,country), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Country> Delete(@PathVariable Long id){
        return new ResponseEntity(countryService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/group")
    public List<Country> groupByRegion(@RequestParam Long id){
        return countryService.groupByRegion(id);
    }

    @GetMapping("/searchbyregion")
    public List<Country> searchByNameRegion(@RequestParam String name){
        return countryService.searchByNameRegion(name);
    }

    
}
