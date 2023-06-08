import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DigitalLibrarySystem {
    private JFrame frame;
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;

    public DigitalLibrarySystem() {
        frame = new JFrame("Digital Library System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new JPanel();
        label1 = new JLabel("Book Title:");
        textField1 = new JTextField(20);
        button1 = new JButton("Search");

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookTitle = textField1.getText();

                // Connect to the database
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root",
                            "");

                    // Prepare the statement
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM books WHERE title = ?");
                    statement.setString(1, bookTitle);

                    // Execute the statement
                    ResultSet resultSet = statement.executeQuery();

                    // Check if the book exists
                    if (resultSet.next()) {
                        // Display the book information
                        System.out.println("Book title: " + resultSet.getString("title"));
                        System.out.println("Author: " + resultSet.getString("author"));
                        System.out.println("Publication date: " + resultSet.getString("publication_date"));
                    } else {
                        System.out.println("Book not found");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(button1);

        frame.add(panel1, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DigitalLibrarySystem();
            }
        });
    }
}
