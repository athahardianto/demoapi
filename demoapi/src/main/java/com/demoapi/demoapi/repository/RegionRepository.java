package com.demoapi.demoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demoapi.demoapi.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region,Long>{
    Boolean existsByName(String name);
    
}
