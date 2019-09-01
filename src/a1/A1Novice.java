package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int numOfCustomers = scan.nextInt();
		String[] output = new String[numOfCustomers];
		
		for (int i = 0; i < numOfCustomers; i++) {
			String firstName = scan.next();
			String lastName = scan.next();
			int numOfItems = scan.nextInt();
			double totalCost = 0.0;
			
			for (int j = 0; j < numOfItems; j++) {
				int quantity = scan.nextInt();
				scan.next();
				double price = scan.nextDouble();
				totalCost += quantity * price;
			}
			
			String costAsString = String.format("%.2f", totalCost);
			output[i] = firstName.charAt(0) + ". " + lastName + ": " + costAsString;
		}
		
		scan.close();
		
		for (int i = 0; i < numOfCustomers; i++) {
			System.out.println(output[i]);
		}
	}
}
