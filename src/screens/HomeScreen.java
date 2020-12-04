package screens;

import com.formdev.flatlaf.FlatLightLaf;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author nixrajput
 */
public class HomeScreen extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);
    static Role role;
    
    static String application_no = null;

    public HomeScreen(Role role, String app_no) {
        this.role = role;
       this.application_no = app_no;
        initComponents();
        customizeComponents();
        setLocationRelativeTo(this);

    }

    private void customizeComponents() {
        if (role != Role.ADMIN) {
            System.out.println("Logged in as " + role);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AppNameLabel = new javax.swing.JLabel();
        BannerLabel = new javax.swing.JLabel();
        StudentButton = new javax.swing.JButton();
        FacultyButton = new javax.swing.JButton();
        LibraryButton = new javax.swing.JButton();
        HostelButton = new javax.swing.JButton();
        AttendanceButton = new javax.swing.JButton();
        AccountsButton = new javax.swing.JButton();
        ReportsButton = new javax.swing.JButton();
        AboutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("constants/strings"); // NOI18N
        setTitle(bundle.getString("APP_NAME")); // NOI18N
        setIconImage(icon.getImage());
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setName("HomeFrame"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        AppNameLabel.setFont(AppNameLabel.getFont().deriveFont(AppNameLabel.getFont().getStyle() | java.awt.Font.BOLD, AppNameLabel.getFont().getSize()+29));
        AppNameLabel.setForeground(new java.awt.Color(60, 185, 145));
        AppNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AppNameLabel.setText(bundle.getString("APP_NAME")); // NOI18N
        AppNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        BannerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BannerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/home_banner.png"))); // NOI18N

        StudentButton.setFont(StudentButton.getFont().deriveFont(StudentButton.getFont().getStyle() | java.awt.Font.BOLD, StudentButton.getFont().getSize()+3));
        StudentButton.setForeground(new java.awt.Color(80, 180, 140));
        StudentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/student.png"))); // NOI18N
        StudentButton.setText("STUDENT");
        StudentButton.setBorder(null);
        StudentButton.setBorderPainted(false);
        StudentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StudentButton.setFocusable(false);
        StudentButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        StudentButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        StudentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                StudentButtonMousePressed(evt);
            }
        });

        FacultyButton.setFont(FacultyButton.getFont().deriveFont(FacultyButton.getFont().getStyle() | java.awt.Font.BOLD, FacultyButton.getFont().getSize()+3));
        FacultyButton.setForeground(new java.awt.Color(80, 180, 140));
        FacultyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/teacher.png"))); // NOI18N
        FacultyButton.setText("FACULTY");
        FacultyButton.setBorder(null);
        FacultyButton.setBorderPainted(false);
        FacultyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FacultyButton.setFocusable(false);
        FacultyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FacultyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        FacultyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FacultyButtonMousePressed(evt);
            }
        });

        LibraryButton.setFont(LibraryButton.getFont().deriveFont(LibraryButton.getFont().getStyle() | java.awt.Font.BOLD, LibraryButton.getFont().getSize()+3));
        LibraryButton.setForeground(new java.awt.Color(80, 180, 140));
        LibraryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/library.png"))); // NOI18N
        LibraryButton.setText("LIBRARY");
        LibraryButton.setBorder(null);
        LibraryButton.setBorderPainted(false);
        LibraryButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LibraryButton.setFocusable(false);
        LibraryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LibraryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        HostelButton.setFont(HostelButton.getFont().deriveFont(HostelButton.getFont().getStyle() | java.awt.Font.BOLD, HostelButton.getFont().getSize()+3));
        HostelButton.setForeground(new java.awt.Color(80, 180, 140));
        HostelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/hostel.png"))); // NOI18N
        HostelButton.setText("HOSTEL");
        HostelButton.setBorder(null);
        HostelButton.setBorderPainted(false);
        HostelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HostelButton.setFocusable(false);
        HostelButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        HostelButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        AttendanceButton.setFont(AttendanceButton.getFont().deriveFont(AttendanceButton.getFont().getStyle() | java.awt.Font.BOLD, AttendanceButton.getFont().getSize()+3));
        AttendanceButton.setForeground(new java.awt.Color(80, 180, 140));
        AttendanceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/attendance.png"))); // NOI18N
        AttendanceButton.setText("ATTENDACE");
        AttendanceButton.setBorder(null);
        AttendanceButton.setBorderPainted(false);
        AttendanceButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AttendanceButton.setFocusable(false);
        AttendanceButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AttendanceButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        AccountsButton.setFont(AccountsButton.getFont().deriveFont(AccountsButton.getFont().getStyle() | java.awt.Font.BOLD, AccountsButton.getFont().getSize()+3));
        AccountsButton.setForeground(new java.awt.Color(80, 180, 140));
        AccountsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/accounts.png"))); // NOI18N
        AccountsButton.setText("ACCOUNTS");
        AccountsButton.setBorder(null);
        AccountsButton.setBorderPainted(false);
        AccountsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AccountsButton.setFocusable(false);
        AccountsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AccountsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        ReportsButton.setFont(ReportsButton.getFont().deriveFont(ReportsButton.getFont().getStyle() | java.awt.Font.BOLD, ReportsButton.getFont().getSize()+3));
        ReportsButton.setForeground(new java.awt.Color(80, 180, 140));
        ReportsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/reports.png"))); // NOI18N
        ReportsButton.setText("REPORTS");
        ReportsButton.setBorder(null);
        ReportsButton.setBorderPainted(false);
        ReportsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ReportsButton.setFocusable(false);
        ReportsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ReportsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        AboutButton.setFont(AboutButton.getFont().deriveFont(AboutButton.getFont().getStyle() | java.awt.Font.BOLD, AboutButton.getFont().getSize()+3));
        AboutButton.setForeground(new java.awt.Color(80, 180, 140));
        AboutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/info.png"))); // NOI18N
        AboutButton.setText("ABOUT");
        AboutButton.setBorder(null);
        AboutButton.setBorderPainted(false);
        AboutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AboutButton.setFocusable(false);
        AboutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AboutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AttendanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FacultyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(LibraryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AccountsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ReportsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HostelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AppNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BannerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AppNameLabel)
                .addGap(28, 28, 28)
                .addComponent(BannerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(StudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AttendanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FacultyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AccountsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LibraryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ReportsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HostelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StudentButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentButtonMousePressed

        StudentPortal studentPortal = new StudentPortal(role, application_no);
        studentPortal.setVisible(true);

    }//GEN-LAST:event_StudentButtonMousePressed

    private void FacultyButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacultyButtonMousePressed
        FacultyPortal facultyPortal = new FacultyPortal(role);
        facultyPortal.setVisible(true);
    }//GEN-LAST:event_FacultyButtonMousePressed

    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeScreen(role, application_no).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AboutButton;
    private javax.swing.JButton AccountsButton;
    private javax.swing.JLabel AppNameLabel;
    private javax.swing.JButton AttendanceButton;
    private javax.swing.JLabel BannerLabel;
    private javax.swing.JButton FacultyButton;
    private javax.swing.JButton HostelButton;
    private javax.swing.JButton LibraryButton;
    private javax.swing.JButton ReportsButton;
    private javax.swing.JButton StudentButton;
    // End of variables declaration//GEN-END:variables
}
