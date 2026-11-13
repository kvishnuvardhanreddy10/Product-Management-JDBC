package productManagementForOnlineShopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import dbConnection.DB_Connection;

public class ProductLogic {

	Scanner sc = new Scanner(System.in);

    String create = "create table product("
            + "product_id int primary key,"
            + "product_name varchar(100),"
            + "price double,"
            + "quantity int"
            + ")";

    DB_Connection call = new DB_Connection();
    Connection con = call.dbConnection3();
    
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
    
    String insert = "insert into product (product_id, product_name, price, quantity) values (?, ?, ?, ?)";
    
    public void insertTable() {
    	
    	System.out.println("---Add Product Details---");

        System.out.println("Enter product id");
        int product_id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter product name");
        String product_name = sc.nextLine();

        System.out.println("Enter product price");
        double price = sc.nextDouble();

        System.out.println("Enter product quantity");
        int quantity = sc.nextInt();
        
        try {
			PreparedStatement ps = con.prepareStatement(insert);
			
			ps.setInt(1, product_id);
			ps.setString(2, product_name);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            
            int row = ps.executeUpdate();
            
            if(row == 1) {
            	System.out.println("Product added successfully");
            }
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
        
        
    }
}
