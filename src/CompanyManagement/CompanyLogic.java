package CompanyManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import dbConnection.DB_Connection;

public class CompanyLogic {
	
	String create = "create table employee("
            + "emp_id int primary key,"
            + "emp_name varchar(50),"
            + "salary double,"
            + "department varchar(50)"
            + ")";
	
	DB_Connection call = new DB_Connection();
    Connection con = call.dbConnection2();
    
    Scanner sc = new Scanner(System.in);
    
    public void createTable() {
    	 try {
             Statement st = con.createStatement();
             st.executeUpdate(create);

             System.out.println("Table created successfully");

         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
     }
    
    String insert = "insert into employee(emp_id,emp_name,salary,department) values(?,?,?,?)";
    
    public void insertTable() {

        System.out.println("Add Employee Details");

        try {

            PreparedStatement ps = con.prepareStatement(insert);

            for(int i = 1; i <= 3; i++) {

                System.out.println("Enter employee id");
                int emp_id = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter employee name");
                String emp_name = sc.nextLine();

                System.out.println("Enter employee salary");
                double salary = sc.nextDouble();
                sc.nextLine();

                System.out.println("Enter employee department");
                String department = sc.nextLine();

                ps.setInt(1, emp_id);
                ps.setString(2, emp_name);
                ps.setDouble(3, salary);
                ps.setString(4, department);

                int row = ps.executeUpdate();

                if(row == 1) {
                    System.out.println("Employee inserted successfully");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    String display = "select emp_id,emp_name from employee";

    public void viewdetails() {

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(display);

            while(rs.next()) {

                System.out.println("Employee ID : "
                        + rs.getInt("emp_id")
                        + ", Employee Name : "
                        + rs.getString("emp_name"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
