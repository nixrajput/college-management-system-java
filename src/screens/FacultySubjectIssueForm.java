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
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import models.Branch;
import models.TimeTable;
import repository.ComboBoxRenderer;
import repository.DBConnection;
import repository.DBFunctions;
import repository.RandomGenerator;

/**
 *
 * @author nixrajput
 */
public class FacultySubjectIssueForm extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
    ImageIcon icon = new ImageIcon(iconURL);
    static Role role;

    String photopath = null;
    Date date = new Date();

    private final Connection con = new DBConnection().connect();

    private String generateIssueID() {
        String id = RandomGenerator.getNumericString(5);
        return "UID" + id;
    }

    private void customizeComponents() {
        setLocationRelativeTo(this);
        DateChooser.setDate(date);
        UIDTextField.setText(generateIssueID());
    }

    private void clearFields() {
        UIDTextField.setText(generateIssueID());
        CourseComboBox.setSelectedItem(null);
        BranchComboBox.setSelectedItem(null);
        SemesterComboBox.setSelectedItem(null);

        DateChooser.setDate(date);

        SubjectComboBox.setSelectedItem(null);
        FacultyComboBox.setSelectedItem(null);

        SectionTextField.setText(null);
        DayComboBox.setSelectedItem(null);
        TimeTextField.setText(null);
    }

    private TimeTable retrieveData(String id) {
        String qry = null;
        TimeTable tTable = null;

        try {
            qry = "SELECT * FROM time_table WHERE id LIKE '%" + id + "%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);
            if (rs.next()) {
                tTable = new TimeTable(rs.getString("id"), rs.getString("subject"), rs.getString("faculty"), rs.getString("course"),
                        rs.getString("branch"), rs.getString("semester"), rs.getString("section"), rs.getString("day"),
                        rs.getString("time"), rs.getString("timestamp"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tTable;
    }

    public void showItemToFields(String id) {
        final TimeTable data = retrieveData(id);
        ArrayList<String> courses = DBFunctions.loadCourses();
        CourseComboBox.setModel(new DefaultComboBoxModel<>(courses.toArray(new String[0])));

        ArrayList<Branch> branches = DBFunctions.loadBranches(data.getCourse());
        ArrayList<String> brArrayList = new ArrayList<>();
        for (int i = 0; i < branches.size(); i++) {
            brArrayList.add(branches.get(i).getInit());
        }
        BranchComboBox.setModel(new DefaultComboBoxModel<>(brArrayList.toArray(new String[0])));

        ArrayList<String> semList = DBFunctions.getSemester(data.getCourse(), data.getBranch());
        if (semList.isEmpty()) {
            semList.add("Select");
        }
        SemesterComboBox.setModel(new DefaultComboBoxModel<>(semList.toArray(new String[0])));

        ArrayList<String> subjList = DBFunctions.getSubjects(data.getCourse());
        if (subjList.isEmpty()) {
            subjList.add("Select");
        }
        SubjectComboBox.setModel(new DefaultComboBoxModel<>(subjList.toArray(new String[0])));

        ArrayList<String> facList = DBFunctions.getFaculty(data.getCourse());
        if (facList.isEmpty()) {
            facList.add("Select");
        }
        FacultyComboBox.setModel(new DefaultComboBoxModel<>(facList.toArray(new String[0])));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        UIDTextField.setText(data.getId());
        CourseComboBox.setSelectedItem(data.getCourse());
        BranchComboBox.setSelectedItem(data.getBranch());
        SemesterComboBox.setSelectedItem(data.getSemester());

        try {
            Date _date = null;
            _date = dateFormat.parse(data.getDate());
            DateChooser.setDate(_date);
        } catch (ParseException e) {
            System.out.println(e);
        }

        SubjectComboBox.setSelectedItem(data.getSubject());
        FacultyComboBox.setSelectedItem(data.getFaculty());

        SectionTextField.setText(data.getSection());
        DayComboBox.setSelectedItem(data.getDay());

        String time = data.getTime();
        String timeMeridian;

        if (time.length() == 2) {
            timeMeridian = time;
        } else if (time.length() > 2) {
            timeMeridian = time.substring(time.length() - 2);
        } else {
            throw new IllegalArgumentException("Word has less than 2 characters!");
        }

        TimeTextField.setText(time.substring(0, time.length() - 2));
        TimeComboBox.setSelectedItem(timeMeridian);

    }

    public FacultySubjectIssueForm(Role role) {
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
        UIDTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        CourseComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        DateChooser = new com.toedter.calendar.JDateChooser();
        SectionTextField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        BranchComboBox = new javax.swing.JComboBox<>();
        BranchLoadingButton = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        SemesterComboBox = new javax.swing.JComboBox<>();
        SemesterLoadingButton = new javax.swing.JButton();
        CourseLoadingButton = new javax.swing.JButton();
        TimeComboBox = new javax.swing.JComboBox<>();
        SubjectComboBox = new javax.swing.JComboBox<>();
        FacultyComboBox = new javax.swing.JComboBox<>();
        SubLoadingButton = new javax.swing.JButton();
        FacultyLoadingButton = new javax.swing.JButton();
        TimeTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        DayComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        ButtonPanel = new javax.swing.JPanel();
        SaveButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("constants/strings"); // NOI18N
        setTitle(bundle.getString("APP_NAME")); // NOI18N
        setIconImage(icon.getImage());
        setMaximumSize(new java.awt.Dimension(540, 760));
        setMinimumSize(new java.awt.Dimension(540, 760));
        setResizable(false);

        TitlePanel.setBackground(new java.awt.Color(51, 51, 51));

        TitleLabel.setFont(TitleLabel.getFont().deriveFont(TitleLabel.getFont().getStyle() | java.awt.Font.BOLD, TitleLabel.getFont().getSize()+29));
        TitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText("SUBJECT ISSUE FORM");
        TitleLabel.setToolTipText("");
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

        jLabel5.setFont(jLabel5.getFont().deriveFont(jLabel5.getFont().getStyle() | java.awt.Font.BOLD, jLabel5.getFont().getSize()+3));
        jLabel5.setForeground(new java.awt.Color(0, 150, 150));
        jLabel5.setText("Subject Name");

        jLabel15.setFont(jLabel15.getFont().deriveFont(jLabel15.getFont().getStyle() | java.awt.Font.BOLD, jLabel15.getFont().getSize()+3));
        jLabel15.setForeground(new java.awt.Color(0, 150, 150));
        jLabel15.setText("UID");

        UIDTextField.setEditable(false);
        UIDTextField.setFont(UIDTextField.getFont().deriveFont(UIDTextField.getFont().getStyle() | java.awt.Font.BOLD, UIDTextField.getFont().getSize()+3));
        UIDTextField.setToolTipText("");
        UIDTextField.setMinimumSize(new java.awt.Dimension(200, 30));
        UIDTextField.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel18.setFont(jLabel18.getFont().deriveFont(jLabel18.getFont().getStyle() | java.awt.Font.BOLD, jLabel18.getFont().getSize()+3));
        jLabel18.setForeground(new java.awt.Color(0, 150, 150));
        jLabel18.setText("Course");

        CourseComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | java.awt.Font.BOLD, jLabel2.getFont().getSize()+3));
        jLabel2.setForeground(new java.awt.Color(0, 150, 150));
        jLabel2.setText("Date");

        DateChooser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DateChooser.setMinSelectableDate(new java.util.Date(946668704000L));

        SectionTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel25.setFont(jLabel25.getFont().deriveFont(jLabel25.getFont().getStyle() | java.awt.Font.BOLD, jLabel25.getFont().getSize()+3));
        jLabel25.setForeground(new java.awt.Color(0, 150, 150));
        jLabel25.setText("Section");

        jLabel10.setFont(jLabel10.getFont().deriveFont(jLabel10.getFont().getStyle() | java.awt.Font.BOLD, jLabel10.getFont().getSize()+3));
        jLabel10.setForeground(new java.awt.Color(0, 150, 150));
        jLabel10.setText("Faculty Name");

        jLabel20.setFont(jLabel20.getFont().deriveFont(jLabel20.getFont().getStyle() | java.awt.Font.BOLD, jLabel20.getFont().getSize()+3));
        jLabel20.setForeground(new java.awt.Color(0, 150, 150));
        jLabel20.setText("Branch");

        BranchComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BranchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        BranchComboBox.setRenderer(new ComboBoxRenderer());

        BranchLoadingButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BranchLoadingButton.setForeground(new java.awt.Color(0, 150, 150));
        BranchLoadingButton.setText("Load");
        BranchLoadingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BranchLoadingButtonMousePressed(evt);
            }
        });

        jLabel21.setFont(jLabel21.getFont().deriveFont(jLabel21.getFont().getStyle() | java.awt.Font.BOLD, jLabel21.getFont().getSize()+3));
        jLabel21.setForeground(new java.awt.Color(0, 150, 150));
        jLabel21.setText("Semester");

        SemesterComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        SemesterLoadingButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SemesterLoadingButton.setForeground(new java.awt.Color(0, 150, 150));
        SemesterLoadingButton.setText("Load");
        SemesterLoadingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SemesterLoadingButtonMousePressed(evt);
            }
        });

        CourseLoadingButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CourseLoadingButton.setForeground(new java.awt.Color(0, 150, 150));
        CourseLoadingButton.setText("Load");
        CourseLoadingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CourseLoadingButtonMousePressed(evt);
            }
        });

        TimeComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TimeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        SubjectComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SubjectComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        FacultyComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        FacultyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        SubLoadingButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SubLoadingButton.setForeground(new java.awt.Color(0, 150, 150));
        SubLoadingButton.setText("Load");
        SubLoadingButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SubLoadingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SubLoadingButtonMousePressed(evt);
            }
        });

        FacultyLoadingButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        FacultyLoadingButton.setForeground(new java.awt.Color(0, 150, 150));
        FacultyLoadingButton.setText("Load");
        FacultyLoadingButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FacultyLoadingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FacultyLoadingButtonMousePressed(evt);
            }
        });

        TimeTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 150, 150));
        jLabel1.setText("Day");

        DayComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DayComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 150, 150));
        jLabel4.setText("Time");

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
                    .addComponent(jLabel18)
                    .addComponent(jLabel10)
                    .addComponent(jLabel25)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                        .addComponent(SubjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SubLoadingButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SemesterComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BranchComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CourseComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CourseLoadingButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BranchLoadingButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SemesterLoadingButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(UIDTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                        .addComponent(TimeTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SectionTextField)
                    .addGroup(BodyPanelLayout.createSequentialGroup()
                        .addComponent(FacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FacultyLoadingButton))
                    .addComponent(DayComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BodyPanelLayout.setVerticalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UIDTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CourseLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BranchComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BranchLoadingButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SemesterLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SubjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SubLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FacultyLoadingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SectionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(BodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed

        if (role == Role.ADMIN) {
            if (CourseComboBox.getSelectedItem() == null || CourseComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Course Field Is Required!!!");
            } else if (BranchComboBox.getSelectedItem() == null || BranchComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Branch Field Is Required!!!");
            } else if (SemesterComboBox.getSelectedItem() == null || SemesterComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Semester Field Is Required!!!");
            } else if (SubjectComboBox.getSelectedItem() == null || SubjectComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Subject Field Is Required!!!");
            } else if (FacultyComboBox.getSelectedItem() == null || FacultyComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Faculty Field Is Required!!!");
            } else if (SectionTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Section Field Is Required!!!");
            } else if (DayComboBox.getSelectedItem() == null || DayComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Day Field Is Required!!!");
            } else {
                final String insert_sql = "INSERT INTO time_table(subject, faculty, "
                        + "course, branch, semester, section, day, time, timestamp, id) "
                        + "VALUES (?,?,?,?,?,?,?,?,?,?)";
                try {
                    PreparedStatement ps = con.prepareStatement(insert_sql);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                    ps.setString(1, SubjectComboBox.getSelectedItem().toString());

                    ps.setString(2, FacultyComboBox.getSelectedItem().toString());

                    ps.setString(3, CourseComboBox.getSelectedItem().toString());
                    ps.setString(4, BranchComboBox.getSelectedItem().toString());

                    ps.setString(5, SemesterComboBox.getSelectedItem().toString());
                    ps.setString(6, SectionTextField.getText());
                    ps.setString(7, DayComboBox.getSelectedItem().toString());

                    String timeString = TimeTextField.getText() + " "
                            + TimeComboBox.getSelectedItem().toString();
                    ps.setString(8, timeString);
                    
                    ps.setString(9, dateFormat.format(DateChooser.getDate()));
                    ps.setString(10, UIDTextField.getText());

                    int i = ps.executeUpdate();

                    if (i >= 1) {
                        JOptionPane.showMessageDialog(null, "Subject Issued Successfully...");
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
            JOptionPane.showMessageDialog(null, "You Are Not Authorised!!!");
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void UpdateButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButtonMousePressed

        if (role == Role.ADMIN) {

            if (CourseComboBox.getSelectedItem() == null || CourseComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Course Field Is Required!!!");
            } else if (BranchComboBox.getSelectedItem() == null || BranchComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Branch Field Is Required!!!");
            } else if (SemesterComboBox.getSelectedItem() == null || SemesterComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Semester Field Is Required!!!");
            } else if (SubjectComboBox.getSelectedItem() == null || SubjectComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Subject Field Is Required!!!");
            } else if (FacultyComboBox.getSelectedItem() == null || FacultyComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Faculty Field Is Required!!!");
            } else if (SectionTextField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Section Field Is Required!!!");
            } else if (DayComboBox.getSelectedItem() == null || DayComboBox.getSelectedItem() == "Select") {
                JOptionPane.showMessageDialog(null, "Day Field Is Required!!!");
            } else {
                final String insert_sql = "UPDATE time_table SET subject=?, faculty=?, "
                        + "course=?, branch=?, semester=?, section=?, day=?, time=?, "
                        + "timestamp=? WHERE id LIKE '%" + UIDTextField.getText() + "%'";
                try {
                    PreparedStatement ps = con.prepareStatement(insert_sql);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                    ps.setString(1, SubjectComboBox.getSelectedItem().toString());

                    ps.setString(2, FacultyComboBox.getSelectedItem().toString());

                    ps.setString(3, CourseComboBox.getSelectedItem().toString());
                    ps.setString(4, BranchComboBox.getSelectedItem().toString());

                    ps.setString(5, SemesterComboBox.getSelectedItem().toString());
                    ps.setString(6, SectionTextField.getText());
                    ps.setString(7, DayComboBox.getSelectedItem().toString());

                    String timeString = TimeTextField.getText() + " "
                            + TimeComboBox.getSelectedItem().toString();
                    ps.setString(8, timeString);
                    ps.setString(9, dateFormat.format(DateChooser.getDate()));

                    int i = ps.executeUpdate();

                    if (i >= 1) {
                        JOptionPane.showMessageDialog(null, "Time Table Updated Successfully...");
                    } else {
                        JOptionPane.showMessageDialog(null, "Updation Failed to Database!!!");
                    }
                } catch (Exception e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "Updation Failed!!!");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "You Are Not Authorised!!!");
        }

    }//GEN-LAST:event_UpdateButtonMousePressed

    private void DeleteButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMousePressed

        if (role == Role.ADMIN) {
            if (!UIDTextField.getText().isEmpty()) {
                String uid = UIDTextField.getText();
                try {
                    String qry = "DELETE FROM time_table WHERE id LIKE '%" + uid + "%'";

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
                JOptionPane.showMessageDialog(null, "Time Table UID is Empty!!!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "You Are Not Authorised!!!");
        }

    }//GEN-LAST:event_DeleteButtonMousePressed

    private void ClearButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearButtonMousePressed
        clearFields();
    }//GEN-LAST:event_ClearButtonMousePressed

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

    private void SemesterLoadingButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SemesterLoadingButtonMousePressed
        ArrayList<String> semList = DBFunctions.getSemester(CourseComboBox.getSelectedItem().toString(), BranchComboBox.getSelectedItem().toString());
        if (semList.isEmpty()) {
            semList.add("Select");
        }
        SemesterComboBox.setModel(new DefaultComboBoxModel<>(semList.toArray(new String[0])));
    }//GEN-LAST:event_SemesterLoadingButtonMousePressed

    private void CourseLoadingButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CourseLoadingButtonMousePressed
        ArrayList<String> courses = DBFunctions.loadCourses();
        if (courses.isEmpty()) {
            courses.add("Select");
        }
        CourseComboBox.setModel(new DefaultComboBoxModel<>(courses.toArray(new String[0])));
    }//GEN-LAST:event_CourseLoadingButtonMousePressed

    private void SubLoadingButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubLoadingButtonMousePressed
        ArrayList<String> subjList = DBFunctions.getSubjects(CourseComboBox.getSelectedItem().toString());
        if (subjList.isEmpty()) {
            subjList.add("Select");
        }
        SubjectComboBox.setModel(new DefaultComboBoxModel<>(subjList.toArray(new String[0])));
    }//GEN-LAST:event_SubLoadingButtonMousePressed

    private void FacultyLoadingButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacultyLoadingButtonMousePressed
        ArrayList<String> facList = DBFunctions.getFaculty(CourseComboBox.getSelectedItem().toString());
        if (facList.isEmpty()) {
            facList.add("Select");
        }
        FacultyComboBox.setModel(new DefaultComboBoxModel<>(facList.toArray(new String[0])));
    }//GEN-LAST:event_FacultyLoadingButtonMousePressed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new FacultySubjectIssueForm(role).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JComboBox<String> BranchComboBox;
    private javax.swing.JButton BranchLoadingButton;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JButton ClearButton;
    private javax.swing.JComboBox<String> CourseComboBox;
    private javax.swing.JButton CourseLoadingButton;
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JComboBox<String> DayComboBox;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JComboBox<String> FacultyComboBox;
    private javax.swing.JButton FacultyLoadingButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField SectionTextField;
    private javax.swing.JComboBox<String> SemesterComboBox;
    private javax.swing.JButton SemesterLoadingButton;
    private javax.swing.JButton SubLoadingButton;
    private javax.swing.JComboBox<String> SubjectComboBox;
    private javax.swing.JComboBox<String> TimeComboBox;
    private javax.swing.JTextField TimeTextField;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JTextField UIDTextField;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

}