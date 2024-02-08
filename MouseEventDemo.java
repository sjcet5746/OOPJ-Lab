import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends JFrame {
    private JLabel eventLabel;

    public MouseEventDemo() {
        setTitle("Mouse Event Demo");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        eventLabel = new JLabel(" ");
        eventLabel.setHorizontalAlignment(JLabel.CENTER);
        eventLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(eventLabel, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showMouseEvent("Mouse Clicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                showMouseEvent("Mouse Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showMouseEvent("Mouse Released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                showMouseEvent("Mouse Entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                showMouseEvent("Mouse Exited");
            }
        });

        setVisible(true);
    }

    private void showMouseEvent(String eventName) {
        eventLabel.setText(eventName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MouseEventDemo();
            }
        });
    }
}
