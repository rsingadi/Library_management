package com.dxc.services;
import java.sql.ResultSet;
import java.util.List;

import com.dxc.dao.IUserDao;
import com.dxc.dao.UserDaoImpl;
import com.dxc.pojos.Book;
import com.dxc.pojos.User;

public class UserServiceImpl implements IUserService {
private IUserDao dao=new UserDaoImpl();
	
	public boolean authenticate(String username1,String password1) 
	{
		return dao.authenticate(username1, password1);
	}
	public List<Book> getBook(String a)
	{
		 return dao.getBook(a);
	}
	public void issueBook()
	{
		dao.issueBook();
	}
	public void getUserBalance(int i)
	{
		dao.getUserBalance(i);
	}
	public void closeConnection()
	{
		dao.closeConnection();
	}
	
}