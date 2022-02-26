package com.revature.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.NumberFormatException;

public class WelcomeTemp {
	// 5 attempts max for usernames and passwords
	final static int MAX_ATTEMPTS = 5;

	public static void main(String[] args) {

		// open scanner
		Scanner scanner = new Scanner(System.in);

		String username = new String();
		String password = new String();

		// HashMap holds test username and passwords
		Map<String, String> userPassword = new HashMap<String, String>();
		userPassword.put("dummyuser", "1234");

		System.out.println("Welcome to Project Zero Bank.");
		System.out.println("Please login.");
		System.out.println("Enter username:");
		username = scanner.nextLine();
		while(username.equals("")) {
			System.out.println("You didn't enter anything.");
			System.out.println("Please enter username:");
			username = scanner.nextLine();
		}
		// counts for login attempts
		int uCount = 1;
		int pCount = 1;

		while (uCount < MAX_ATTEMPTS) {
			if (!(userPassword.containsKey(username)) && uCount != MAX_ATTEMPTS) {
				uCount++;
				System.out.println("We can't find that username.");
				System.out.println("Please try to login again.");
				System.out.println("Enter username:");
				username = scanner.nextLine();
			} else {
				uCount = MAX_ATTEMPTS;

				System.out.println("Enter password:");
				password = scanner.nextLine();
				while (pCount < MAX_ATTEMPTS) {
					if (!(userPassword.get(username).equals(password)) && pCount != MAX_ATTEMPTS) {
						System.out.println("Incorrect password. Please try again.");
						System.out.println("Enter password:");
						password = scanner.nextLine();
					} else if (userPassword.get(username).equals(password)) {
						pCount = MAX_ATTEMPTS;
						System.out.println("You successfully logged in as " + username);
						//System.exit(0);
					}
					pCount++;
				}
			}
		}
		loggedInAsCustomer(username);
		loggedInAsEmployee(username);
		loggedInAsAdmin(username);

		scanner.close();
		System.out.println("You have entered an incorrect username and password combination too many times.");
		System.out.println("Please email help@pz.bank Project Zero Bank for help.");
		System.exit(0);

	}
	
	private static void loggedInAsCustomer(String username) {
		System.out.println("You sucessfully logged in as " + username + "(customer)");
		System.out.println("What would you like to do?");
		System.out.println("Please enter:");
		System.out.println("--> D = Deposit");
		System.out.println("--> W = Withdraw");
		System.out.println("--> T = Transfer");
	}

	private static void loggedInAsEmployee(String username) {
		System.out.println("You sucessfully logged in as " + username + "(employee)");
		System.out.println("What would you like to do?");
		System.out.println("Please enter:");
		System.out.println("--> V = View customer info");
		System.out.println("--> A = Approve open applications");
	}

	private static void loggedInAsAdmin(String username) {
		System.out.println("You sucessfully logged in as " + username + "(admin)");
		System.out.println("What would you like to do?");
		System.out.println("Please enter:");
		System.out.println("--> V = View customer info");
		System.out.println("--> D = Deposit");
		System.out.println("--> W = Withdraw");
		System.out.println("--> T = Transfer");
		System.out.println("--> A = Approve open applications");
		System.out.println("--> C = Cancel accounts");
	}

	private static void enterPassword() {

	}
}
