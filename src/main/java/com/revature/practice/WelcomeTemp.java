package com.revature.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WelcomeTemp {

	final static int MAX_ATTEMPTS = 5;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String username = new String();
		String password = new String();
		
		Map<String, Integer> userPassword = new HashMap<String, Integer>(); 
		userPassword.put("dummyuser", new Integer(1234));
		
		
		System.out.println("Welcome to Project Zero Bank.");
		System.out.println("Please login.");
		System.out.println("Enter username:");
		username = scanner.nextLine();
		
		int uCount = 1;
		int pCount = 1;

		while (uCount<MAX_ATTEMPTS) {
			System.out.println("in uCount while");
			if (!(userPassword.containsKey(username)) && uCount != MAX_ATTEMPTS) {
				uCount++;
				System.out.println("We can't find that username. Please try again.");
				System.out.println("Please login.");
				System.out.println("Enter username:");
				username = scanner.nextLine();
			} else {
				uCount=5;
				System.out.println("Enter password:");
				password = scanner.nextLine();
				while (pCount<MAX_ATTEMPTS) {
					System.out.println("pCount before if: " + pCount);
					if (userPassword.get(username)!=Integer.parseInt(password) && pCount != MAX_ATTEMPTS) {
						System.out.println("Incorrect password. Please try again.");
						System.out.println("Enter password:");
						password = scanner.nextLine();
					} else if (userPassword.get(username)==Integer.parseInt(password)) {
						System.out.println("You entered " + username + " and " + password);
						System.exit(0);
					}
					pCount++;
				}
			}
		}
		
		System.out.println("You have entered an incorrect username and password combination too many times.");
		System.out.println("Please email help@pz.bank Project Zero Bank for help.");
		System.exit(0);
		
		
		

	}

}
