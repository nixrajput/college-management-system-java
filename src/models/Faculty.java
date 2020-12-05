package models;

/**
 *
 * @author nixrajput
 */
public class Faculty {

    private String regNo;
    private String name;
    private String father_name;
    private String sex;
    private String dob;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String address;
    private byte[] photo;
    private String qualifications;
    private String institution;
    private String designation;
    private String experience;
    private String branch;
    private String date_joined;

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

    public String getUsername() {
        return username;
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

    public String getExperience() {
        return experience;
    }

    public String getBranch() {
        return branch;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public Faculty(String regNo, String name, String father_name, String sex,
            String dob, String email, String phone, String username,
            String password, String address, byte[] photo, String qualifications,
            String institution, String designation, String experience,
            String branch, String date_joined) {
        this.regNo = regNo;
        this.name = name;
        this.father_name = father_name;
        this.sex = sex;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.address = address;
        this.photo = photo;
        this.qualifications = qualifications;
        this.institution = institution;
        this.designation = designation;
        this.experience = experience;
        this.branch = branch;
        this.date_joined = date_joined;
    }
}
