/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.concretes;

import com.mysql.jdbc.Connection;
import daos.concretes.RegionDAO;
import daos.interfaces.IRegionDAO;
import java.util.List;
import models.Region;

/**
 *
 * @author athab
 */
public class RegionController {
    private Connection connection;
    private IRegionDAO rdao;
    
    public RegionController(Connection connection){
        rdao = new RegionDAO(connection);
    }
    
    public String insert(String regionId, String regionName){
//        String result = "";
        
        //parsing
        int newRegionId = Integer.parseInt(regionId);
        Region region = new Region(newRegionId, regionName);
        
        if (rdao.insert(region)) {
//            result = "Data berhasil diinput";
//            System.out.println("Data berhasil diinput");
//            return result;
             return "Data berhasil diinput";
        }else{
//            result = "Data gagal diinput";
//            System.out.println("Data gagal diinput");
//            return result;
            return "Data gagal diinput";
        }
    }
    
    public String update(String regionId, String regionName){
        int newRegionId = Integer.parseInt(regionId);
        Region region = new Region(newRegionId, regionName);
        
        if (rdao.update(region)) {
//            result = "Data berhasil diinput";
//            System.out.println("Data berhasil diinput");
//            return result;
             return "Data berhasil diubah";
        }else{
//            result = "Data gagal diinput";
//            System.out.println("Data gagal diinput");
//            return result;
            return "Data gagal diubah";
        }
    }
    
    public String delete(String regionId){
        int newRegionId = Integer.parseInt(regionId);
        
        if (rdao.delete(newRegionId)) {
//            result = "Data berhasil diinput";
//            System.out.println("Data berhasil diinput");
//            return result;
             return "Data berhasil dihapus";
        }else{
//            result = "Data gagal diinput";
//            System.out.println("Data gagal diinput");
//            return result;
            return "Data gagal dihapus";
        }
    }
    
    public Region getById(int regionId){
        return rdao.getById(regionId);
    }
    
    public List<Region> getAll(){
        return rdao.getAll();
    }

}
