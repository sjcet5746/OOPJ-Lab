import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlinkingEyesAndMouth extends JFrame {
    private boolean isEyesOpen = true;
    private boolean isMouthOpen = false;

    public BlinkingEyesAndMouth() {
        setTitle("Blinking Eyes and Mouth");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawFace(g);
                drawEyes(g);
                drawMouth(g);
            }
        };

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isEyesOpen = !isEyesOpen;
                isMouthOpen = !isMouthOpen;
                panel.repaint();
            }
        });
        timer.start();

        add(panel);
        setVisible(true);
    }

    private void drawFace(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(100, 100, 200, 200);
    }

    private void drawEyes(Graphics g) {
        g.setColor(Color.BLACK);
        if (isEyesOpen) {
            g.fillOval(140, 150, 40, 40); // Left eye
            g.fillOval(220, 150, 40, 40); // Right eye
        } else {
            g.fillRect(140, 160, 40, 20); // Left eye closed
            g.fillRect(220, 160, 40, 20); // Right eye closed
        }
    }

    private void drawMouth(Graphics g) {
        if (isMouthOpen) {
            g.setColor(Color.RED);
            g.fillArc(150, 220, 100, 60, 0, -180); // Open mouth
        } else {
            g.setColor(Color.YELLOW);
            g.fillRect(150, 220, 100, 30); // Closed mouth
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BlinkingEyesAndMouth();
            }
        });
    }
}
