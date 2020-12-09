package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import models.Branch;
import models.TimeTable;

/**
 *
 * @author nixrajput
 */
public class DBFunctions {

    static Connection conn = new DBConnection().connect();

    public static ArrayList<String> loadCourses() {
        ArrayList<String> courseList = new ArrayList<>();
        try {
            String sql_query = "SELECT * FROM course";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql_query);
            while (rs.next()) {
                courseList.add(rs.getString("title"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return courseList;
    }

    public static ArrayList<Branch> loadBranches(String course) {
        ArrayList<Branch> branchList = new ArrayList<>();
        try {
            String sql_query = "SELECT * FROM branch WHERE course LIKE '%" + course + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql_query);
            Branch branch;
            while (rs.next()) {
                branch = new Branch(rs.getString("course"), rs.getString("title"), rs.getString("initial"));
                branchList.add(branch);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return branchList;
    }

    public static Double getTotalFees(String branch) {
        Double fees = 0.0;
        try {
            String sql_query = "SELECT * FROM branch WHERE title LIKE '%" + branch + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql_query);
            if (rs.next()) {
                fees = Double.parseDouble(rs.getString("tution_fees"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return fees;
    }

    public static ArrayList<String> getSemester(String course, String branch) {
        ArrayList<String> sem = new ArrayList<>();
        try {
            String sql_query = "SELECT * FROM semester WHERE course LIKE '%" + course + "%' "
                    + "AND branch LIKE '%" + branch + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql_query);
            while (rs.next()) {
                sem.add(rs.getString("title"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sem;
    }

    public static ArrayList<String> getSubjects(String course) {
        ArrayList<String> subjectList = new ArrayList<>();
        try {
            String sql_query = "SELECT * FROM subject WHERE course LIKE '%" + course + "%'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql_query);
            while (rs.next()) {
                subjectList.add(rs.getString("title"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return subjectList;
    }

    public static ArrayList<String> getFaculty(String course) {
        ArrayList<String> facList = new ArrayList<>();
        try {
            String sql_query = "SELECT * FROM faculty WHERE course LIKE '%" + course + "%'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql_query);
            while (rs.next()) {
                facList.add(rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return facList;
    }

    public static ArrayList<TimeTable> getTimeTables(String course) {
        ArrayList<TimeTable> timeTables = new ArrayList<>();
        try {
            String sql_query = "SELECT * FROM time_table";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql_query);
            while (rs.next()) {
                TimeTable timeTable = new TimeTable(rs.getString("id"), rs.getString("subject"), rs.getString("faculty"),
                        rs.getString("course"), rs.getString("branch"), rs.getString("semester"), rs.getString("section"),
                        rs.getString("day"), rs.getString("time"), rs.getString("timestamp"));
                timeTables.add(timeTable);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return timeTables;
    }
}
