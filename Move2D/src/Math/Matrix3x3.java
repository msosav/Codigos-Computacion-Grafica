package Math;

import java.util.ArrayList;

import Operations2D.TranslScalRot3x3;

public class Matrix3x3 {
    public double a11, a12, a13;
    public double a21, a22, a23;
    public double a31, a32, a33;

    public Matrix3x3() {
        this.a11 = 1;
        this.a12 = 0;
        this.a13 = 0;
        this.a21 = 0;
        this.a22 = 1;
        this.a23 = 0;
        this.a31 = 0;
        this.a32 = 0;
        this.a33 = 1;
    }

    public Matrix3x3(double a11, double a12, double a13,
            double a21, double a22, double a23,
            double a31, double a32, double a33) {
        this.a11 = a11;
        this.a12 = a12;
        this.a13 = a13;
        this.a21 = a21;
        this.a22 = a22;
        this.a23 = a23;
        this.a31 = a31;
        this.a32 = a32;
        this.a33 = a33;
    }

    public Point3 times(Matrix3x3 Matriz, Point3 Punto) {
        return new Point3(
                Matriz.a11 * Punto.x + Matriz.a12 * Punto.y + Matriz.a13 * Punto.z,
                Matriz.a21 * Punto.x + Matriz.a22 * Punto.y + Matriz.a23 * Punto.z,
                Matriz.a31 * Punto.x + Matriz.a32 * Punto.y + Matriz.a33 * Punto.z);
    }

    public static Matrix3x3 times(Matrix3x3 Matriz1, Matrix3x3 Matriz2) {
        return new Matrix3x3(
                Matriz1.a11 * Matriz2.a11 + Matriz1.a12 * Matriz2.a21 + Matriz1.a13 * Matriz2.a31,
                Matriz1.a11 * Matriz2.a12 + Matriz1.a12 * Matriz2.a22 + Matriz1.a13 * Matriz2.a32,
                Matriz1.a11 * Matriz2.a13 + Matriz1.a12 * Matriz2.a23 + Matriz1.a13 * Matriz2.a33,
                Matriz1.a21 * Matriz2.a11 + Matriz1.a22 * Matriz2.a21 + Matriz1.a23 * Matriz2.a31,
                Matriz1.a21 * Matriz2.a12 + Matriz1.a22 * Matriz2.a22 + Matriz1.a23 * Matriz2.a32,
                Matriz1.a21 * Matriz2.a13 + Matriz1.a22 * Matriz2.a23 + Matriz1.a23 * Matriz2.a33,
                Matriz1.a31 * Matriz2.a11 + Matriz1.a32 * Matriz2.a21 + Matriz1.a33 * Matriz2.a31,
                Matriz1.a31 * Matriz2.a12 + Matriz1.a32 * Matriz2.a22 + Matriz1.a33 * Matriz2.a32,
                Matriz1.a31 * Matriz2.a13 + Matriz1.a32 * Matriz2.a23 + Matriz1.a33 * Matriz2.a33);
    }

    public static ArrayList<Edge> times(ArrayList<Edge> edges, Matrix3x3 translationMatrix) {
        ArrayList<Edge> newEdges = new ArrayList<Edge>();
        for (Edge edge : edges) {
            Point3 point1 = new Point3(edge.point1.x, edge.point1.y, 1);
            Point3 point2 = new Point3(edge.point2.x, edge.point2.y, 1);

            Point3 newPoint1 = translationMatrix.times(translationMatrix, point1);
            Point3 newPoint2 = translationMatrix.times(translationMatrix, point2);

            newEdges.add(new Edge(new Point2(newPoint1.x, newPoint1.y), new Point2(newPoint2.x, newPoint2.y)));
        }
        return newEdges;
    }
}
