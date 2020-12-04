package screens;

import com.formdev.flatlaf.FlatLightLaf;
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

    static String application_no = null;

    Connection con = new DBConnection().connect();

    ArrayList<Student> student_list = new ArrayList<Student>();

    private void customizeComponents() {
        StudentTable.getTableHeader().setFont(new java.awt.Font("Tahoma", 1, 12));
        StudentTable.getTableHeader().setForeground(new java.awt.Color(0, 150, 150));
    }

    private ArrayList<Student> retrieveData() {
        String qry = null;
        student_list.clear();

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
                student_list.add(student);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return student_list;
    }

    private void fillTable() {
        student_list = retrieveData();
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

    public StudentApplicationsScreen() {
        initComponents();
        setLocationRelativeTo(this);
        customizeComponents();
        fillTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        StudentScrollPane = new javax.swing.JScrollPane();
        StudentTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("constants/strings"); // NOI18N
        setTitle(bundle.getString("APP_NAME")); // NOI18N
        setIconImage(icon.getImage());
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setPreferredSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        TitleLabel.setFont(TitleLabel.getFont().deriveFont(TitleLabel.getFont().getStyle() | java.awt.Font.BOLD, TitleLabel.getFont().getSize()+29));
        TitleLabel.setForeground(new java.awt.Color(60, 185, 145));
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText("STUDENT APPLICATIONS");
        TitleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        StudentScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Students", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 150, 150))); // NOI18N
        StudentScrollPane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StudentScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(SearchButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(StudentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchButtonMousePressed

        String val = SearchTextField.getText().toString();
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

            if (student_list.size() == 0) {
                JOptionPane.showMessageDialog(null, "No Records Found!");

            } else {
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

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SearchButtonMousePressed

    private void StudentTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentTableMousePressed
        int ind = StudentTable.getSelectedRow();
        String roll_no = student_list.get(ind).getRollNo();
        StudentEntryForm entryForm = new StudentEntryForm(role);
        entryForm.setVisible(true);
        entryForm.showItemToFields(ind, roll_no);
    }//GEN-LAST:event_StudentTableMousePressed

    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentApplicationsScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JScrollPane StudentScrollPane;
    private javax.swing.JTable StudentTable;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
