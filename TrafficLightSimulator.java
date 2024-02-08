import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightSimulator extends JFrame {
    private JLabel messageLabel;
    private JRadioButton redButton, yellowButton, greenButton;

    public TrafficLightSimulator() {
        setTitle("Traffic Light Simulator");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 5, 5));

        ButtonGroup buttonGroup = new ButtonGroup();

        redButton = new JRadioButton("Red");
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessage("STOP", Color.RED);
            }
        });
        buttonGroup.add(redButton);
        panel.add(redButton);

        yellowButton = new JRadioButton("Yellow");
        yellowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessage("READY", Color.YELLOW);
            }
        });
        buttonGroup.add(yellowButton);
        panel.add(yellowButton);

        greenButton = new JRadioButton("Green");
        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessage("GO", Color.GREEN);
            }
        });
        buttonGroup.add(greenButton);
        panel.add(greenButton);

        messageLabel = new JLabel();
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(messageLabel);

        add(panel);
        setVisible(true);
    }

    private void showMessage(String message, Color color) {
        messageLabel.setText(message);
        messageLabel.setForeground(color);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TrafficLightSimulator();
            }
        });
    }
}
