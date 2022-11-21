package com.bridgelabz.qa.DB_Testing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DB_Test extends Base{
	@Test
	public void getTableData() throws SQLException {
		con=this.setUp();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select *  from Persons");
		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        		int ID = rs.getInt(1);								        
                    String Name = rs.getString(2);
                    int Age = rs.getInt(3);
                    
                    System. out.println(ID+" "+Name+" "+Age);
		}
	}	
	
	//Inserting Method
	@Test
	public void insertData() throws SQLException {
		con=this.setUp();
		PreparedStatement stmt = con.prepareStatement("insert into Persons(ID,Name,Age) values(?,?,?)");
		stmt.setInt(1,4);
		stmt.setString(2, "Aftab");
		stmt.setInt(3, 25);
		stmt.executeUpdate();
		getTableData();
	}
	
	//Updating Method
	@Test
	public void updateData() throws SQLException {
		con=this.setUp();
		PreparedStatement stmt = con.prepareStatement("update Persons set Name='Aftab'  where ID=4 ");
		stmt.executeUpdate();
		getTableData();
	}
	
	//Deleting Method
	@Test
	public void deleteData() throws SQLException {
		con=this.setUp();
		PreparedStatement stmt = con.prepareStatement("delete from Persons where ID=2 ");
		stmt.executeUpdate();
		getTableData();
	}
}