package screens;

import com.formdev.flatlaf.FlatLightLaf;
import constants.Role;
import constants.Strings;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import repository.DBConnection;

/**
 *
 * @author nixrajput
 */
public class LoginScreen extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);

    private void customizeComponents() {
        setLocationRelativeTo(this);
    }

    public LoginScreen() {
        initComponents();
        customizeComponents();
    }

    private void loginAdmin(java.awt.event.ActionEvent event) {
        if (UsernameTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Username Field Is Empty!!!");
        } else if (PasswordTextField.getPassword().length <= 0) {
            JOptionPane.showMessageDialog(null, "Password Field Is Empty!!!");
        } else {
            Connection conn = new DBConnection().connect();
            String admin_sql = "SELECT * FROM admins WHERE username=? and password=?";
            String faculty_sql = "SELECT * FROM faculty WHERE registration_no=? and password=?";
            String student_sql = "SELECT * FROM student WHERE registration_no=? and password=?";
            String uname = UsernameTextField.getText();
            String pass = String.copyValueOf(PasswordTextField.getPassword());
            String role = RoleComboBox.getSelectedItem().toString();
            Role role_id = null;
            PreparedStatement stmt = null;
            try {
                switch (role) {
                    case "ADMIN":
                    case "admin":
                        role_id = Role.ADMIN;
                        stmt = conn.prepareStatement(admin_sql);
                        break;
                    case "FACULTY":
                    case "faculty":
                        role_id = Role.FACULTY;
                        stmt = conn.prepareStatement(faculty_sql);
                        break;
                    case "STUDENT":
                    case "student":
                        role_id = Role.STUDENT;
                        stmt = conn.prepareStatement(student_sql);
                        break;
                    default:
                        break;
                }
                stmt.setString(1, uname);
                stmt.setString(2, pass);

                ResultSet resultSet = stmt.executeQuery();

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "Logged In Successfully.", "Success", 1);
                    this.dispose();
                    HomeScreen homeScreen = new HomeScreen(role_id, uname);
                    homeScreen.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Wrong credentials. Please check and try again!", "Error", 0);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitlePanel = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        BodyPanel = new javax.swing.JPanel();
        BannerLabel = new javax.swing.JLabel();
        UsernameLabel = new javax.swing.JLabel();
        UsernameTextField = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        PasswordTextField = new javax.swing.JPasswordField();
        RoleLabel = new javax.swing.JLabel();
        RoleComboBox = new javax.swing.JComboBox<>();
        ButtonPanel = new javax.swing.JPanel();
        LoginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(Strings.getAPP_NAME());
        setIconImage(icon.getImage());
        setMaximumSize(new java.awt.Dimension(680, 620));
        setMinimumSize(new java.awt.Dimension(680, 620));
        setName("LoginFrame"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        TitlePanel.setBackground(new java.awt.Color(51, 51, 51));

        TitleLabel.setFont(TitleLabel.getFont().deriveFont(TitleLabel.getFont().getStyle() | java.awt.Font.BOLD, TitleLabel.getFont().getSize()+29));
        TitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("constants/strings"); // NOI18N
        TitleLabel.setText(bundle.getString("LOGIN")); // NOI18N
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

        javax.swing.GroupLayout BodyPanelLayout = new javax.swing.GroupLayout(BodyPanel);
        BodyPanel.setLayout(BodyPanelLayout);
        BodyPanelLayout.setHorizontalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyPanelLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyPanelLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(BannerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BodyPanelLayout.createSequentialGroup()
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RoleComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UsernameTextField)
                            .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        BodyPanelLayout.setVerticalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BannerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsernameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UsernameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        LoginButton.setFont(LoginButton.getFont().deriveFont(LoginButton.getFont().getStyle() | java.awt.Font.BOLD, LoginButton.getFont().getSize()+3));
        LoginButton.setText(bundle.getString("NEXT")); // NOI18N
        LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LoginButton.setOpaque(false);
        LoginButton.setPreferredSize(new java.awt.Dimension(180, 40));
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(LoginButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
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

        java.awt.EventQueue.invokeLater(() -> {
            new LoginScreen().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BannerLabel;
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPasswordField PasswordTextField;
    private javax.swing.JComboBox<String> RoleComboBox;
    private javax.swing.JLabel RoleLabel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JTextField UsernameTextField;
    // End of variables declaration//GEN-END:variables
}
