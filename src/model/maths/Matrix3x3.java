/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.maths;

/**
 *
 * @author rober
 */
public class Matrix3x3{

    private double[] matrix;
    private double delta;
    private double constants[];

    // for internal computation, we dont need constants in odrer to get the final form or 
    private Matrix3x3(double a1,double a2,double a3,double a4,double a5,double a6,double a7,double a8,double a9){
        this.matrix = new double[]{a1, a2, a3, a4, a5, a6, a7, a8, a9};

    }

    public Matrix3x3(double a1,double a2,double a3,double a4,double a5,double a6,double a7,double a8,double a9, double constant1, double constant2, double constant3){

        this.matrix = new double[]{a1, a2, a3, a4, a5, a6, a7, a8, a9};
        this.delta = getDelta();
        this.constants = new double[]{constant1,constant2,constant3};

    }

    
    private double[] getMinors() {

        /*
            |a1 a2 a3|      |as1 as2 as3|
            |a4 a5 a6|  =>  |as4 as5 as6|
            |a7 a8 a9|      |as7 as8 as9|
        */
        double as1 = new Matrix2x2(this.matrix[4],this.matrix[5],this.matrix[7],this.matrix[8]).getDelta();
        double as2 = new Matrix2x2(this.matrix[3],this.matrix[5],this.matrix[6],this.matrix[8]).getDelta();
        double as3 = new Matrix2x2(this.matrix[3],this.matrix[4],this.matrix[6],this.matrix[7]).getDelta();
        double as4 = new Matrix2x2(this.matrix[1],this.matrix[2],this.matrix[7],this.matrix[8]).getDelta();
        double as5 = new Matrix2x2(this.matrix[0],this.matrix[2],this.matrix[6],this.matrix[8]).getDelta();
        double as6 = new Matrix2x2(this.matrix[0],this.matrix[1],this.matrix[6],this.matrix[7]).getDelta();
        double as7 = new Matrix2x2(this.matrix[1],this.matrix[2],this.matrix[4],this.matrix[5]).getDelta();
        double as8= new Matrix2x2(this.matrix[0],this.matrix[2],this.matrix[3],this.matrix[5]).getDelta();
        double as9 = new Matrix2x2(this.matrix[0],this.matrix[1],this.matrix[3],this.matrix[4]).getDelta();

        return  new double[]{as1,as2,as3,as4,as5,as6,as7,as8,as9};
    }

    
    private double[] getCofactor() {
        /*
        it maps approptiate elements of the matrix
        |a1 a2 a3|      |a1 -a2  a3|
        |a4 a5 a6|  =>  |-a4 a5 -a6|
        |a7 a8 a9|      |a7 -a8  a9|
        */
        double[] min = this.getMinors();
        return new double[]{min[0], min[1]*-1,min[2],min[3]*-1,min[4],min[5]*-1,min[6],min[7]*-1,min[8]};
    }
    
    
    private double[] getTranspose() {
        /*
        it maps approptiate elements of the matrix
        |a1 a2 a3|      |a1 a4 a7|
        |a4 a5 a6|  =>  |a2 a5 a8|
        |a7 a8 a9|      |a3 a6 a9|
        */
        double[] coFac = this.getCofactor();
        return new double[]{coFac[0],coFac[3],coFac[6],coFac[1],coFac[4],coFac[7],coFac[2],coFac[5],coFac[8]};
    }
    
    
    private double getDelta() {
        double[] matrixOfCofactors = this.getCofactor();
        return (this.matrix[0]*matrixOfCofactors[0] + this.matrix[1]*matrixOfCofactors[1] + this.matrix[2]*matrixOfCofactors[2]);
    }
    
    
    private Matrix3x3 getInverse() {
        // each elemnet of matrix is devided by delta and new values are assigned to matrix[]
        double[] t = this.getTranspose();
        return new Matrix3x3( t[0]/this.delta,t[1]/this.delta,t[2]/this.delta,t[3]/this.delta,t[4]/this.delta,t[5]/this.delta,t[6]/this.delta,t[7]/this.delta,t[8]/this.delta);
    }
    





    public double[] getSolution(){
        /*
        it maps approptiate elements of the matrix
        |a1 a2 a3|    |c1|
        |a4 a5 a6|  * |c2| => (x, y ,z)
        |a7 a8 a9|    |c3|
        */
        Matrix3x3 temp = this.getInverse();
        double x = temp.matrix[0]*this.constants[0] + temp.matrix[1]*this.constants[1]+ temp.matrix[2]*this.constants[2];
        double y = temp.matrix[3]*this.constants[0] + temp.matrix[4]*this.constants[1] + temp.matrix[5]*this.constants[2];
        double z = temp.matrix[6]*this.constants[0] + temp.matrix[7]*this.constants[1] + temp.matrix[8]*this.constants[2];

        return new double[]{x,y,z};
    }
    
}
