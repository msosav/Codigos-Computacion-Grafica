package Math;

public class Matrix3x3 {
    public int a11;
    public int a12;
    public int a13;
    public int a21;
    public int a22;
    public int a23;
    public int a31;
    public int a32;
    public int a33;

    public Matrix3x3(
            int a11, int a12, int a13,
            int a21, int a22, int a23,
            int a31, int a32, int a33) {
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
}
