import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoorAnimation extends JFrame {
    private JButton openButton, closeButton;
    private JLabel personLabel;

    public DoorAnimation() {
        setTitle("Door Animation");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        openButton = new JButton("Open Door");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPerson(true);
            }
        });
        buttonPanel.add(openButton);

        closeButton = new JButton("Close Door");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPerson(false);
            }
        });
        buttonPanel.add(closeButton);

        panel.add(buttonPanel, BorderLayout.NORTH);

        personLabel = new JLabel();
        personLabel.setIcon(new ImageIcon(getClass().getResource("person.png")));
        panel.add(personLabel, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }

    private void showPerson(boolean show) {
        personLabel.setVisible(show);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DoorAnimation();
            }
        });
    }
}
