package com.dxc.presentation;

import java.util.*;

import com.dxc.dao.AdminDaoImpl;
import com.dxc.dao.IAdminDao;
import com.dxc.dao.IUserDao;
import com.dxc.dao.UserDaoImpl;
import com.dxc.pojos.Book;
import com.dxc.pojos.User;

public class Library {

	public static void main(String[] args) {
		IAdminDao adminservice=new AdminDaoImpl();
		IUserDao userservice=new UserDaoImpl();
		Scanner sc=new Scanner(System.in);
		int choice,ch,cho;
		while(true)
		{
		System.out.println("\n*********LIBRARY********\n");
		System.out.println("1.to login as admin");
		System.out.println("2.to login as user");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
		String username,password;
		System.out.print("Enter name\n");
		username=sc.next();
		System.out.println("Enter Password");
		password=sc.next();
		boolean b=adminservice.authenticate(username, password);
		if(b)
			System.out.println("admin logged in successfully");
		else
			System.out.println("invalid admin");
		while(b)
		{
			System.out.println("enter your choice");
			System.out.println("-------------------");
			System.out.println("1.add book to library");
			System.out.println("2.delete book from library");
			System.out.println("3.get list of book issued by particular user");
			System.out.println("4.get balance amount of particular user");
			System.out.println("5.delete user account from library");
			System.out.println("6.to exit\n");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:System.out.println("enter book id");
			       System.out.println("enter book name");
			       System.out.println("enter author name");
			       System.out.print("enter quantity");
			       adminservice.addBook(new Book(sc.nextInt(), sc.next(),sc.next(),sc.nextInt()));
			       break;
			case 2:System.out.println("enter book id");
		           int d=sc.nextInt();
		           adminservice.deleteBook(d);
		           break;
			case 3:System.out.println("enter userid to get issued books of particular user");
				   int uid=sc.nextInt();
				   adminservice.issuedBook(uid);
				   break;
			case 4:System.out.println("enter userid to get balance amount of particular user");
			 int i=sc.nextInt();
			 adminservice.getUserBalance(i);
			 User.display();
				   break;
			case 5:System.out.println("delete particular user account from user table");
			       int i1=sc.nextInt();
			       adminservice.deleteUser(i1);
			       break;
			case 6:adminservice.closeConnection();
			System.out.println("connection closed");
		       System.exit(0);
			    
			}	
		}
	break;
		
		
	
		   case 2:
			String username1,password1;
			System.out.print("Enter Username");
			username1=sc.next();
			System.out.println("Enter Password");
			password1=sc.next();
			boolean b1=userservice.authenticate(username1, password1);
			if(b1)
				System.out.println("user logged in successfully");
			else
				System.out.println("invalid admin");
			while(b1) {
			System.out.println("enter your choice....");
			System.out.println("1.issue book from library");
			System.out.println("2.get list of books by particular author");
			System.out.println("3.check available balance in library account");
			System.out.println("4.to exit");
			cho=sc.nextInt();
			switch(cho)
			{
			case 1:
				 userservice.issueBook();
			       System.out.println();
			       break;
			case 2:System.out.println("enter author name");
			String a=sc.next();
			List<Book> l1=userservice.getBook(a);
			
		        break;
			case 3:System.out.println("enter user id to check balance");
			int i=sc.nextInt();
			userservice.getUserBalance(i);
			//User.balance();
			case 4:userservice.closeConnection();
			System.out.println("connection closed");
		       System.exit(0);
			}	
			}
			break;
		}
		}

}
}




