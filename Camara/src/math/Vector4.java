package math;

public class Vector4 {
    public double [] vector = new double[4];

    public Vector4() {
        vector[0] = 0;
        vector[1] = 0;
        vector[2] = 0;
        vector[3] = 1;
    }

    public Vector4(double x, double y, double z) {
        vector[0] = x;
        vector[1] = y;
        vector[2] = z;
        vector[3] = 1;
    }

    public void normalizeW() {
        if(vector[3] == 0) {
            return;
        }
        vector[0] /= vector[3];
        vector[1] /= vector[3];
        vector[2] /= vector[3];
        vector[3] = 1;
    }

    public String toString() {
        return "(" + vector[0] + ", " + vector[1] + ", " + vector[2] + ")";
    }

    public static Vector4 subtract(Vector4 v1, Vector4 v2) {
        return new Vector4(v1.vector[0] - v2.vector[0], v1.vector[1] - v2.vector[1], v1.vector[2] - v2.vector[2]);
    }

    public static Vector4 cross(Vector4 v1, Vector4 v2) {
        return new Vector4(v1.vector[1] * v2.vector[2] - v1.vector[2] * v2.vector[1],
                           v1.vector[2] * v2.vector[0] - v1.vector[0] * v2.vector[2],
                           v1.vector[0] * v2.vector[1] - v1.vector[1] * v2.vector[0]);
    }

    public static Vector4 minus(Vector4 v) {
        return new Vector4(-v.vector[0], -v.vector[1], -v.vector[2]);
    }

    public static double dot(Vector4 v1, Vector4 v2) {
        return v1.vector[0] * v2.vector[0] + v1.vector[1] * v2.vector[1] + v1.vector[2] * v2.vector[2];
    }

    public void normalize() {
        double length = Math.sqrt(vector[0] * vector[0] + vector[1] * vector[1] + vector[2] * vector[2]);
        vector[0] /= length;
        vector[1] /= length;
        vector[2] /= length;
    }
}
