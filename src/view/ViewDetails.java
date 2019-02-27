package view;
import java.util.Scanner;

public class ViewDetails {
	
	static Scanner s=new Scanner(System.in);
	 
	 
		public static void main(String[] args) {
		
		System.out.println("Enter your choice :");
		System.out.println("1.Registration \n 2.Login");
		int ch=s.nextInt();
		switch(ch)
		{
		case 1 :Registration r=new Registration();
		r.registratino();
		break;
			
		case 2 :Login l=new Login();
		l.login();
		break;
		}

			}

}
