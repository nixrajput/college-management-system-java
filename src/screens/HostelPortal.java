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
import models.Hostel;
import repository.DBConnection;

/**
 *
 * @author nixrajput
 */
public class HostelPortal extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);
    static Role role;

    private final Connection con = new DBConnection().connect();

    ArrayList<Hostel> hostel_list = new ArrayList<>();

    private void customizeComponents() {
        setLocationRelativeTo(this);
        StudentTable.getTableHeader().setFont(new java.awt.Font("Tahoma", 1, 12));
        StudentTable.getTableHeader().setForeground(new java.awt.Color(0, 150, 150));
    }

    private ArrayList<Hostel> retrieveData() {
        String qry = null;
        ArrayList<Hostel> stu_list = new ArrayList<>();
        try {
            qry = "SELECT * FROM hostel";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);
            Hostel hostel;
            while (rs.next()) {
                hostel = new Hostel(rs.getString("reg_no"), rs.getString("name"), rs.getString("hostel_no"),
                        rs.getString("floor_no"), rs.getString("room_no"), rs.getString("room_type"),
                        rs.getString("bed_type"), rs.getString("timestamp"));
                stu_list.add(hostel);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return stu_list;
    }

    private void fillTable() {
        hostel_list.clear();
        hostel_list = retrieveData();
        DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < hostel_list.size(); i++) {
            row[0] = hostel_list.get(i).getReg_no();
            row[1] = hostel_list.get(i).getName();
            row[2] = hostel_list.get(i).getHostel_no();
            row[3] = hostel_list.get(i).getFloor_no();
            row[4] = hostel_list.get(i).getRoom_no();
            row[5] = hostel_list.get(i).getRoom_type();
            row[6] = hostel_list.get(i).getBed_type();
            model.addRow(row);
        }
    }

    public HostelPortal(Role role) {
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
        EntryButton = new javax.swing.JButton();
        ApplicationButton = new javax.swing.JButton();
        ConfirmationButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();
        SearchPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
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
        TitleLabel.setText("HOSTEL PORTAL");
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

        ButtonPanel.setOpaque(false);
        ButtonPanel.setLayout(new java.awt.GridLayout(1, 0));

        EntryButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        EntryButton.setForeground(new java.awt.Color(0, 150, 150));
        EntryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user_add.png"))); // NOI18N
        EntryButton.setText("New Entry");
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

        ApplicationButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ApplicationButton.setForeground(new java.awt.Color(0, 150, 150));
        ApplicationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/form_add.png"))); // NOI18N
        ApplicationButton.setText("Mess Menu");
        ApplicationButton.setBorder(null);
        ApplicationButton.setBorderPainted(false);
        ApplicationButton.setContentAreaFilled(false);
        ApplicationButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ApplicationButton.setFocusable(false);
        ApplicationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ApplicationButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ApplicationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplicationButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(ApplicationButton);

        ConfirmationButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ConfirmationButton.setForeground(new java.awt.Color(0, 150, 150));
        ConfirmationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/info80.png"))); // NOI18N
        ConfirmationButton.setText("Rules & Regulations");
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

        TablePanel.setOpaque(false);

        StudentScrollPane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StudentScrollPane.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StudentScrollPane.setRowHeaderView(null);

        StudentTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg. No.", "Name", "Hostel No.", "Floor No.", "Room No.", "Room Type", "Bed Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StudentTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StudentTable.setGridColor(new java.awt.Color(102, 102, 102));
        StudentTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        StudentTable.setShowGrid(true);
        StudentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                StudentTableMousePressed(evt);
            }
        });
        StudentScrollPane.setViewportView(StudentTable);
        if (StudentTable.getColumnModel().getColumnCount() > 0) {
            StudentTable.getColumnModel().getColumn(0).setResizable(false);
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
            .addComponent(StudentScrollPane)
        );
        TablePanelLayout.setVerticalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StudentScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
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
                    .addComponent(ButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StudentTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentTableMousePressed
        int ind = StudentTable.getSelectedRow();
        String _reg_no = hostel_list.get(ind).getReg_no();
        HostelIssueForm issueForm = new HostelIssueForm(role);
        issueForm.setVisible(true);
        issueForm.showItemToFields(_reg_no);
    }//GEN-LAST:event_StudentTableMousePressed

    private void SearchButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchButtonMousePressed

        String val = SearchTextField.getText();
        hostel_list.clear();
        try {
            String qry = "SELECT * FROM hostel WHERE name LIKE '%" + val + "%' OR reg_no LIKE '%" + val + "%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);
            Hostel hostel;
            while (rs.next()) {
                hostel = new Hostel(rs.getString("reg_no"), rs.getString("name"), rs.getString("hostel_no"),
                        rs.getString("floor_no"), rs.getString("room_no"), rs.getString("room_type"),
                        rs.getString("bed_type"), rs.getString("timestamp"));
                hostel_list.add(hostel);
            }
            DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();
            model.setRowCount(0);
            if (hostel_list.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No Records Found!", "Not Found", 0);
            } else {
                Object[] row = new Object[7];
                for (int i = 0; i < hostel_list.size(); i++) {
                    row[0] = hostel_list.get(i).getReg_no();
                    row[1] = hostel_list.get(i).getName();
                    row[2] = hostel_list.get(i).getHostel_no();
                    row[3] = hostel_list.get(i).getFloor_no();
                    row[4] = hostel_list.get(i).getRoom_no();
                    row[5] = hostel_list.get(i).getRoom_type();
                    row[6] = hostel_list.get(i).getBed_type();
                    model.addRow(row);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_SearchButtonMousePressed

    private void EntryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntryButtonActionPerformed
        if (role == Role.ADMIN) {
            HostelIssueForm hostelIssueForm = new HostelIssueForm(role);
            hostelIssueForm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "You Are Not Authorised!", "Access Denied", 0);
        }
    }//GEN-LAST:event_EntryButtonActionPerformed

    private void ApplicationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplicationButtonActionPerformed

    }//GEN-LAST:event_ApplicationButtonActionPerformed

    private void ConfirmationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmationButtonActionPerformed

    }//GEN-LAST:event_ConfirmationButtonActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        SearchTextField.setText(null);
        fillTable();
    }//GEN-LAST:event_RefreshButtonActionPerformed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new HostelPortal(role).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApplicationButton;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JButton ConfirmationButton;
    private javax.swing.JButton EntryButton;
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
