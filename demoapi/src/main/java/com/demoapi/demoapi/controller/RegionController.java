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

import com.demoapi.demoapi.model.Country;
import com.demoapi.demoapi.model.Region;
import com.demoapi.demoapi.service.RegionService;

///@Controller mengembalikan data berbentuk View HTML
@RestController///mengembalikan data berbentuk json
@RequestMapping("/region")
public class RegionController {
    

    private RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping // http:/localhost:8080/region
    public ResponseEntity<List<Region>> getAll() {
        return new ResponseEntity(regionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") // http:/localhost:8080/region/1
    public ResponseEntity<Region> getById(@PathVariable Long id) {
        return new ResponseEntity(regionService.getById(id), HttpStatus.OK);
    }

    @PostMapping // http:/localhost:8080/region
    public ResponseEntity<Region> create(@RequestBody Region region) {
        return new ResponseEntity(regionService.create(region), HttpStatus.CREATED);
    }

    @PutMapping("/{id}") // http:/localhost:8080/region/1
    public ResponseEntity<Region> update(@PathVariable Long id,@RequestBody Region region) {
        return new ResponseEntity(regionService.update(id, region), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}") // http:/localhost:8080/region/1
    public ResponseEntity<Region> delete(@PathVariable Long id) {
        return new ResponseEntity(regionService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<Region> searchByName(@RequestParam String name){
        return regionService.serachByName(name);
    }

    @GetMapping("/urut")
    public List<Region> urutNama(){
        return regionService.urutNama();
    }
}
