import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class MapPanel extends JPanel {

    private BufferedImage mapImage;
    private List<CountryRegion> countries;
    private boolean debugRegions = true;

    public MapPanel() {
        try {
            mapImage = ImageIO.read(getClass().getResource("/MapaEvropy.png"));
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Nepodařilo se načíst obrázek mapy: " + e.getMessage());
        }
    }

    public void setCountries(List<CountryRegion> countries) {
        this.countries = countries;
    }
    public void toggleDebug() {
        debugRegions = !debugRegions;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (mapImage != null) {
            g.drawImage(mapImage, 0, 0, getWidth(), getHeight(), this);
        }

        if (debugRegions && countries != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(255, 0, 0, 80));

            for (CountryRegion c : countries) {
                Polygon p = c.getPolygon(getWidth(), getHeight());
                g2.fillPolygon(p);
            }
        }
    }
}