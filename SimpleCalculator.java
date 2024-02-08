import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JTextField resultField;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        resultField = new JTextField();
        resultField.setEditable(false);
        panel.add(resultField);

        JButton[] digitButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(Integer.toString(i));
            final int digit = i;
            digitButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    resultField.setText(resultField.getText() + digit);
                }
            });
            panel.add(digitButtons[i]);
        }

        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + " + ");
            }
        });
        panel.add(addButton);

        JButton subtractButton = new JButton("-");
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + " - ");
            }
        });
        panel.add(subtractButton);

        JButton multiplyButton = new JButton("*");
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + " * ");
            }
        });
        panel.add(multiplyButton);

        JButton divideButton = new JButton("/");
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + " / ");
            }
        });
        panel.add(divideButton);

        JButton percentButton = new JButton("%");
        percentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + " % ");
            }
        });
        panel.add(percentButton);

        JButton clearButton = new JButton("C");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText("");
            }
        });
        panel.add(clearButton);

        JButton calculateButton = new JButton("=");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String expression = resultField.getText();
                    String[] tokens = expression.split("\\s+");
                    double result = evaluateExpression(tokens);
                    resultField.setText(Double.toString(result));
                } catch (NumberFormatException ex) {
                    resultField.setText("Error");
                }
            }
        });
        panel.add(calculateButton);

        add(panel);
        setVisible(true);
    }

    private double evaluateExpression(String[] tokens) {
        double operand1 = Double.parseDouble(tokens[0]);
        double operand2 = Double.parseDouble(tokens[2]);
        switch (tokens[1]) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero!");
                }
                return operand1 / operand2;
            case "%":
                return operand1 % operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + tokens[1]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleCalculator();
            }
        });
    }
}
