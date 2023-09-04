package Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import Math.Point2;
import Math.Edge;

public class ReadTextFile {
    public Map<Integer, Point2> points = new HashMap<Integer, Point2>();
    public ArrayList<Edge> edges = new ArrayList<Edge>();
    public Point2 origen;

    public ReadTextFile(String fileName) {
        readFile(fileName);
    }

    public void readFile(String fileName) {
        int mayorX = 0;
        int mayorY = 0;

        try {
            Scanner scanner = new Scanner(new File(fileName));
            int numPoints = scanner.nextInt();
            for (int i = 0; i <= numPoints - 1; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                points.put(i, new Point2(x, y));
                mayorX += x;
                mayorY += y;
            }
            int ox = (mayorX)/numPoints;
            int oy = (mayorY)/numPoints;
            origen = new Point2(ox, oy);
            int numLines = scanner.nextInt();
            for (int i = 0; i <= numLines - 1; i++) {
                int punto1 = scanner.nextInt();
                int punto2 = scanner.nextInt();
                edges.add(new Edge(points.get(punto1), points.get(punto2)));
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}