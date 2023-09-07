
import javax.swing.JPanel;

import Utils.App;

import javax.swing.JFrame;

public class Main extends JPanel {
    public static void main(String[] args) {
        App app = new App("casita.txt");
        JFrame frame = new JFrame("Puntos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(app);
        Operations2D.TranslScalRot3x3.CENTER_TRANFORMS = true;
        frame.setSize(App.getWIDTH(), App.getHEIGHT());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}