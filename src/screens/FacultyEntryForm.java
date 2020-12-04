package screens;

import com.formdev.flatlaf.FlatLightLaf;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author nixrajput
 */
public class FacultyEntryForm extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    
     URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);
    static Role role;

   
    public FacultyEntryForm(Role role) {
        this.role = role;
        initComponents();
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("constants/strings"); // NOI18N
        setTitle(bundle.getString("APP_NAME")); // NOI18N
        setIconImage(icon.getImage());
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        TitleLabel.setFont(TitleLabel.getFont().deriveFont(TitleLabel.getFont().getStyle() | java.awt.Font.BOLD, TitleLabel.getFont().getSize()+29));
        TitleLabel.setForeground(new java.awt.Color(60, 185, 145));
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText(bundle.getString("FACULTY_ENTRY_FORM")); // NOI18N
        TitleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel)
                .addContainerGap(740, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
         try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacultyEntryForm(role).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitleLabel;
    // End of variables declaration//GEN-END:variables
}
