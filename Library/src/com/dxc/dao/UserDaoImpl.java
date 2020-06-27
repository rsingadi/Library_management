package com.dxc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dxc.pojos.Book;
import com.dxc.pojos.User;

public class UserDaoImpl implements IUserDao {
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
	
	public boolean authenticate(String username1, String password1)
	{
		try
		{

			 Statement stmt = conn.createStatement();
			 ResultSet rset = stmt.executeQuery("select username,password from user1");
			
			 while(rset.next())
			 {
				 if(rset.getString(1).equals(username1) && rset.getString(2).equals(password1))
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
	public void issueBook()
	{   
		
		try {
		
		  Scanner sc2=new Scanner(System.in);
		
		  Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select * from book");
		  System.out.println("Bookid\tBookname\tAuthor\tQuantity");
		  System.out.println("---------------------------------------");						  
		  	while(rset.next())
		  	{
		  		
			  System.out.println(rset.getInt(1)+"\t"+rset.getString(2)+"\t\t"+rset.getString(3)+"\t "+rset.getInt(4));
		  	}	
		  	System.out.println();
		    System.out.println("Enter bookname to issue:");
			String s = sc2.next();
		    System.out.println("How many books needed:");
		    int n = sc2.nextInt();
		    System.out.println("enter uid");
		    int u=sc2.nextInt();
		    PreparedStatement pstmt = conn.prepareStatement("update book set quantity=quantity-? where name=?");
		    pstmt.setInt(1,n);
		    pstmt.setString(2,s);
          pstmt.execute();
		    System.out.println("How many days you want:");
		    int days = sc2.nextInt();
		    
		    PreparedStatement pstmt1 = conn.prepareStatement("update user set balance=balance-(quantity*?*5) , issuedbook=? where uid=?");
		    pstmt1.setInt(1,days);
		    pstmt1.setString(2,s);
		    pstmt1.setInt(3, u);
		    pstmt1.execute();
		    System.out.println("Book issued successfully!!");
		    
		    
		    }
	 catch (SQLException e) 
	 {
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

	
	
	
	
	
	
	public List<Book> getBook(String a)
	{
		List<Book> list=new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("select name ,author from book where author=?");
			  pstmt.setString(1,a);
			  ResultSet rset=pstmt.executeQuery();
			   if(rset.next())
			   {
				   System.out.println("book names....");
			   System.out.println(rset.getString(1));
			   }
			   else
			   {
				   System.out.println("no books");
			   }
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
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
