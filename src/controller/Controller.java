/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.util.Map;
import model.sql.SQLConnection;

/**
 *
 * @author rober
 */
public class Controller implements InterfaceCredentials{
    
    SQLConnection sqlConnection;
    
    public Controller() {
        this.sqlConnection = new SQLConnection();
    }
    
    // controller methods 

    
    @Override
    public boolean changePassword(int id, String newPassword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean changeFirstName(int id, String newFirstName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean changeLastName(int id, String newFirstName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    //admin methods 
    
   
    
    
    
    //user mathods 
    
    // needs to be implemented 
    public Map<String, String> fetchUser(int user_id){
        return this.sqlConnection.fetchUser(user_id);
    }
    
     public boolean saveSolution(int user_id , String equations, String x, String y, String z){
        return this.sqlConnection.saveSolution(user_id, equations, x, y, z);
    }

     
     
     
     
     
     
}
