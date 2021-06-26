package model.application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		String name = sc.next();
		System.out.print("Initial balance: ");
		sc.next();
		Double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();

		Account acc = new Account(number, name, balance, withdrawLimit);
		try {
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double value = sc.nextDouble();
		
			acc.withdraw(value);

		}
		catch(DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		finally {
			sc.close();
		}
	}

}
