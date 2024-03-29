package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numOfItems = scan.nextInt();
		String[] itemNames = new String[numOfItems];
		int[] customerPurchases = new int[numOfItems];
		int[] itemsPurchased = new int[numOfItems];
		
		
		// load the item names into an array
		for (int i = 0; i < numOfItems; i++) {
			itemNames[i] = scan.next();
			// ignore item cost
			scan.nextDouble();
		}
		
		int numOfCustomers = scan.nextInt();
		
		
		for (int i = 0; i < numOfCustomers; i++) {
			// ignore first and last names
			scan.next();
			scan.next();
			int numOfPurchases = scan.nextInt();
			boolean[] previouslyPurchased = new boolean[numOfItems];
			for (int j = 0; j < numOfPurchases; j++) {
				int quantity = scan.nextInt();
				String item = scan.next();
				
				// get item index
				int index = getIndexOfItem(item, itemNames);
				itemsPurchased[index] += quantity;
				
				// customer purchases only incremented if the current customer has not already purchased the item
				if (!previouslyPurchased[index]) {
					previouslyPurchased[index] = true;
					customerPurchases[index]++;
				}
			}
		}
		
		scan.close();
		
		// print out using the format "[#customers] customers bought [#purchased] [item name]"
		// replace [#customers] with "No" if the item wasn't purchased
		for (int i = 0; i < numOfItems; i++) {
			if (customerPurchases[i] == 0) {
				System.out.println("No customers bought " + itemNames[i]);
			} else {
				System.out.println(customerPurchases[i] + " customers bought "
						+ itemsPurchased[i] + " " + itemNames[i]);
			}	
		}
	}
	
	/* Method that finds and returns index of a specific item name
	 * id: item name used to find index
	 * items: array of item names
	 */
	public static int getIndexOfItem(String id, String[] items) {
		for (int i = 0; i < items.length; i++) {
			if (id.equals(items[i])) {
				return i;
			}
		}
		return -1;
	}
}
