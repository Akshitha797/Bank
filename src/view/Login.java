package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import model.User;

public class Login {
	static Scanner s=new Scanner(System.in);

	public static void login()
	{
		
try {
	System.out.println("Login Page");
	System.out.println("Enter Account Number");
	long accNo=s.nextLong();
	System.out.println("Enter Password :");
	String pass=s.next();
	
			FileInputStream fileInputStream=new FileInputStream("F:\\JavaPrograms\\Users.txt");
			ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
			
			ArrayList<User> userList=(ArrayList<User>)objectInputStream.readObject();			
					
			User user=new User();
			int count=0;
			System.out.println(accNo);
			System.out.println(pass);
	
			for(int i=0;i<userList.size();i++)
			{
				user=userList.get(i);				
				
				if(accNo == user.getAccountNo() && pass.equals(user.getPassword()))
				{
					System.out.println("Enter your choice");
					System.out.println("1.Withdrawal \n 2.Deposit \n 3.Exit");
					int ch=s.nextInt();
				
					FileOutputStream fileOutputStream=new FileOutputStream("F:\\JavaPrograms\\Users.txt");
					ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
					
					switch(ch)
					{
					case 1:user.setBalance(withdrawal(user.getBalance()));
					objectOutputStream.writeObject(userList);
					System.out.println(user.getBalance());
					break;
						
					case 2:user.setBalance(deposit(user.getBalance())); 
					objectOutputStream.writeObject(userList);
					System.out.println(user.getBalance());
					break;
						
					case 3: System.exit(0);
					break;
					}	
					count++;
					break;
				}
				
			}
								
			if(count==0)
				System.out.println("Incorrect credentials");
			
			
			
}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	public static double withdrawal(double balance)
	{
		System.out.println("Enter amount :");
		double amount=s.nextDouble();
		
		if(amount<=balance)
			balance-=amount;
		else
			System.out.println("Insufficient balance");
		return balance;
		
	}

	
	public static double deposit(double balance)
	{
		System.out.println("Enter amount :");
		double amount=s.nextDouble();
		balance+=amount;
		return balance;
	}


}
