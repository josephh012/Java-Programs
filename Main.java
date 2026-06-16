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

        // Student Panel
        studentPanel = new JPanel(new BorderLayout());
        studentModel = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Class"}, 0);
        studentTable = new JTable(studentModel);
        studentPanel.add(new JScrollPane(studentTable), BorderLayout.CENTER);
        studentPanel.add(createInputPanel(studentModel, new String[]{"ID", "Name", "Age", "Class"}), BorderLayout.SOUTH);

        // Teacher Panel
        teacherPanel = new JPanel(new BorderLayout());
        teacherModel = new DefaultTableModel(new String[]{"ID", "Name", "Subject", "Experience"}, 0);
        teacherTable = new JTable(teacherModel);
        teacherPanel.add(new JScrollPane(teacherTable), BorderLayout.CENTER);
        teacherPanel.add(createInputPanel(teacherModel, new String[]{"ID", "Name", "Subject", "Experience"}), BorderLayout.SOUTH);

        // Subject Panel
        subjectPanel = new JPanel(new BorderLayout());
        subjectModel = new DefaultTableModel(new String[]{"Code", "Name", "Credits"}, 0);
        subjectTable = new JTable(subjectModel);
        subjectPanel.add(new JScrollPane(subjectTable), BorderLayout.CENTER);
        subjectPanel.add(createInputPanel(subjectModel, new String[]{"Code", "Name", "Credits"}), BorderLayout.SOUTH);

        tabbedPane.addTab("Students", studentPanel);
        tabbedPane.addTab("Teachers", teacherPanel);
        tabbedPane.addTab("Subjects", subjectPanel);

        add(tabbedPane);
    }

    private JPanel createInputPanel(DefaultTableModel model, String[] labels) {
        JPanel panel = new JPanel(new GridLayout(labels.length + 1, 2));
        JTextField[] textFields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            panel.add(new JLabel(labels[i] + ":"));
            textFields[i] = new JTextField();
            panel.add(textFields[i]);
        }

        JButton addButton = new JButton("Add");
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SchoolManagementSystem().setVisible(true));
    }
}
