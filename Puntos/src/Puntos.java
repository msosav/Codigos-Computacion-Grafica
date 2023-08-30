import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import Math.Edge;
import Math.Matrix3x3;
import Math.Point2;
import Math.Point3;

import javax.swing.JFrame;

public class Puntos extends JPanel {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 600;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawAxis(g);

        Map<Integer, Point2> pointsCasita = new HashMap<Integer, Point2>();
        ArrayList<Edge> edgesCasita = new ArrayList<Edge>();

        ReadTextFile casita = new ReadTextFile(pointsCasita, edgesCasita, "casita.txt");

        drawFigure(g, edgesCasita);
        traslateFigure(g, edgesCasita, 100, 50);
        // drawFigure(g, "gancho.txt");
    }

    public void traslateFigure(Graphics g, ArrayList<Edge> edges, int dx, int dy) {

        Matrix3x3 matriz = new Matrix3x3(1, 0, dx,
                                        0, 1, dy,
                                        0, 0, 1);

        g.setColor(Color.blue);

        for (Edge edge : edges) {
            Point3 punto1 = new Point3(edge.point1.x, edge.point1.y, 1);
            Point3 punto2 = new Point3(edge.point2.x, edge.point2.y, 1);
            punto1 = matriz.times(matriz, punto1);
            punto2 = matriz.times(matriz, punto2);

            edge.point1.x = punto1.x;
            edge.point1.y = punto1.y;

            edge.point2.x = punto2.x;
            edge.point2.y = punto2.y;

            myDrawLine(g, punto1.x, punto1.y, punto2.x, punto2.y);
        }
    }

    public void drawFigure(Graphics g, ArrayList<Edge> edges) {
        g.setColor(Color.black);

        for (Edge edge : edges) {
            myDrawLine(g, edge.point1.x, edge.point1.y, edge.point2.x, edge.point2.y);
        }
    }

    public void drawAxis(Graphics g) {
        g.setColor(Color.red);
        myDrawLine(g, -HEIGHT, 0, HEIGHT, 0);
        g.setColor(Color.green);
        myDrawLine(g, 0, -WIDTH, 0, WIDTH);
    }

    public void myDrawPoint(Graphics g, int x, int y) {
        int xj = x + WIDTH / 2;
        int yj = HEIGHT / 2 - y;
        g.drawLine(xj, yj, xj, yj);
    }

    public void myDrawLine(Graphics g, int x1, int y1, int x2, int y2) {
        int xj1 = x1 + WIDTH / 2;
        int yj1 = HEIGHT / 2 - y1;
        int xj2 = x2 + WIDTH / 2;
        int yj2 = HEIGHT / 2 - y2;
        g.drawLine(xj1, yj1, xj2, yj2);
    }

    public static void main(String[] args) {
        // Crear un nuevo Frame
        JFrame frame = new JFrame("Puntos");
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel que se llama Points (esta clase)
        frame.add(new Puntos());
        // Asignarle tamaño
        frame.setSize(WIDTH, HEIGHT);
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        // Mostrar el frame
        frame.setVisible(true);
    }

}