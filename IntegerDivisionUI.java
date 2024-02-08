import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntegerDivisionUI extends JFrame {
    private JTextField num1Field, num2Field, resultField;

    public IntegerDivisionUI() {
        setTitle("Integer Division");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 5, 5));

        JLabel num1Label = new JLabel("Num1:");
        num1Field = new JTextField();
        panel.add(num1Label);
        panel.add(num1Field);

        JLabel num2Label = new JLabel("Num2:");
        num2Field = new JTextField();
        panel.add(num2Label);
        panel.add(num2Field);

        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);
        panel.add(resultLabel);
        panel.add(resultField);

        JButton divideButton = new JButton("Divide");
        panel.add(divideButton);

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(num1Field.getText());
                    int num2 = Integer.parseInt(num2Field.getText());

                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero!");
                    }

                    int result = num1 / num2;
                    resultField.setText(Integer.toString(result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(IntegerDivisionUI.this, "Please enter valid integers!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(IntegerDivisionUI.this, "Division by zero is not allowed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new IntegerDivisionUI();
            }
        });
    }
}
