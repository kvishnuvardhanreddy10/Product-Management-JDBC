package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {

	String url = "jdbc:mysql://localhost:3306/ProductManagementJDBC";
	String username = "root";
	String password = "root";
	
	String url1 = "jdbc:mysql://localhost:3306/CollegeDB";
	
	public Connection dbConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return con;
	}
	
	public Connection dbConnection1() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url1, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public static void main(String[] args) {
		DB_Connection dbconnection = new DB_Connection();
		System.out.println(dbconnection.dbConnection());
		System.out.println(dbconnection.dbConnection1());
	}
}
