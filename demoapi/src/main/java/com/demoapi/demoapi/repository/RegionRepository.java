package com.demoapi.demoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demoapi.demoapi.model.Country;
import com.demoapi.demoapi.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region,Long>{
    Boolean existsByName(String name);

    @Query("SELECT r FROM Region r WHERE r.name like %?1%") // Entity/Class
    public List<Region> searchByName(String name);
    
    @Query( value = "SELECT * FROM tb_region WHERE region_name like %?1%", nativeQuery = true) // Table
    public List<Region> searchByNameNative(String name);
    
    @Query(value="SELECT * FROM tb_region ORDER BY region_name ASC", nativeQuery= true)//native 1
    public List<Region> urutNama();
}
