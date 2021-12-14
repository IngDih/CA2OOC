/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.users;

import java.util.List;
import java.util.Map;

/**
 *
 * @author robert
 */
public interface InterfaceAdmin {
     /**
     * Deletes user from a database
     */
    String deleteUser(int user_id);


    /**
     * Gets list of all users
     * @return list of all users
     */
    Map<String,String> getAllUsers();

    /**
     *
     *  
     * @param
     * @return Map of all operations calculated by users where key is a operation_id and value is a list of all database information
     * 
     */
    Map<String,List<String>> getAllOperations();
}
