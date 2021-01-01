package screens;

import com.formdev.flatlaf.FlatLightLaf;
import constants.Role;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Student;
import repository.DBConnection;

/**
 *
 * @author nixrajput
 */
public class StudentApplicationsScreen extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);
    static Role role;

    static String reg_no = null;

    private final Connection con = new DBConnection().connect();

    ArrayList<Student> student_list = new ArrayList<>();

    private void customizeComponents() {
        setLocationRelativeTo(this);
        StudentTable.getTableHeader().setFont(new java.awt.Font("Tahoma", 1, 12));
        StudentTable.getTableHeader().setForeground(new java.awt.Color(0, 150, 150));
    }

    private ArrayList<Student> retrieveData() {
        String qry = null;
        ArrayList<Student> stu_list = new ArrayList<>();

        try {
            qry = "SELECT name, roll_no, application_no, registration_no, "
                    + "mother_name, mother_occupation, address, father_name, father_occupation, "
                    + "sex, dob, phone, email, photo, date_of_application, course, branch, batch, "
                    + "semester, year_of_passing, hostel, library, qualification, university, "
                    + "quota, marks, status FROM student WHERE status NOT LIKE '%CONFIRM%'";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);
            Student student;
            while (rs.next()) {
                student = new Student(rs.getString("name"), rs.getString("roll_no"), rs.getString("application_no"),
                        rs.getString("registration_no"), rs.getString("mother_name"), rs.getString("mother_occupation"),
                        rs.getString("address"), rs.getString("father_name"), rs.getString("father_occupation"),
                        rs.getString("sex"), rs.getString("dob"), rs.getString("phone"), rs.getString("email"),
                        rs.getBytes("photo"), rs.getString("date_of_application"), rs.getString("course"), rs.getString("branch"),
                        rs.getInt("batch"), rs.getString("semester"), rs.getInt("year_of_passing"), rs.getBoolean("hostel"), rs.getBoolean("library"),
                        rs.getString("qualification"), rs.getString("university"), rs.getString("quota"), rs.getString("marks"), rs.getString("status"));
                stu_list.add(student);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return stu_list;
    }

    private void fillTable() {
        student_list.clear();
        student_list = retrieveData();
        DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < student_list.size(); i++) {
            row[0] = student_list.get(i).getRegNo();
            row[1] = student_list.get(i).getRollNo();
            row[2] = student_list.get(i).getName();
            row[3] = student_list.get(i).getFather_name();
            row[4] = student_list.get(i).getCourse();
            row[5] = student_list.get(i).getBranch();
            row[6] = student_list.get(i).getSemester();
            model.addRow(row);
        }
    }

    public StudentApplicationsScreen(Role role) {
        this.role = role;
        initComponents();
        customizeComponents();
        fillTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitlePanel = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        SearchPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();
        TablePanel = new javax.swing.JPanel();
        StudentScrollPane = new javax.swing.JScrollPane();
        StudentTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("constants/strings"); // NOI18N
        setTitle(bundle.getString("APP_NAME")); // NOI18N
        setIconImage(icon.getImage());
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        TitlePanel.setBackground(new java.awt.Color(51, 51, 51));

        TitleLabel.setFont(TitleLabel.getFont().deriveFont(TitleLabel.getFont().getStyle() | java.awt.Font.BOLD, TitleLabel.getFont().getSize()+29));
        TitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText("STUDENT APPLICATION");
        TitleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
                .addContainerGap())
        );
        TitlePanelLayout.setVerticalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SearchPanel.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 150, 150));
        jLabel1.setText("Search");

        SearchButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SearchButton.setForeground(new java.awt.Color(0, 150, 150));
        SearchButton.setText("Search");
        SearchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SearchButtonMousePressed(evt);
            }
        });

        RefreshButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RefreshButton.setForeground(new java.awt.Color(0, 150, 150));
        RefreshButton.setText("Refresh");
        RefreshButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RefreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RefreshButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout SearchPanelLayout = new javax.swing.GroupLayout(SearchPanel);
        SearchPanel.setLayout(SearchPanelLayout);
        SearchPanelLayout.setHorizontalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(SearchTextField)
                .addGap(18, 18, 18)
                .addComponent(SearchButton)
                .addGap(18, 18, 18)
                .addComponent(RefreshButton)
                .addContainerGap())
        );
        SearchPanelLayout.setVerticalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        TablePanel.setOpaque(false);

        StudentScrollPane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StudentScrollPane.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StudentScrollPane.setMinimumSize(new java.awt.Dimension(462, 425));
        StudentScrollPane.setRowHeaderView(null);

        StudentTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg. No.", "Roll No.", "Name", "Father's Name", "Course", "Branch", "Semester"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StudentTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        StudentTable.setShowGrid(true);
        StudentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                StudentTableMousePressed(evt);
            }
        });
        StudentScrollPane.setViewportView(StudentTable);
        if (StudentTable.getColumnModel().getColumnCount() > 0) {
            StudentTable.getColumnModel().getColumn(1).setResizable(false);
            StudentTable.getColumnModel().getColumn(2).setResizable(false);
            StudentTable.getColumnModel().getColumn(3).setResizable(false);
            StudentTable.getColumnModel().getColumn(4).setResizable(false);
            StudentTable.getColumnModel().getColumn(5).setResizable(false);
            StudentTable.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout TablePanelLayout = new javax.swing.GroupLayout(TablePanel);
        TablePanel.setLayout(TablePanelLayout);
        TablePanelLayout.setHorizontalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StudentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TablePanelLayout.setVerticalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StudentScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchButtonMousePressed

        String val = SearchTextField.getText();
        student_list.clear();
        try {

            String qry = "SELECT name, roll_no, application_no, registration_no, "
                    + "mother_name, mother_occupation, address, father_name, father_occupation, "
                    + "sex, dob, phone, email, photo, date_of_application, course, branch, batch, "
                    + "semester, year_of_passing, hostel, library, qualification, university, "
                    + "quota, marks, status FROM student WHERE (name LIKE '%" + val + "%' OR roll_no LIKE '%" + val + "%' "
                    + "OR registration_no LIKE '%" + val + "%' OR application_no LIKE '%" + val + "%') AND (status!='CONFIRM')";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);
            Student student;
            while (rs.next()) {
                student = new Student(rs.getString("name"), rs.getString("roll_no"), rs.getString("application_no"),
                        rs.getString("registration_no"), rs.getString("mother_name"), rs.getString("mother_occupation"),
                        rs.getString("address"), rs.getString("father_name"), rs.getString("father_occupation"),
                        rs.getString("sex"), rs.getString("dob"), rs.getString("phone"), rs.getString("email"),
                        rs.getBytes("photo"), rs.getString("date_of_application"), rs.getString("course"), rs.getString("branch"),
                        rs.getInt("batch"), rs.getString("semester"), rs.getInt("year_of_passing"), rs.getBoolean("hostel"), rs.getBoolean("library"),
                        rs.getString("qualification"), rs.getString("university"), rs.getString("quota"), rs.getString("marks"), rs.getString("status"));
                student_list.add(student);
            }
            DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();
            model.setRowCount(0); // Empty/clear the table

            if (student_list.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Records Found!");
            } else {
                Object[] row = new Object[7];
                for (int i = 0; i < student_list.size(); i++) {
                    row[0] = student_list.get(i).getRegNo();
                    row[1] = student_list.get(i).getRollNo();
                    row[2] = student_list.get(i).getName();
                    row[3] = student_list.get(i).getFather_name();
                    row[4] = student_list.get(i).getCourse();
                    row[5] = student_list.get(i).getBranch();
                    row[6] = student_list.get(i).getSemester();
                    model.addRow(row);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SearchButtonMousePressed

    private void StudentTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentTableMousePressed
        int ind = StudentTable.getSelectedRow();
        String _reg_no = student_list.get(ind).getRegNo();
        StudentEntryForm entryForm = new StudentEntryForm(role, reg_no);
        entryForm.setVisible(true);
        entryForm.showItemToFields(_reg_no);
    }//GEN-LAST:event_StudentTableMousePressed

    private void RefreshButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshButtonMousePressed
        fillTable();
    }//GEN-LAST:event_RefreshButtonMousePressed

    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new StudentApplicationsScreen(role).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JScrollPane StudentScrollPane;
    private javax.swing.JTable StudentTable;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
