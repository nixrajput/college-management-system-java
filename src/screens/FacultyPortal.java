package screens;

import com.formdev.flatlaf.FlatLightLaf;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author nixrajput
 */
public class FacultyPortal extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);
    static Role role;

    public FacultyPortal(Role role) {
        this.role = role;
        initComponents();
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleLabel = new javax.swing.JLabel();
        ButtonPanel = new javax.swing.JPanel();
        EntryButton = new javax.swing.JButton();
        ApplicationButton = new javax.swing.JButton();
        ConfirmationButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("constants/strings"); // NOI18N
        setTitle(bundle.getString("APP_NAME")); // NOI18N
        setIconImage(icon.getImage());
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        TitleLabel.setFont(TitleLabel.getFont().deriveFont(TitleLabel.getFont().getStyle() | java.awt.Font.BOLD, TitleLabel.getFont().getSize()+29));
        TitleLabel.setForeground(new java.awt.Color(60, 185, 145));
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText("FACULTY PORTAL");
        TitleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ButtonPanel.setLayout(new java.awt.GridLayout());

        EntryButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        EntryButton.setForeground(new java.awt.Color(0, 150, 150));
        EntryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user_add.png"))); // NOI18N
        EntryButton.setText("Add Faculty");
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
        ApplicationButton.setText("Subject Issuing");
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
        ConfirmationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/list80.png"))); // NOI18N
        ConfirmationButton.setText("Time Table");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchButton))
                    .addComponent(ButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addContainerGap(569, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EntryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntryButtonActionPerformed

        FacultyEntryForm facultyEntryForm = new FacultyEntryForm(role);
        facultyEntryForm.setVisible(true);
    }//GEN-LAST:event_EntryButtonActionPerformed

    private void ApplicationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplicationButtonActionPerformed
       
    }//GEN-LAST:event_ApplicationButtonActionPerformed

    private void ConfirmationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmationButtonActionPerformed

        
    }//GEN-LAST:event_ConfirmationButtonActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed

        
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void SearchButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchButtonMousePressed

       
    }//GEN-LAST:event_SearchButtonMousePressed

    
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacultyPortal(role).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApplicationButton;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JButton ConfirmationButton;
    private javax.swing.JButton EntryButton;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
