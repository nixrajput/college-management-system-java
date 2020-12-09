package models;

/**
 *
 * @author nixrajput
 */
public class Student {

    private final String name;
    private final String rollNo;
    private final String applicationNo;
    private final String regNo;
    private final String mother_name;
    private final String mother_occupation;
    private final String address;
    private final String father_name;
    private final String father_occupation;
    private final String sex;
    private final String dob;
    private final String phone;
    private final String email;
    private final byte[] photo;
    private final String date_of_application;
    private final String course;
    private final String branch;
    private final int batch;
    private final String semester;
    private final int passing_year;
    private final boolean isHostler;
    private final boolean libraryFacility;
    private final String qualification;
    private final String university;
    private final String quota;
    private final String marks;
    private final String status;

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getMother_name() {
        return mother_name;
    }

    public String getMother_occupation() {
        return mother_occupation;
    }

    public String getAddress() {
        return address;
    }

    public String getFather_name() {
        return father_name;
    }

    public String getFather_occupation() {
        return father_occupation;
    }

    public String getSex() {
        return sex;
    }

    public String getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public String getDate_of_application() {
        return date_of_application;
    }

    public String getCourse() {
        return course;
    }

    public String getBranch() {
        return branch;
    }

    public int getBatch() {
        return batch;
    }

    public String getSemester() {
        return semester;
    }

    public int getPassing_year() {
        return passing_year;
    }

    public boolean isIsHostler() {
        return isHostler;
    }

    public boolean isLibraryFacility() {
        return libraryFacility;
    }

    public String getQualification() {
        return qualification;
    }

    public String getUniversity() {
        return university;
    }

    public String getQuota() {
        return quota;
    }

    public String getMarks() {
        return marks;
    }

    public String getStatus() {
        return status;
    }

    public Student(String name, String rollNo, String applicationNo, String regNo,
            String mother_name, String mother_occupation, String address,
            String father_name, String father_occupation, String sex, String dob,
            String phone, String email, byte[] photo, String date_of_application, String course, String branch,
            int batch, String semester, int passing_year, boolean isHostler,
            boolean libraryFacility, String qualification, String university, String quota, String marks, String status) {
        this.name = name;
        this.rollNo = rollNo;
        this.applicationNo = applicationNo;
        this.regNo = regNo;
        this.mother_name = mother_name;
        this.mother_occupation = mother_occupation;
        this.address = address;
        this.father_name = father_name;
        this.father_occupation = father_occupation;
        this.sex = sex;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.photo = photo;
        this.date_of_application = date_of_application;
        this.course = course;
        this.branch = branch;
        this.batch = batch;
        this.semester = semester;
        this.passing_year = passing_year;
        this.isHostler = isHostler;
        this.libraryFacility = libraryFacility;
        this.qualification = qualification;
        this.university = university;
        this.quota = quota;
        this.marks = marks;
        this.status = status;
    }

}
