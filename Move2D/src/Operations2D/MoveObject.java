package Operations2D;

import java.util.ArrayList;
import java.util.Map;

import Math.Edge;
import Math.Matrix3x3;
import Math.Point2;

public class MoveObject {
    public Map<Integer, Point2> points;
    public ArrayList<Edge> edges;

    public Translation3x3 translationMatrix;
    public Scaling3x3 scaledMatrix;
    public Rotation3x3 rotatedMatrix;

    public static boolean CENTER_TRANSFORMS;

    public MoveObject(Map<Integer, Point2> points, ArrayList<Edge> edges, Point2 origen) {
        this.points = points;
        this.edges = edges;
    }

    public ArrayList<Edge> up(int dy) {
        this.translationMatrix = new Translation3x3(0, dy);
        return Matrix3x3.times(edges, translationMatrix.matrix);
    }

    public ArrayList<Edge> down(int dy) {
        this.translationMatrix = new Translation3x3(0, -dy);
        return Matrix3x3.times(edges, translationMatrix.matrix);
    }

    public ArrayList<Edge> left(int dx) {
        this.translationMatrix = new Translation3x3(-dx, 0);
        return Matrix3x3.times(edges, translationMatrix.matrix);
    }

    public ArrayList<Edge> right(int dx) {
        this.translationMatrix = new Translation3x3(dx, 0);
        return Matrix3x3.times(edges, translationMatrix.matrix);
    }

    public ArrayList<Edge> scaleUp(double sx, double sy) {
        this.scaledMatrix = new Scaling3x3(sx, sy);
        if (CENTER_TRANSFORMS) {
            Matrix3x3 aux = transform(0, 0, sx, sy, 0);
            return Matrix3x3.times(edges, aux);
        } else {
            return Matrix3x3.times(edges, scaledMatrix.matrix);
        }
    }

    public ArrayList<Edge> scaleDown(double sx, double sy) {
        this.scaledMatrix = new Scaling3x3(1 / sx, 1 / sy);
        return Matrix3x3.times(edges, scaledMatrix.matrix);
    }

    public ArrayList<Edge> rotate(double theta) {
        this.rotatedMatrix = new Rotation3x3(theta);
        return Matrix3x3.times(edges, rotatedMatrix.matrix);
    }

    public Matrix3x3 transform(double dx, double dy, double sx, double sy, double theta) {
        Translation3x3 translation = new Translation3x3(dx, dy);
        Scaling3x3 scaling = new Scaling3x3(sx, sy);
        Rotation3x3 rotation = new Rotation3x3(theta);

        Matrix3x3 m2 = new Translation3x3(-dx, -dy).matrix;
        Matrix3x3 m3 = new Scaling3x3(sx, sy).matrix;
        Matrix3x3 m4 = new Translation3x3(dx, dy).matrix;
        scaling.matrix = Matrix3x3.times(m4, Matrix3x3.times(m3, m2));
        Matrix3x3 m5 = new Rotation3x3(theta).matrix;
        rotation.matrix = Matrix3x3.times(m4, Matrix3x3.times(m5, m2));

        Matrix3x3 m1 = Matrix3x3.times(scaling.matrix, translation.matrix);
        Matrix3x3 finalMatrix = Matrix3x3.times(rotation.matrix, m1);

        return finalMatrix;
    }
}
