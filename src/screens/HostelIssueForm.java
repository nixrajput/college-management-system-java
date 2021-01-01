package screens;

import com.formdev.flatlaf.FlatLightLaf;
import constants.Role;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import models.Hostel;
import repository.ComboBoxRenderer;
import repository.DBConnection;

/**
 *
 * @author nixrajput
 */
public class HostelIssueForm extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);
    static Role role;
    Date date = new Date();

    private final Connection con = new DBConnection().connect();

    private void customizeComponents() {
        setLocationRelativeTo(this);
        DateChooser.setDate(date);
    }

    private void clearFields() {
        RegNoTextField.setText(null);
        NameTextField.setText(null);
        HostelNoComboBox.setSelectedItem(null);
        RoomNoComboBox.setSelectedItem(null);
        FloorNoComboBox.setSelectedItem(null);
        RoomTypeComboBox.setSelectedItem(null);
        BedTypeComboBox.setSelectedItem(null);
        DateChooser.setDate(date);
    }

    private Hostel retrieveData(String reg_no) {
        String qry = null;
        Hostel hostel = null;

        try {
            qry = "SELECT * FROM hostel WHERE reg_no LIKE '%" + reg_no + "%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);
            if (rs.next()) {
                hostel = new Hostel(rs.getString("reg_no"), rs.getString("name"), rs.getString("hostel_no"),
                        rs.getString("floor_no"), rs.getString("room_no"), rs.getString("room_type"),
                        rs.getString("bed_type"), rs.getString("timestamp"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return hostel;
    }

    public void showItemToFields(String reg_no) {
        final Hostel data = retrieveData(reg_no);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        RegNoTextField.setText(data.getReg_no());
        NameTextField.setText(data.getName());
        HostelNoComboBox.setSelectedItem(data.getHostel_no());
        FloorNoComboBox.setSelectedItem(data.getFloor_no());
        RoomNoComboBox.setSelectedItem(data.getRoom_no());
        RoomTypeComboBox.setSelectedItem(data.getRoom_type());
        BedTypeComboBox.setSelectedItem(data.getBed_type());
        try {
            Date _date = null;
            _date = dateFormat.parse(data.getDate());
            DateChooser.setDate(_date);
        } catch (ParseException e) {
            System.out.println(e);
        }
    }

    private boolean _checkInputFields() {
        boolean isValid = false;
        if (RegNoTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Registration No. Field Is Required!");
        } else if (NameTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Name Field Is Required!");
        } else if (HostelNoComboBox.getSelectedItem() == null || HostelNoComboBox.getSelectedItem() == "Select") {
            JOptionPane.showMessageDialog(null, "Hostel No. Field Is Required!");
        } else if (FloorNoComboBox.getSelectedItem() == null || FloorNoComboBox.getSelectedItem() == "Select") {
            JOptionPane.showMessageDialog(null, "Floor No. Field Is Required!");
        } else if (RoomNoComboBox.getSelectedItem() == null || RoomNoComboBox.getSelectedItem() == "Select") {
            JOptionPane.showMessageDialog(null, "Room No. Field Is Required!");
        } else if (RoomTypeComboBox.getSelectedItem() == null || RoomTypeComboBox.getSelectedItem() == "Select") {
            JOptionPane.showMessageDialog(null, "Room Type Field Is Required!");
        } else if (BedTypeComboBox.getSelectedItem() == null || BedTypeComboBox.getSelectedItem() == "Select") {
            JOptionPane.showMessageDialog(null, "Bed Type Field Is Required!");
        } else {
            isValid = true;
        }
        return isValid;
    }

    private void _saveStudentInfo() {
        final String insert_sql = "INSERT INTO hostel(reg_no, name, hostel_no, "
                + "floor_no, room_no, room_type, bed_type, timestamp) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(insert_sql);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            ps.setString(1, RegNoTextField.getText().toUpperCase());

            ps.setString(2, NameTextField.getText());

            ps.setString(3, HostelNoComboBox.getSelectedItem().toString());
            ps.setString(4, FloorNoComboBox.getSelectedItem().toString());

            ps.setString(5, RoomNoComboBox.getSelectedItem().toString());
            ps.setString(6, RoomTypeComboBox.getSelectedItem().toString());
            ps.setString(7, BedTypeComboBox.getSelectedItem().toString());

            ps.setString(8, dateFormat.format(DateChooser.getDate()));

            int i = ps.executeUpdate();

            if (i >= 1) {
                JOptionPane.showMessageDialog(null, "Hostel Room Issued Successfully.", "Success", 1);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "Insertion Failed!", "Error", 0);
            }
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Insertion Failed!", "Error", 0);
        }
    }

    private void _updateStudentInfo() {
        final String insert_sql = "UPDATE hostel SET reg_no=?, name=?, "
                + "hostel_no=?, floor_no=?, room_no=?, room_type=?, bed_type=?, "
                + "timestamp=? WHERE reg_no LIKE '%" + RegNoTextField.getText() + "%'";
        try {
            PreparedStatement ps = con.prepareStatement(insert_sql);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            ps.setString(1, RegNoTextField.getText().toUpperCase());

            ps.setString(2, NameTextField.getText());

            ps.setString(3, HostelNoComboBox.getSelectedItem().toString());
            ps.setString(4, FloorNoComboBox.getSelectedItem().toString());

            ps.setString(5, RoomNoComboBox.getSelectedItem().toString());
            ps.setString(6, RoomTypeComboBox.getSelectedItem().toString());
            ps.setString(7, BedTypeComboBox.getSelectedItem().toString());

            ps.setString(8, dateFormat.format(DateChooser.getDate()));

            int i = ps.executeUpdate();

            if (i >= 1) {
                JOptionPane.showMessageDialog(null, "Record Updated.", "Success", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Updation Failed!", "Error", 0);
            }
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Updation Failed!", "Error", 0);
        }
    }

    private void _getStudentName() {
        String val = RegNoTextField.getText();
        String name;
        try {
            String qry = "SELECT name FROM student WHERE registration_no LIKE '%" + val + "%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);
            if (rs.next()) {
                name = rs.getString("name");
                NameTextField.setText(name);
            } else {
                JOptionPane.showMessageDialog(null, "No Records Found!", "Not Found", 0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void _deleteStudentInfo(String _reg_no) {
        try {
            String qry = "DELETE FROM hostel WHERE reg_no LIKE '%" + _reg_no + "%'";

            PreparedStatement ps = con.prepareStatement(qry);

            int x = ps.executeUpdate();
            if (x >= 1) {
                JOptionPane.showMessageDialog(null, "Record Deleted.", "Success", 1);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "Deletion Failed!", "Error", 0);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            JOptionPane.showMessageDialog(null, "Deletion Failed!", "Error", 0);
        }
    }

    public HostelIssueForm(Role role) {
        this.role = role;
        initComponents();
        customizeComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitlePanel = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        BodyPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        RegNoTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        DateChooser = new com.toedter.calendar.JDateChooser();
        NameTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        HostelNoComboBox = new javax.swing.JComboBox<>();
        RoomLoadingButton = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        RoomNoComboBox = new javax.swing.JComboBox<>();
        HostelLoadingButton = new javax.swing.JButton();
        GetDetailsButton = new javax.swing.JButton();
        RoomTypeComboBox = new javax.swing.JComboBox<>();
        BedTypeComboBox = new javax.swing.JComboBox<>();
        FloorLoadingButton = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        FloorNoComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        ButtonPanel = new javax.swing.JPanel();
        SaveButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("constants/strings"); // NOI18N
        setTitle(bundle.getString("APP_NAME")); // NOI18N
        setIconImage(icon.getImage());
        setMaximumSize(new java.awt.Dimension(540, 680));
        setMinimumSize(new java.awt.Dimension(540, 680));
        setResizable(false);

        TitlePanel.setBackground(new java.awt.Color(51, 51, 51));

        TitleLabel.setFont(TitleLabel.getFont().deriveFont(TitleLabel.getFont().getStyle() | java.awt.Font.BOLD, TitleLabel.getFont().getSize()+29));
        TitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText("HOSTEL ISSUE FORM");
        TitleLabel.setToolTipText("");
        TitleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );
        TitlePanelLayout.setVerticalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(jLabel5.getFont().deriveFont(jLabel5.getFont().getStyle() | java.awt.Font.BOLD, jLabel5.getFont().getSize()+3));
        jLabel5.setForeground(new java.awt.Color(0, 150, 150));
        jLabel5.setText("Room Type");

        jLabel15.setFont(jLabel15.getFont().deriveFont(jLabel15.getFont().getStyle() | java.awt.Font.BOLD, jLabel15.getFont().getSize()+3));
        jLabel15.setForeground(new java.awt.Color(0, 150, 150));
        jLabel15.setText("Reg. No.");

        RegNoTextField.setFont(RegNoTextField.getFont().deriveFont(RegNoTextField.getFont().getStyle() | java.awt.Font.BOLD, RegNoTextField.getFont().getSize()+3));
        RegNoTextField.setToolTipText("");
        RegNoTextField.setMinimumSize(new java.awt.Dimension(200, 30));
        RegNoTextField.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | java.awt.Font.BOLD, jLabel2.getFont().getSize()+3));
        jLabel2.setForeground(new java.awt.Color(0, 150, 150));
        jLabel2.setText("Date");

        DateChooser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DateChooser.setMinSelectableDate(new java.util.Date(946668704000L));

        NameTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel10.setFont(jLabel10.getFont().deriveFont(jLabel10.getFont().getStyle() | java.awt.Font.BOLD, jLabel10.getFont().getSize()+3));
        jLabel10.setForeground(new java.awt.Color(0, 150, 150));
        jLabel10.setText("Bed Type");

        jLabel20.setFont(jLabel20.getFont().deriveFont(jLabel20.getFont().getStyle() | java.awt.Font.BOLD, jLabel20.getFont().getSize()+3));
        jLabel20.setForeground(new java.awt.Color(0, 150, 150));
        jLabel20.setText("Hostel No.");

        HostelNoComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        HostelNoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Hostel - 1", "Hostel - 2", "Hostel - 3" }));
        HostelNoComboBox.setRenderer(new ComboBoxRenderer());

        RoomLoadingButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RoomLoadingButton.setForeground(new java.awt.Color(0, 150, 150));
        RoomLoadingButton.setText("Load");

        jLabel21.setFont(jLabel21.getFont().deriveFont(jLabel21.getFont().getStyle() | java.awt.Font.BOLD, jLabel21.getFont().getSize()+3));
        jLabel21.setForeground(new java.awt.Color(0, 150, 150));
        jLabel21.setText("Room No.");

        RoomNoComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RoomNoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        HostelLoadingButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        HostelLoadingButton.setForeground(new java.awt.Color(0, 150, 150));
        HostelLoadingButton.setText("Load");

        GetDetailsButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        GetDetailsButton.setForeground(new java.awt.Color(0, 150, 150));
        GetDetailsButton.setText("Get Details");
        GetDetailsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GetDetailsButtonMousePressed(evt);
            }
        });

        RoomTypeComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RoomTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Single Bed Room", "2-Bed Room", "3-Bed Room", "4-Bed Room" }));

        BedTypeComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BedTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Separate", "Shared" }));

        FloorLoadingButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        FloorLoadingButton.setForeground(new java.awt.Color(0, 150, 150));
        FloorLoadingButton.setText("Load");
        FloorLoadingButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel22.setFont(jLabel22.getFont().deriveFont(jLabel22.getFont().getStyle() | java.awt.Font.BOLD, jLabel22.getFont().getSize()+3));
        jLabel22.setForeground(new java.awt.Color(0, 150, 150));
        jLabel22.setText("Floor No.");

        FloorNoComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        FloorNoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Ground Floor", "First Floor", "Second Floor", "Third Floor", "Top Floor" }));
        FloorNoComboBox.setRenderer(new ComboBoxRenderer());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 150, 150));
        jLabel1.setText("Name");

        javax.swing.GroupLayout BodyPanelLayout = new javax.swing.GroupLayout(BodyPanel);
        BodyPanel.setLayout(BodyPanelLayout);
        BodyPanelLayout.setHorizontalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel5)
                    .addComponent(jLabel15)
                    .addComponent(jLabel10)
                    .addComponent(jLabel22)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                        .addComponent(HostelNoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HostelLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NameTextField)
                    .addComponent(RoomTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BedTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                        .addComponent(RoomNoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RoomLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                        .addComponent(RegNoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GetDetailsButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                        .addComponent(FloorNoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(FloorLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        BodyPanelLayout.setVerticalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegNoTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GetDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(HostelNoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(HostelLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FloorNoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FloorLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RoomNoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(RoomLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RoomTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BedTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10);
        flowLayout1.setAlignOnBaseline(true);
        ButtonPanel.setLayout(flowLayout1);

        SaveButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SaveButton.setForeground(new java.awt.Color(255, 255, 255));
        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn.png"))); // NOI18N
        SaveButton.setText("Save");
        SaveButton.setBorder(null);
        SaveButton.setBorderPainted(false);
        SaveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SaveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SaveButton.setPreferredSize(new java.awt.Dimension(160, 40));
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(SaveButton);

        UpdateButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UpdateButton.setForeground(new java.awt.Color(255, 255, 255));
        UpdateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn.png"))); // NOI18N
        UpdateButton.setText("Update");
        UpdateButton.setBorder(null);
        UpdateButton.setBorderPainted(false);
        UpdateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        UpdateButton.setPreferredSize(new java.awt.Dimension(160, 40));
        UpdateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UpdateButtonMousePressed(evt);
            }
        });
        ButtonPanel.add(UpdateButton);

        DeleteButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn.png"))); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.setBorder(null);
        DeleteButton.setBorderPainted(false);
        DeleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DeleteButton.setPreferredSize(new java.awt.Dimension(160, 40));
        DeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DeleteButtonMousePressed(evt);
            }
        });
        ButtonPanel.add(DeleteButton);

        ClearButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ClearButton.setForeground(new java.awt.Color(255, 255, 255));
        ClearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn.png"))); // NOI18N
        ClearButton.setText("Clear");
        ClearButton.setBorder(null);
        ClearButton.setBorderPainted(false);
        ClearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClearButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ClearButton.setPreferredSize(new java.awt.Dimension(160, 40));
        ClearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ClearButtonMousePressed(evt);
            }
        });
        ButtonPanel.add(ClearButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed

        if (role == Role.ADMIN) {
            if (_checkInputFields()) {
                int choice = JOptionPane.showConfirmDialog(null, "Do You want to issue hostel for this student?", "Confirm", 0, 3);
                if (choice == 0) {
                    _saveStudentInfo();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You Are Not Authorised!", "Access Denied", 0);
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void UpdateButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButtonMousePressed

        if (role == Role.ADMIN) {
            if (_checkInputFields()) {
                int choice = JOptionPane.showConfirmDialog(null, "Do You want to update this record?", "Confirm", 0, 3);
                if (choice == 0) {
                    _updateStudentInfo();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You Are Not Authorised", "Access Denied!", 0);
        }
    }//GEN-LAST:event_UpdateButtonMousePressed

    private void DeleteButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMousePressed

        if (role == Role.ADMIN) {
            if (RegNoTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Registration No. Is Required!");
            } else {
                String _reg_no = RegNoTextField.getText();
                int choice = JOptionPane.showConfirmDialog(null, "Do You want to delete the student?", "Confirm", 0, 3);
                if (choice == 0) {
                    _deleteStudentInfo(_reg_no);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You Are Not Authorised!", "Access Denied", 0);
        }

    }//GEN-LAST:event_DeleteButtonMousePressed

    private void ClearButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearButtonMousePressed
        clearFields();
    }//GEN-LAST:event_ClearButtonMousePressed

    private void GetDetailsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GetDetailsButtonMousePressed

        NameTextField.setText(null);
        if (RegNoTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Registration No. Is Required!");
        } else {
            _getStudentName();
        }
    }//GEN-LAST:event_GetDetailsButtonMousePressed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new HostelIssueForm(role).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BedTypeComboBox;
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JButton ClearButton;
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton FloorLoadingButton;
    private javax.swing.JComboBox<String> FloorNoComboBox;
    private javax.swing.JButton GetDetailsButton;
    private javax.swing.JButton HostelLoadingButton;
    private javax.swing.JComboBox<String> HostelNoComboBox;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JTextField RegNoTextField;
    private javax.swing.JButton RoomLoadingButton;
    private javax.swing.JComboBox<String> RoomNoComboBox;
    private javax.swing.JComboBox<String> RoomTypeComboBox;
    private javax.swing.JButton SaveButton;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

}
