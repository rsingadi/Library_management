package com.dxc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.pojos.Book;
import com.dxc.pojos.User;

public class AdminDaoImpl implements IAdminDao{
	private static Connection conn;
	static {
	 try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","rash");
			System.out.println("connected to database");
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	}

	
	public boolean authenticate(String username, String password)
	{
		try
		{

			 Statement stmt = conn.createStatement();
			 ResultSet rset = stmt.executeQuery("select username,password from administrator");
			
			 while(rset.next())
			 {
				 if(rset.getString(1).equals(username) && rset.getString(2).equals(password))
				 {
					 return true;
				 }
				 break;
			 }
		}
		catch (Exception e) 
		{
			System.out.println("Authentication Error Occured!!!");
			e.printStackTrace();
		}
		return false;
	}
	
		
	
	
	public void addBook(Book b) {
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("insert into book values(?,?,?,?)");
		pstmt.setInt(1, b.getId());
		pstmt.setString(2,b.getName());
		pstmt.setString(3, b.getAuthor());
		pstmt.setInt(4, b.getQuantity());
		pstmt.execute();
		}
		catch(Exception e)
		{
			 e.printStackTrace();
	}
	
	}
	public void deleteBook(int d)
	{
	PreparedStatement pstmt;
	try {
		pstmt = conn.prepareStatement("delete from book where id=?");
	    pstmt.setInt(1,d);
	    pstmt.executeUpdate();
	    System.out.println("deleted book");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	}	
	public void issuedBook(int uid)
	{
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("select issuedbook from user where uid=?");
		    pstmt.setInt(1,uid);
		    ResultSet rset=pstmt.executeQuery();
			   if(rset.next())
			   {
			   System.out.println(rset.getString(1));
			   }
			   else
			   {
				   System.out.println("user has not issued any books");
			   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void getUserBalance(int i)
	{
		try
		{

			Statement stmt = conn.createStatement();
			 PreparedStatement pstmt = conn.prepareStatement("select balance from user where uid=?");
			  
			 pstmt.setInt(1,i);
			  
			  ResultSet rset = pstmt.executeQuery();
			  
			  while(rset.next())
			  {
				  System.out.println(rset.getInt(1));
			  }
			  
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void deleteUser(int i1) {
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("delete from user where uid=?");
		    pstmt.setInt(1,i1);
		    pstmt.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
	
	public void closeConnection()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	
