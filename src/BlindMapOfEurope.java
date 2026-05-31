import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlindMapOfEurope extends JFrame {

    private MapPanel mapPanel;
    private JLabel lblStat;
    private JLabel lblSkore;

    private List<CountryRegion> countries = new ArrayList<>();
    private CountryRegion currentCountry;

    private int correct = 0;
    private int wrong = 0;
    private Random random = new Random();


    public BlindMapOfEurope() {
        super("Slepá mapa Evropy");

        mapPanel = new MapPanel();
        mapPanel.setPreferredSize(new Dimension(700, 680));

        JPanel topPanel = new JPanel(new BorderLayout());
        lblStat = new JLabel("Stát: ", SwingConstants.CENTER);
        lblStat.setFont(lblStat.getFont().deriveFont(Font.BOLD, 20f));
        lblSkore = new JLabel("Správně: 0   Špatně: 0", SwingConstants.CENTER);

        topPanel.add(lblStat, BorderLayout.CENTER);
        topPanel.add(lblSkore, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(mapPanel, BorderLayout.CENTER);

        initCountries();
        nextCountry();
        mapPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("F2"), "toggleDebug");

        mapPanel.getActionMap().put("toggleDebug", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapPanel.toggleDebug();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initCountries() {

       countries.add(new CountryRegion(
                "Francie",
                new double[]{0.28, 0.37, 0.37, 0.45, 0.43, 0.37, 0.31},
                new double[]{0.70, 0.64, 0.65, 0.68, 0.78, 0.82, 0.80}
        )) ;
        countries.add(new CountryRegion(
                "Spanelsko",
                new double[]{0.22, 0.31, 0.37, 0.31, 0.24, 0.25, 0.22},
                new double[]{0.80, 0.80, 0.82, 0.91, 0.90, 0.83, 0.83}
        )) ;

        countries.add(new CountryRegion(
                "Portugalsko",
                new double[]{0.22, 0.25, 0.24, 0.215},
                new double[]{0.825, 0.83, 0.90, 0.90}
));

        countries.add(new CountryRegion(
                "Velká Británie",
                new double[]{0.25, 0.30, 0.35, 0.30, 0.26, 0.275},
                new double[]{0.48, 0.465, 0.62, 0.66, 0.67, 0.57}
));

        countries.add(new CountryRegion(
                "Irsko",
                new double[]{0.20, 0.25, 0.25, 0.20},
                new double[]{0.58, 0.58, 0.615, 0.63}
));

        countries.add(new CountryRegion(
                "Belgie",
                new double[]{0.38, 0.42, 0.415, 0.37},
                new double[]{0.63, 0.64, 0.66, 0.65}
));

        countries.add(new CountryRegion(
                "Nizozemsko",
                new double[]{0.40, 0.435, 0.42, 0.38},
                new double[]{0.60, 0.60, 0.65, 0.64}
));


        countries.add(new CountryRegion(
               "Německo",
                new double[]{0.44, 0.52, 0.53, 0.50, 0.515, 0.45, 0.42},
                new double[]{0.58, 0.57, 0.65, 0.66, 0.70, 0.71, 0.65}
));

        countries.add(new CountryRegion(
               "Česko",
                new double[]{0.50, 0.53, 0.59, 0.56, 0.52},
                new double[]{0.67, 0.65, 0.68, 0.695, 0.695}
));

        countries.add(new CountryRegion(
                "Slovensko",
                new double[]{0.58, 0.64, 0.635, 0.57, 0.56},
                new double[]{0.67, 0.685, 0.70, 0.71, 0.69}
));

        countries.add(new CountryRegion(
                "Rakousko",
        new double[]{0.52, 0.56, 0.55, 0.465, 0.465},
                new double[]{0.695, 0.695, 0.73, 0.72, 0.71}
));

        countries.add(new CountryRegion(
                "Švýcarsko",
                new double[]{0.44, 0.465, 0.465, 0.43, 0.415},
                new double[]{0.71, 0.71, 0.74, 0.745, 0.73}
));

        countries.add(new CountryRegion(
               "Itálie",
                new double[]{0.43, 0.49, 0.52, 0.50, 0.57, 0.55, 0.47, 0.44},
                new double[]{0.74, 0.72, 0.74, 0.79, 0.85, 0.88, 0.78, 0.79}
));

        countries.add(new CountryRegion(
                "Polsko",
                new double[]{0.53, 0.65, 0.64, 0.58, 0.53},
                new double[]{0.58, 0.58, 0.685, 0.68, 0.65}
));

        countries.add(new CountryRegion(
               "Litva",
                new double[]{0.62, 0.685, 0.665, 0.64},
                new double[]{0.52, 0.53, 0.58, 0.57}
));

        countries.add(new CountryRegion(
                "Lotyšsko",
        new double[]{0.625, 0.675, 0.70, 0.71, 0.68, 0.65, 0.615},
                new double[]{0.485, 0.48, 0.49, 0.525, 0.54, 0.52, 0.52}
));

        countries.add(new CountryRegion(
               "Estonsko",
        new double[]{0.65, 0.70, 0.70, 0.65},
                new double[]{0.44, 0.44, 0.49, 0.48}
));

        countries.add(new CountryRegion(
               "Dánsko",
        new double[]{0.44, 0.48, 0.50, 0.45},
                new double[]{0.50, 0.50, 0.55, 0.56}
));

        countries.add(new CountryRegion(
               "Švédsko",
        new double[]{0.57, 0.64, 0.65, 0.54, 0.48, 0.50},
                new double[]{0.16, 0.16, 0.25, 0.53, 0.46, 0.31}
));

        countries.add(new CountryRegion(
                "Norsko",
        new double[]{0.60, 0.70, 0.70, 0.56, 0.50, 0.49, 0.40, 0.40},
                new double[]{0.08, 0.05, 0.10, 0.16, 0.31, 0.46, 0.47, 0.37}
));

        countries.add(new CountryRegion(
                "Finsko",
        new double[]{0.65, 0.70, 0.72, 0.75, 0.70, 0.62, 0.62, 0.66},
                new double[]{0.14, 0.10, 0.14, 0.35, 0.40, 0.40, 0.33, 0.25}
));

        countries.add(new CountryRegion(
                "Ukrajina",
        new double[]{0.65, 0.78, 0.86, 0.85, 0.74, 0.70, 0.63},
                new double[]{0.62, 0.61, 0.68, 0.72, 0.74, 0.70, 0.70}
));

        countries.add(new CountryRegion(
                "Bělorusko",
        new double[]{0.65, 0.70, 0.75, 0.75, 0.65},
                new double[]{0.58, 0.52, 0.53, 0.61, 0.62}
));

        countries.add(new CountryRegion(
               "Rumunsko",
        new double[]{0.64, 0.70, 0.725, 0.71, 0.64, 0.61},
                new double[]{0.7, 0.7, 0.73, 0.8, 0.8, 0.75}
));

        countries.add(new CountryRegion(
                "Bulharsko",
        new double[]{0.64, 0.71, 0.70, 0.64},
                new double[]{0.79, 0.79, 0.82, 0.84}
));

        countries.add(new CountryRegion(
               "Srbsko",
        new double[]{0.58, 0.61, 0.64, 0.64, 0.60},
                new double[]{0.75, 0.75, 0.79, 0.82, 0.8}
));

        countries.add(new CountryRegion(
                "Chorvatsko",
        new double[]{0.55, 0.59, 0.59, 0.55, 0.56, 0.53},
                new double[]{0.73, 0.74, 0.76, 0.76, 0.8, 0.76}
));

        countries.add(new CountryRegion(
                "Slovinsko",
        new double[]{0.52, 0.55, 0.53, 0.52},
                new double[]{0.74, 0.74, 0.76, 0.75}
));

        countries.add(new CountryRegion(
               "Maďarsko",
        new double[]{0.56, 0.63, 0.63, 0.61, 0.57, 0.55},
                new double[]{0.71, 0.70, 0.71, 0.74, 0.74, 0.73}
));

        mapPanel.setCountries(countries);

        mapPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleClick(e.getPoint());
            }
        });
    }

    private void handleClick(Point p) {
        if (currentCountry == null) return;

        Polygon poly = currentCountry.getPolygon(mapPanel.getWidth(), mapPanel.getHeight());

        if (poly.contains(p)) {
            correct++;
            JOptionPane.showMessageDialog(this, "Správně! " + currentCountry.getName());
        } else {
            wrong++;
            JOptionPane.showMessageDialog(this, "Špatně");
        }

        updateScoreLabel();
        nextCountry();
    }

    private void updateScoreLabel() {
        lblSkore.setText("Správně: " + correct + "   Špatně: " + wrong);
    }

    private void nextCountry() {
        currentCountry = countries.get(random.nextInt(countries.size()));
        lblStat.setText("Stát: " + currentCountry.getName());
    }}