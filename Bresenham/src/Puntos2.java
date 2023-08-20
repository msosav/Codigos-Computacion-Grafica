import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class Puntos2 extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.blue);

        drawAxis(g2d);

        // Dibujar unos puntos.
        g2d.drawLine(10000, 1000, 20000, 1000);
        g2d.drawLine(20, 20, 20, 20);
        g2d.drawLine(30, 30, 30, 30);
        g2d.drawLine(40, 40, 40, 40);

        // bresenham(10, 10, 100, 100, g2d);
    }

    public void bresenham(int x1, int y1, int x2, int y2, Graphics2D g2d) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int incE = 2 * dy;
        int incNE = 2 * dy - 2 * dx;
        int d = 2 * dy - dx;
        int y = y1;
        for (int x = x1; x <= x2; x++) {
            myDrawLine(g2d, x, y, x, y);
            if (d <= 0) {
                d += incE;
            } else {
                d += incNE;
                y += 1;
            }
        }
    }

    public void drawAxis(Graphics2D g) {
        g.setColor(Color.red);
        myDrawLine(g, -HEIGHT, 0, HEIGHT, 0);
        g.setColor(Color.green);
        myDrawLine(g, 0, -WIDTH, 0, WIDTH);
    }

    public void myDrawLine(Graphics2D g, int x1, int y1, int x2, int y2) {
        int xj1 = x1 + WIDTH / 2;
        int yj1 = HEIGHT / 2 - y1;
        int xj2 = x2 + WIDTH / 2;
        int yj2 = HEIGHT / 2 - y2;
        g.drawLine(xj1, yj1, xj2, yj2);
    }

    public static void main(String[] args) {
        // Crear un nuevo Frame
        JFrame frame = new JFrame("Puntos2");
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel que se llama Points (esta clase)
        frame.add(new Puntos2());
        // Asignarle tamaño
        frame.setSize(700, 500);
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        // Mostrar el frame
        frame.setVisible(true);
    }

}
