import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame {
    private JTextField num1Field, num2Field, resultField;

    public CalculatorApp() {
        setTitle("Calculator");
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

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation('+');
            }
        });
        panel.add(addButton);

        JButton subtractButton = new JButton("Subtract");
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation('-');
            }
        });
        panel.add(subtractButton);

        JButton multiplyButton = new JButton("Multiply");
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation('*');
            }
        });
        panel.add(multiplyButton);

        JButton divideButton = new JButton("Divide");
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation('/');
            }
        });
        panel.add(divideButton);

        add(panel);
        setVisible(true);
    }

    private void performOperation(char operator) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero!");
                    }
                    result = num1 / num2;
                    break;
            }

            resultField.setText(Double.toString(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, "Division by zero is not allowed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorApp();
            }
        });
    }
}
