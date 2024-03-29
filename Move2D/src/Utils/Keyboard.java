package Utils;

import java.awt.event.KeyListener;
import java.util.ArrayList;

import Math.Edge;
import Utils.App;

import Operations2D.MoveObject;

import java.awt.event.KeyEvent;

public class Keyboard implements KeyListener {
    public static int dx = 0;
    public static int dy = 0;
    private MoveObject figure;
    private App app;

    public Keyboard(MoveObject figure, App app) {
        this.figure = figure;
        this.app = app;
    }

    public void keyPressed(KeyEvent e) {
        int units = 10;

        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_W:
                figure.up(units);
                break;
            case KeyEvent.VK_S:
                figure.down(units);
                break;
            case KeyEvent.VK_A:
                figure.left(units);
                break;
            case KeyEvent.VK_D:
                figure.right(units);
                break;
            case KeyEvent.VK_Q:
                figure.scaleUp(1.1, 1.1);
                break;
            case KeyEvent.VK_E:
                figure.scaleDown(1.1, 1.1);
                break;
            case KeyEvent.VK_R:
                figure.rotate(1);
                break;
            case KeyEvent.VK_T:
                figure.rotate(-1);
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
        }

        app.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
