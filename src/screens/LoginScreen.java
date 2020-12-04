package screens;

import com.formdev.flatlaf.FlatLightLaf;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import repository.DBConnection;

enum Role {
    NULL,ADMIN,FACULTY,STUDENT;
}

/**
 *
 * @author nixrajput
 */
public class LoginScreen extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);

    public LoginScreen() {
        initComponents();
        setLocationRelativeTo(this);
    }

    private void loginAdmin(java.awt.event.ActionEvent event) {
        String admin_sql = "SELECT * FROM admins WHERE username=? and password=?";
        String faculty_sql = "SELECT * FROM faculty WHERE username=? and password=?";
        String student_sql = "SELECT * FROM student WHERE application_no=? and password=?";
        String role = RoleComboBox.getSelectedItem().toString();
        Role role_id = Role.NULL;
        PreparedStatement stmt = null;
        try {
            Connection conn = new DBConnection().connect();
            if (role == "ADMIN" || role == "admin") {
                role_id = Role.ADMIN;
                stmt = conn.prepareStatement(admin_sql);
            } else if (role == "FACULTY" || role == "faculty") {
                role_id = Role.FACULTY;
                stmt = conn.prepareStatement(faculty_sql);
            } else if (role == "STUDENT" || role == "student") {
                role_id = Role.STUDENT;
                stmt = conn.prepareStatement(student_sql);
            }
            stmt.setString(1, UsernameTextField.getText());
            stmt.setString(2, String.copyValueOf(PasswordTextField.getPassword()));

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                MainScreen mainScreen = new MainScreen();
                mainScreen.setVisible(false);
                this.dispose();

                HomeScreen homeScreen = new HomeScreen(role_id, UsernameTextField.getText().toString());
                homeScreen.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Wrong credentials. Please check and try again.");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleLabel = new javax.swing.JLabel();
        BannerLabel = new javax.swing.JLabel();
        UsernameLabel = new javax.swing.JLabel();
        UsernameTextField = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        PasswordTextField = new javax.swing.JPasswordField();
        RoleLabel = new javax.swing.JLabel();
        RoleComboBox = new javax.swing.JComboBox<>();
        LoginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("constants/strings"); // NOI18N
        setTitle(bundle.getString("APP_NAME")); // NOI18N
        setIconImage(icon.getImage());
        setMaximumSize(new java.awt.Dimension(680, 620));
        setMinimumSize(new java.awt.Dimension(680, 620));
        setName("LoginFrame"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        TitleLabel.setFont(TitleLabel.getFont().deriveFont(TitleLabel.getFont().getStyle() | java.awt.Font.BOLD, TitleLabel.getFont().getSize()+29));
        TitleLabel.setForeground(new java.awt.Color(60, 185, 145));
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText(bundle.getString("LOGIN")); // NOI18N
        TitleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        BannerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BannerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/college.png"))); // NOI18N
        BannerLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BannerLabel.setMaximumSize(new java.awt.Dimension(320, 200));
        BannerLabel.setMinimumSize(new java.awt.Dimension(320, 200));
        BannerLabel.setPreferredSize(new java.awt.Dimension(320, 200));

        UsernameLabel.setFont(UsernameLabel.getFont().deriveFont(UsernameLabel.getFont().getStyle() | java.awt.Font.BOLD, UsernameLabel.getFont().getSize()+3));
        UsernameLabel.setForeground(new java.awt.Color(60, 185, 145));
        UsernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UsernameLabel.setText(bundle.getString("USERNAME")); // NOI18N
        UsernameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        UsernameTextField.setFont(UsernameTextField.getFont().deriveFont(UsernameTextField.getFont().getSize()+1f));
        UsernameTextField.setToolTipText(bundle.getString("USERNAME")); // NOI18N

        PasswordLabel.setFont(PasswordLabel.getFont().deriveFont(PasswordLabel.getFont().getStyle() | java.awt.Font.BOLD, PasswordLabel.getFont().getSize()+3));
        PasswordLabel.setForeground(new java.awt.Color(60, 185, 145));
        PasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PasswordLabel.setText(bundle.getString("PASSWORD")); // NOI18N
        PasswordLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        RoleLabel.setFont(RoleLabel.getFont().deriveFont(RoleLabel.getFont().getStyle() | java.awt.Font.BOLD, RoleLabel.getFont().getSize()+3));
        RoleLabel.setForeground(new java.awt.Color(60, 185, 145));
        RoleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RoleLabel.setText(bundle.getString("ROLE")); // NOI18N
        RoleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        RoleComboBox.setFont(RoleComboBox.getFont().deriveFont(RoleComboBox.getFont().getStyle() | java.awt.Font.BOLD, RoleComboBox.getFont().getSize()+1));
        RoleComboBox.setForeground(new java.awt.Color(51, 51, 51));
        RoleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "FACULTY", "STUDENT" }));

        LoginButton.setFont(LoginButton.getFont().deriveFont(LoginButton.getFont().getStyle() | java.awt.Font.BOLD, LoginButton.getFont().getSize()+3));
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn.png"))); // NOI18N
        LoginButton.setText(bundle.getString("NEXT")); // NOI18N
        LoginButton.setBorder(null);
        LoginButton.setBorderPainted(false);
        LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(TitleLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(BannerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RoleComboBox, 0, 240, Short.MAX_VALUE)
                            .addComponent(UsernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordTextField))))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel)
                .addGap(26, 26, 26)
                .addComponent(BannerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsernameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UsernameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(LoginButton)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        loginAdmin(evt);
    }//GEN-LAST:event_LoginButtonActionPerformed

    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BannerLabel;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPasswordField PasswordTextField;
    private javax.swing.JComboBox<String> RoleComboBox;
    private javax.swing.JLabel RoleLabel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JTextField UsernameTextField;
    // End of variables declaration//GEN-END:variables
}
