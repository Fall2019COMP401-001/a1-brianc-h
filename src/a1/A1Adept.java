package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numOfItems = scan.nextInt();
		String[] itemNames = new String[numOfItems];
		double[] itemCosts = new double[numOfItems];
		
		for (int i = 0; i < numOfItems; i++) {
			itemNames[i] = scan.next();
			itemCosts[i] = scan.nextDouble();
		}
		
		int numOfCustomers = scan.nextInt();
		
		String smallestSpender = "";
		double smallestCost = Double.MAX_VALUE;
		
		String largestSpender = "";
		double largestCost = 0.0;
		
		double cumulativeCost = 0.0;
		
		for (int i = 0; i < numOfCustomers; i++) {
			String firstName = scan.next();
			String lastName = scan.next();
			int numOfPurchases = scan.nextInt();
			double totalCost = 0.0;
			for (int j = 0; j < numOfPurchases; j++) {
				int quantity = scan.nextInt();
				String item = scan.next();
				
				double cost = getCost(item, numOfItems, itemNames, itemCosts);
				totalCost += cost * quantity;
			}
			
			cumulativeCost += totalCost;
			
			if (totalCost > largestCost) {
				largestSpender = firstName + " " + lastName;
				largestCost = totalCost;
			}
			
			if (totalCost < smallestCost) {
				smallestSpender = firstName + " " + lastName;
				smallestCost = totalCost;
			}
		}
		
		scan.close();
		
		System.out.println("Biggest: " + largestSpender + 
				" (" + String.format("%.2f", largestCost) + ")");
		System.out.println("Smallest: " + smallestSpender + 
				" (" + String.format("%.2f", smallestCost) + ")");
		System.out.println("Average: " + String.format("%.2f", cumulativeCost/numOfCustomers));
	}
	
	public static double getCost(String id, int numOfItems, String[] items, double[] costs) {
		for (int i = 0; i < numOfItems; i++) {
			if (id.equals(items[i])) {
				return costs[i];
			}
		}
		return 0.0;
	}
}
