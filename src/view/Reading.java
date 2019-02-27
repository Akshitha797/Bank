package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import model.User;

public class Reading {

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		try {
			
			FileInputStream fileInputStream=new FileInputStream("F:\\JavaPrograms\\Users.txt");
			ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
			
			ArrayList<User> userList=(ArrayList<User>)objectInputStream.readObject();
					
			User user=new User();
			user=userList.get(0);
			System.out.println(user.getAccountNo());
			System.out.println(user.getPassword());
			System.out.println(user.getBalance());
			
			user=userList.get(1);
			System.out.println(user.getAccountNo());
			System.out.println(user.getPassword());
			System.out.println(user.getBalance());
			
			user=userList.get(2);
			System.out.println(user.getAccountNo());
			System.out.println(user.getPassword());
			System.out.println(user.getBalance());
			
			user=userList.get(3);
			System.out.println(user.getAccountNo());
			System.out.println(user.getPassword());
			System.out.println(user.getBalance());
			
			objectInputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
