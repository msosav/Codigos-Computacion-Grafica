package Operations2D;

import Math.Matrix3x3;

// This class performs the following transformations:
// - Translation
// - Scaling
// - Rotation
public class TranslScalRot3x3 extends Matrix3x3 {

    double dx = 0;
    double dy = 0;
    double sx = 1;
    double sy = 1;
    double theta = 0;
    public Matrix3x3 matrix;

    public static boolean CENTER_TRANFORMS;

    public TranslScalRot3x3() {
        super();
        this.dx = 0;
        this.dy = 0;
        this.sx = 1;
        this.sy = 1;
        this.theta = 0;
    }

    public TranslScalRot3x3(double dx, double dy, double sx, double sy, double theta) {
        super();
        this.dx = dx;
        this.dy = dy;
        this.sx = sx;
        this.sy = sy;
        this.theta = theta;
        this.matrix = new Matrix3x3(sx, 0, dx,
                0, sy, dy,
                0, 0, 1);

        Translation3x3 translation = new Translation3x3(dx, dy);
        Scaling3x3 scaling = new Scaling3x3(sx, sy);
        Rotation3x3 rotation = new Rotation3x3(theta);

        if (CENTER_TRANFORMS) {
            Translation3x3 m2 = new Translation3x3(-dx, -dy);
            Scaling3x3 m3 = new Scaling3x3(sx, sy);
            Translation3x3 m4 = new Translation3x3(dx, dy);
            scaling.matrix = Matrix3x3.times(m4.matrix, Matrix3x3.times(m3.matrix, m2.matrix));
            Rotation3x3 m5 = new Rotation3x3(theta);
            rotation.matrix = Matrix3x3.times(m4.matrix, Matrix3x3.times(m5.matrix, m2.matrix));
        }

        Matrix3x3 m1 = Matrix3x3.times(scaling.matrix, translation.matrix);
        Matrix3x3 finalMatrix = Matrix3x3.times(rotation.matrix, m1);
        this.matrix = finalMatrix;
    }

}
