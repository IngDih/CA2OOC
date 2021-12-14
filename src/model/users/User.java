/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.users;

import controller.Controller;
import java.util.Map;
import model.maths.Matrix2x2;
import model.maths.Matrix3x3;

/**
 *
 * @author rober
 */
public class User implements InterfaceUser {
    
    
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private int isAdmin;
    private int id;
    private Controller controller;


    public User(int id){
        this.controller = new Controller();
        this.id = id;
        Map<String,String> data = controller.fetchUser(this.id);
        this.userName = data.get("userName");
        this.password = data.get("password");
        this.firstName = data.get("firstName");
        this.lastName = data.get("lastName");
        this.isAdmin = 0;
    }

    @Override
    public String[] solve(String equation1, String equation2) {
        boolean flag = true;
        if(equation1.equals(equation2) || equation1.equals(equation2)){
            flag = false;
        }
        // ax + by + c = 0
        double a1 = Double.parseDouble(equation1.substring(0, equation1.indexOf("x")));
        double b1 = Double.parseDouble(equation1.substring(equation1.indexOf("x") + 1, equation1.indexOf("y")));
        double c1 = Double.parseDouble(equation1.substring(equation1.indexOf("y") + 1,equation1.indexOf("="))) * -1;

        double a2 = Double.parseDouble(equation2.substring(0, equation2.indexOf("x")));
        double b2 = Double.parseDouble(equation2.substring(equation2.indexOf("x") + 1, equation2.indexOf("y")));
        double c2 = Double.parseDouble(equation2.substring(equation2.indexOf("y") + 1,equation1.indexOf("="))) * -1;

        Matrix2x2 matrix2x2 = new Matrix2x2(a1,b1,a2,b2,c1,c2);

        double[] solution = matrix2x2.getSolution();

        System.out.println("x::"+solution[0] + ", y::"+ solution[1]);
        StringBuilder equations = new StringBuilder(equation1).append(";").append(equation2);

        String x = String.format("%,.2f", solution[0]);
        String y = String.format("%,.2f", solution[1]);


        if(flag){
            controller.saveSolution(this.id, equations.toString(), x, y, "-");
            return new String[]{x,y,""};
        }

        return new String[]{"-","-","-"};


    }

    @Override
    public String[] solve(String equation1, String equation2, String equation3) {

        //ax+by+cz+d=0
        boolean flag = true;
        if(equation1.equals(equation2) || equation1.equals(equation3) || equation2.equals(equation3)){
            flag = false;
        }

        double a1 = Double.parseDouble((equation1.substring(0, equation1.indexOf("x"))));
        double b1 = Double.parseDouble((equation1.substring(equation1.indexOf("x") + 1, equation1.indexOf("y"))));
        double c1 = Double.parseDouble((equation1.substring(equation1.indexOf("y") + 1, equation1.indexOf("z"))));
        double d1 = Double.parseDouble((equation1.substring(equation1.indexOf("z") + 1, equation1.indexOf("=")))) * -1;

        double a2 = Double.parseDouble((equation2.substring(0, equation2.indexOf("x"))));
        double b2 = Double.parseDouble((equation2.substring(equation2.indexOf("x") + 1, equation2.indexOf("y"))));
        double c2 = Double.parseDouble((equation2.substring(equation2.indexOf("y") + 1, equation2.indexOf("z"))));
        double d2 = Double.parseDouble((equation2.substring(equation2.indexOf("z") + 1,equation2.indexOf("=")))) * -1;

        double a3 = Double.parseDouble((equation3.substring(0, equation3.indexOf("x"))));
        double b3 = Double.parseDouble((equation3.substring(equation3.indexOf("x") + 1, equation3.indexOf("y"))));
        double c3 = Double.parseDouble((equation3.substring(equation3.indexOf("y") + 1, equation3.indexOf("z"))));
        double d3 = Double.parseDouble((equation3.substring(equation3.indexOf("z") + 1,equation3.indexOf("=")))) * -1;

        Matrix3x3 matrix3x3 = new Matrix3x3(a1,b1,c1,a2,b2,c2,a3,b3,c3,d1,d2,d3);

        double[] solution = matrix3x3.getSolution();

        StringBuilder equations = new StringBuilder(equation1).append(";").append(equation2).append(";").append(equation3);

        String x = String.format("%,.2f", solution[0]);
        String y = String.format("%,.2f", solution[1]);
        String z = String.format("%,.2f", solution[2]);


        if(flag){
            controller.saveSolution(this.id,equations.toString(),x,y,z);
            return new String[]{x,y,z};
        }
        return new String[]{"-","-","-"};
        

    }
}
