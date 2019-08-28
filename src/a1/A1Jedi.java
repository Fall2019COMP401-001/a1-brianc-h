package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numOfItems = scan.nextInt();
		String[] itemNames = new String[numOfItems];
		int[] customerPurchases = new int[numOfItems];
		int[] itemsPurchased = new int[numOfItems];
		
		
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
				
				int index = getIndexOfItem(item, numOfItems, itemNames);
				itemsPurchased[index] += quantity;
				
				if (!previouslyPurchased[index]) {
					previouslyPurchased[index] = true;
					customerPurchases[index]++;
				}
			}
		}
		
		scan.close();
		
		for (int i = 0; i < numOfItems; i++) {
			if (customerPurchases[i] == 0) {
				System.out.println("No customers bought " + itemNames[i]);
			} else {
				System.out.println(customerPurchases[i] + " customers bought "
						+ itemsPurchased[i] + " " + itemNames[i]);
			}	
		}
	}
	
	public static int getIndexOfItem(String id, int numOfItems, String[] items) {
		for (int i = 0; i < numOfItems; i++) {
			if (id.equals(items[i])) {
				return i;
			}
		}
		return -1;
	}
}
