package dataAccess;

import java.util.*;

import entity.Product;

public class DatabaseExample {

	//creating a list for simulating a database
	private static List<Product> products = new ArrayList<>();

	static {
		products.add(new Product("Laptop", 1200.0, 10, "Electronics"));
		products.add(new Product("Phone", 800.0, 20, "Electronics"));
		products.add(new Product("Tablet", 500.0, 15, "Electronics"));
		products.add(new Product("Headphones", 150.0, 50, "Accessories"));
		products.add(new Product("Monitor", 300.0, 25, "Electronics"));
	}
	
	public static List<Product> getAllProducts(){
		return products;
	}
}
