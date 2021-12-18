/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.util.Map;
import model.sql.SQLConnection;
import model.users.Admin;
import model.users.User;

/**
 *
 * @author rober
 *         Ingrid
 */
public class Controller implements InterfaceCredentials {

    SQLConnection sqlConnection;
    public int id;
    Admin admin;
    public User user;

    public Controller() {
        this.sqlConnection = new SQLConnection();
    }

    // controller methods \\
    public int login(String userName, String password) {

        String pass = sqlConnection.login(userName);
        if (pass != null && pass.equals(password)) {
            this.id = sqlConnection.getID(userName);
        } else {
            this.id = 0;
        }

        if (this.id != 0) {
            return this.id;
        } else {
            return 0;
        }
    }

    //Verifies if user has the user_id of an admin
    public boolean isAdmin(int user_id) {
        if (this.sqlConnection.fetchIsAdmin(user_id) == 1) {
            return true;
        }
        return false;
    }

    public void assignUser(int user_id) {
        this.setID(user_id);
        if (this.sqlConnection.fetchIsAdmin(user_id) == 1) {
            // admin
            this.admin = new Admin(user_id);

        } else {
            // regular user
            this.user = new User(this.id);
        }
    }
    //Creates a new user on the database table
    public boolean createNewUser(String userName, String password, String firstName, String lastName) {
        return sqlConnection.createUser(userName, password, firstName, lastName, 0);
    }

    private void setID(int user_id) {
        this.id = user_id;
    }

    @Override
    public boolean changePassword(int id, String newPassword) {
        return sqlConnection.changePassword(id, newPassword);
    }

    @Override
    public boolean changeFirstName(int id, String newFirstName) {
        return sqlConnection.changeFirstName(id, newFirstName);
    }

    @Override
    public boolean changeLastName(int id, String newLastName) {
        return sqlConnection.changeLastName(id, newLastName);
    }
    
    //admin methods     
    public Map<String,String> getAllUsers() {
        return this.admin.getAllUsers();
    }
    
    public String deleteUser(int user_id) {
        return this.admin.deleteUser(user_id);
            
    }
    
    public Map<String,List<String>> getAllOperations() {
        return this.admin.getAllOperations();
    }
    
    
    //user methods 
    public boolean saveSolution(int user_id, String equations, String x, String y, String z) {
        return this.sqlConnection.saveSolution(user_id, equations, x, y, z);
    }

    public Map<String, String> fetchUser(int user_id) {
        return this.sqlConnection.fetchUser(user_id);
    }

    public Map<String, List<String>> getOperationsByID(int user_id) {
        return this.sqlConnection.getOperationsByUser(user_id);
    }

    public String[] solve(String equation1, String equation2, String equation3) {
        return this.user.solve(equation1, equation2, equation3);
    }

    public String[] solve(String equation1, String equation2) {
        return this.user.solve(equation1, equation2);
    }
    
}
