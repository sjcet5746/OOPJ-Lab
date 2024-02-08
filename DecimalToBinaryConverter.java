import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecimalToBinaryConverter extends JFrame {
    private JTextField decimalField, binaryField;

    public DecimalToBinaryConverter() {
        setTitle("Decimal to Binary Converter");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel decimalLabel = new JLabel("Decimal Number:");
        panel.add(decimalLabel);

        decimalField = new JTextField(10);
        panel.add(decimalField);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertDecimalToBinary();
            }
        });
        panel.add(convertButton);

        JLabel binaryLabel = new JLabel("Binary Number:");
        panel.add(binaryLabel);

        binaryField = new JTextField(10);
        binaryField.setEditable(false);
        panel.add(binaryField);

        add(panel);
        setVisible(true);
    }

    private void convertDecimalToBinary() {
        try {
            int decimalNumber = Integer.parseInt(decimalField.getText());
            String binaryNumber = Integer.toBinaryString(decimalNumber);
            binaryField.setText(binaryNumber);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid decimal number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DecimalToBinaryConverter();
            }
        });
    }
}
