package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.User;

public class Registration {
	static Scanner s=new Scanner(System.in);

	 public static User getInfo() {
		Random random=new Random();
		 System.out.println("Enter the details of User");
		 
		 User user=new User();
		
		 System.out.println("Enter First Name :");
		 user.setFirstName(s.next());
		 System.out.println("Enter Last Name :");
		 user.setLastName(s.next());
		 System.out.println("Enter Aadhar Card Number :");
		 user.setAadharCardNo(s.nextLong());
		 System.out.println("Enter Account type :");
		 user.setAccountType(s.next());
		 System.out.println("Enter Pan Card Number :");
		 user.setPanCardNo(s.nextLong());
		 System.out.println("Enter Phone Number :");
		 user.setPanCardNo(s.nextLong());
		 System.out.println("Enter Address :");
		 user.setAddress(s.next());
		 System.out.println("Enter balance :");
		 user.setBalance(s.nextDouble());
		 System.out.println("Enter password :");
		 user.setPassword(s.next()); 
		 
		 user.setAccountNo(random.nextInt(1000000000));
		 System.out.println(user.getAccountNo());
			 
		 return user;	 
	 }
	 
	 public static void registratino() {
	
	try {
		
		FileInputStream fileInputStream=new FileInputStream("F:\\JavaPrograms\\Users.txt");
		ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
		ArrayList<User> userList=(ArrayList<User>)objectInputStream.readObject();
		
		
		userList.add(getInfo());

		FileOutputStream fileOutputStream=new FileOutputStream("F:\\JavaPrograms\\Users.txt");
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);

		objectOutputStream.writeObject(userList);
		
		//objectInputStream.close();
		//objectOutputStream.close();

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	 Login l=new Login();
		l.login();
	
	 }
	 
	 
			
}
