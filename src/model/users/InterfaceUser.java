/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.users;

/**
 *
 * @author rober
 */
public interface InterfaceUser {
    
    /**
     * 
     * @param equation1
     * @param equation2
     * @return array of strings with solutions
     */
    String[] solve(String equation1, String equation2);


    /**
     * 
     * @param equation1
     * @param equation2
     * @param equation3
     * @return array of strings with solutions
     */
    String[] solve(String equation1, String equation2, String equation3);


    
}
