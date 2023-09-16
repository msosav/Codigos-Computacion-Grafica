package math;

public class UVN4x4 extends Matrix4x4 {

    public UVN4x4() {
        super();

        matrix[0][0] = 1;
        matrix[1][1] = 1;
        matrix[2][2] = 1;
        matrix[3][3] = 1;
    }

    public UVN4x4(Vector4 from, Vector4 lookAt, Vector4 up) {
        super();

        Vector4 n = Vector4.subtract(from, lookAt);

        n.normalize();

        Vector4 u = Vector4.cross(up, n);

        u.normalize();

        Vector4 v = Vector4.cross(n, u);

        v.normalize();

        matrix[0][0] = u.vector[0];
        matrix[0][1] = u.vector[1];
        matrix[0][2] = u.vector[2];
        matrix[0][3] = Vector4.dot(Vector4.minus(u), from);

        matrix[1][0] = v.vector[0];
        matrix[1][1] = v.vector[1];
        matrix[1][2] = v.vector[2];
        matrix[1][3] = Vector4.dot(Vector4.minus(v), from);

        matrix[2][0] = n.vector[0];
        matrix[2][1] = n.vector[1];
        matrix[2][2] = n.vector[2];
        matrix[2][3] = Vector4.dot(Vector4.minus(n), from);
    }

    public UVN4x4 createUVN(){
        UVN4x4 uvn = new UVN4x4();
        uvn.matrix[0][0] = matrix[0][0];
        uvn.matrix[0][1] = matrix[0][1];
        uvn.matrix[0][2] = matrix[0][2];
        uvn.matrix[0][3] = matrix[0][3];

        uvn.matrix[1][0] = matrix[1][0];
        uvn.matrix[1][1] = matrix[1][1];
        uvn.matrix[1][2] = matrix[1][2];
        uvn.matrix[1][3] = matrix[1][3];

        uvn.matrix[2][0] = matrix[2][0];
        uvn.matrix[2][1] = matrix[2][1];
        uvn.matrix[2][2] = matrix[2][2];
        uvn.matrix[2][3] = matrix[2][3];

        uvn.matrix[3][0] = matrix[3][0];
        uvn.matrix[3][1] = matrix[3][1];
        uvn.matrix[3][2] = matrix[3][2];
        uvn.matrix[3][3] = matrix[3][3];

        return uvn;
    }
}