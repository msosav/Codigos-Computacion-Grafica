package Operations2D;

import Math.Matrix3x3;

public class Translation3x3 extends Matrix3x3{
    public double dx = 0;
    public double dy = 0;
    public Matrix3x3 matrix;

    public Translation3x3(double dx, double dy) {
        super();
        this.dx = dx;
        this.dy = dy;
        this.matrix = new Matrix3x3(1, 0, dx,
                                    0, 1, dy,
                                    0, 0, 1);
    }
}
