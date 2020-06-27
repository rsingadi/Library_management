package com.dxc.services;

import java.util.List;

import com.dxc.dao.AdminDaoImpl;
import com.dxc.dao.IAdminDao;
import com.dxc.pojos.Book;
import com.dxc.pojos.User;

public class AdminServiceImpl implements IAdminService {
	private IAdminDao dao=new AdminDaoImpl();
	
	public boolean authenticate(String username,String password) 
	{
		return dao.authenticate(username, password);
	}
	public void addBook(Book b) 
	{
		dao.addBook(b);
	}
	public void deleteBook(int d)
	{
		dao.deleteBook(d);
	}
	public void issuedBook(int uid)
	{
		dao.issuedBook(uid);
	}
	public void getUserBalance(int i)
	{
		dao.getUserBalance(i);
	}
	public void deleteUser(int i1)
	{
		 dao.deleteUser(i1);
	}
	public void closeConnection()
	{
		dao.closeConnection();
	}
}
