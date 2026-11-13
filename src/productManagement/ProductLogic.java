package productManagement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import dbConnection.DB_Connection;

public class ProductLogic {
	
	Scanner sc = new Scanner(System.in);
	
	String create = "create table productdetails("
			+ "productid int primary key,"
			+ "productname varchar(150),"
			+ "productprice double, "
			+ "qty int,"
			+ "dates date"
			+ ")";
	
	DB_Connection call = new DB_Connection();
	Connection con = call.dbConnection();
	
	public void createTable() {
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate(create);
			System.out.println("Table created successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
				}
	
	String insert = "insert into productdetails(productid,productname,productprice,qty,dates) values (?,?,?,?,?) ";
	
	public void insertTable() {
		
		System.out.println("---Add Product details---");
		System.out.println("Enter product id");
		int productid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter product name");
		String productname=sc.nextLine();
		System.out.println("Enter product price");
		double productprice=sc.nextDouble();
		System.out.println("Enter your qty");
		int qty=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter dates");
		String date=sc.nextLine();
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, productid);
			ps.setString(2, productname);
			ps.setDouble(3, productprice);
			ps.setInt(4, qty);
			ps.setString(5, date);
			int row = ps.executeUpdate(); //1
			if(row == 1) {
				System.out.println(row + " product added");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	String displayall = "select * from productdetails";
	
	public void viewalldetails() {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(displayall);
			
			while(rs.next()) {
				System.out.println("product id : " + rs.getInt("productid") + ", product name : " + rs.getString("productname") + 
						", product price : " + rs.getDouble("productprice") + ", product qty : " + rs.getInt("qty") + ", Date : "
						+ rs.getString("dates"));
			}
			
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	String displaybyid = "select * from productdetails where productid = ? ";
	
	public void viewdetails() {
		System.out.println("Entere u r productid ");
		int productid = sc.nextInt();
		
		try {
			PreparedStatement ps = con.prepareStatement(displaybyid);
			ps.setInt(1, productid);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("product id:"+rs.getInt("productid")
				  +",product name:"+rs.getString("productname")+
				  ",product price:"+rs.getDouble("productprice")
				  +",qty:"+rs.getDouble("qty")+",order date:"+rs.getString("dates"));
			}else {
				System.out.println("not present product");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}		
	}
	
	String update="update productdetails set productname=?,productprice=?,qty=?,dates=?"
						+ "where productid=?";
	
	public void updatedetials() {
		System.out.println("update product details by using product id");
		System.out.println("enter your product id");
		int productid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your product name");
		String productname=sc.nextLine();
		System.out.println("enter your product price");
		double price=sc.nextDouble();
		System.out.println("Enter product qty");
		int qty=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter product order date");
		String date=sc.nextLine();
		
		try {
			PreparedStatement ps= con.prepareStatement(update);
			ps.setString(1, productname);
			ps.setDouble(2, price);
			ps.setInt(3, qty);
			ps.setString(4, date);
	        ps.setInt(5, productid);
	       int row =ps.executeUpdate();
	       if(row==1) {
	    	   System.out.println("product detials is updated");
	       }else {
	    	   System.out.println(productid+" product id is not present in table");
	       }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	String delete="delete from productdetails where productid=?";

	public void deleteproduct() {
		System.out.println("--delete product details using by id--");
		System.out.println("Enter your product id");
		int productid=sc.nextInt();
		try {
			PreparedStatement ps=con.prepareStatement(delete);
			ps.setInt(1, productid);
			int row=ps.executeUpdate();
			if(row==1) {
				System.out.println(productid+" product id is deleted successfully");
			}else {
				System.out.println("this "+productid+" not present in the database");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		}
	}
}





