package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nixrajput
 */
public class DBFunctions {

    static Connection conn = new DBConnection().connect();

    public static ArrayList<String> loadCourses() {
        ArrayList<String> courseList = new ArrayList<String>();
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

    public static ArrayList<String> loadBranches(String course) {
        ArrayList<String> branchList = new ArrayList<String>();
        try {
            String sql_query = "SELECT * FROM branch WHERE course LIKE ?";
            String cond = "%" + course + "%";
            PreparedStatement stmt = conn.prepareStatement(sql_query);
            stmt.setString(1, cond);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                branchList.add(rs.getString("title"));
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

    public static int getSemester(String branch) {
        int sem = 0;
        try {
            String sql_query = "SELECT * FROM branch WHERE title LIKE '%" + branch + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql_query);
            if (rs.next()) {
                sem = rs.getInt("semester");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sem;
    }
}
