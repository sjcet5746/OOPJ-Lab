import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentDatabase extends JFrame {
    private JTextArea textArea;

    public StudentDatabase() {
        setTitle("Student Database");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton displayButton = new JButton("Display Students");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStudents();
            }
        });
        panel.add(displayButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private void displayStudents() {
        textArea.setText("");
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");
            Statement stmt = conn.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS student (name VARCHAR(50), register_number INT, mark1 INT, mark2 INT, mark3 INT)";
            stmt.executeUpdate(createTableQuery);

            String insertDataQuery = "INSERT INTO student (name, register_number, mark1, mark2, mark3) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertDataQuery);
            pstmt.setString(1, "John");
            pstmt.setInt(2, 101);
            pstmt.setInt(3, 85);
            pstmt.setInt(4, 90);
            pstmt.setInt(5, 92);
            pstmt.executeUpdate();

            pstmt.setString(1, "Alice");
            pstmt.setInt(2, 102);
            pstmt.setInt(3, 78);
            pstmt.setInt(4, 82);
            pstmt.setInt(5, 88);
            pstmt.executeUpdate();

            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                String name = rs.getString("name");
                int registerNumber = rs.getInt("register_number");
                int mark1 = rs.getInt("mark1");
                int mark2 = rs.getInt("mark2");
                int mark3 = rs.getInt("mark3");
                textArea.append("Name: " + name + ", Register Number: " + registerNumber + ", Marks: " + mark1 + ", " + mark2 + ", " + mark3 + "\n");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentDatabase();
            }
        });
    }
}
