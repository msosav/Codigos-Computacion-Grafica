package Operations2D;

import Math.Matrix3x3;

public class Scaling3x3 extends Matrix3x3 {
    public double sx;
    public double sy;
    public Matrix3x3 matrix;

    public Scaling3x3(double sx, double sy) {
        super();
        this.sx = sx;
        this.sy = sy;
        this.matrix = new Matrix3x3(sx, 0, 0,
                0, sy, 0,
                0, 0, 1);
    }

}
