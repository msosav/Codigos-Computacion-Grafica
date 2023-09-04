package Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Math.Edge;
import Math.Point2;
import Operations2D.MoveObject;

import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

public class App extends JPanel {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;

    public MoveObject figure;

    public App(String fileName) {
        ReadTextFile figureFile = new ReadTextFile(fileName);
        Map<Integer, Point2> points = figureFile.points;
        ArrayList<Edge> edges = figureFile.edges;
        Point2 origen = figureFile.origen;
        figure = new MoveObject(points, edges, origen);
        this.addKeyListener(
                new Keyboard(figure, this));
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        DrawFigure.drawAxis(g);
        DrawFigure.drawFigure(g, figure.edges);
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }
}
