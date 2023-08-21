import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Bresenham extends JPanel {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final int MAX_X = 100;
    private static final int MAX_Y = 100;

    public static void main(String[] args) {
        // Crear un nuevo Frame
        JFrame frame = new JFrame("Bresenham");
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel que se llama Points (esta clase)
        frame.add(new Bresenham());
        // Asignarle tamaño
        frame.setSize(WIDTH, HEIGHT);
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        // Mostrar el frame
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawAxis(g);

        int x1 = -MAX_X, x2 = MAX_X * -2 / 3, x3 = MAX_X * 2 / 3, x4 = MAX_X, x5 = MAX_X * 1 / 3, x6 = MAX_X * -1 / 3;
        int y1 = -MAX_Y, y2 = MAX_Y * -2 / 3, y3 = MAX_Y * 2 / 3, y4 = MAX_Y, y5 = MAX_Y * 1 / 3, y6 = MAX_Y * -1 / 3;

        int[] x = { x1, x2, x3, x4, x5, x6 };
        int[] y = { y1, y2, y3, y4, y5, y6 };

        drawOctants(g, x, y);
    }

    public void drawOctants(Graphics g, int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {
            bresenham(g, 0, 0, -MAX_X, y[i]);
            bresenham(g, 0, 0, x[i], -MAX_Y);
            bresenham(g, 0, 0, MAX_X, y[i]);
            bresenham(g, 0, 0, x[i], MAX_Y);
        }
    }

    public void drawAxis(Graphics g) {
        g.setColor(Color.red);
        myDrawLine(g, -MAX_X, 0, MAX_X, 0);
        g.setColor(Color.green);
        myDrawLine(g, 0, -MAX_Y, 0, MAX_Y);
    }

    public void myDrawPoint(Graphics g, int x, int y) {
        g.setColor(Color.black);
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

    private void bresenham(Graphics g, int x1, int y1, int x2, int y2) {
        // delta of exact value and rounded value of the dependent variable
        int d = 0;

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int dx2 = 2 * dx; // slope scaling factors to
        int dy2 = 2 * dy; // avoid floating point

        int ix = x1 < x2 ? 1 : -1; // increment direction
        int iy = y1 < y2 ? 1 : -1;

        int x = x1;
        int y = y1;

        if (dx >= dy) {
            while (true) {
                myDrawPoint(g, x, y);
                if (x == x2)
                    break;
                x += ix;
                d += dy2;
                if (d > dx) {
                    y += iy;
                    d -= dx2;
                }
            }
        } else {
            while (true) {
                myDrawPoint(g, x, y);
                if (y == y2)
                    break;
                y += iy;
                d += dx2;
                if (d > dy) {
                    x += ix;
                    d -= dy2;
                }
            }
        }
    }
}