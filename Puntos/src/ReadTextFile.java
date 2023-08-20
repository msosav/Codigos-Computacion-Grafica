import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadTextFile {
    public Map<Integer, String> points = new HashMap<Integer, String>();
    public Map<Integer, String> lines = new HashMap<Integer, String>();

    public ReadTextFile(Map<Integer, String> points, Map<Integer, String> lines) {
        this.points = points;
        this.lines = lines;
    }

    public ReadTextFile readFile(String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            int numPoints = scanner.nextInt();
            for (int i = 0; i <= numPoints - 1; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String point = x + "," + y;
                points.put(i, point);
            }
            int numLines = scanner.nextInt();
            for (int i = 0; i <= numLines - 1; i++) {
                int indice1 = scanner.nextInt();
                int indice2 = scanner.nextInt();
                String line = indice1 + "," + indice2;
                lines.put(i, line);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new ReadTextFile(points, lines);
    }
}