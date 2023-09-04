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
    static Scanner scanner;

    public ReadTextFile(String fileName) {
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        readFile(fileName);
    }

    public void readFile(String fileName) {
        setPoints();
        setEdges(points, edges);
    }

    public void setPoints() {
        int numPoints = scanner.nextInt();
        for (int i = 0; i <= numPoints - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.put(i, new Point2(x, y));
        }
    }

    public static void setEdges(Map<Integer, Point2> points, ArrayList<Edge> edges) {
        int numEdges = scanner.nextInt();
        for (int i = 0; i <= numEdges - 1; i++) {
            int punto1 = scanner.nextInt();
            int punto2 = scanner.nextInt();
            edges.add(new Edge(points.get(punto1), points.get(punto2)));
        }
    }
}