import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo1 extends JFrame implements MouseListener {
    private JLabel eventLabel;

    public MouseEventDemo1() {
        setTitle("Mouse Event Demo");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        eventLabel = new JLabel(" ");
        eventLabel.setHorizontalAlignment(JLabel.CENTER);
        eventLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(eventLabel, BorderLayout.CENTER);

        panel.addMouseListener(this);

        add(panel);
        setVisible(true);
    }

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
