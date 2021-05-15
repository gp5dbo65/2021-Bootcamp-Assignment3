/***************************************************************************/
/* May 2021 Java Bootcamp                                                  */
/*                                                                         */
/* Assignment #3 - User Validation with CSV file                           */
/* Author: Dave Otis                                                       */
/* Date: May 17, 2021                                                      */
/*                                                                         */
/* The purpose of this assignment is to mimic a user login from a Java     */
/* console application.                                                    */
/*                                                                         */
/* The app will read a text file that contains user login information and  */
/* load the data into an User array.                                       */
/*                                                                         */
/* Then the app will prompt the user to enter their login information.     */
/* They are given only 5 tries to successfully log in or they are locked   */
/* out of the system.                                                      */
/*                                                                         */
/*                                                                         */
/***************************************************************************/
package com.coderscampus.assignment3;

//import java.io.BufferedReader;
import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {
	//class variables and constants
	static final int MAX_TRIES = 5;
	static final String EMAIL_PROMPT = "Enter your email: ";
	static final String PASSWORD_PROMPT = "Enter your password: ";
	static final String INVALID_PROMPT = "Invalid login, please try again";
	static final String LOCKOUT_MSG = "Too many failed login attempts, you are now locked out.";
	
	public static User[] users = new User[4];

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//Call the method that will load the users into the User array
		UserServices.loadUsersArray(users);
		
		Scanner scanner = null;
		int loginAttempts = 0;
		boolean validLogin = false;
		

		try {
			scanner = new Scanner(System.in);
			
			while(!validLogin && loginAttempts < 5) {
				System.out.println(EMAIL_PROMPT);
				String username = scanner.nextLine();
				System.out.println(PASSWORD_PROMPT);
				String password = scanner.nextLine();
				
				String name = UserServices.validateUser(username, password);
				if (name != null) {
					System.out.println("Welcome: " + name);
					validLogin = true;
				} else {
					loginAttempts++;
				 	if (loginAttempts >= 5) {
				 		System.out.println(LOCKOUT_MSG);
				 	} else {
				 		System.out.println(INVALID_PROMPT);
				 	}
				}
			} //end of while loop
		} //end of try block
		finally {
			if (scanner != null) {
				scanner.close();
			}
		} //end of finally block
		

	} //end of main method
} //end of UserLoginApplication class
