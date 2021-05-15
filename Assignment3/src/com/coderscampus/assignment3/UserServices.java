package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserServices {
	
	//This method is used to read the user login information from a text file and load
	//that information into an User Array.
	public static void loadUsersArray(User[] users) throws FileNotFoundException, IOException {
		String fileName = "Data.txt";
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = null;
			int i = 0;	//index for User array
			while ((line = reader.readLine()) != null) {
				users[i] = new User(line.split(","));
//				System.out.println(users[i]);
				i++;
			} //end of while loop
		} //end of try block
		finally {
			if (reader != null)
			reader.close();
		}
	} //end of loadUsersArray method
	
	public static String validateUser (String username, String password) {
		for (User user : UserLoginApplication.users) {
			if (user.getUsername().equalsIgnoreCase(username) &&
				user.getPassword().equals(password)) {
				return user.getName();	//match found, return userName
			}
		} //end of for-each loop
		return null;					//no match found, return null
	} //end of validateUser method
} //end of UserServices class
