import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class StackApplication extends JFrame {
    private Stack<Integer> stack;

    private JTextField inputField;
    private JTextArea stackArea;

    public StackApplication() {
        setTitle("Stack Application");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        stack = new Stack<>();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        inputField = new JTextField();
        panel.add(inputField);

        JButton pushButton = new JButton("Push");
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int value = Integer.parseInt(inputField.getText());
                    stack.push(value);
                    updateStackArea();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(StackApplication.this, "Please enter a valid integer!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                inputField.setText("");
            }
        });
        panel.add(pushButton);

        JButton popButton = new JButton("Pop");
        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!stack.isEmpty()) {
                    stack.pop();
                    updateStackArea();
                } else {
                    JOptionPane.showMessageDialog(StackApplication.this, "Stack is empty!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(popButton);

        stackArea = new JTextArea();
        stackArea.setEditable(false);
        panel.add(new JScrollPane(stackArea));

        add(panel);
        setVisible(true);
    }

    private void updateStackArea() {
        StringBuilder sb = new StringBuilder();
        for (int i = stack.size() - 1; i >= 0; i--) {
            sb.append(stack.get(i)).append("\n");
        }
        stackArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StackApplication();
            }
        });
    }
}
