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
import models.Faculty;
import repository.DBConnection;

/**
 *
 * @author nixrajput
 */
public class FacultyPortal extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);
    static Role role;

    private final Connection con = new DBConnection().connect();

    ArrayList<Faculty> faculty_list = new ArrayList<>();

    private void customizeComponents() {
        setLocationRelativeTo(this);
        FacultyTable.getTableHeader().setFont(new java.awt.Font("Tahoma", 1, 12));
        FacultyTable.getTableHeader().setForeground(new java.awt.Color(0, 150, 150));
    }

    private ArrayList<Faculty> retrieveData() {
        String qry = null;
        ArrayList<Faculty> fac_list = new ArrayList<>();
        try {
            qry = "SELECT * FROM faculty";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);
            Faculty faculty;
            while (rs.next()) {
                faculty = new Faculty(rs.getString("registration_no"), rs.getString("name"),
                        rs.getString("father_name"), rs.getString("sex"), rs.getString("dob"),
                        rs.getString("email"), rs.getString("phone"), rs.getString("password"),
                        rs.getString("address"), rs.getBytes("photo"), rs.getString("qualifications"),
                        rs.getString("institution"), rs.getString("designation"), rs.getInt("experience"),
                        rs.getString("course"), rs.getString("department"), rs.getString("date_joined"),
                        rs.getString("date_updated"));
                fac_list.add(faculty);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return fac_list;
    }

    private void fillTable() {
        faculty_list.clear();
        faculty_list = retrieveData();
        DefaultTableModel model = (DefaultTableModel) FacultyTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < faculty_list.size(); i++) {
            row[0] = faculty_list.get(i).getRegNo();
            row[1] = faculty_list.get(i).getName();
            row[2] = faculty_list.get(i).getQualifications();
            row[3] = faculty_list.get(i).getDesignation();
            row[4] = faculty_list.get(i).getDepartment();
            row[5] = faculty_list.get(i).getExperience();
            row[6] = faculty_list.get(i).getDate_joined();
            model.addRow(row);
        }
    }

    public FacultyPortal(Role role) {
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
        ButtonPanel = new javax.swing.JPanel();
        AddFacultyButton = new javax.swing.JButton();
        SubjectIssueButton = new javax.swing.JButton();
        TimetableButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();
        SearchPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        TablePanel = new javax.swing.JPanel();
        FacultyScrollPane = new javax.swing.JScrollPane();
        FacultyTable = new javax.swing.JTable();

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
        TitleLabel.setText("FACULTY PORTAL");
        TitleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        TitlePanelLayout.setVerticalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ButtonPanel.setLayout(new java.awt.GridLayout(1, 0));

        AddFacultyButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddFacultyButton.setForeground(new java.awt.Color(0, 150, 150));
        AddFacultyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user_add.png"))); // NOI18N
        AddFacultyButton.setText("Add Faculty");
        AddFacultyButton.setBorder(null);
        AddFacultyButton.setBorderPainted(false);
        AddFacultyButton.setContentAreaFilled(false);
        AddFacultyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddFacultyButton.setFocusable(false);
        AddFacultyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddFacultyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AddFacultyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFacultyButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(AddFacultyButton);

        SubjectIssueButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SubjectIssueButton.setForeground(new java.awt.Color(0, 150, 150));
        SubjectIssueButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_add.png"))); // NOI18N
        SubjectIssueButton.setText("Subject Issuing");
        SubjectIssueButton.setBorder(null);
        SubjectIssueButton.setBorderPainted(false);
        SubjectIssueButton.setContentAreaFilled(false);
        SubjectIssueButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SubjectIssueButton.setFocusable(false);
        SubjectIssueButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SubjectIssueButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        SubjectIssueButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SubjectIssueButtonMousePressed(evt);
            }
        });
        ButtonPanel.add(SubjectIssueButton);

        TimetableButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TimetableButton.setForeground(new java.awt.Color(0, 150, 150));
        TimetableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/list80.png"))); // NOI18N
        TimetableButton.setText("Time Table");
        TimetableButton.setBorder(null);
        TimetableButton.setBorderPainted(false);
        TimetableButton.setContentAreaFilled(false);
        TimetableButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TimetableButton.setFocusable(false);
        TimetableButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TimetableButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        TimetableButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TimetableButtonMousePressed(evt);
            }
        });
        ButtonPanel.add(TimetableButton);

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

        javax.swing.GroupLayout SearchPanelLayout = new javax.swing.GroupLayout(SearchPanel);
        SearchPanel.setLayout(SearchPanelLayout);
        SearchPanelLayout.setHorizontalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SearchButton)
                .addContainerGap())
        );
        SearchPanelLayout.setVerticalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FacultyScrollPane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FacultyScrollPane.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        FacultyScrollPane.setRowHeaderView(null);

        FacultyTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        FacultyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg No.", "Name", "Qualification", "Designation", "Department", "Experience", "DOJ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        FacultyTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FacultyTable.setGridColor(new java.awt.Color(102, 102, 102));
        FacultyTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        FacultyTable.setShowGrid(true);
        FacultyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FacultyTableMousePressed(evt);
            }
        });
        FacultyScrollPane.setViewportView(FacultyTable);

        javax.swing.GroupLayout TablePanelLayout = new javax.swing.GroupLayout(TablePanel);
        TablePanel.setLayout(TablePanelLayout);
        TablePanelLayout.setHorizontalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(FacultyScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE))
        );
        TablePanelLayout.setVerticalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
            .addGroup(TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(FacultyScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SearchPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddFacultyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFacultyButtonActionPerformed

        if (role == Role.ADMIN) {
            FacultyEntryForm facultyEntryForm = new FacultyEntryForm(role);
            facultyEntryForm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "You Are Not Authorised!!!");
        }
    }//GEN-LAST:event_AddFacultyButtonActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        fillTable();
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void SearchButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchButtonMousePressed

        String val = SearchTextField.getText();
        faculty_list.clear();
        try {

            String qry = "SELECT * FROM faculty WHERE name LIKE '%" + val + "%' "
                    + "OR registration_no LIKE '%" + val + "%' OR designation LIKE '%" + val + "%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);
            Faculty faculty;
            while (rs.next()) {
                faculty = new Faculty(rs.getString("registration_no"), rs.getString("name"),
                        rs.getString("father_name"), rs.getString("sex"), rs.getString("dob"),
                        rs.getString("email"), rs.getString("phone"), rs.getString("password"),
                        rs.getString("address"), rs.getBytes("photo"), rs.getString("qualifications"),
                        rs.getString("institution"), rs.getString("designation"), rs.getInt("experience"),
                        rs.getString("course"), rs.getString("department"), rs.getString("date_joined"),
                        rs.getString("date_updated"));
                faculty_list.add(faculty);
            }
            DefaultTableModel model = (DefaultTableModel) FacultyTable.getModel();
            model.setRowCount(0);
            if (faculty_list.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Records Found!");
            } else {
                Object[] row = new Object[7];
                for (int i = 0; i < faculty_list.size(); i++) {
                    row[0] = faculty_list.get(i).getRegNo();
                    row[1] = faculty_list.get(i).getName();
                    row[2] = faculty_list.get(i).getQualifications();
                    row[3] = faculty_list.get(i).getDesignation();
                    row[4] = faculty_list.get(i).getDepartment();
                    row[5] = faculty_list.get(i).getExperience();
                    row[6] = faculty_list.get(i).getDate_joined();
                    model.addRow(row);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SearchButtonMousePressed

    private void FacultyTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacultyTableMousePressed
        int ind = FacultyTable.getSelectedRow();
        String reg_no = faculty_list.get(ind).getRegNo();
        System.out.println(reg_no);
        FacultyEntryForm entryForm = new FacultyEntryForm(role);
        entryForm.setVisible(true);
        entryForm.showItemToFields(reg_no);
    }//GEN-LAST:event_FacultyTableMousePressed

    private void SubjectIssueButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubjectIssueButtonMousePressed
        FacultySubjectIssuingScreen issuingScreen = new FacultySubjectIssuingScreen(role);
        issuingScreen.setVisible(true);
    }//GEN-LAST:event_SubjectIssueButtonMousePressed

    private void TimetableButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimetableButtonMousePressed


    }//GEN-LAST:event_TimetableButtonMousePressed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FacultyPortal(role).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddFacultyButton;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JScrollPane FacultyScrollPane;
    private javax.swing.JTable FacultyTable;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JButton SubjectIssueButton;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JButton TimetableButton;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
