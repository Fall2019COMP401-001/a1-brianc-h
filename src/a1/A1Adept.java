package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numOfItems = scan.nextInt();
		String[] itemNames = new String[numOfItems];
		double[] itemCosts = new double[numOfItems];
		
		// load item names and costs into arrays
		for (int i = 0; i < numOfItems; i++) {
			itemNames[i] = scan.next();
			itemCosts[i] = scan.nextDouble();
		}
		
		int numOfCustomers = scan.nextInt();
		
		// keep track of smallest/largest spender and cost
		String smallestSpender = "";
		double smallestCost = Double.MAX_VALUE;
		
		String largestSpender = "";
		double largestCost = 0.0;
		
		// keeps track of all money spent by all customers
		double cumulativeCost = 0.0;
		
		
		
		
		for (int i = 0; i < numOfCustomers; i++) {
			// loads relevant information
			String firstName = scan.next();
			String lastName = scan.next();
			int numOfPurchases = scan.nextInt();
			double totalCost = 0.0;
			for (int j = 0; j < numOfPurchases; j++) {
				int quantity = scan.nextInt();
				String item = scan.next();
				
				// looks up item cost to get total cost
				double cost = getCostOfItem(item, itemNames, itemCosts);
				totalCost += cost * quantity;
			}
			
			cumulativeCost += totalCost;
			
			// compares total cost to current smallest/largest cost
			// replaces values if it is smaller/larger
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
		
		// print out largest and smallest spenders
		System.out.println("Biggest: " + largestSpender 
				+ " (" + String.format("%.2f", largestCost) + ")");
		System.out.println("Smallest: " + smallestSpender 
				+ " (" + String.format("%.2f", smallestCost) + ")");
		// print out average cost
		System.out.println("Average: " + 
				String.format("%.2f", cumulativeCost/numOfCustomers));
	}
	
	/* Method that returns of cost of an item
	 * id: item name
	 * items: array of item names
	 * costs: array of item costs
	 * items and costs are parallel arrays
	 */
	public static double getCostOfItem(String id, String[] items, double[] costs) {
		for (int i = 0; i < items.length; i++) {
			if (id.equals(items[i])) {
				return costs[i];
			}
		}
		
		// returns 0 if the item name isn't found
		return 0.0;
	}
}
