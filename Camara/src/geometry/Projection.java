package geometry;

import math.Matrix4x4;

public class Projection extends Matrix4x4{
    public double projectionDistance;
    public PolygonObject transformedObject;

    public Projection(double d) {
        super();
        matrix[3][2] = 1/d;
        matrix[3][3] = 0;

        projectionDistance = d;

        transformedObject = null;

        applyProjection();
    }

    private void applyProjection() {
        Projection proj = new Projection(-projectionDistance);
        transformedObject = PolygonObject.transformObject(transformedObject, proj);
    }
}
