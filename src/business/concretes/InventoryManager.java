package business.concretes;

import java.util.*;

import entity.Product;

public class InventoryManager<T extends Product> {// a generic class that accepts only Product class and its derived
													// classes

	private List<T> items = new ArrayList<>();

	public void addItem(T item) {
		items.add(item);
	} // this method provides more control and helps for future scenarios

	public void removeItem(T item) {
		items.remove(item);
	}

	public List<T> findItemsByName(String name) {
		List<T> matchingItems = new ArrayList<>();
		for (T item : items) {
			if (item.getName().toLowerCase().contains(name.toLowerCase())) {
				matchingItems.add(item);
			}
		}
		return matchingItems;
	}

	public List<T> getItemsSortedByStock() {
		items.sort(ProductManager.compareByStock());

		return items;
	}

	public List<T> getItemsSortedByPrice() {
		items.sort(ProductManager.compareByPrice());

		return items;
	}

	public void printInventory() {
		ProductManager.printProducts(items);
	}

}
