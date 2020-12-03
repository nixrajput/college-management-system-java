package screens;

import com.formdev.flatlaf.FlatLightLaf;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import models.Student;
import repository.DBConnection;

/**
 *
 * @author nixrajput
 */
public class StudentPortal extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);
    static Role role;

    static String application_no = null;

    Connection con = new DBConnection().connect();

    private void customizeComponents() {
        StudentTable.getTableHeader().setFont(new java.awt.Font("Tahoma", 1, 12));
        StudentTable.getTableHeader().setForeground(new java.awt.Color(0, 150, 150));
        if (role != Role.ADMIN) {
            EntryButton.setEnabled(false);
            ConfirmationButton.setEnabled(false);
            DeleteButton.setEnabled(false);
        }
    }

    private ArrayList<Student> retrieveData() {
        ArrayList<Student> student_list = new ArrayList<Student>();
        String qry = null;

        try {
            if (role == Role.STUDENT) {
                qry = "SELECT name, roll_no, application_no, registration_no, "
                        + "mother_name, mother_occupation, address, father_name, father_occupation, "
                        + "sex, dob, phone, email, photo, date_of_application, course, branch, batch, "
                        + "semester, year_of_passing, hostel, library, qualification, university, "
                        + "quota, marks, status FROM student WHERE application_no LIKE '%" + application_no + "%'";
            }
            else{
                qry = "SELECT name, roll_no, application_no, registration_no, "
                    + "mother_name, mother_occupation, address, father_name, father_occupation, "
                    + "sex, dob, phone, email, photo, date_of_application, course, branch, batch, "
                    + "semester, year_of_passing, hostel, library, qualification, university, "
                    + "quota, marks, status FROM student";
            }
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

        } catch (Exception e) {
            System.out.println(e);
        }
        return student_list;
    }

    private void fillTable() {
        ArrayList<Student> student_list = retrieveData();
        DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[6];
        for (int i = 0; i < student_list.size(); i++) {
            row[0] = student_list.get(i).getRollNo();
            row[1] = student_list.get(i).getName();
            row[2] = student_list.get(i).getFather_name();
            row[3] = student_list.get(i).getCourse();
            row[4] = student_list.get(i).getBranch();
            row[5] = student_list.get(i).getSemester();
            model.addRow(row);
        }
    }

    public StudentPortal(Role role, String app_no) {
        this.role = role;
        this.application_no = app_no;
        initComponents();
        customizeComponents();
        setLocationRelativeTo(this);
        fillTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleLabel = new javax.swing.JLabel();
        ButtonPanel = new javax.swing.JPanel();
        EntryButton = new javax.swing.JButton();
        ConfirmationButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        StudentScrollPane = new javax.swing.JScrollPane();
        StudentTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("constants/strings"); // NOI18N
        setTitle(bundle.getString("APP_NAME")); // NOI18N
        setIconImage(icon.getImage());
        setResizable(false);

        TitleLabel.setFont(TitleLabel.getFont().deriveFont(TitleLabel.getFont().getStyle() | java.awt.Font.BOLD, TitleLabel.getFont().getSize()+29));
        TitleLabel.setForeground(new java.awt.Color(60, 185, 145));
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText("STUDENT PORTAL");
        TitleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ButtonPanel.setLayout(new java.awt.GridLayout(1, 0));

        EntryButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        EntryButton.setForeground(new java.awt.Color(0, 150, 150));
        EntryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user_add.png"))); // NOI18N
        EntryButton.setText("Entry");
        EntryButton.setBorder(null);
        EntryButton.setBorderPainted(false);
        EntryButton.setContentAreaFilled(false);
        EntryButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EntryButton.setFocusable(false);
        EntryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EntryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EntryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntryButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(EntryButton);

        ConfirmationButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ConfirmationButton.setForeground(new java.awt.Color(0, 150, 150));
        ConfirmationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user_confirm.png"))); // NOI18N
        ConfirmationButton.setText("Confirmation");
        ConfirmationButton.setBorder(null);
        ConfirmationButton.setBorderPainted(false);
        ConfirmationButton.setContentAreaFilled(false);
        ConfirmationButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ConfirmationButton.setFocusable(false);
        ConfirmationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ConfirmationButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ConfirmationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmationButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(ConfirmationButton);

        DeleteButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeleteButton.setForeground(new java.awt.Color(0, 150, 150));
        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/cancel80.png"))); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.setBorder(null);
        DeleteButton.setBorderPainted(false);
        DeleteButton.setContentAreaFilled(false);
        DeleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteButton.setFocusable(false);
        DeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DeleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(DeleteButton);

        RefreshButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RefreshButton.setForeground(new java.awt.Color(0, 150, 150));
        RefreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/refresh80.png"))); // NOI18N
        RefreshButton.setText("Refresh");
        RefreshButton.setBorder(null);
        RefreshButton.setBorderPainted(false);
        RefreshButton.setContentAreaFilled(false);
        RefreshButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RefreshButton.setFocusable(false);
        RefreshButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RefreshButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(RefreshButton);

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

        StudentScrollPane.setBorder(null);
        StudentScrollPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        StudentScrollPane.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StudentScrollPane.setRowHeaderView(null);

        StudentTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Roll No.", "Name", "Father's Name", "Course", "Branch", "Semester"
            }
        ));
        StudentTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        StudentTable.setShowGrid(true);
        StudentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                StudentTableMousePressed(evt);
            }
        });
        StudentScrollPane.setViewportView(StudentTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StudentScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchButton)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel)
                .addGap(18, 18, 18)
                .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(StudentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EntryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntryButtonActionPerformed
        StudentEntryForm applicationForm = new StudentEntryForm(role);
        applicationForm.setVisible(true);
    }//GEN-LAST:event_EntryButtonActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed

        fillTable();

    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void ConfirmationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmationButtonActionPerformed
        
        ArrayList<Student> student_list = new ArrayList<Student>();

        String val = SearchTextField.getText().toString();
        try {

            String qry = "SELECT name, roll_no, application_no, registration_no, "
                    + "mother_name, mother_occupation, address, father_name, father_occupation, "
                    + "sex, dob, phone, email, photo, date_of_application, course, branch, batch, "
                    + "semester, year_of_passing, hostel, library, qualification, university, "
                    + "quota, marks, status FROM application_form";
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
            Object[] row = new Object[6];
            for (int i = 0; i < student_list.size(); i++) {
                row[0] = student_list.get(i).getRollNo();
                row[1] = student_list.get(i).getName();
                row[2] = student_list.get(i).getFather_name();
                row[3] = student_list.get(i).getCourse();
                row[4] = student_list.get(i).getBranch();
                row[5] = student_list.get(i).getSemester();
                model.addRow(row);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_ConfirmationButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void SearchButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchButtonMousePressed

        ArrayList<Student> student_list = new ArrayList<Student>();

        String val = SearchTextField.getText().toString();
        try {

            String qry = "SELECT name, roll_no, application_no, registration_no, "
                    + "mother_name, mother_occupation, address, father_name, father_occupation, "
                    + "sex, dob, phone, email, photo, date_of_application, course, branch, batch, "
                    + "semester, year_of_passing, hostel, library, qualification, university, "
                    + "quota, marks, status FROM student WHERE name LIKE '%" + val + "%' OR roll_no LIKE '%" + val + "%' "
                    + "OR registration_no LIKE '%" + val + "%' OR application_no LIKE '%" + val + "%'";
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
            Object[] row = new Object[6];
            for (int i = 0; i < student_list.size(); i++) {
                row[0] = student_list.get(i).getRollNo();
                row[1] = student_list.get(i).getName();
                row[2] = student_list.get(i).getFather_name();
                row[3] = student_list.get(i).getCourse();
                row[4] = student_list.get(i).getBranch();
                row[5] = student_list.get(i).getSemester();
                model.addRow(row);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_SearchButtonMousePressed

    private void StudentTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentTableMousePressed
        int ind = StudentTable.getSelectedRow();
        StudentEntryForm applicationForm = new StudentEntryForm(role);
        applicationForm.setVisible(true);
        applicationForm.showItemToFields(ind);
    }//GEN-LAST:event_StudentTableMousePressed

    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentPortal(role, application_no).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JButton ConfirmationButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EntryButton;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JScrollPane StudentScrollPane;
    private javax.swing.JTable StudentTable;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
