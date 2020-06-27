package com.dxc.services;
import java.util.List;

import com.dxc.pojos.Book;
import com.dxc.pojos.User;

public interface IAdminService {
	public boolean authenticate(String username,String password);
	public void addBook(Book b);
	public void deleteBook(int d);
	public void issuedBook(int uid);
	public void getUserBalance(int i);
	public void deleteUser(int i1);
	public void closeConnection();
}
