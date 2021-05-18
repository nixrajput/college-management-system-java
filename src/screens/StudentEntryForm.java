package screens;

import com.formdev.flatlaf.FlatLightLaf;
import constants.Role;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.Branch;
import models.Student;
import repository.DBConnection;
import repository.DBFunctions;
import repository.RandomGenerator;
import repository.UtilFunctions;

/**
 *
 * @author nixrajput
 */
public class StudentEntryForm extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);
    static Role role;
    static String reg_no;

    String photopath = null;
    Date date = new Date();

    private final Connection con = new DBConnection().connect();

    private String generateAppNo() {
        String app_no = RandomGenerator.getNumericString(5);
        return "APN" + app_no;
    }

    private String generateRegNo() {
        String app_no = RandomGenerator.getNumericString(4);
        return "STUDENT" + app_no;
    }

    private Student retrieveData(String reg_no) {
        String qry = null;
        Student student = null;

        try {
            qry = "SELECT name, roll_no, application_no, registration_no, "
                    + "mother_name, mother_occupation, address, father_name, father_occupation, "
                    + "sex, dob, phone, email, photo, date_of_application, course, branch, batch, "
                    + "semester, year_of_passing, hostel, library, qualification, university, "
                    + "quota, marks, status FROM student "
                    + "WHERE registration_no LIKE '%" + reg_no + "%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);

            if (rs.next()) {
                student = new Student(rs.getString("name"), rs.getString("roll_no"), rs.getString("application_no"),
                        rs.getString("registration_no"), rs.getString("mother_name"), rs.getString("mother_occupation"),
                        rs.getString("address"), rs.getString("father_name"), rs.getString("father_occupation"),
                        rs.getString("sex"), rs.getString("dob"), rs.getString("phone"), rs.getString("email"),
                        rs.getBytes("photo"), rs.getString("date_of_application"), rs.getString("course"), rs.getString("branch"),
                        rs.getInt("batch"), rs.getString("semester"), rs.getInt("year_of_passing"), rs.getBoolean("hostel"), rs.getBoolean("library"),
                        rs.getString("qualification"), rs.getString("university"), rs.getString("quota"), rs.getString("marks"), rs.getString("status"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return student;
    }

    public void showItemToFields(String reg_no) {
        final Student data = retrieveData(reg_no);
        ArrayList<String> courses = DBFunctions.loadCourses();
        CourseComboBox.setModel(new DefaultComboBoxModel<>(courses.toArray(new String[0])));

        ArrayList<Branch> branches = DBFunctions.loadBranches(data.getCourse());
        ArrayList<String> brArrayList = new ArrayList<>();

        if (branches.isEmpty()) {
            brArrayList.add("Select");
        } else {
            for (int i = 0; i < branches.size(); i++) {
                brArrayList.add(branches.get(i).getInit());
            }
        }
        BranchComboBox.setModel(new DefaultComboBoxModel<>(brArrayList.toArray(new String[0])));

        ArrayList<String> semList = DBFunctions.getSemester(data.getCourse(), data.getBranch());
        if (semList.isEmpty()) {
            semList.add("Select");
        }
        SemesterComboBox.setModel(new DefaultComboBoxModel<>(semList.toArray(new String[0])));

        ApplNoTextField.setText(data.getApplicationNo());
        RolllNoTextField.setText(data.getRollNo());
        RegNoTextField.setText(data.getRegNo());
        NameTextField.setText(data.getName());
        SexComboBox.setSelectedItem(data.getSex());

        try {
            Date dob = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            dob = sdf.parse(data.getDob());
            DOBChooser.setDate(dob);
            Date _date;
            _date = sdf.parse(data.getDate_of_application());
            DateChooser.setDate(_date);
        } catch (ParseException e) {
            System.out.println(e);
        }
        MotherNameTextField.setText(data.getMother_name());
        MotherOccupationTextField.setText(data.getMother_occupation());
        FatherNameTextField.setText(data.getFather_name());
        FatherOccupationTextField.setText(data.getFather_occupation());
        AddressTextArea.setText(data.getAddress());
        PhoneTextField.setText(data.getPhone());
        EmailTextField.setText(data.getEmail());
        CourseComboBox.setSelectedItem(data.getCourse());
        BranchComboBox.setSelectedItem(data.getBranch());
        SemesterComboBox.setSelectedItem(data.getSemester());
        BatchYearChooser.setYear(data.getBatch());
        PassingYearChooser.setYear(data.getPassing_year());
        HostelCheckBox.setSelected(data.isIsHostler());
        LibraryCheckBox.setSelected(data.isLibraryFacility());
        QualificationTextField.setText(data.getQualification());
        UniversityTextField.setText(data.getUniversity());
        QuotaComboBox.setSelectedItem(data.getQuota());
        MarksTextField.setText(data.getMarks());
        StatusComboBox.setSelectedItem(data.getStatus());

        PhotoLabel.setIcon(UtilFunctions.resizeImage(null, data.getPhoto(), PhotoLabel));
    }

    private void customizeComponents() {
        setLocationRelativeTo(this);
        setTitle("STUDENT ENTRY FORM");
        DateChooser.setDate(date);
        ApplNoTextField.setText(generateAppNo());
        RegNoTextField.setText(generateRegNo());
    }

    private void clearFields() {
        ApplNoTextField.setText(generateAppNo());
        RegNoTextField.setText(generateRegNo());
        RolllNoTextField.setText(null);
        NameTextField.setText(null);
        MotherNameTextField.setText(null);
        MotherOccupationTextField.setText(null);
        FatherNameTextField.setText("");
        FatherOccupationTextField.setText(null);
        AddressTextArea.setText(null);
        PhoneTextField.setText(null);
        EmailTextField.setText(null);
        BatchYearChooser.setYear(2020);
        PassingYearChooser.setYear(2020);
        photopath = null;
        PhotoLabel.setIcon(null);
        DateChooser.setDate(date);
        QualificationTextField.setText(null);
        UniversityTextField.setText(null);
        MarksTextField.setText(null);

        SexComboBox.setSelectedItem(null);
        DOBChooser.setDate(null);

        CourseComboBox.setSelectedItem(null);
        BranchComboBox.setSelectedItem(null);
        SemesterComboBox.setSelectedItem(null);
        QuotaComboBox.setSelectedItem(null);
        StatusComboBox.setSelectedItem(null);

        photopath = null;
        PhotoLabel.setIcon(null);
    }

    private boolean _checkInputFields() {
        boolean isValid = false;
        if (NameTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Name Field Is Required!!!");
        } else if (DOBChooser.getDate() == null) {
            JOptionPane.showMessageDialog(null, "DOB Field Is Required!!!");
        } else if (SexComboBox.getSelectedItem() == null || SexComboBox.getSelectedItem() == "Select") {
            JOptionPane.showMessageDialog(null, "Sex Field Is Required!!!");
        } else if (MotherNameTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Mother's Name Field Is Required!!!");
        } else if (MotherOccupationTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Mother's Occupation Field Is Required!!!");
        } else if (FatherNameTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Father's Name Field Is Required!!!");
        } else if (FatherOccupationTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Father's Occupation Field Is Required!!!");
        } else if (AddressTextArea.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Address Field Is Required!!!");
        } else if (PhoneTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Phone Field Is Required!!!");
        } else if (EmailTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Email Field Is Required!!!");
        } else if (CourseComboBox.getSelectedItem() == null || CourseComboBox.getSelectedItem() == "Select") {
            JOptionPane.showMessageDialog(null, "Course Field Is Required!!!");
        } else if (BranchComboBox.getSelectedItem() == null || BranchComboBox.getSelectedItem() == "Select") {
            JOptionPane.showMessageDialog(null, "Branch Field Is Required!!!");
        } else if (SemesterComboBox.getSelectedItem() == null || SemesterComboBox.getSelectedItem() == "Select") {
            JOptionPane.showMessageDialog(null, "Semester Field Is Required!!!");
        } else if (BatchYearChooser == null) {
            JOptionPane.showMessageDialog(null, "Batch Field Is Required!!!");
        } else if (PassingYearChooser.getValue() == 0) {
            JOptionPane.showMessageDialog(null, "YOP Field Is Required!!!");
        } else if (QualificationTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Qualification Field Is Required!!!");
        } else if (UniversityTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "University Field Is Required!!!");
        } else if (QualificationTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Qualification Field Is Required!!!");
        } else if (MarksTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Marks Field Is Required!!!");
        } else if (QuotaComboBox.getSelectedItem() == null || QuotaComboBox.getSelectedItem() == "Select") {
            JOptionPane.showMessageDialog(null, "Quota Field Is Required!!!");
        } else {
            isValid = true;
        }
        return isValid;
    }

    public StudentEntryForm(Role role, String reg_no) {
        this.role = role;
        this.reg_no = reg_no;
        initComponents();
        customizeComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitlePanel = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        BodyPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ApplNoTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DateChooser = new com.toedter.calendar.JDateChooser();
        BatchYearChooser = new com.toedter.calendar.JYearChooser();
        jLabel4 = new javax.swing.JLabel();
        PassingYearChooser = new com.toedter.calendar.JYearChooser();
        jLabel5 = new javax.swing.JLabel();
        NameTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        MotherNameTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        MotherOccupationTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        DOBChooser = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        FatherNameTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        FatherOccupationTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        AddressScrollPane = new javax.swing.JScrollPane();
        AddressTextArea = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        PhoneTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        RolllNoTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        RegNoTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        CourseComboBox = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        BranchComboBox = new javax.swing.JComboBox<>();
        SemesterComboBox = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        HostelCheckBox = new javax.swing.JCheckBox();
        LibraryCheckBox = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        PhotoLabel = new javax.swing.JLabel();
        PhotoChooserButton = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        EmailTextField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        QualificationTextField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        UniversityTextField = new javax.swing.JTextField();
        SexComboBox = new javax.swing.JComboBox<>();
        CourseLoadingButton = new javax.swing.JButton();
        BranchLoadingButton = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        MarksTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        QuotaComboBox = new javax.swing.JComboBox<>();
        StatusComboBox = new javax.swing.JComboBox<>();
        SemLoadingButton = new javax.swing.JButton();
        ButtonPanel = new javax.swing.JPanel();
        SaveButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();

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
        TitleLabel.setText(bundle.getString("STUDENT_ENTRY_FORM")); // NOI18N
        TitleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
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

        BodyPanel.setDoubleBuffered(false);
        BodyPanel.setFocusable(false);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+3));
        jLabel1.setForeground(new java.awt.Color(0, 150, 150));
        jLabel1.setText("Appl. No.");

        ApplNoTextField.setEditable(false);
        ApplNoTextField.setFont(ApplNoTextField.getFont().deriveFont(ApplNoTextField.getFont().getStyle() | java.awt.Font.BOLD, ApplNoTextField.getFont().getSize()+3));
        ApplNoTextField.setToolTipText("");
        ApplNoTextField.setMinimumSize(new java.awt.Dimension(200, 30));
        ApplNoTextField.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | java.awt.Font.BOLD, jLabel2.getFont().getSize()+3));
        jLabel2.setForeground(new java.awt.Color(0, 150, 150));
        jLabel2.setText("Date");

        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getStyle() | java.awt.Font.BOLD, jLabel3.getFont().getSize()+3));
        jLabel3.setForeground(new java.awt.Color(0, 150, 150));
        jLabel3.setText("Batch");

        DateChooser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        BatchYearChooser.setEndYear(2050);
        BatchYearChooser.setStartYear(2000);

        jLabel4.setFont(jLabel4.getFont().deriveFont(jLabel4.getFont().getStyle() | java.awt.Font.BOLD, jLabel4.getFont().getSize()+3));
        jLabel4.setForeground(new java.awt.Color(0, 150, 150));
        jLabel4.setText("Y.O.P");

        PassingYearChooser.setEndYear(2050);
        PassingYearChooser.setStartYear(2000);

        jLabel5.setFont(jLabel5.getFont().deriveFont(jLabel5.getFont().getStyle() | java.awt.Font.BOLD, jLabel5.getFont().getSize()+3));
        jLabel5.setForeground(new java.awt.Color(0, 150, 150));
        jLabel5.setText("Name");

        NameTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel6.setFont(jLabel6.getFont().deriveFont(jLabel6.getFont().getStyle() | java.awt.Font.BOLD, jLabel6.getFont().getSize()+3));
        jLabel6.setForeground(new java.awt.Color(0, 150, 150));
        jLabel6.setText("Mother's Name");

        MotherNameTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel7.setFont(jLabel7.getFont().deriveFont(jLabel7.getFont().getStyle() | java.awt.Font.BOLD, jLabel7.getFont().getSize()+3));
        jLabel7.setForeground(new java.awt.Color(0, 150, 150));
        jLabel7.setText("Occupation");

        MotherOccupationTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel8.setFont(jLabel8.getFont().deriveFont(jLabel8.getFont().getStyle() | java.awt.Font.BOLD, jLabel8.getFont().getSize()+3));
        jLabel8.setForeground(new java.awt.Color(0, 150, 150));
        jLabel8.setText("Sex");

        jLabel9.setFont(jLabel9.getFont().deriveFont(jLabel9.getFont().getStyle() | java.awt.Font.BOLD, jLabel9.getFont().getSize()+3));
        jLabel9.setForeground(new java.awt.Color(0, 150, 150));
        jLabel9.setText("D.O.B");

        DOBChooser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel10.setFont(jLabel10.getFont().deriveFont(jLabel10.getFont().getStyle() | java.awt.Font.BOLD, jLabel10.getFont().getSize()+3));
        jLabel10.setForeground(new java.awt.Color(0, 150, 150));
        jLabel10.setText("Father's Name");

        FatherNameTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel11.setFont(jLabel11.getFont().deriveFont(jLabel11.getFont().getStyle() | java.awt.Font.BOLD, jLabel11.getFont().getSize()+3));
        jLabel11.setForeground(new java.awt.Color(0, 150, 150));
        jLabel11.setText("Occupation");

        FatherOccupationTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel12.setFont(jLabel12.getFont().deriveFont(jLabel12.getFont().getStyle() | java.awt.Font.BOLD, jLabel12.getFont().getSize()+3));
        jLabel12.setForeground(new java.awt.Color(0, 150, 150));
        jLabel12.setText("Address");

        AddressTextArea.setColumns(20);
        AddressTextArea.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AddressTextArea.setRows(5);
        AddressScrollPane.setViewportView(AddressTextArea);

        jLabel13.setFont(jLabel13.getFont().deriveFont(jLabel13.getFont().getStyle() | java.awt.Font.BOLD, jLabel13.getFont().getSize()+3));
        jLabel13.setForeground(new java.awt.Color(0, 150, 150));
        jLabel13.setText("Phone");

        PhoneTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel14.setFont(jLabel14.getFont().deriveFont(jLabel14.getFont().getStyle() | java.awt.Font.BOLD, jLabel14.getFont().getSize()+3));
        jLabel14.setForeground(new java.awt.Color(0, 150, 150));
        jLabel14.setText("Roll No.");

        RolllNoTextField.setEditable(false);
        RolllNoTextField.setFont(RolllNoTextField.getFont().deriveFont(RolllNoTextField.getFont().getStyle() | java.awt.Font.BOLD, RolllNoTextField.getFont().getSize()+3));
        RolllNoTextField.setToolTipText("");
        RolllNoTextField.setMinimumSize(new java.awt.Dimension(200, 30));
        RolllNoTextField.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel15.setFont(jLabel15.getFont().deriveFont(jLabel15.getFont().getStyle() | java.awt.Font.BOLD, jLabel15.getFont().getSize()+3));
        jLabel15.setForeground(new java.awt.Color(0, 150, 150));
        jLabel15.setText("Reg. No.");

        RegNoTextField.setEditable(false);
        RegNoTextField.setFont(RegNoTextField.getFont().deriveFont(RegNoTextField.getFont().getStyle() | java.awt.Font.BOLD, RegNoTextField.getFont().getSize()+3));
        RegNoTextField.setToolTipText("");
        RegNoTextField.setMinimumSize(new java.awt.Dimension(200, 30));
        RegNoTextField.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel16.setFont(jLabel16.getFont().deriveFont(jLabel16.getFont().getStyle() | java.awt.Font.BOLD, jLabel16.getFont().getSize()+3));
        jLabel16.setForeground(new java.awt.Color(0, 150, 150));
        jLabel16.setText("Course");

        CourseComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jLabel17.setFont(jLabel17.getFont().deriveFont(jLabel17.getFont().getStyle() | java.awt.Font.BOLD, jLabel17.getFont().getSize()+3));
        jLabel17.setForeground(new java.awt.Color(0, 150, 150));
        jLabel17.setText("Branch");

        BranchComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BranchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        SemesterComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jLabel18.setFont(jLabel18.getFont().deriveFont(jLabel18.getFont().getStyle() | java.awt.Font.BOLD, jLabel18.getFont().getSize()+3));
        jLabel18.setForeground(new java.awt.Color(0, 150, 150));
        jLabel18.setText("Semsester");

        HostelCheckBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HostelCheckBox.setForeground(new java.awt.Color(0, 150, 150));
        HostelCheckBox.setText("Hostel");

        LibraryCheckBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LibraryCheckBox.setForeground(new java.awt.Color(0, 150, 150));
        LibraryCheckBox.setText("Library");

        jLabel19.setFont(jLabel19.getFont().deriveFont(jLabel19.getFont().getStyle() | java.awt.Font.BOLD, jLabel19.getFont().getSize()+3));
        jLabel19.setForeground(new java.awt.Color(0, 150, 150));
        jLabel19.setText("Photo");

        PhotoLabel.setBackground(new java.awt.Color(255, 255, 255));
        PhotoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PhotoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user.png"))); // NOI18N
        PhotoLabel.setOpaque(true);

        PhotoChooserButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PhotoChooserButton.setForeground(new java.awt.Color(0, 150, 150));
        PhotoChooserButton.setText("Select Photo");
        PhotoChooserButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PhotoChooserButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PhotoChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhotoChooserButtonActionPerformed(evt);
            }
        });

        jLabel23.setFont(jLabel23.getFont().deriveFont(jLabel23.getFont().getStyle() | java.awt.Font.BOLD, jLabel23.getFont().getSize()+3));
        jLabel23.setForeground(new java.awt.Color(0, 150, 150));
        jLabel23.setText("Email");

        EmailTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel24.setFont(jLabel24.getFont().deriveFont(jLabel24.getFont().getStyle() | java.awt.Font.BOLD, jLabel24.getFont().getSize()+3));
        jLabel24.setForeground(new java.awt.Color(0, 150, 150));
        jLabel24.setText("Qualification");

        QualificationTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel25.setFont(jLabel25.getFont().deriveFont(jLabel25.getFont().getStyle() | java.awt.Font.BOLD, jLabel25.getFont().getSize()+3));
        jLabel25.setForeground(new java.awt.Color(0, 150, 150));
        jLabel25.setText("University");

        UniversityTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        SexComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SexComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female", "Other" }));

        CourseLoadingButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CourseLoadingButton.setForeground(new java.awt.Color(0, 150, 150));
        CourseLoadingButton.setText("Load");
        CourseLoadingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CourseLoadingButtonMousePressed(evt);
            }
        });

        BranchLoadingButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BranchLoadingButton.setForeground(new java.awt.Color(0, 150, 150));
        BranchLoadingButton.setText("Load");
        BranchLoadingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BranchLoadingButtonMousePressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 150, 150));
        jLabel20.setText("Marks(%)/CGPA");

        MarksTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 150, 150));
        jLabel21.setText("Status");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 150, 150));
        jLabel22.setText("Quota");

        QuotaComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        QuotaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Entrance Exam", "Academic Marks", "Management Quota" }));

        StatusComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "CONFIRM", "PENDING", "CANCELLED" }));

        SemLoadingButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SemLoadingButton.setForeground(new java.awt.Color(0, 150, 150));
        SemLoadingButton.setText("Load");
        SemLoadingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SemLoadingButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout BodyPanelLayout = new javax.swing.GroupLayout(BodyPanel);
        BodyPanel.setLayout(BodyPanelLayout);
        BodyPanelLayout.setHorizontalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BodyPanelLayout.createSequentialGroup()
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BodyPanelLayout.createSequentialGroup()
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                        .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 149, Short.MAX_VALUE))
                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                        .addComponent(ApplNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BodyPanelLayout.createSequentialGroup()
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FatherNameTextField)
                                    .addComponent(MotherNameTextField)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BodyPanelLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(37, 37, 37)
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AddressScrollPane)
                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(SemesterComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(CourseComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 165, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CourseLoadingButton)
                                            .addComponent(SemLoadingButton))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(10, 10, 10)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(SexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(RolllNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(135, 135, 135)
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(RegNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(DOBChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(MotherOccupationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FatherOccupationTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23)
                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                        .addComponent(BranchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(BranchLoadingButton))
                                    .addComponent(LibraryCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(PassingYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(18, 18, 18)
                                        .addComponent(QuotaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(18, 18, 18)
                                        .addComponent(MarksTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(18, 18, 18)
                                        .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(EmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BodyPanelLayout.createSequentialGroup()
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BodyPanelLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addGap(51, 51, 51))
                            .addGroup(BodyPanelLayout.createSequentialGroup()
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25))
                                .addGap(18, 18, 18)
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(UniversityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(QualificationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(BodyPanelLayout.createSequentialGroup()
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addGap(18, 18, 18))
                                            .addGroup(BodyPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(50, 50, 50)))
                                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BatchYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel2))
                                .addGap(244, 244, 244)
                                .addComponent(HostelCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BodyPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(PhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PhotoChooserButton)
                                .addGap(35, 35, 35)))))
                .addContainerGap())
        );
        BodyPanelLayout.setVerticalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ApplNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(RolllNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RegNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(DOBChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MotherNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MotherOccupationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FatherNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FatherOccupationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BodyPanelLayout.createSequentialGroup()
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(AddressScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BranchLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BranchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(PhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PhotoChooserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BodyPanelLayout.createSequentialGroup()
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CourseLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BodyPanelLayout.createSequentialGroup()
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(LibraryCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(HostelCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SemLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PassingYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(BatchYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(QuotaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MarksTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(QualificationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UniversityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5);
        flowLayout1.setAlignOnBaseline(true);
        ButtonPanel.setLayout(flowLayout1);

        SaveButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SaveButton.setText("Save");
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
        UpdateButton.setText("Update");
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
        DeleteButton.setText("Delete");
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
        ClearButton.setText("Clear");
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PhotoChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhotoChooserButtonActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("*.images", "jpg", "png");
        chooser.addChoosableFileFilter(fnef);
        int ans = chooser.showSaveDialog(null);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File selectedPhoto = chooser.getSelectedFile();
            String path = selectedPhoto.getAbsolutePath();
            PhotoLabel.setIcon(UtilFunctions.resizeImage(path, null, PhotoLabel));
            this.photopath = path;
        } else {
            System.out.println("Photo Not Selected ....");
        }

    }//GEN-LAST:event_PhotoChooserButtonActionPerformed

    private void CourseLoadingButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CourseLoadingButtonMousePressed
        ArrayList<String> courses = DBFunctions.loadCourses();
        CourseComboBox.setModel(new DefaultComboBoxModel<>(courses.toArray(new String[0])));
    }//GEN-LAST:event_CourseLoadingButtonMousePressed

    private void BranchLoadingButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BranchLoadingButtonMousePressed

        if (CourseComboBox.getSelectedItem() != null) {
            ArrayList<Branch> branches = DBFunctions.loadBranches(CourseComboBox.getSelectedItem().toString());
            ArrayList<String> brArrayList = new ArrayList<>();

            if (branches.isEmpty()) {
                brArrayList.add("Select");
            } else {
                for (int i = 0; i < branches.size(); i++) {
                    brArrayList.add(branches.get(i).getInit());
                }
            }
            BranchComboBox.setModel(new DefaultComboBoxModel<>(brArrayList.toArray(new String[0])));
        } else {
            JOptionPane.showMessageDialog(null, "Select a course first.");
        }

    }//GEN-LAST:event_BranchLoadingButtonMousePressed

    private void _saveStudentData() {
        if (photopath == null) {
            JOptionPane.showMessageDialog(null, "Photo Is Required!!!");
        } else {

            final String insert_sql = "INSERT INTO student(name, roll_no, application_no, registration_no, "
                    + "mother_name, mother_occupation, address, father_name, father_occupation, sex, dob, phone, email,"
                    + "photo, password, date_of_application, course, branch, batch, semester, year_of_passing, hostel, library, "
                    + "qualification, university, quota, marks, status) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(insert_sql);

                ps.setString(1, NameTextField.getText());

                int batch_year = BatchYearChooser.getYear() % 100;
                String rand_no = RandomGenerator.getNumericString(3);
                String roll_no = batch_year + rand_no;
                ps.setString(2, roll_no);

                ps.setString(3, ApplNoTextField.getText());
                ps.setString(4, RegNoTextField.getText());

                ps.setString(5, MotherNameTextField.getText());
                ps.setString(6, MotherOccupationTextField.getText());
                ps.setString(7, AddressTextArea.getText());
                ps.setString(8, FatherNameTextField.getText());
                ps.setString(9, FatherOccupationTextField.getText());
                ps.setString(10, SexComboBox.getSelectedItem().toString());

                SimpleDateFormat dobFormat = new SimpleDateFormat("dd-MM-yyyy");
                String dob = dobFormat.format(DOBChooser.getDate());
                ps.setString(11, dob);

                ps.setString(12, PhoneTextField.getText());
                ps.setString(13, EmailTextField.getText());

                InputStream photoStream = new FileInputStream(new File(photopath));
                ps.setBlob(14, photoStream);

                SimpleDateFormat passFormat = new SimpleDateFormat("ddMMyyyy");
                String pass = passFormat.format(DOBChooser.getDate());
                ps.setString(15, pass);

                ps.setString(16, dobFormat.format(DateChooser.getDate()));
                ps.setString(17, CourseComboBox.getSelectedItem().toString());
                ps.setString(18, BranchComboBox.getSelectedItem().toString());
                ps.setInt(19, BatchYearChooser.getYear());
                ps.setString(20, SemesterComboBox.getSelectedItem().toString());
                ps.setInt(21, PassingYearChooser.getYear());

                if (HostelCheckBox.isSelected()) {
                    ps.setBoolean(22, true);

                } else {
                    ps.setBoolean(22, false);
                }

                if (LibraryCheckBox.isSelected()) {
                    ps.setBoolean(23, true);
                } else {
                    ps.setBoolean(23, false);
                }

                ps.setString(24, QualificationTextField.getText());
                ps.setString(25, UniversityTextField.getText());
                ps.setString(26, QuotaComboBox.getSelectedItem().toString());
                ps.setDouble(27, Double.parseDouble(MarksTextField.getText()));
                ps.setString(28, StatusComboBox.getSelectedItem().toString());

                int i = ps.executeUpdate();

                if (i >= 1) {
                    JOptionPane.showMessageDialog(null, "Student Inserted Succussfully. You Registration No. is [" + RegNoTextField.getText() + "].", "Success", 1);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Insertion Failed!", "Error", 0);
                }
            } catch (Exception e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Insertion Failed!", "Error", 0);
            }
        }
    }

    private void _updateStudentData() {
        String qry = null;
        PreparedStatement ps = null;
        String _reg_no = RegNoTextField.getText();

        if (photopath == null) {
            try {
                qry = "UPDATE student SET name=?, mother_name=?, mother_occupation=?, "
                        + "address=?, father_name=?, father_occupation=?, sex=?, "
                        + "dob=?, phone=?, email=?, date_of_application=?, course=?, "
                        + "branch=?, batch=?, semester=?, year_of_passing=?, hostel=?, "
                        + "library=?, qualification=?, university=?, quota=?, marks=?, status=? "
                        + "WHERE registration_no LIKE '%" + _reg_no + "%'";
                ps = con.prepareStatement(qry);

                ps.setString(1, NameTextField.getText());
                ps.setString(2, MotherNameTextField.getText());
                ps.setString(3, MotherOccupationTextField.getText());
                ps.setString(4, AddressTextArea.getText());
                ps.setString(5, FatherNameTextField.getText());
                ps.setString(6, FatherOccupationTextField.getText());
                ps.setString(7, SexComboBox.getSelectedItem().toString());

                SimpleDateFormat dobFormat = new SimpleDateFormat("dd-MM-yyyy");
                String dob = dobFormat.format(DOBChooser.getDate());
                ps.setString(8, dob);

                ps.setString(9, PhoneTextField.getText());
                ps.setString(10, EmailTextField.getText());
                ps.setString(11, dobFormat.format(DateChooser.getDate()));
                ps.setString(12, CourseComboBox.getSelectedItem().toString());
                ps.setString(13, BranchComboBox.getSelectedItem().toString());
                ps.setInt(14, BatchYearChooser.getYear());
                ps.setString(15, SemesterComboBox.getSelectedItem().toString());
                ps.setInt(16, PassingYearChooser.getYear());

                if (HostelCheckBox.isSelected()) {
                    ps.setBoolean(17, true);
                } else {
                    ps.setBoolean(17, false);
                }

                if (LibraryCheckBox.isSelected()) {
                    ps.setBoolean(18, true);
                } else {
                    ps.setBoolean(18, false);
                }

                ps.setString(19, QualificationTextField.getText());
                ps.setString(20, UniversityTextField.getText());
                ps.setString(21, QuotaComboBox.getSelectedItem().toString());
                ps.setDouble(22, Double.parseDouble(MarksTextField.getText()));
                ps.setString(23, StatusComboBox.getSelectedItem().toString());

                int res = ps.executeUpdate();
                if (res >= 1) {
                    JOptionPane.showMessageDialog(null, "Record Updated.", "Success", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Updation Failed!", "Error", 0);
                }
            } catch (Exception e) {
                System.err.println(e.toString());
                JOptionPane.showMessageDialog(null, "Updation Failed!", "Error", 0);
            }
        } else {
            try {
                InputStream photoStream = new FileInputStream(new File(photopath));

                qry = "UPDATE student SET name=?, mother_name=?, mother_occupation=?, "
                        + "address=?, father_name=?, father_occupation=?, sex=?, "
                        + "dob=?, phone=?, email=?, date_of_application=?, course=?, "
                        + "branch=?, batch=?, semester=?, year_of_passing=?, hostel=?, "
                        + "library=?, qualification=?, university=?, quota=?, marks=?, status=?, "
                        + "photo=? WHERE registration_no LIKE '%" + reg_no + "%'";
                ps = con.prepareStatement(qry);

                ps.setString(1, NameTextField.getText());
                ps.setString(2, MotherNameTextField.getText());
                ps.setString(3, MotherOccupationTextField.getText());
                ps.setString(4, AddressTextArea.getText());
                ps.setString(5, FatherNameTextField.getText());
                ps.setString(6, FatherOccupationTextField.getText());
                ps.setString(7, SexComboBox.getSelectedItem().toString());

                SimpleDateFormat dobFormat = new SimpleDateFormat("dd-MM-yyyy");
                String dob = dobFormat.format(DOBChooser.getDate());
                ps.setString(8, dob);

                ps.setString(9, PhoneTextField.getText());
                ps.setString(10, EmailTextField.getText());
                ps.setString(11, dobFormat.format(DateChooser.getDate()));
                ps.setString(12, CourseComboBox.getSelectedItem().toString());
                ps.setString(13, BranchComboBox.getSelectedItem().toString());
                ps.setInt(14, BatchYearChooser.getYear());
                ps.setString(15, SemesterComboBox.getSelectedItem().toString());
                ps.setInt(16, PassingYearChooser.getYear());

                if (HostelCheckBox.isSelected()) {
                    ps.setBoolean(17, true);
                } else {
                    ps.setBoolean(17, false);
                }

                if (LibraryCheckBox.isSelected()) {
                    ps.setBoolean(18, true);
                } else {
                    ps.setBoolean(18, false);
                }

                ps.setString(19, QualificationTextField.getText());
                ps.setString(20, UniversityTextField.getText());
                ps.setString(21, QuotaComboBox.getSelectedItem().toString());
                ps.setDouble(22, Double.parseDouble(MarksTextField.getText()));
                ps.setString(23, StatusComboBox.getSelectedItem().toString());

                ps.setBlob(24, photoStream);

                int i = ps.executeUpdate();
                if (i >= 1) {
                    JOptionPane.showMessageDialog(null, "Record Updated.", "Success", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Updation Failed!", "Error", 0);
                }
            } catch (Exception e) {
                System.err.println(e.toString());
                JOptionPane.showMessageDialog(null, "Updation Failed!", "Error", 0);
            }
        }
    }

    private void _deleteStudentData(String reg_no) {
        try {
            String qry = "DELETE FROM student WHERE registration_no LIKE '%" + reg_no + "%'";

            PreparedStatement ps = con.prepareStatement(qry);
            ps.setString(1, RolllNoTextField.getText());
            int x = ps.executeUpdate();
            if (x >= 1) {
                JOptionPane.showMessageDialog(null, "Record Deleted.", "Success", 1);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "Deletion Failed!", "Error", 0);
            }
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Deletion Failed!", "Error", 0);
        }
    }

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed

        if (role == Role.ADMIN) {
            if (_checkInputFields()) {
                int choice = JOptionPane.showConfirmDialog(null, "Do You want to add this student?", "Confirm", 0, 3);
                if (choice == 0) {
                    _saveStudentData();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You Are Not Authorised!", "Access Denied", 0);
        }

    }//GEN-LAST:event_SaveButtonActionPerformed

    private void UpdateButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButtonMousePressed

        if (role == Role.ADMIN) {
            if (_checkInputFields()) {
                int choice = JOptionPane.showConfirmDialog(null, "Do You want to update the data?", "Confirm", 0, 3);
                if (choice == 0) {
                    _updateStudentData();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You Are Not Authorised!", "Access Denied", 0);
        }

    }//GEN-LAST:event_UpdateButtonMousePressed

    private void DeleteButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMousePressed

        if (role == Role.ADMIN) {
            if (RegNoTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Student Registration No. Is Required!");
            } else {
                String _reg_no = RegNoTextField.getText();
                int choice = JOptionPane.showConfirmDialog(null, "Do You want to delete the student?", "Confirm", 0, 3);
                if (choice == 0) {
                    _deleteStudentData(_reg_no);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You Are Not Authorised!", "Access Denied", 0);
        }

    }//GEN-LAST:event_DeleteButtonMousePressed

    private void ClearButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearButtonMousePressed
        clearFields();
    }//GEN-LAST:event_ClearButtonMousePressed

    private void SemLoadingButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SemLoadingButtonMousePressed
        if (CourseComboBox.getSelectedItem() == null || CourseComboBox.getSelectedItem() == "Select") {
            JOptionPane.showMessageDialog(null, "Select a course first.");
        } else if (BranchComboBox.getSelectedItem() == null || BranchComboBox.getSelectedItem() == "Select") {
            JOptionPane.showMessageDialog(null, "Select a branch first.");
        } else {
            ArrayList<String> semList = DBFunctions.getSemester(CourseComboBox.getSelectedItem().toString(), BranchComboBox.getSelectedItem().toString());
            if (semList.isEmpty()) {
                semList.add("Select");
            }
            SemesterComboBox.setModel(new DefaultComboBoxModel<>(semList.toArray(new String[0])));
        }
    }//GEN-LAST:event_SemLoadingButtonMousePressed

    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new StudentEntryForm(role, reg_no).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane AddressScrollPane;
    private javax.swing.JTextArea AddressTextArea;
    private javax.swing.JTextField ApplNoTextField;
    private com.toedter.calendar.JYearChooser BatchYearChooser;
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JComboBox<String> BranchComboBox;
    private javax.swing.JButton BranchLoadingButton;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JButton ClearButton;
    private javax.swing.JComboBox<String> CourseComboBox;
    private javax.swing.JButton CourseLoadingButton;
    private com.toedter.calendar.JDateChooser DOBChooser;
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JTextField FatherNameTextField;
    private javax.swing.JTextField FatherOccupationTextField;
    private javax.swing.JCheckBox HostelCheckBox;
    private javax.swing.JCheckBox LibraryCheckBox;
    private javax.swing.JTextField MarksTextField;
    private javax.swing.JTextField MotherNameTextField;
    private javax.swing.JTextField MotherOccupationTextField;
    private javax.swing.JTextField NameTextField;
    private com.toedter.calendar.JYearChooser PassingYearChooser;
    private javax.swing.JTextField PhoneTextField;
    private javax.swing.JButton PhotoChooserButton;
    private javax.swing.JLabel PhotoLabel;
    private javax.swing.JTextField QualificationTextField;
    private javax.swing.JComboBox<String> QuotaComboBox;
    private javax.swing.JTextField RegNoTextField;
    private javax.swing.JTextField RolllNoTextField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton SemLoadingButton;
    private javax.swing.JComboBox<String> SemesterComboBox;
    private javax.swing.JComboBox<String> SexComboBox;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JTextField UniversityTextField;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
