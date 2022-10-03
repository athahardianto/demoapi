/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.concretes;

import com.mysql.jdbc.Connection;
import daos.interfaces.IRegionDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Region;

/**
 *
 * @author athab
 */
public class RegionDAO implements IRegionDAO{
    private Connection connection;
    
    public RegionDAO(Connection connection){
        this.connection = connection;
    }
    
    public List<Region> getAll(){
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM regions";
        try {
            ResultSet resultSet = connection
                                 .prepareStatement(query)
                                 .executeQuery();
            
            while (resultSet.next()){
                Region region = new Region(resultSet.getInt(1), resultSet.getString(2));
//                region.setRegionId(resultSet.getInt(1));
//                region.setRegionName(resultSet.getString(2));
                regions.add(region);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regions;
    }
    
    public Region getById(int regionID){
        Region hasil = new Region();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM regions WHERE region_id=?");
            preparedStatement.setInt(1, regionID);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
//                Region region = new Region(resultSet.getInt(1), resultSet.getString(2));
//                region.setRegionId(resultSet.getInt(1));
//                region.setRegionName(resultSet.getString(2));
                
                hasil = new Region(resultSet.getInt(1),resultSet.getString(2));
                
//                System.out.println(region.getRegionId());
//                System.out.println(region.getRegionName());
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasil;
    }
    
    public boolean insert(Region region){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO regions(region_id, region_name) VALUES(?,?)");
            preparedStatement.setInt(1, region.getRegionId());
            preparedStatement.setString(2, region.getRegionName());
            int x = preparedStatement.executeUpdate();
            if(x>0){
//                System.out.println("Data berhasil ditambahkan");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(Region region){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE regions SET region_name=? WHERE region_id=?");
            preparedStatement.setInt(2, region.getRegionId());
            preparedStatement.setString(1, region.getRegionName());
            int x= preparedStatement.executeUpdate();
            if(x>0){
//                System.out.println("Data berhasil diubah");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(int regionId){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM regions WHERE region_id=?");
            preparedStatement.setInt(1, regionId);
            int x= preparedStatement.executeUpdate();
            if(x>0){
//                System.out.println("Data berhasil dihapus");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
