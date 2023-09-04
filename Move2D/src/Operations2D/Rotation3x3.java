package Operations2D;

import Math.Matrix3x3;

public class Rotation3x3 extends Matrix3x3 {
    public double angle = 0;
    public Matrix3x3 matrix;

    public Rotation3x3(double angle) {
        super();
        this.angle = angle;
        this.matrix = new Matrix3x3(Math.cos(angle), -Math.sin(angle), 0,
                                    Math.sin(angle), Math.cos(angle), 0,
                                    0, 0, 1);
    }
}
