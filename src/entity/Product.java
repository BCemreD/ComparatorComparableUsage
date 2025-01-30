package entity;

import java.util.Random;

public class Product { 
	
	//the features
	private static Random random = new Random(); // Create a single Random instance
    private final int id; // Use final for immutability
	private String name;
	private double price;
	private int stock;
	private String category;

	public Product(String name, double price, int stock, String category) {
		super();
		this.id = random.nextInt(10000) + 1; // Generate random ID between 1 and 10000
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.category = category;
	}

	public int getId() {
		return id;
	}//no set method for id, because it's finalized.


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return String.format("ID: %d, Name: %s, Price: %.2f, Stock: %d, Category: %s", id, name, price, stock,
				category);
	}

}
