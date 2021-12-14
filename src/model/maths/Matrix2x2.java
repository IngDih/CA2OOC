/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.maths;

/**
 *
 * @author rober
 */
public class Matrix2x2 implements InterfaceMatrix{
    
    /*
        | a1 a2 |
        | a3 a4 |

    */

    private double[] matrix;
    private double[] constants;
    private double delta;

    public Matrix2x2(double a1, double a2, double a3, double a4, double c1, double c2) {
        this.matrix = new double[] {a1,a2,a3,a4};
        this.constants = new double[] {c1, c2};
        this.delta = getDelta();

    }
    // for matrix3x3 purpose only
    protected Matrix2x2(double a1, double a2, double a3, double a4) {
        this.matrix = new double[] {a1,a2,a3,a4};
        this.delta = getDelta();

    }
    
    
    private double getDelta() {
        return (this.matrix[0]*this.matrix[3] - this.matrix[1]*this.matrix[2]);
    }

    
    private Matrix2x2 getInverse() {

        if(this.delta == 0) {
            // what if delta equals 0 ? can't divide by 0, is there no solution?
        }

        double a = this.matrix[0]/this.delta;
        double b = this.matrix[1]/this.delta;;
        double c = this.matrix[2]/this.delta;
        double d = this.matrix[3]/this.delta;;

        return  new Matrix2x2(d,-b,-c,a, this.constants[0], this.constants[1]);

    }

    @Override
    public double[] getSolution() {
        Matrix2x2 temp = this.getInverse();
        double x = temp.matrix[0]*this.constants[0] + temp.matrix[1]*this.constants[1];
        double y = temp.matrix[2]*this.constants[0] + temp.matrix[3]*this.constants[1];

        return new double[]{x,y};
    }

    
}
