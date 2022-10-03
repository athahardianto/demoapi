/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author athab
 */
public class DbConnection {
    private Connection con;
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_hr_tes?zeroDateTimeBehavior=convertToNull", "root", "");
            
        } catch (Exception e) {
            System.out.println("Error + "+ e.getMessage());
        }
        return  con;
    }
}
