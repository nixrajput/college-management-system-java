package screens;

import com.formdev.flatlaf.FlatLightLaf;
import constants.Role;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import repository.DBConnection;
import repository.DBFunctions;

/**
 *
 * @author nixrajput
 */
public class TimeTableScreen extends javax.swing.JFrame {
private static final long serialVersionUID = 1L;

    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);
    static Role role;

    private final Connection con = new DBConnection().connect();
    
    public TimeTableScreen(Role role) {
        this.role = role;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitlePanel = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        ButtonPanel = new javax.swing.JPanel();
        CoursePanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        CourseComboBox = new javax.swing.JComboBox<>();
        CourseLoadingButton = new javax.swing.JButton();
        BranchPanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        CourseComboBox2 = new javax.swing.JComboBox<>();
        BranchLoadingButton = new javax.swing.JButton();
        SemPanel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        CourseComboBox3 = new javax.swing.JComboBox<>();
        SemLoadingButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("constants/strings"); // NOI18N
        setTitle(bundle.getString("APP_NAME")); // NOI18N
        setIconImage(icon.getImage());
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setPreferredSize(new java.awt.Dimension(1200, 800));
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

        ButtonPanel.setOpaque(false);
        ButtonPanel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jLabel18.setFont(jLabel18.getFont().deriveFont(jLabel18.getFont().getStyle() | java.awt.Font.BOLD, jLabel18.getFont().getSize()+3));
        jLabel18.setForeground(new java.awt.Color(0, 150, 150));
        jLabel18.setText("Course");

        CourseComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        CourseLoadingButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CourseLoadingButton.setForeground(new java.awt.Color(0, 150, 150));
        CourseLoadingButton.setText("Load");
        CourseLoadingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CourseLoadingButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout CoursePanelLayout = new javax.swing.GroupLayout(CoursePanel);
        CoursePanel.setLayout(CoursePanelLayout);
        CoursePanelLayout.setHorizontalGroup(
            CoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoursePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CourseLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CoursePanelLayout.setVerticalGroup(
            CoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoursePanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(CoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CourseLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        ButtonPanel.add(CoursePanel);

        jLabel20.setFont(jLabel20.getFont().deriveFont(jLabel20.getFont().getStyle() | java.awt.Font.BOLD, jLabel20.getFont().getSize()+3));
        jLabel20.setForeground(new java.awt.Color(0, 150, 150));
        jLabel20.setText("Branch");

        CourseComboBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CourseComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        BranchLoadingButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BranchLoadingButton.setForeground(new java.awt.Color(0, 150, 150));
        BranchLoadingButton.setText("Load");
        BranchLoadingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BranchLoadingButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout BranchPanelLayout = new javax.swing.GroupLayout(BranchPanel);
        BranchPanel.setLayout(BranchPanelLayout);
        BranchPanelLayout.setHorizontalGroup(
            BranchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BranchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CourseComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BranchLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        BranchPanelLayout.setVerticalGroup(
            BranchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BranchPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(BranchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CourseComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BranchLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        ButtonPanel.add(BranchPanel);

        jLabel21.setFont(jLabel21.getFont().deriveFont(jLabel21.getFont().getStyle() | java.awt.Font.BOLD, jLabel21.getFont().getSize()+3));
        jLabel21.setForeground(new java.awt.Color(0, 150, 150));
        jLabel21.setText("Semester");

        CourseComboBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CourseComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        SemLoadingButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SemLoadingButton.setForeground(new java.awt.Color(0, 150, 150));
        SemLoadingButton.setText("Load");
        SemLoadingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SemLoadingButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout SemPanelLayout = new javax.swing.GroupLayout(SemPanel);
        SemPanel.setLayout(SemPanelLayout);
        SemPanelLayout.setHorizontalGroup(
            SemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CourseComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SemLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        SemPanelLayout.setVerticalGroup(
            SemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SemPanelLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(SemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CourseComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SemLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        ButtonPanel.add(SemPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitlePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CourseLoadingButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CourseLoadingButtonMousePressed
        ArrayList<String> courses = DBFunctions.loadCourses();
        if (courses.isEmpty()) {
            courses.add("Select");
        }
        CourseComboBox.setModel(new DefaultComboBoxModel<>(courses.toArray(new String[0])));
    }//GEN-LAST:event_CourseLoadingButtonMousePressed

    private void BranchLoadingButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BranchLoadingButtonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BranchLoadingButtonMousePressed

    private void SemLoadingButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SemLoadingButtonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_SemLoadingButtonMousePressed

 
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new TimeTableScreen(role).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BranchLoadingButton;
    private javax.swing.JPanel BranchPanel;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JComboBox<String> CourseComboBox;
    private javax.swing.JComboBox<String> CourseComboBox2;
    private javax.swing.JComboBox<String> CourseComboBox3;
    private javax.swing.JButton CourseLoadingButton;
    private javax.swing.JPanel CoursePanel;
    private javax.swing.JButton SemLoadingButton;
    private javax.swing.JPanel SemPanel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
