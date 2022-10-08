package com.demoapi.demoapi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.demoapi.demoapi.model.Country;
import com.demoapi.demoapi.repository.CountryRepository;

@Service
public class CountryService {
    
    private CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAll(){
        return countryRepository.findAll();
    }

    public Country getById(Long id){
        return countryRepository.findById(id)
            .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Country not found!") );
    }

    public Country create(Country country){
        if (country.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Country id already exists!");
        } 

        if(countryRepository.existsByName(country.getName()) ){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Country name is already exists!");
        }

        return countryRepository.save(country);
    }
    
    public Country update(Long id, Country country){
        getById(id);
        country.setId(id);
        if(countryRepository.existsByName(country.getName()) ){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Country name is already exists!");
        }
        return countryRepository.save(country);
    }
    
    public Country delete(Long id){
        Country country = getById(id);
        countryRepository.delete(country);
        return country;
    }
}
