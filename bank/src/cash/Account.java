package cash;

import java.util.Scanner;

public class Account {

	private String aname;
	private int anumber;
	private double balance;
	public int getAnumber() {
		// TODO Auto-generated method stub
		return anumber;
	}
public Account()
{
	aname="rashmi";
	anumber=1234567890;
	balance=3456;
}
public Account(String aname,int anumber,double balance)
{
	this.aname=aname;
	this.anumber=anumber;
	this.balance=balance;
}
public void accept()
{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the account number");
	anumber=sc.nextInt();
    System.out.println("enter account name");  	
    aname=sc.next();
    System.out.println("enter account balance");
    balance=sc.nextDouble();
}
public void display()
{
System.out.println(aname+" "+anumber+" "+balance);
}
public void deposit(int amount)
{
	balance=balance+amount;
}
public void withdraw(int amount)
{
	balance=balance-amount;
}

}
