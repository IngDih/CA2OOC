/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author rober
 */
public class SQLConnection {
    
     String dbServer;
    String user;
    String databasePassword;

    public SQLConnection ( )  { 
        this.dbServer = "jdbc:mysql://localhost:3306/ca2";
        this.user = "root";
//        this.databasePassword = "Robcio10"; // robert's password
        this.databasePassword = "root"; // ingrid's password

    }

    // database interaction methods 
    
        private Map<String, String> queryAll(String preparedStatement) {

            Map<String, String> map = new HashMap<>();
        try {            
            Connection connection = DriverManager.getConnection(this.dbServer, this.user, this.databasePassword);
             Statement statement = connection.createStatement() ;


            ResultSet rs = statement.executeQuery(preparedStatement);

            while(rs.next()){
                if(rs.getString("user_id").equals("1")){
                    continue;
                };
                StringBuilder temp = new StringBuilder(rs.getString("userName"));
                temp.append(";").append(rs.getString("firstName")).append(";").append(rs.getString("lastName"));
                
                map.put(rs.getString("user_id"), temp.toString());
            }

        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"There might be a problem with database, " + e.getMessage());

        }
        return map;
    }

    private Map<String,List<String>> queryAllOperations() {
        Map<String,List<String>> map = new HashMap<>();
        List<String> list;
        try{
            Connection connection = DriverManager.getConnection(this.dbServer, this.user, this.databasePassword);
             Statement statement = connection.createStatement();
            
            ResultSet rs =  statement.executeQuery(PreparedStatement.fetchAllOperations);
            while(rs.next()){
                list = new ArrayList<>();
                list.add(rs.getString("user_id"));
                list.add(rs.getString("setOfEquations"));
                list.add(rs.getString("valueOfX"));
                list.add(rs.getString("valueOfY"));
                list.add(rs.getString("valueOfZ"));
                
                
                map.put(rs.getString("result_id"),list);
            }

        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"There might be a problem with database, " + e.getMessage());

        }
        return map;
    }
    
    
     private boolean execute(String preparedStatement) {
        try {
            Connection connection = DriverManager.getConnection(this.dbServer, this.user, this.databasePassword);
            Statement statement = connection.createStatement();
            return statement.execute(preparedStatement);
        }catch(Exception e) {
             JOptionPane.showMessageDialog(null,"There might be a problem with database, " + e.getMessage());
        }
        return false;
    }
    
    
    
    // to implement ####################################
     
    
     public Map<String, String> fetchUser(int user_id){
        return  null;
    }
    
     
     
     
     // admin methods 
    
     public String deleteUser(int user_id){

        // if admin -> do not remove
        if(user_id == 1) {
            return "Cannot delete admin";
        } else if (user_id > 1 && !this.fetchUser(user_id).isEmpty()) {
            this.execute(PreparedStatement.deleteUser + user_id + PreparedStatement.semiColon);
            if(this.fetchUser(user_id).isEmpty()){
                return  "User succesfully deleted";
            }
        } else {
            return "";
        }
        return "";
    }

    
    
    
    public Map<String,List<String>> getAllOperations(){
        return this.queryAllOperations();
    }
    
    
    public Map<String, String> fetchAllUsers() {
        return this.queryAll(PreparedStatement.fetchAllUsers);
    }
     
    private void deleteSolution(int user_id) {
        this.execute(PreparedStatement.deleteSolutions + user_id + PreparedStatement.semiColon);
    }
     
    
    // user methods 
    
     public boolean saveSolution(int user_id , String equations, String x, String y, String z){
        return this.execute(PreparedStatement.saveSolution + user_id + PreparedStatement.coma +
                equations + PreparedStatement.betweenStringValues + x + PreparedStatement.betweenStringValues + y + PreparedStatement.betweenStringValues + z + PreparedStatement.closeString);

    }

    
}
