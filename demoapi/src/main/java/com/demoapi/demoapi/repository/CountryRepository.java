package com.demoapi.demoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demoapi.demoapi.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long>{
    Boolean existsByName(String name);
}
