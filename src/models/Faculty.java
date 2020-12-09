package models;

/**
 *
 * @author nixrajput
 */
public class Faculty {

    private final String regNo;
    private final String name;
    private final String father_name;
    private final String sex;
    private final String dob;
    private final String email;
    private final String phone;
    private final String password;
    private final String address;
    private final byte[] photo;
    private final String qualifications;
    private final String institution;
    private final String designation;
    private final int experience;
    private final String course;
    private final String department;
    private final String date_joined;
    private final String date_updated;

    public String getRegNo() {
        return regNo;
    }

    public String getName() {
        return name;
    }

    public String getFather_name() {
        return father_name;
    }

    public String getSex() {
        return sex;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public String getQualifications() {
        return qualifications;
    }

    public String getInstitution() {
        return institution;
    }

    public String getDesignation() {
        return designation;
    }

    public int getExperience() {
        return experience;
    }

    public String getCourse() {
        return course;
    }

    public String getDepartment() {
        return department;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public String getDate_updated() {
        return date_updated;
    }

    public Faculty(String regNo, String name, String father_name, String sex,
            String dob, String email, String phone, String password,
            String address, byte[] photo, String qualifications,
            String institution, String designation, int experience, String course,
            String department, String date_joined, String date_updated) {
        this.regNo = regNo;
        this.name = name;
        this.father_name = father_name;
        this.sex = sex;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.photo = photo;
        this.qualifications = qualifications;
        this.institution = institution;
        this.designation = designation;
        this.experience = experience;
        this.course = course;
        this.department = department;
        this.date_joined = date_joined;
        this.date_updated = date_updated;
    }
}
