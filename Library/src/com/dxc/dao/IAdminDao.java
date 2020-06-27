package com.dxc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dxc.pojos.Book;
import com.dxc.pojos.User;

public interface IAdminDao {

	public boolean authenticate(String username, String password);

	public void addBook(Book b);
	public void deleteBook(int d);
	public void issuedBook(int uid);
	public void getUserBalance(int i);
	public void deleteUser(int i1);
	public void closeConnection();
}
