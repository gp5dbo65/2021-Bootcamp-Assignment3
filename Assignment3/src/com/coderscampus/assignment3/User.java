/***************************************************************************/
/* May 2021 Java Bootcamp                                                  */
/*                                                                         */
/* Assignment #3 - User Validation with CSV file                           */
/* Author: Dave Otis                                                       */
/* Date: May 17, 2021                                                      */
/*                                                                         */
/* This is the User POJO (Plain Old Java Object) class that will be used   */
/* to instantiate the User's login information to check against when a     */
/* user logs on to the application.                                        */
/***************************************************************************/
package com.coderscampus.assignment3;

public class User {
	private String username;
	private String password;
	private String name;
	
	// 1-Argument String Array Constructor for the User object
	public User(String[] userInfo) {
		this.username = userInfo[0];
		this.password = userInfo[1];
		this.name = userInfo[2];
	}	
	// 3-Argument Constructor for the User object
	public User(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
	}
	// 2-Argument Constructor for the User object
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.name = null;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Override of the toString method to format the output of the User Object
	@Override
	public String toString() {
		return "User : username=" + username + ", password=" +
				password + ", name=" + name;
	}
} //end of User class
