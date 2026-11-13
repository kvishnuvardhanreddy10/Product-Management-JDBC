package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {

	String url = "jdbc:mysql://localhost:3306/ProductManagementJDBC";
	String username = "root";
	String password = "root";
	
	String url1 = "jdbc:mysql://localhost:3306/CollegeDB";
	
	String url2 = "jdbc:mysql://localhost:3306/CompanyDB";
	
	String url3 = "jdbc:mysql://localhost:3306/shopping_db";
	
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
	
	public Connection dbConnection2() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url2, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public Connection dbConnection3() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url3, username, password);
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
		System.out.println(dbconnection.dbConnection2());
		System.out.println(dbconnection.dbConnection3());
	}
}
