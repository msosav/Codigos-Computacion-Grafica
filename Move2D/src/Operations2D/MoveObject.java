package Operations2D;

import java.util.ArrayList;
import java.util.Map;

import Math.Edge;
import Math.Matrix3x3;
import Math.Point2;
import Math.Point3;
import Utils.DrawFigure;
import java.awt.Color;

import java.awt.Graphics;

public class MoveObject {
    public Map<Integer, Point2> points;
    public ArrayList<Edge> edges;

    public TranslScalRot3x3 translationMatrix;
    public TranslScalRot3x3 scaledMatrix;
    public TranslScalRot3x3 rotatedMatrix;
    public int transformation = 0;

    public static boolean CENTER_TRANSFORMS;

    public MoveObject(Map<Integer, Point2> points, ArrayList<Edge> edges) {
        this.points = points;
        this.edges = edges;
    }

    public void up(int dy) {
        translationMatrix = new TranslScalRot3x3(0, dy, 1, 1, 0);
        setEdges(translationMatrix);
    }

    public void down(int dy) {
        translationMatrix = new TranslScalRot3x3(0, -dy, 1, 1, 0);
        setEdges(translationMatrix);
    }

    public void left(int dx) {
        translationMatrix = new TranslScalRot3x3(-dx, 0, 1, 1, 0);
        setEdges(translationMatrix);
    }

    public void right(int dx) {
        translationMatrix = new TranslScalRot3x3(dx, 0, 1, 1, 0);
        setEdges(translationMatrix);
    }

    public void scaleUp(double sx, double sy) {
        Point2 center = findCenter();
        pointsToCenter(center);
        TranslScalRot3x3 scaleMatrix = new TranslScalRot3x3(0, 0, sx, sy, 0);
        setEdges(scaleMatrix);
        pointsToNormal(center);
    }

    public ArrayList<Edge> scaleDown(double sx, double sy) {
        Point2 center = findCenter();
        pointsToCenter(center);
        TranslScalRot3x3 scaleMatrix = new TranslScalRot3x3(0, 0, 1 / sx, 1 / sy, 0);
        setEdges(scaleMatrix);
        pointsToNormal(center);
        return edges;
    }

    public void scale(double sx, double sy) {
        Point2 center = findCenter();
        pointsToCenter(center);
        TranslScalRot3x3 scaleMatrix = new TranslScalRot3x3(0, 0, sx, sy, 0);
        setEdges(scaleMatrix);
        pointsToNormal(center);
    }

    public ArrayList<Edge> rotate(double theta) {
        Point2 center = findCenter();
        pointsToCenter(center);
        TranslScalRot3x3 rotateMatrix = new TranslScalRot3x3(0, 0, 1, 1, theta);

        setEdges(rotateMatrix);
        pointsToNormal(center);
        return edges;
    }

    public Point2 findCenter() {
        double x = 0;
        double y = 0;
        for (Point2 point : points.values()) {
            x += point.x;
            y += point.y;
        }
        x /= points.size();
        y /= points.size();
        return new Point2(x, y);
    }

    public void pointsToCenter(Point2 center) {
        for (Point2 point : points.values()) {
            point.x -= center.x;
            point.y -= center.y;
        }
    }

    public void pointsToNormal(Point2 center) {
        for (Point2 point : points.values()) {
            point.x += center.x;
            point.y += center.y;
        }
    }

    public void drawFigure(Graphics g) {
        g.setColor(Color.black);
        for (Edge edge : edges) {
            DrawFigure.myDrawLine(g, (int) edge.point1.x, (int) edge.point1.y, (int) edge.point2.x,
                    (int) edge.point2.y);
        }
    }

    public void setEdges(TranslScalRot3x3 matrix) {
        for (Edge edge : edges) {
            Point3 point1 = new Point3(edge.point1.x, edge.point1.y, 1);
            Point3 point2 = new Point3(edge.point2.x, edge.point2.y, 1);

            point1 = Matrix3x3.times(matrix.matrix, point1);
            point2 = Matrix3x3.times(matrix.matrix, point2);

            edge.point1 = new Point2(point1.x, point1.y);
            edge.point2 = new Point2(point2.x, point2.y);
        }
    }
}
