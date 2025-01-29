package business.concretes;

import java.util.*;

import entity.Product;

public class InventoryManager<T extends Product> {

	private List<T> items = new ArrayList<>();

	public void addItem(T item) {
		items.add(item);
	}

	public void removeItem(T item) {
		items.remove(item);
	}

	public T findItemByName(String name) {
		for (T item : items) {
			if (item.getName().equalsIgnoreCase(name)) {

				return item;
			}
		}
		return null;
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
