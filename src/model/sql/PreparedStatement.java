/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.sql;

/**
 *
 * @author Ingrid
 */
public class PreparedStatement {
    
    // to resuse 
    
        public static final String coma = ",'";
        public static final String betweenStringValues = "','";
        public static final String closeString = "');";
        public static final String semiColon = ";";
        public static final String closeStatement = "';";



    
    // users table
        public static final String fetchAllUsers = "SELECT * FROM users;";        
        public static final String deleteSolutions = "DELETE FROM users WHERE user_id = ";
        public static final String deleteUser = "DELETE FROM users WHERE user_id = ";
        public static final String login = "SELECT password FROM users WHERE userName ='";
        public static final String fetchId = "SELECT user_id FROM users WHERE userName = '";
        public static final String fetchUserByID = "SELECT * FROM users WHERE user_id = ";

    
    
    //  results table 
        public static final String fetchAllOperations = "SELECT * FROM results;";
        public static final String saveSolution= "INSERT INTO results (user_id, setOfEquations, valueOfX, valueOfY, valueOfZ) VALUES (";

    
}
