/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.concretes.RegionController;
import daos.concretes.RegionDAO;
import models.Region;
import views.UserInterface;

/**
 *
 * @author athab
 */
public class Test {
    
    public static void main(String[] args) {
        DbConnection connection = new DbConnection();
        System.out.println(connection.getConnection());
        
        UserInterface ui = new UserInterface(connection.getConnection());
        
        ui.Menu();
        
        
//        RegionDAO rdao = new RegionDAO(connection.getConnection());
        
        //getall
//        for(Region region : rdao.getAll()){
//            System.out.println(region.getRegionId());
//            System.out.println(region.getRegionName());
//        }

              //getbyid
//            Region hasil= rdao.getById(3);
//            System.out.println(hasil.getRegionId());
//            System.out.println(hasil.getRegionName());
//           
//           Region region = new Region(0,"sukses deh amin");
//           
            //insert
//           rdao.insert(region);
           
            //update
//           rdao.update(region);

            //delete
//           rdao.delete(20);
               

           //insert pake controller
//           RegionController rc = new RegionController(connection.getConnection());
//           System.out.println(rc.insert("0", "AHAHAHAHA"));
           //update
//           System.out.println(rc.update("21", "wkwkkwkwk"));
           //delete
//           System.out.println(rc.delete("21"));
          //getbyid
//          Region tes = rc.getById(3);
//          System.out.println(tes.getRegionId()+". "+ tes.getRegionName());
    }
    
}
