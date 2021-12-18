/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2ooc;

import views.LoginForm;
/**
 *
 * @author Robert Szlufik #2020358 
 *         Ingrid Castro #2020341
 */
public class CA2OOC {

    /**
     * @param args the command line arguments
     * Link for the public GITHUB repository: https://github.com/IngDih/CA2OOC
     * Change password if needed on SQLConnection.java according to your localhost one.
     * If database doesn't run, check if the mysql-connector-java-8.0.26.jar is in libraries. 
     * If not you can add .JAR folder that is included on the ca2ooc packet.
     */
    public static void main(String[] args) {
        LoginForm loginScreen = new LoginForm();
    }

}
