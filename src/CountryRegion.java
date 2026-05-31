import java.awt.*;

public class CountryRegion {

    private String name;


    private double[] px;
    private double[] py;

    public CountryRegion(String name, double[] px, double[] py) {
        this.name = name;
        this.px = px;
        this.py = py;
    }

    public String getName() {
        return name;
    }

    public Polygon getPolygon(int w, int h) {
        int[] x = new int[px.length];
        int[] y = new int[py.length];

        for (int i = 0; i < px.length; i++) {
            x[i] = (int)(px[i] * w);
            y[i] = (int)(py[i] * h);
        }

        return new Polygon(x, y, px.length);
    }
}