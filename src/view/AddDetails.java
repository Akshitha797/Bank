package view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.User;

public class AddDetails {
	
	static int count=1;
	
	 public static User getInfo()
	 {
		 Scanner s=new Scanner(System.in);
		 Random random=new Random();
		 System.out.println("Enter the details of User"+count);
		 
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
		 System.out.println("Enter Balance");
		 user.setBalance(s.nextDouble());
		 System.out.println("Enter Password :");
		 user.setPassword(s.next());
		 
		 user.setAccountNo(random.nextInt(1000000000));
		 System.out.println(user.getAccountNo());
		 
		 count++;
		 
		 
		 return user;	 
	 }

	public static void main(String[] args) {

		ArrayList us=new ArrayList();
		us.add(getInfo());
		us.add(getInfo());
		//us.add(getInfo());
		//us.add(getInfo());
		//us.add(getInfo());
		
		try {
			FileOutputStream fileOutputStream=new FileOutputStream("F:\\JavaPrograms\\Users.txt");
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(us);
			
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
