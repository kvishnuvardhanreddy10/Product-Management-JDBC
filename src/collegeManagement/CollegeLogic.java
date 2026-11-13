package collegeManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import dbConnection.DB_Connection;

public class CollegeLogic {

	String create = "create table student("
			+ "id int primary key,"
			+ "name varchar(50),"
			+ "age int,"
			+ "course varchar(50)"
			+ ")";
	
	DB_Connection call = new DB_Connection();
    Connection con = call.dbConnection1();

    public void createTable() {
        try {
            Statement st = con.createStatement();
            st.executeUpdate(create);
            System.out.println("Table created successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    String insert = "insert into student(id,name,age,course) values(?,?,?,?)";

    public void insertTable() {

        try {
            PreparedStatement ps = con.prepareStatement(insert);

            ps.setInt(1, 1);
            ps.setString(2, "Vishnu");
            ps.setInt(3, 22);
            ps.setString(4, "Java");

            int row = ps.executeUpdate();

            if(row == 1) {
                System.out.println("Student inserted successfully");
            }

            ps.setInt(1, 2);
            ps.setString(2, "Venkat");
            ps.setInt(3, 23);
            ps.setString(4, "Python");

            row = ps.executeUpdate();

            if(row == 1) {
                System.out.println("Student inserted successfully");
            }

            ps.setInt(1, 3);
            ps.setString(2, "Rahul");
            ps.setInt(3, 22);
            ps.setString(4, "Java Full Stack");

            row = ps.executeUpdate();

            if(row == 1) {
                System.out.println("Student inserted successfully");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
