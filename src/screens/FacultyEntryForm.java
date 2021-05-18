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
import models.Faculty;
import repository.DBConnection;
import repository.DBFunctions;
import repository.RandomGenerator;
import repository.UtilFunctions;

/**
 *
 * @author nixrajput
 */
public class FacultyEntryForm extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);
    static Role role;

    String photopath = null;
    Date date = new Date();

    private final Connection con = new DBConnection().connect();

    private String generateAppNo() {
        String app_no = RandomGenerator.getNumericString(4);
        return "FACULTY" + app_no;
    }

    private void customizeComponents() {
        setLocationRelativeTo(this);
        DateChooser.setDate(date);
        RegNoTextField.setText(generateAppNo());
    }

    private void clearFields() {
        RegNoTextField.setText(generateAppNo());
        NameTextField.setText("");
        DOBChooser.setDate(null);
        DOJChooser.setDate(null);
        FatherNameTextField.setText("");

        AddressTextArea.setText("");
        PhoneTextField.setText("");
        EmailTextField.setText("");

        DateChooser.setDate(date);
        PasswordTextField.setText("");
        QualificationTextField.setText("");
        InstitutionTextField.setText("");
        ExperienceSpinner.setValue(0);

        photopath = null;
        PhotoLabel.setIcon(null);
    }

    private Faculty retrieveData(String reg_no) {
        String qry = null;
        Faculty faculty = null;

        try {
            qry = "SELECT * FROM faculty "
                    + "WHERE registration_no LIKE '%" + reg_no + "%'";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);

            if (rs.next()) {
                faculty = new Faculty(rs.getString("registration_no"), rs.getString("name"), rs.getString("father_name"),
                        rs.getString("sex"), rs.getString("dob"), rs.getString("email"), rs.getString("phone"), rs.getString("password"),
                        rs.getString("address"), rs.getBytes("photo"), rs.getString("qualifications"), rs.getString("institution"),
                        rs.getString("designation"), rs.getInt("experience"), rs.getString("course"),
                        rs.getString("department"), rs.getString("date_joined"), rs.getString("date_updated"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return faculty;
    }

    public void showItemToFields(String reg_no) {
        final Faculty data = retrieveData(reg_no);
        ArrayList<String> courses = DBFunctions.loadCourses();
        CourseComboBox.setModel(new DefaultComboBoxModel<>(courses.toArray(new String[0])));

        ArrayList<Branch> branches = DBFunctions.loadBranches(data.getCourse());
        ArrayList<String> brArrayList = new ArrayList<>();
        for (int i = 0; i < branches.size(); i++) {
            brArrayList.add(branches.get(i).getInit());
        }
        DepartmentComboBox.setModel(new DefaultComboBoxModel<>(brArrayList.toArray(new String[0])));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        RegNoTextField.setText(data.getRegNo());
        NameTextField.setText(data.getName());
        FatherNameTextField.setText(data.getFather_name());
        SexComboBox.setSelectedItem(data.getSex());
        DateChooser.setDate(date);

        try {
            DateChooser.setDate(sdf.parse(data.getDate_updated()));
            DOBChooser.setDate(sdf.parse(data.getDob()));
            DOJChooser.setDate(sdf.parse(data.getDate_joined()));
        } catch (ParseException e) {
            System.out.println("Error in showItemToFields method...");
        }
        AddressTextArea.setText(data.getAddress());
        PhoneTextField.setText(data.getPhone());
        EmailTextField.setText(data.getEmail());
        DesignationComboBox.setSelectedItem(data.getDesignation());
        CourseComboBox.setSelectedItem(data.getCourse());
        DepartmentComboBox.setSelectedItem(data.getDepartment());
        ExperienceSpinner.setValue(data.getExperience());

        PhotoLabel.setIcon(UtilFunctions.resizeImage(null, data.getPhoto(), PhotoLabel));

        PasswordTextField.setText(data.getPassword());
        QualificationTextField.setText(data.getQualifications());
        InstitutionTextField.setText(data.getInstitution());
    }

    public FacultyEntryForm(Role role) {
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
        NameTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        RegNoTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        SexComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        DOBChooser = new com.toedter.calendar.JDateChooser();
        FatherNameTextField = new javax.swing.JTextField();
        AddressScrollPane = new javax.swing.JScrollPane();
        AddressTextArea = new javax.swing.JTextArea();
        PhoneTextField = new javax.swing.JTextField();
        EmailTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        DesignationComboBox = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        PhotoLabel = new javax.swing.JLabel();
        PhotoChooserButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        DateChooser = new com.toedter.calendar.JDateChooser();
        PasswordTextField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        QualificationTextField = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        InstitutionTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        DOJChooser = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        DepartmentComboBox = new javax.swing.JComboBox<>();
        ExperienceSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        GenPassButton = new javax.swing.JButton();
        DepartmentLoadingButton = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        AccountNoTextField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        SalaryTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        CourseComboBox = new javax.swing.JComboBox<>();
        CourseLoadingButton = new javax.swing.JButton();
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
        TitleLabel.setText("FACULTY ENTRY FORM");
        TitleLabel.setToolTipText("");
        TitleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
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
        jLabel5.setText("Name");

        NameTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel15.setFont(jLabel15.getFont().deriveFont(jLabel15.getFont().getStyle() | java.awt.Font.BOLD, jLabel15.getFont().getSize()+3));
        jLabel15.setForeground(new java.awt.Color(0, 150, 150));
        jLabel15.setText("Reg. No.");

        RegNoTextField.setEditable(false);
        RegNoTextField.setFont(RegNoTextField.getFont().deriveFont(RegNoTextField.getFont().getStyle() | java.awt.Font.BOLD, RegNoTextField.getFont().getSize()+3));
        RegNoTextField.setToolTipText("");
        RegNoTextField.setMinimumSize(new java.awt.Dimension(200, 30));
        RegNoTextField.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel8.setFont(jLabel8.getFont().deriveFont(jLabel8.getFont().getStyle() | java.awt.Font.BOLD, jLabel8.getFont().getSize()+3));
        jLabel8.setForeground(new java.awt.Color(0, 150, 150));
        jLabel8.setText("Sex");

        SexComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SexComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female", "Other" }));

        jLabel9.setFont(jLabel9.getFont().deriveFont(jLabel9.getFont().getStyle() | java.awt.Font.BOLD, jLabel9.getFont().getSize()+3));
        jLabel9.setForeground(new java.awt.Color(0, 150, 150));
        jLabel9.setText("D.O.B");

        DOBChooser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        FatherNameTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        AddressTextArea.setColumns(20);
        AddressTextArea.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AddressTextArea.setRows(5);
        AddressScrollPane.setViewportView(AddressTextArea);

        PhoneTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        EmailTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel18.setFont(jLabel18.getFont().deriveFont(jLabel18.getFont().getStyle() | java.awt.Font.BOLD, jLabel18.getFont().getSize()+3));
        jLabel18.setForeground(new java.awt.Color(0, 150, 150));
        jLabel18.setText("Designation");

        DesignationComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DesignationComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Assistant Professor", "Associate Professor", "Head of Department", "Principal", "Dean" }));

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

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | java.awt.Font.BOLD, jLabel2.getFont().getSize()+3));
        jLabel2.setForeground(new java.awt.Color(0, 150, 150));
        jLabel2.setText("Date");

        DateChooser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DateChooser.setMinSelectableDate(new java.util.Date(946668704000L));

        PasswordTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel25.setFont(jLabel25.getFont().deriveFont(jLabel25.getFont().getStyle() | java.awt.Font.BOLD, jLabel25.getFont().getSize()+3));
        jLabel25.setForeground(new java.awt.Color(0, 150, 150));
        jLabel25.setText("Password");

        jLabel23.setFont(jLabel23.getFont().deriveFont(jLabel23.getFont().getStyle() | java.awt.Font.BOLD, jLabel23.getFont().getSize()+3));
        jLabel23.setForeground(new java.awt.Color(0, 150, 150));
        jLabel23.setText("Email");

        jLabel13.setFont(jLabel13.getFont().deriveFont(jLabel13.getFont().getStyle() | java.awt.Font.BOLD, jLabel13.getFont().getSize()+3));
        jLabel13.setForeground(new java.awt.Color(0, 150, 150));
        jLabel13.setText("Phone");

        jLabel10.setFont(jLabel10.getFont().deriveFont(jLabel10.getFont().getStyle() | java.awt.Font.BOLD, jLabel10.getFont().getSize()+3));
        jLabel10.setForeground(new java.awt.Color(0, 150, 150));
        jLabel10.setText("Father's Name");

        jLabel12.setFont(jLabel12.getFont().deriveFont(jLabel12.getFont().getStyle() | java.awt.Font.BOLD, jLabel12.getFont().getSize()+3));
        jLabel12.setForeground(new java.awt.Color(0, 150, 150));
        jLabel12.setText("Address");

        jLabel26.setFont(jLabel26.getFont().deriveFont(jLabel26.getFont().getStyle() | java.awt.Font.BOLD, jLabel26.getFont().getSize()+3));
        jLabel26.setForeground(new java.awt.Color(0, 150, 150));
        jLabel26.setText("Qualification");

        QualificationTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel27.setFont(jLabel27.getFont().deriveFont(jLabel27.getFont().getStyle() | java.awt.Font.BOLD, jLabel27.getFont().getSize()+3));
        jLabel27.setForeground(new java.awt.Color(0, 150, 150));
        jLabel27.setText("Institution");

        InstitutionTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel11.setFont(jLabel11.getFont().deriveFont(jLabel11.getFont().getStyle() | java.awt.Font.BOLD, jLabel11.getFont().getSize()+3));
        jLabel11.setForeground(new java.awt.Color(0, 150, 150));
        jLabel11.setText("D.O.J");

        DOJChooser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel20.setFont(jLabel20.getFont().deriveFont(jLabel20.getFont().getStyle() | java.awt.Font.BOLD, jLabel20.getFont().getSize()+3));
        jLabel20.setForeground(new java.awt.Color(0, 150, 150));
        jLabel20.setText("Department");

        DepartmentComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DepartmentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        ExperienceSpinner.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Years");

        jLabel28.setFont(jLabel28.getFont().deriveFont(jLabel28.getFont().getStyle() | java.awt.Font.BOLD, jLabel28.getFont().getSize()+3));
        jLabel28.setForeground(new java.awt.Color(0, 150, 150));
        jLabel28.setText("Experience");

        GenPassButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        GenPassButton.setForeground(new java.awt.Color(0, 150, 150));
        GenPassButton.setText("Generate");
        GenPassButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GenPassButtonMousePressed(evt);
            }
        });

        DepartmentLoadingButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DepartmentLoadingButton.setForeground(new java.awt.Color(0, 150, 150));
        DepartmentLoadingButton.setText("Load");
        DepartmentLoadingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DepartmentLoadingButtonMousePressed(evt);
            }
        });

        jLabel29.setFont(jLabel29.getFont().deriveFont(jLabel29.getFont().getStyle() | java.awt.Font.BOLD, jLabel29.getFont().getSize()+3));
        jLabel29.setForeground(new java.awt.Color(0, 150, 150));
        jLabel29.setText("A/C No.");

        AccountNoTextField.setEditable(false);
        AccountNoTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel30.setFont(jLabel30.getFont().deriveFont(jLabel30.getFont().getStyle() | java.awt.Font.BOLD, jLabel30.getFont().getSize()+3));
        jLabel30.setForeground(new java.awt.Color(0, 150, 150));
        jLabel30.setText("Salary");

        SalaryTextField.setEditable(false);
        SalaryTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel21.setFont(jLabel21.getFont().deriveFont(jLabel21.getFont().getStyle() | java.awt.Font.BOLD, jLabel21.getFont().getSize()+3));
        jLabel21.setForeground(new java.awt.Color(0, 150, 150));
        jLabel21.setText("Course");

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

        javax.swing.GroupLayout BodyPanelLayout = new javax.swing.GroupLayout(BodyPanel);
        BodyPanel.setLayout(BodyPanelLayout);
        BodyPanelLayout.setHorizontalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyPanelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(FatherNameTextField)
                        .addGap(634, 634, 634))
                    .addGroup(BodyPanelLayout.createSequentialGroup()
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BodyPanelLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BodyPanelLayout.createSequentialGroup()
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel25)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel20))
                                        .addGap(18, 18, 18)
                                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(BodyPanelLayout.createSequentialGroup()
                                                .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(GenPassButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                                        .addComponent(DOBChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(59, 59, 59))
                                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel28)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(ExperienceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel1))))
                                            .addGroup(BodyPanelLayout.createSequentialGroup()
                                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(QualificationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(InstitutionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                                        .addGap(12, 12, 12)
                                                        .addComponent(jLabel30)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(SalaryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                                        .addComponent(jLabel29)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(AccountNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BodyPanelLayout.createSequentialGroup()
                                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(DepartmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(DesignationComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(DepartmentLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(334, 334, 334))
                                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel21)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(CourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(CourseLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(BodyPanelLayout.createSequentialGroup()
                                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15))
                                        .addGap(18, 18, 18)
                                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RegNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(BodyPanelLayout.createSequentialGroup()
                                                .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(108, 108, 108)
                                                .addComponent(jLabel9)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(218, 218, 218))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(SexComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(DateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))))
                            .addGroup(BodyPanelLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(AddressScrollPane)
                                .addGap(222, 222, 222)
                                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(18, 18, 18)
                                        .addComponent(EmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                                        .addComponent(PhotoChooserButton)
                                        .addGap(29, 29, 29))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(PhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)
                                                .addComponent(DOJChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addContainerGap())))
        );
        BodyPanelLayout.setVerticalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(RegNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(DOBChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FatherNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DOJChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddressScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BodyPanelLayout.createSequentialGroup()
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(DesignationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CourseLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DepartmentLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DepartmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExperienceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GenPassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(QualificationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AccountNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InstitutionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SalaryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BodyPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(PhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PhotoChooserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
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

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed

        if (role == Role.ADMIN) {
            if (NameTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Name Field Is Required!!!");
            } else if (DateChooser.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Date Field Is Required!!!");
            } else if (DOBChooser.getDate() == null) {
                JOptionPane.showMessageDialog(null, "DOB Field Is Required!!!");
            } else if (FatherNameTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Father's Name Field Is Required!!!");
            } else if (AddressTextArea.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Address Field Is Required!!!");
            } else if (PhoneTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Phone Field Is Required!!!");
            } else if (EmailTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Email Field Is Required!!!");
            } else if (QualificationTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Qualification Field Is Required!!!");
            } else if (InstitutionTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Institution Field Is Required!!!");
            } else if (PasswordTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Password Field Is Required!!!");
            } else if (photopath == null) {
                JOptionPane.showMessageDialog(null, "Photo Field Is Required!!!");
            } else if (DOJChooser.getDate() == null) {
                JOptionPane.showMessageDialog(null, "DOJ Field Is Required!!!");
            } else if (DepartmentComboBox.getSelectedItem() == null || DepartmentComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Department Field Is Required!!!");
            } else if (SexComboBox.getSelectedItem() == null || DepartmentComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Sex Field Is Required!!!");
            } else if (DesignationComboBox.getSelectedItem() == null || DepartmentComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Designation Field Is Required!!!");
            } else {
                final String insert_sql = "INSERT INTO faculty(registration_no, name, father_name,"
                        + "sex, dob, email, phone, password, address, photo, qualifications, "
                        + "institution, designation, experience, course, department, date_joined, date_updated)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                try {
                    PreparedStatement ps = con.prepareStatement(insert_sql);
                    SimpleDateFormat dobFormat = new SimpleDateFormat("dd-MM-yyyy");

                    ps.setString(1, RegNoTextField.getText());

                    ps.setString(2, NameTextField.getText());

                    ps.setString(3, FatherNameTextField.getText());
                    ps.setString(4, SexComboBox.getSelectedItem().toString());

                    String dob = dobFormat.format(DOBChooser.getDate());
                    ps.setString(5, dob);
                    ps.setString(6, EmailTextField.getText());
                    ps.setString(7, PhoneTextField.getText());

                    ps.setString(8, PasswordTextField.getText());
                    ps.setString(9, AddressTextArea.getText());

                    InputStream photoStream = new FileInputStream(new File(photopath));
                    ps.setBlob(10, photoStream);

                    ps.setString(11, QualificationTextField.getText());
                    ps.setString(12, InstitutionTextField.getText());

                    ps.setString(13, DesignationComboBox.getSelectedItem().toString());

                    ps.setString(14, ExperienceSpinner.getValue().toString());

                    ps.setString(15, CourseComboBox.getSelectedItem().toString());
                    ps.setString(16, DepartmentComboBox.getSelectedItem().toString());
                    ps.setString(17, dobFormat.format(DOJChooser.getDate()));
                    ps.setString(18, dobFormat.format(DateChooser.getDate()));

                    int i = ps.executeUpdate();

                    if (i >= 1) {
                        JOptionPane.showMessageDialog(null, "Faculty Inserted Succussfully. You Registration No. is [" + RegNoTextField.getText()
                                + "]. Kindly Note & Remember Your Registraion No.");
                        clearFields();
                    } else {
                        JOptionPane.showMessageDialog(null, "Insertion Failed!!!");
                    }
                } catch (Exception e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "Insertion Failed!!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You Are Not Authorised!", "Access Denied", 0);
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void UpdateButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButtonMousePressed

        if (role == Role.ADMIN) {
            if (NameTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Name Field Is Required!!!");
            } else if (DateChooser.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Date Field Is Required!!!");
            } else if (DOBChooser.getDate() == null) {
                JOptionPane.showMessageDialog(null, "DOB Field Is Required!!!");
            } else if (FatherNameTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Father's Name Field Is Required!!!");
            } else if (AddressTextArea.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Address Field Is Required!!!");
            } else if (PhoneTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Phone Field Is Required!!!");
            } else if (EmailTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Email Field Is Required!!!");
            } else if (QualificationTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Qualification Field Is Required!!!");
            } else if (InstitutionTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Institution Field Is Required!!!");
            } else if (PasswordTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Password Field Is Required!!!");
            } else if (DOJChooser.getDate() == null) {
                JOptionPane.showMessageDialog(null, "DOJ Field Is Required!!!");
            } else if (DepartmentComboBox.getSelectedItem() == null || DepartmentComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Department Field Is Required!!!");
            } else if (SexComboBox.getSelectedItem() == null || DepartmentComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Sex Field Is Required!!!");
            } else if (DesignationComboBox.getSelectedItem() == null || DepartmentComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Designation Field Is Required!!!");
            } else {

                String reg_no = RegNoTextField.getText();
                String qry = null;
                PreparedStatement ps = null;
                SimpleDateFormat dobFormat = new SimpleDateFormat("dd-MM-yyyy");

                if (photopath == null) {
                    try {
                        qry = "UPDATE faculty SET name=?, father_name=?, sex=?, dob=?, "
                                + "email=?, phone=?, password=?, address=?, "
                                + "qualifications=?, institution=?, designation=?, experience=?, "
                                + "course=?, department=?, date_joined=?, date_updated=?"
                                + "WHERE registration_no LIKE '%" + reg_no + "%'";
                        ps = con.prepareStatement(qry);

                        ps.setString(1, NameTextField.getText());
                        ps.setString(2, FatherNameTextField.getText());

                        ps.setString(3, SexComboBox.getSelectedItem().toString());

                        String dob = dobFormat.format(DOBChooser.getDate());
                        ps.setString(4, dob);
                        ps.setString(5, EmailTextField.getText());
                        ps.setString(6, PhoneTextField.getText());

                        ps.setString(7, PasswordTextField.getText());
                        ps.setString(8, AddressTextArea.getText());

                        ps.setString(9, QualificationTextField.getText());
                        ps.setString(10, InstitutionTextField.getText());

                        ps.setString(11, DesignationComboBox.getSelectedItem().toString());

                        ps.setString(12, ExperienceSpinner.getValue().toString());

                        ps.setString(13, CourseComboBox.getSelectedItem().toString());
                        ps.setString(14, DepartmentComboBox.getSelectedItem().toString());
                        ps.setString(15, dobFormat.format(DOJChooser.getDate()));
                        ps.setString(16, dobFormat.format(DateChooser.getDate()));

                        int res = ps.executeUpdate();
                        if (res >= 1) {
                            JOptionPane.showMessageDialog(null, "Record successfully Updated..");
                        } else {
                            JOptionPane.showMessageDialog(null, "Record Updation Failed...");
                        }
                    } catch (Exception e) {
                        System.err.println(e.toString());
                        JOptionPane.showMessageDialog(null, "Record Updation Failed...");
                    }
                } else {
                    try {
                        InputStream photoStream = new FileInputStream(new File(photopath));

                        qry = "UPDATE faculty SET name=?, father_name=?, sex=?, dob=?, "
                                + "email=?, phone=?, password=?, address=?, photo=? "
                                + "qualifications=?, institution=?, designation=?, experience=?, "
                                + "course=?, department=?, date_joined=?, date_updated=?"
                                + "WHERE registration_no LIKE '%" + reg_no + "%'";
                        ps = con.prepareStatement(qry);

                        ps.setString(1, NameTextField.getText());
                        ps.setString(2, FatherNameTextField.getText());

                        ps.setString(3, SexComboBox.getSelectedItem().toString());

                        String dob = dobFormat.format(DOBChooser.getDate());
                        ps.setString(4, dob);
                        ps.setString(5, EmailTextField.getText());
                        ps.setString(6, PhoneTextField.getText());

                        ps.setString(7, PasswordTextField.getText());
                        ps.setString(8, AddressTextArea.getText());

                        ps.setBlob(9, photoStream);
                        ps.setString(10, QualificationTextField.getText());
                        ps.setString(11, InstitutionTextField.getText());

                        ps.setString(12, DesignationComboBox.getSelectedItem().toString());

                        ps.setString(13, ExperienceSpinner.getValue().toString());

                        ps.setString(14, CourseComboBox.getSelectedItem().toString());
                        ps.setString(15, DepartmentComboBox.getSelectedItem().toString());
                        ps.setString(16, dobFormat.format(DOJChooser.getDate()));
                        ps.setString(17, dobFormat.format(DateChooser.getDate()));

                        int i = ps.executeUpdate();
                        if (i >= 1) {
                            JOptionPane.showMessageDialog(null, "Record Successfully Updated..");
                        } else {
                            JOptionPane.showMessageDialog(null, "Updation Failed!!!");
                        }
                    } catch (Exception e) {
                        System.err.println(e.toString());
                        JOptionPane.showMessageDialog(null, "Updation Failed!!!");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You Are Not Authorised!", "Access Denied", 0);
        }

    }//GEN-LAST:event_UpdateButtonMousePressed

    private void DeleteButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMousePressed

        if (role == Role.ADMIN) {
            if (!RegNoTextField.getText().isEmpty()) {
                String reg_no = RegNoTextField.getText();
                try {
                    String qry = "DELETE FROM faculty WHERE registration_no LIKE '%" + reg_no + "%'";

                    PreparedStatement ps = con.prepareStatement(qry);

                    int x = ps.executeUpdate();
                    if (x >= 1) {
                        JOptionPane.showMessageDialog(null, "Record Deleted...");
                        clearFields();
                    } else {
                        JOptionPane.showMessageDialog(null, "Deletion Failed!!!");
                    }
                } catch (Exception e) {
                    System.err.println(e.toString());
                    JOptionPane.showMessageDialog(null, "Deletion Failed!!!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Student Registration No. is Empty!!!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "You Are Not Authorised!", "Access Denied", 0);
        }


    }//GEN-LAST:event_DeleteButtonMousePressed

    private void ClearButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearButtonMousePressed
        clearFields();
    }//GEN-LAST:event_ClearButtonMousePressed

    private void GenPassButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenPassButtonMousePressed
        String rand_no = RandomGenerator.getNumericString(4);
        PasswordTextField.setText(rand_no);
    }//GEN-LAST:event_GenPassButtonMousePressed

    private void DepartmentLoadingButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DepartmentLoadingButtonMousePressed

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
            DepartmentComboBox.setModel(new DefaultComboBoxModel<>(brArrayList.toArray(new String[0])));
        } else {
            JOptionPane.showMessageDialog(null, "Select a course first.");
        }

    }//GEN-LAST:event_DepartmentLoadingButtonMousePressed

    private void CourseLoadingButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CourseLoadingButtonMousePressed
        ArrayList<String> courses = DBFunctions.loadCourses();
        if (courses.isEmpty()) {
            courses.add("Select");
        }
        CourseComboBox.setModel(new DefaultComboBoxModel<>(courses.toArray(new String[0])));
    }//GEN-LAST:event_CourseLoadingButtonMousePressed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new FacultyEntryForm(role).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccountNoTextField;
    private javax.swing.JScrollPane AddressScrollPane;
    private javax.swing.JTextArea AddressTextArea;
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JButton ClearButton;
    private javax.swing.JComboBox<String> CourseComboBox;
    private javax.swing.JButton CourseLoadingButton;
    private com.toedter.calendar.JDateChooser DOBChooser;
    private com.toedter.calendar.JDateChooser DOJChooser;
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JComboBox<String> DepartmentComboBox;
    private javax.swing.JButton DepartmentLoadingButton;
    private javax.swing.JComboBox<String> DesignationComboBox;
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JSpinner ExperienceSpinner;
    private javax.swing.JTextField FatherNameTextField;
    private javax.swing.JButton GenPassButton;
    private javax.swing.JTextField InstitutionTextField;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JTextField PasswordTextField;
    private javax.swing.JTextField PhoneTextField;
    private javax.swing.JButton PhotoChooserButton;
    private javax.swing.JLabel PhotoLabel;
    private javax.swing.JTextField QualificationTextField;
    private javax.swing.JTextField RegNoTextField;
    private javax.swing.JTextField SalaryTextField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JComboBox<String> SexComboBox;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
