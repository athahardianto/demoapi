package com.demoapi.demoapi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.demoapi.demoapi.model.Region;
import com.demoapi.demoapi.repository.RegionRepository;

@Service
public class RegionService {
    
    private RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getAll(){
        return regionRepository.findAll();
    }
    
    public Region getById(Long id){
        return regionRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Region not found!"));
    }
    
    public Region create(Region region){
        if (region.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Region id is already exists!");
        }

        if(regionRepository.existsByName(region.getName()) ){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Region name is already exists!");
        }

        return regionRepository.save(region);
    }
    
    public Region update(Long id, Region region){
        getById(id);
        region.setId(id);
        return regionRepository.save(region);
    }
    
    public Region delete(Long id){
        Region region = getById(id);
        regionRepository.delete(region);
        return region;
    }

    
}
