import cash.Account;
import java.util.Scanner;
public class A {

	public static void main(String[] args) {
	int cnt=0,num,amt;
Scanner sc=new Scanner(System.in);
System.out.println("enter size of array");
int size=sc.nextInt();
Account[] arr=new Account[size];
for(int i=0;i<size;i++)
{
	arr[i]=new Account();
}
while(true)
{
System.out.println("Enter 1 for add account");
System.out.println("Enter 2 for account detail");
System.out.println("Enter 3 for deposit");
System.out.println("Enter 4 for withdraw");
 int choice=sc.nextInt();
switch(choice)
{
case 1:arr[cnt].accept();
       cnt++;
       break;
case 2:for(int i=0;i<cnt;i++)
{
	arr[i].display();
}
System.out.println();
break;
case 3:System.out.println("enter account number to deposit");
       num=sc.nextInt();
       System.out.println("enter amount to be deposited");
       amt=sc.nextInt();
       for(int i=0;i<cnt;i++) {
    	   if(arr[i].getAnumber()==num)
    	   {
    		   arr[i].deposit(amt);
    	   }
       }
break;
case 4 :System.out.println("enter account number to withdraw");
        num=sc.nextInt();
        System.out.println("enter amount to be withdraw");
        amt=sc.nextInt();
        for(int i=0;i<cnt;i++) {
	        if(arr[i].getAnumber()==num)
	       {
		      arr[i].withdraw(amt);
	       }
}
break;
}
}
	}
}
	


