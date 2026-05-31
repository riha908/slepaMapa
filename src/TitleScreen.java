import javax.swing.*;
import java.awt.*;

public class TitleScreen {

    private JFrame frame;

    public TitleScreen() {
        frame = new JFrame("Slepá mapa");
    }

    public void init() {
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Welcome", JLabel.CENTER);
        frame.add(label, BorderLayout.CENTER);

        JButton button = new JButton("Start");
        frame.add(button, BorderLayout.SOUTH);

        button.addActionListener(e -> {
            frame.dispose();
            SwingUtilities.invokeLater(() -> new BlindMapOfEurope().setVisible(true));
        });

        frame.setVisible(true);
    }
}