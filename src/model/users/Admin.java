/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.users;

import controller.Controller;
import java.util.List;
import java.util.Map;
import model.sql.SQLConnection;

/**
 *
 * @author rober
 */
public class Admin implements InterfaceAdmin {
    
     private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private int isAdmin;
    private Controller controller;
    private SQLConnection sqlConnection;

    public Admin(int user_id) {
        this.controller = new Controller();
        this.sqlConnection = new SQLConnection();
        Map<String,String> data = controller.fetchUser(user_id);
        this.id = user_id;
        this.userName = data.get("userName");
        this.firstName = data.get("firstName");
        this.lastName = data.get("lastName");;
        this.password = data.get("password");;
        this.isAdmin = 1;
    }
    
    @Override
    public String deleteUser(int user_id) {
        return this.sqlConnection.deleteUser(user_id);
    }

    @Override
    public Map<String,String> getAllUsers() {
            return this.sqlConnection.fetchAllUsers();
    }

    @Override
    public Map<String,List<String>> getAllOperations() {
        return this.sqlConnection.getAllOperations();
    }

    public int getId(){
        return this.id;
    }
    
}
