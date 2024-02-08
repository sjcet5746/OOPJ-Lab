import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventDemo extends JFrame {
    private JLabel eventLabel;

    public KeyEventDemo() {
        setTitle("Key Event Demo");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        eventLabel = new JLabel(" ");
        eventLabel.setHorizontalAlignment(JLabel.CENTER);
        eventLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(eventLabel, BorderLayout.CENTER);

        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                showKeyEvent("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                showKeyEvent("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            @Override
            public void keyTyped(KeyEvent e) {
                showKeyEvent("Key Typed: " + e.getKeyChar());
            }
        });

        setFocusable(true);
        setVisible(true);
    }

    private void showKeyEvent(String eventName) {
        eventLabel.setText(eventName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new KeyEventDemo();
            }
        });
    }
}
