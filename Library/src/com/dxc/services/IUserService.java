package com.dxc.services;

import java.util.List;

import com.dxc.pojos.Book;
import com.dxc.pojos.User;

public interface IUserService {
	public boolean authenticate(String username1,String password1);
	public List<Book> getBook(String a);
	public void issueBook();
	public void getUserBalance(int i);
	public void closeConnection();
	

}
