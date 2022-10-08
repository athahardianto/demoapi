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
    public List<Region> getAll() {
        return regionService.getAll();
    }

    @GetMapping("/{id}") // http:/localhost:8080/region/1
    public Region getById(@PathVariable Long id) {
        return regionService.getById(id);
    }

    @PostMapping // http:/localhost:8080/region
    public Region create(@RequestBody Region region) {
        return regionService.create(region);
    }

    @PutMapping("/{id}") // http:/localhost:8080/region/1
    public Region update(@PathVariable Long id,@RequestBody Region region) {
        return regionService.update(id, region);
    }

    @DeleteMapping("/{id}") // http:/localhost:8080/region/1
    public Region delete(@PathVariable Long id) {
        return regionService.delete(id);
    }
}
