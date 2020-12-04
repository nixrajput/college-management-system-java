package screens;

import com.formdev.flatlaf.FlatLightLaf;
import java.net.URL;
import java.sql.Connection;
import javax.swing.ImageIcon;
import repository.DBConnection;

public class MainScreen extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    int deviceWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    int deviceHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

    Connection conn = new DBConnection().connect();
    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);

    public MainScreen() {
        initComponents();
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        ToLabel = new javax.swing.JLabel();
        WelcomeLabel = new javax.swing.JLabel();
        AppNameLabel = new javax.swing.JLabel();
        LoginLabel = new javax.swing.JLabel();
        BannerLabel = new javax.swing.JLabel();
        LoginLabel1 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("constants/strings"); // NOI18N
        setTitle(bundle.getString("APP_NAME")); // NOI18N
        setIconImage(icon.getImage());
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setName("MainFrame"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        ToLabel.setFont(ToLabel.getFont().deriveFont(ToLabel.getFont().getStyle() | java.awt.Font.BOLD, ToLabel.getFont().getSize()+29));
        ToLabel.setForeground(new java.awt.Color(60, 185, 145));
        ToLabel.setText(bundle.getString("TO")); // NOI18N

        WelcomeLabel.setFont(WelcomeLabel.getFont().deriveFont(WelcomeLabel.getFont().getStyle() | java.awt.Font.BOLD, WelcomeLabel.getFont().getSize()+29));
        WelcomeLabel.setForeground(new java.awt.Color(60, 185, 145));
        WelcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeLabel.setText(bundle.getString("WELCOME")); // NOI18N
        WelcomeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        AppNameLabel.setFont(AppNameLabel.getFont().deriveFont(AppNameLabel.getFont().getStyle() | java.awt.Font.BOLD, AppNameLabel.getFont().getSize()+29));
        AppNameLabel.setForeground(new java.awt.Color(60, 185, 145));
        AppNameLabel.setText(bundle.getString("APP_NAME")); // NOI18N

        LoginLabel.setFont(LoginLabel.getFont().deriveFont(LoginLabel.getFont().getStyle() | java.awt.Font.BOLD, LoginLabel.getFont().getSize()+5));
        LoginLabel.setForeground(new java.awt.Color(255, 255, 255));
        LoginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn300x60.png"))); // NOI18N
        LoginLabel.setText("LOGIN HERE");
        LoginLabel.setToolTipText("");
        LoginLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LoginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LoginLabelMousePressed(evt);
            }
        });

        BannerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BannerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/college_banner.png"))); // NOI18N
        BannerLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        LoginLabel1.setFont(LoginLabel1.getFont().deriveFont(LoginLabel1.getFont().getStyle() | java.awt.Font.BOLD, LoginLabel1.getFont().getSize()+5));
        LoginLabel1.setForeground(new java.awt.Color(255, 255, 255));
        LoginLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn300x60.png"))); // NOI18N
        LoginLabel1.setText(" APPLY NOW");
        LoginLabel1.setToolTipText("");
        LoginLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LoginLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LoginLabel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(488, 488, 488)
                        .addComponent(WelcomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ToLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(BannerLabel)))
                .addContainerGap(225, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(AppNameLabel)
                        .addGap(306, 306, 306))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LoginLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(417, 417, 417))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WelcomeLabel)
                    .addComponent(ToLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AppNameLabel)
                .addGap(49, 49, 49)
                .addComponent(BannerLabel)
                .addGap(18, 18, 18)
                .addComponent(LoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginLabelMousePressed

        this.dispose();

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);

    }//GEN-LAST:event_LoginLabelMousePressed

    private void LoginLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginLabel1MousePressed
        StudentApplicationForm applicationForm = new StudentApplicationForm(Role.ADMIN);
        applicationForm.setVisible(true);
    }//GEN-LAST:event_LoginLabel1MousePressed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new MainScreen().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AppNameLabel;
    private javax.swing.JLabel BannerLabel;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JLabel LoginLabel1;
    private javax.swing.JLabel ToLabel;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
