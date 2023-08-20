package Math;


public class EcParSegRec {
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    public int u1;
    public int u2;

    public EcParSegRec(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public static void solve(EcParSegRec epsr1, EcParSegRec epsr2){
        int x1 = epsr1.x1;
        int y1 = epsr1.y1;
        int x2 = epsr1.x2;
        int y2 = epsr1.y2;

        int u1 = epsr2.x1;
        int v1 = epsr2.y1;
        int u2 = epsr2.x2;
        int v2 = epsr2.y2;

        int a = (y2 - y1);
        int b = (x1 - x2);
        int c = (x2 * y1 - x1 * y2);

        int d = (v2 - v1);
        int e = (u1 - u2);
        int f = (u2 * v1 - u1 * v2);

        int x = (b * f - c * e) / (a * e - b * d);
        int y = (c * d - a * f) / (a * e - b * d);

        System.out.println("x = " + x);
        System.out.println("y = " + y);

    }
}
