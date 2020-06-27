package com.dxc.pojos;

public class User {
	private static  int uid;
	public static int balance;
	private static String issuedbook;
	private int quantity;
	private int no_of_days;
	public User(int uid, int balance, int quantity, int no_of_days) {
		super();
		this.uid = uid;
		this.balance = balance;
		this.quantity = quantity;
		this.no_of_days = no_of_days;

	}
	public User(int id, int balance) {
		this.uid=uid;
		this.balance=balance;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public static String getIssuedbook() {
		return issuedbook;
	}
	public static void setIssuedbook(String issuedbook) {
		User.issuedbook = issuedbook;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getNo_of_days() {
		return no_of_days;
	}
	public void setNo_of_days(int no_of_days) {
		this.no_of_days = no_of_days;
	}
	public static void display() {
		System.out.println(uid+" "+balance);		
	}
	
	
	
}
