package com.greatlearning.test;

import java.util.Scanner;
import com.greatlearning.model.Employee;
import com.greatlearning.service.CredentialService;
import com.greatlearning.service.CredentialServiceImpl;

public class ITSupportTest {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("IT Support welcomes new user!!!");
		System.out.println("Enter your First name: ");
		String fName = sc.next();
		System.out.println("Enter your Last name: ");
		String lName = sc.next();
		Employee newUser = new Employee(fName,lName);
		CredentialService cs = new CredentialServiceImpl();
		
		System.out.println("\nPlease select your department from the following: "+"\n1.Technical\n2.Admin\n3.Human Resource\n4.Legal");

		String dept = "";
		int option = sc.nextInt();
		switch(option) {
		case 1: {
			dept = "Technical";
			break;
		}
		case 2: {
			dept = "Admin";
			break;
		}
		case 3: {
			dept = "Human Resource";
			break;
		}
		case 4: {
			dept = "Legal";
			break;
		}
		default:
			System.out.println("Enter a valid option!!!");
		}
		
		String emailAddress = cs.generateEmailAddress(fName.toLowerCase(), lName.toLowerCase(), dept.toLowerCase());
		String password = cs.generatePassword();
		cs.showCredentials(newUser, emailAddress, password);
		System.out.println("\nHave a great time ahead!");
		sc.close();
	}

}
