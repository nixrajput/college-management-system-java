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
import models.TimeTable;
import repository.DBConnection;

/**
 *
 * @author nixrajput
 */
public class FacultySubjectIssuingScreen extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);
    static Role role;

    private final Connection con = new DBConnection().connect();

    ArrayList<TimeTable> timeTables = new ArrayList<>();

    private void customizeComponents() {
        setLocationRelativeTo(this);
        TimeTableTable.getTableHeader().setFont(new java.awt.Font("Tahoma", 1, 12));
        TimeTableTable.getTableHeader().setForeground(new java.awt.Color(0, 150, 150));       
    }

    private ArrayList<TimeTable> retrieveData() {
        String qry = null;
        ArrayList<TimeTable> tTables = new ArrayList<>();
        timeTables.clear();

        try {
            qry = "SELECT * FROM time_table";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);
            while (rs.next()) {
                TimeTable timeTable = new TimeTable(rs.getString("id"), rs.getString("subject"), rs.getString("faculty"), rs.getString("course"),
                        rs.getString("branch"), rs.getString("semester"), rs.getString("section"), rs.getString("day"),
                        rs.getString("time"), rs.getString("timestamp"));
                tTables.add(timeTable);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tTables;
    }

    private void fillTable() {
        timeTables = retrieveData();
        DefaultTableModel model = (DefaultTableModel) TimeTableTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[8];
        for (int i = 0; i < timeTables.size(); i++) {
            row[0] = timeTables.get(i).getCourse();                  
            row[1] = timeTables.get(i).getBranch();
            row[2] = timeTables.get(i).getSemester();
            row[3] = timeTables.get(i).getSection();
            row[4] = timeTables.get(i).getSubject();
            row[5] = timeTables.get(i).getFaculty();
            row[6] = timeTables.get(i).getDay();
            row[7] = timeTables.get(i).getTime();
            model.addRow(row);
        }
    }

    public FacultySubjectIssuingScreen(Role role) {
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
        IssueSubjectButton = new javax.swing.JButton();
        TimetableButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();
        SearchPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        TablePanel = new javax.swing.JPanel();
        TimeTableScrollPane = new javax.swing.JScrollPane();
        TimeTableTable = new javax.swing.JTable();

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
        TitleLabel.setText("TIME TABLE");
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

        IssueSubjectButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        IssueSubjectButton.setForeground(new java.awt.Color(0, 150, 150));
        IssueSubjectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_add.png"))); // NOI18N
        IssueSubjectButton.setText("Issue Subject");
        IssueSubjectButton.setBorder(null);
        IssueSubjectButton.setBorderPainted(false);
        IssueSubjectButton.setContentAreaFilled(false);
        IssueSubjectButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IssueSubjectButton.setFocusable(false);
        IssueSubjectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IssueSubjectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        IssueSubjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IssueSubjectButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(IssueSubjectButton);

        TimetableButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TimetableButton.setForeground(new java.awt.Color(0, 150, 150));
        TimetableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/list80.png"))); // NOI18N
        TimetableButton.setText("View Time Table");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        TimeTableScrollPane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TimeTableScrollPane.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TimeTableScrollPane.setRowHeaderView(null);

        TimeTableTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TimeTableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course", "Branch", "Semester", "Section", "Subject", "Faculty Name", "Day", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TimeTableTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TimeTableTable.setGridColor(new java.awt.Color(180, 180, 180));
        TimeTableTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TimeTableTable.setShowGrid(true);
        TimeTableTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TimeTableTableMousePressed(evt);
            }
        });
        TimeTableScrollPane.setViewportView(TimeTableTable);
        if (TimeTableTable.getColumnModel().getColumnCount() > 0) {
            TimeTableTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            TimeTableTable.getColumnModel().getColumn(2).setMaxWidth(100);
            TimeTableTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            TimeTableTable.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        javax.swing.GroupLayout TablePanelLayout = new javax.swing.GroupLayout(TablePanel);
        TablePanel.setLayout(TablePanelLayout);
        TablePanelLayout.setHorizontalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TimeTableScrollPane)
        );
        TablePanelLayout.setVerticalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TimeTableScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
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
                    .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchButtonMousePressed

    }//GEN-LAST:event_SearchButtonMousePressed

    private void TimeTableTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimeTableTableMousePressed
        int ind = TimeTableTable.getSelectedRow();
        String id = timeTables.get(ind).getId();
        FacultySubjectIssueForm entryForm = new FacultySubjectIssueForm(role);
        entryForm.setVisible(true);
        entryForm.showItemToFields(id);
    }//GEN-LAST:event_TimeTableTableMousePressed

    private void IssueSubjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IssueSubjectButtonActionPerformed
        if (role == Role.ADMIN) {
            FacultySubjectIssueForm issueForm = new FacultySubjectIssueForm(role);
            issueForm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "You Are Not Authorised!!!");
        }
    }//GEN-LAST:event_IssueSubjectButtonActionPerformed

    private void TimetableButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimetableButtonMousePressed

    }//GEN-LAST:event_TimetableButtonMousePressed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed

        fillTable();
    }//GEN-LAST:event_RefreshButtonActionPerformed

    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FacultySubjectIssuingScreen(role).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JButton IssueSubjectButton;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JScrollPane TimeTableScrollPane;
    private javax.swing.JTable TimeTableTable;
    private javax.swing.JButton TimetableButton;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
