import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchoolManagementSystem extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel studentPanel, teacherPanel, subjectPanel;
    private JTable studentTable, teacherTable, subjectTable;
    private DefaultTableModel studentModel, teacherModel, subjectModel;

    public SchoolManagementSystem() {
        setTitle("School Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(Color.LIGHT_GRAY);

        // Student Panel
        studentPanel = new JPanel(new BorderLayout());
        studentPanel.setBackground(new Color(173, 216, 230)); // Light Blue
        studentModel = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Department", "Semester"}, 0);
        studentTable = new JTable(studentModel);
        studentPanel.add(new JScrollPane(studentTable), BorderLayout.CENTER);
        studentPanel.add(createInputPanel(studentModel, new String[]{"ID", "Name", "Age", "Department", "Semester"}), BorderLayout.SOUTH);

        // Teacher Panel
        teacherPanel = new JPanel(new BorderLayout());
        teacherPanel.setBackground(new Color(144, 238, 144)); // Light Green
        teacherModel = new DefaultTableModel(new String[]{"ID", "Name", "Subject", "Experience"}, 0);
        teacherTable = new JTable(teacherModel);
        teacherPanel.add(new JScrollPane(teacherTable), BorderLayout.CENTER);
        teacherPanel.add(createInputPanel(teacherModel, new String[]{"ID", "Name", "Subject", "Experience"}), BorderLayout.SOUTH);

        // Subject Panel
        subjectPanel = new JPanel(new BorderLayout());
        subjectPanel.setBackground(new Color(255, 218, 185)); // Peach
        subjectModel = new DefaultTableModel(new String[]{"Code", "Name", "Credits"}, 0);
        subjectTable = new JTable(subjectModel);
        subjectPanel.add(new JScrollPane(subjectTable), BorderLayout.CENTER);
        subjectPanel.add(createInputPanel(subjectModel, new String[]{"Code", "Name", "Credits"}), BorderLayout.SOUTH);

        tabbedPane.addTab("Students", studentPanel);
        tabbedPane.addTab("Teachers", teacherPanel);
        tabbedPane.addTab("Subjects", subjectPanel);

        // Logout Button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(Color.RED);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    dispose();
                    createAndShowLogin();
                }
            }
        });
        add(logoutButton, BorderLayout.SOUTH);

        add(tabbedPane);
    }

    private JPanel createInputPanel(DefaultTableModel model, String[] labels) {
        JPanel panel = new JPanel(new GridLayout(labels.length + 1, 2));
        panel.setBackground(Color.WHITE);
        JTextField[] textFields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i] + ":");
            label.setForeground(Color.BLACK);
            panel.add(label);
            textFields[i] = new JTextField();
            panel.add(textFields[i]);
        }

        JButton addButton = new JButton("Add");
        addButton.setBackground(new Color(30, 144, 255)); // Dodger Blue
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] rowData = new String[textFields.length];
                for (int i = 0; i < textFields.length; i++) {
                    rowData[i] = textFields[i].getText();
                    textFields[i].setText("");
                }
                model.addRow(rowData);
            }
        });
        panel.add(addButton);
        return panel;
    }

    private static void createAndShowLogin() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(300, 150);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.setBackground(new Color(240, 230, 140)); // Khaki
        panel.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(34, 139, 34)); // Forest Green
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if ("admin".equals(username) && "password".equals(password)) {
                    loginFrame.dispose();
                    SwingUtilities.invokeLater(() -> new SchoolManagementSystem().setVisible(true));
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(loginButton);
        
        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exitButton);

        loginFrame.add(panel);
        loginFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SchoolManagementSystem::createAndShowLogin);
    }
}
