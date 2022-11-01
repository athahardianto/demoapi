package com.demoapi.demoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.demoapi.demoapi.model.Country;
import com.demoapi.demoapi.model.Region;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long>{
    Boolean existsByName(String name);

    @Query(value = "SELECT * FROM tb_country WHERE region_id=?", nativeQuery = true) 
    public List<Country> groupByRegion(Long id);

    @Query(value = "SELECT * FROM tb_country c,tb_region r WHERE c.region_id=r.id AND r.region_name=?1", nativeQuery = true)
    public List<Country> searchByNameRegion(String name);
}
