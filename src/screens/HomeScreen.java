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

    static String current_uname = null;

    public HomeScreen(Role role, String reg_no) {
        this.role = role;
        this.current_uname = reg_no;
        initComponents();
        customizeComponents();
    }

    private void customizeComponents() {
        setLocationRelativeTo(this);
        if (role != Role.ADMIN) {
            System.out.println("Logged in as " + role);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitlePanel = new javax.swing.JPanel();
        AppNameLabel = new javax.swing.JLabel();
        BannerPanel = new javax.swing.JPanel();
        BannerLabel = new javax.swing.JLabel();
        ControlPanel = new javax.swing.JPanel();
        ButtonPanel = new javax.swing.JPanel();
        MenuOne = new javax.swing.JPanel();
        StudentButton = new javax.swing.JButton();
        FacultyButton = new javax.swing.JButton();
        LibraryButton = new javax.swing.JButton();
        HostelButton = new javax.swing.JButton();
        MenuTwo = new javax.swing.JPanel();
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

        TitlePanel.setBackground(new java.awt.Color(51, 51, 51));

        AppNameLabel.setFont(AppNameLabel.getFont().deriveFont(AppNameLabel.getFont().getStyle() | java.awt.Font.BOLD, AppNameLabel.getFont().getSize()+29));
        AppNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        AppNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AppNameLabel.setText(bundle.getString("APP_NAME")); // NOI18N
        AppNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AppNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        TitlePanelLayout.setVerticalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AppNameLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BannerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BannerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/home_banner.png"))); // NOI18N
        BannerPanel.add(BannerLabel);

        ButtonPanel.setMinimumSize(new java.awt.Dimension(1180, 349));
        ButtonPanel.setOpaque(false);
        ButtonPanel.setLayout(new java.awt.GridLayout(2, 1, 10, 10));

        MenuOne.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

        StudentButton.setFont(StudentButton.getFont().deriveFont(StudentButton.getFont().getStyle() | java.awt.Font.BOLD, StudentButton.getFont().getSize()+3));
        StudentButton.setForeground(new java.awt.Color(80, 180, 140));
        StudentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/student.png"))); // NOI18N
        StudentButton.setText("STUDENT");
        StudentButton.setBorder(null);
        StudentButton.setBorderPainted(false);
        StudentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StudentButton.setFocusable(false);
        StudentButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        StudentButton.setOpaque(false);
        StudentButton.setPreferredSize(new java.awt.Dimension(160, 160));
        StudentButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        StudentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                StudentButtonMousePressed(evt);
            }
        });
        MenuOne.add(StudentButton);

        FacultyButton.setFont(FacultyButton.getFont().deriveFont(FacultyButton.getFont().getStyle() | java.awt.Font.BOLD, FacultyButton.getFont().getSize()+3));
        FacultyButton.setForeground(new java.awt.Color(80, 180, 140));
        FacultyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/teacher.png"))); // NOI18N
        FacultyButton.setText("FACULTY");
        FacultyButton.setBorder(null);
        FacultyButton.setBorderPainted(false);
        FacultyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FacultyButton.setFocusable(false);
        FacultyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FacultyButton.setOpaque(false);
        FacultyButton.setPreferredSize(new java.awt.Dimension(160, 160));
        FacultyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        FacultyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FacultyButtonMousePressed(evt);
            }
        });
        MenuOne.add(FacultyButton);

        LibraryButton.setFont(LibraryButton.getFont().deriveFont(LibraryButton.getFont().getStyle() | java.awt.Font.BOLD, LibraryButton.getFont().getSize()+3));
        LibraryButton.setForeground(new java.awt.Color(80, 180, 140));
        LibraryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/library.png"))); // NOI18N
        LibraryButton.setText("LIBRARY");
        LibraryButton.setBorder(null);
        LibraryButton.setBorderPainted(false);
        LibraryButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LibraryButton.setFocusable(false);
        LibraryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LibraryButton.setOpaque(false);
        LibraryButton.setPreferredSize(new java.awt.Dimension(160, 160));
        LibraryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MenuOne.add(LibraryButton);

        HostelButton.setFont(HostelButton.getFont().deriveFont(HostelButton.getFont().getStyle() | java.awt.Font.BOLD, HostelButton.getFont().getSize()+3));
        HostelButton.setForeground(new java.awt.Color(80, 180, 140));
        HostelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/hostel.png"))); // NOI18N
        HostelButton.setText("HOSTEL");
        HostelButton.setBorder(null);
        HostelButton.setBorderPainted(false);
        HostelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HostelButton.setFocusable(false);
        HostelButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        HostelButton.setOpaque(false);
        HostelButton.setPreferredSize(new java.awt.Dimension(160, 160));
        HostelButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MenuOne.add(HostelButton);

        ButtonPanel.add(MenuOne);

        MenuTwo.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

        AttendanceButton.setFont(AttendanceButton.getFont().deriveFont(AttendanceButton.getFont().getStyle() | java.awt.Font.BOLD, AttendanceButton.getFont().getSize()+3));
        AttendanceButton.setForeground(new java.awt.Color(80, 180, 140));
        AttendanceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/attendance.png"))); // NOI18N
        AttendanceButton.setText("ATTENDACE");
        AttendanceButton.setBorder(null);
        AttendanceButton.setBorderPainted(false);
        AttendanceButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AttendanceButton.setFocusable(false);
        AttendanceButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AttendanceButton.setOpaque(false);
        AttendanceButton.setPreferredSize(new java.awt.Dimension(160, 160));
        AttendanceButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MenuTwo.add(AttendanceButton);

        AccountsButton.setFont(AccountsButton.getFont().deriveFont(AccountsButton.getFont().getStyle() | java.awt.Font.BOLD, AccountsButton.getFont().getSize()+3));
        AccountsButton.setForeground(new java.awt.Color(80, 180, 140));
        AccountsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/accounts.png"))); // NOI18N
        AccountsButton.setText("ACCOUNTS");
        AccountsButton.setBorder(null);
        AccountsButton.setBorderPainted(false);
        AccountsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AccountsButton.setFocusable(false);
        AccountsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AccountsButton.setOpaque(false);
        AccountsButton.setPreferredSize(new java.awt.Dimension(160, 160));
        AccountsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MenuTwo.add(AccountsButton);

        ReportsButton.setFont(ReportsButton.getFont().deriveFont(ReportsButton.getFont().getStyle() | java.awt.Font.BOLD, ReportsButton.getFont().getSize()+3));
        ReportsButton.setForeground(new java.awt.Color(80, 180, 140));
        ReportsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/reports.png"))); // NOI18N
        ReportsButton.setText("REPORTS");
        ReportsButton.setBorder(null);
        ReportsButton.setBorderPainted(false);
        ReportsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ReportsButton.setFocusable(false);
        ReportsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ReportsButton.setOpaque(false);
        ReportsButton.setPreferredSize(new java.awt.Dimension(160, 160));
        ReportsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MenuTwo.add(ReportsButton);

        AboutButton.setFont(AboutButton.getFont().deriveFont(AboutButton.getFont().getStyle() | java.awt.Font.BOLD, AboutButton.getFont().getSize()+3));
        AboutButton.setForeground(new java.awt.Color(80, 180, 140));
        AboutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/info.png"))); // NOI18N
        AboutButton.setText("ABOUT");
        AboutButton.setBorder(null);
        AboutButton.setBorderPainted(false);
        AboutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AboutButton.setFocusable(false);
        AboutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AboutButton.setOpaque(false);
        AboutButton.setPreferredSize(new java.awt.Dimension(160, 160));
        AboutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MenuTwo.add(AboutButton);

        ButtonPanel.add(MenuTwo);

        ControlPanel.add(ButtonPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(BannerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BannerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StudentButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentButtonMousePressed
        StudentPortal studentPortal = new StudentPortal(role, current_uname);
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

        java.awt.EventQueue.invokeLater(() -> {
            new HomeScreen(role, current_uname).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AboutButton;
    private javax.swing.JButton AccountsButton;
    private javax.swing.JLabel AppNameLabel;
    private javax.swing.JButton AttendanceButton;
    private javax.swing.JLabel BannerLabel;
    private javax.swing.JPanel BannerPanel;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JPanel ControlPanel;
    private javax.swing.JButton FacultyButton;
    private javax.swing.JButton HostelButton;
    private javax.swing.JButton LibraryButton;
    private javax.swing.JPanel MenuOne;
    private javax.swing.JPanel MenuTwo;
    private javax.swing.JButton ReportsButton;
    private javax.swing.JButton StudentButton;
    private javax.swing.JPanel TitlePanel;
    // End of variables declaration//GEN-END:variables
}
