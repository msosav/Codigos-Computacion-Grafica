package Math;

public class Vector3 {
    public int x;
    public int y;
    public int z;

    public Vector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector3 crossProduct(Vector3 Vector1, Vector3 Vector2) {
        return new Vector3(
                Vector1.y * Vector2.z - Vector1.z * Vector2.y,
                Vector1.z * Vector2.x - Vector1.x * Vector2.z,
                Vector1.x * Vector2.y - Vector1.y * Vector2.x);
    }

    public static double dotProduct(Vector3 Vector1, Vector3 Vector2) {
        return Vector1.x * Vector2.x + Vector1.y * Vector2.y + Vector1.z * Vector2.z;
    }

    public static double magnitude(Vector3 Vector) {
        return Math.sqrt(Vector.x * Vector.x + Vector.y * Vector.y + Vector.z * Vector.z);
    }

    public static Vector3 normalize(Vector3 Vector) {
        double Magnitude = Vector3.magnitude(Vector);
        return new Vector3((int) (Vector.x / Magnitude), (int) (Vector.y / Magnitude), (int) (Vector.z / Magnitude));
    }
}
