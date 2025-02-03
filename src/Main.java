import java.util.List;
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
		Scanner scanner = new Scanner(System.in); // to take input from users

		// menu
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

				Product product = new Product(name, price, stock, category);
				inventory.addItem(product);
				System.out.println("Product added: " + name);
				break;

			case 2:
				System.out.print("Enter product name to remove: ");
				String removeName = scanner.nextLine();
				List<Product> toRemoveList = inventory.findItemsByName(removeName);

				if (!toRemoveList.isEmpty()) {
					// List matching products
					System.out.println("Found the following products:");
					for (int i = 0; i < toRemoveList.size(); i++) {
						System.out.println((i + 1) + ". " + toRemoveList.get(i)); // Mark w/ numbers
					}

					// Take input from user to remove the exact product
					System.out.print("Enter the number of the product to remove: ");
					int option = scanner.nextInt();
					scanner.nextLine(); // Consume newline

					if (option >= 1 && option <= toRemoveList.size()) {
						Product toRemove = toRemoveList.get(option - 1); // Selected product
						inventory.removeItem(toRemove);
						System.out.println("Product removed: " + toRemove.getName());
					} else {
						System.out.println("Invalid selection.");
					}
				} else {
					System.out.println("Product not found.");
				}
				break;

			case 3:
				System.out.print("Enter product name to find: ");
				String findName = scanner.nextLine();
				List<Product> foundItems = inventory.findItemsByName(findName);

				if (!foundItems.isEmpty()) {
					System.out.println("Found the following products:");
					for (Product item : foundItems) {
						System.out.println(item);
					}
				} else {
					System.out.println("No products found matching the given name.");
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
				System.out.println("Products sorted by ID:");
				inventory.getItemsSortedById().reversed().forEach(System.out::println);

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
