package mii.co.id.clientappsibkm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import mii.co.id.clientappsibkm.model.Region;

@AllArgsConstructor
@Service
public class RegionService {
    private RestTemplate restTemplate;

    public List<Region> getAll() {
        return restTemplate.exchange("http://localhost:8088/region", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Region>>() {
                }).getBody();
    }

    public Region getById(Long id) {
        Map<String, Integer> param = new HashMap<>();
        long l = id;
        int i = (int) l;
        param.put("id", i);

        Region regionById= restTemplate.getForObject("http://localhost:8088/region/{id}", Region.class,param);

        return regionById;
    }
     public Region create(Region region) {
        return restTemplate.exchange("http://localhost:8088/region", HttpMethod.POST, new HttpEntity(region),
                new ParameterizedTypeReference<Region>() {
                }).getBody();
    }

    public Region update(Long id, Region region){
        Map<String, Integer> param = new HashMap<>();
        long l = id;
        int i = (int) l;
        param.put("id", i);
        return restTemplate.exchange("http://localhost:8088/region/{id}", HttpMethod.PUT, new HttpEntity(region),
                new ParameterizedTypeReference<Region>() {
                },param).getBody();
    }

    public Region delete(Long id){
        Map<String, Integer> param = new HashMap<>();
        long l = id;
        int i = (int) l;
        param.put("id", i);
        return restTemplate.exchange("http://localhost:8088/region/{id}", HttpMethod.DELETE, null,
                new ParameterizedTypeReference<Region>() {
                },param).getBody();
    }
}
