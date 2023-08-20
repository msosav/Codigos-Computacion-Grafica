import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class Puntos extends JPanel {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 600;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawAxis(g);

        drawFigure(g, "casita.txt");
        drawFigure(g, "gancho.txt");
    }

    public void drawFigure(Graphics g, String fileName) {
        Map<Integer, String> points = new HashMap<Integer, String>();
        Map<Integer, String> lines = new HashMap<Integer, String>();
        ReadTextFile casita = new ReadTextFile(points, lines).readFile(fileName);
        g.setColor(Color.black);
        casita.lines.forEach((k, v) -> {
            String[] line = v.split(",");

            int index1 = Integer.parseInt(line[0]);
            int index2 = Integer.parseInt(line[1]);

            String[] point1 = casita.points.get(index1).split(",");
            String[] point2 = casita.points.get(index2).split(",");

            int x1 = Integer.parseInt(point1[0]);
            int y1 = Integer.parseInt(point1[1]);
            int x2 = Integer.parseInt(point2[0]);
            int y2 = Integer.parseInt(point2[1]);

            myDrawLine(g, x1, y1, x2, y2);
        });
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