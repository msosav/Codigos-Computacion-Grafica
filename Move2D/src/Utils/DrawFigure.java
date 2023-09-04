package Utils;

import java.util.ArrayList;

import java.awt.Graphics;
import java.awt.Color;

import Math.Edge;

public class DrawFigure {
    private static int WIDTH = App.getWIDTH();
    public static int HEIGHT = App.getHEIGHT();

    public DrawFigure(Graphics g) {
        super();
    }

    public static void drawFigure(Graphics g, ArrayList<Edge> edges) {
        g.setColor(Color.black);

        for (Edge edge : edges) {
            myDrawLine(g, (int) edge.point1.x, (int) edge.point1.y, (int) edge.point2.x, (int) edge.point2.y);
        }
    }

    public static void drawAxis(Graphics g) {
        g.setColor(Color.red);
        myDrawLine(g, -WIDTH, 0, HEIGHT, 0);
        g.setColor(Color.green);
        myDrawLine(g, 0, -WIDTH, 0, WIDTH);
    }

    public void myDrawPoint(Graphics g, int x, int y) {
        int xj = x + WIDTH / 2;
        int yj = HEIGHT / 2 - y;
        g.drawLine(xj, yj, xj, yj);
    }

    public static void myDrawLine(Graphics g, int x1, int y1, int x2, int y2) {
        int xj1 = x1 + WIDTH / 2;
        int yj1 = HEIGHT / 2 - y1;
        int xj2 = x2 + WIDTH / 2;
        int yj2 = HEIGHT / 2 - y2;
        g.drawLine(xj1, yj1, xj2, yj2);
    }
}
