import java.util.Scanner;

import entity.Product;
import business.concretes.*;
import dataAccess.DatabaseExample;

public class Main {

	public static void main(String[] args) {

		InventoryManager<Product> inventory = new InventoryManager<>();
		
		for (Product product : DatabaseExample.getAllProducts()) {
            inventory.addItem(product);
        }
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("1. Add Product");
			System.out.println("2. Remove Product");
			System.out.println("3. Find Product");
			System.out.println("4. Sort by Stock");
			System.out.println("5. Sort by Price");
			System.out.println("6. Print Inventory");
			System.out.println("7. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				System.out.print("Enter price: ");
				double price = scanner.nextDouble();
				System.out.print("Enter stock: ");
				int stock = scanner.nextInt();
				scanner.nextLine(); // Consume newline
				System.out.print("Enter category: ");
				String category = scanner.nextLine();

				Product product = new Product( name, price, stock, category);
				inventory.addItem(product);
				System.out.println("Product added: " + name);
				break;

			case 2:
				System.out.print("Enter product name to remove: ");
				String removeName = scanner.nextLine();
				Product toRemove = inventory.findItemByName(removeName);

				if (toRemove != null) {
					inventory.removeItem(toRemove);
					System.out.println("Product removed.");
				}

				else {
					System.out.println("Product not found.");
				}
				
				break;

			case 3:
				System.out.print("Enter product name to find: ");
				String findName = scanner.nextLine();
				Product found = inventory.findItemByName(findName);
				
				if (found != null) {
					System.out.println(found);
				}
				
				else {
					System.out.println("Product not found.");
				}
				
				break;

			case 4:
				System.out.println("Products sorted by stock:");
				inventory.getItemsSortedByStock().forEach(System.out::println);
				
				break;

			case 5:
				System.out.println("Products sorted by price:");
				inventory.getItemsSortedByPrice().forEach(System.out::println);
				
				break;

			case 6:
				System.out.println("Inventory:");
				inventory.printInventory();
				
				break;

			case 7:
				System.out.println("Exiting...");
				scanner.close();
				
				return;

			default:
				System.out.println("Invalid choice.");
			}
		}
	}
}
