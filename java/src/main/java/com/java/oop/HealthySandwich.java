package com.java.oop;

/**
 * 
 * @author Nitish Sharma
 *
 */
public class HealthySandwich extends Sandwich {
	
	private String healthyFlavorOne;
	private String healthyFlavorTwo;

	private double healthyFlavorOnePrice;
	private double healthyFlavorTwoPrice;

	/**
	 * Constructor for new type of Sandwich
	 * @param basePrice
	 * @param filling
	 */
	public HealthySandwich(String filling, double basePrice) {
		super("Healthy Sandwich", basePrice, filling, "Whole Wheat");
	}
	
	/**
	 * Adding healthy flavor one
	 * @param flavor
	 * @param price
	 */
	public void addHealthyFlavorOne(String flavor, double price) {
		this.healthyFlavorOne = flavor;
		this.healthyFlavorOnePrice = price;
	}

	/**
	 * Adding healthy flavor two
	 * @param flavor
	 * @param price
	 */
	public void addHealthyFlavorTwo(String flavor, double price) {
		this.healthyFlavorTwo = flavor;
		this.healthyFlavorTwoPrice = price;
	}
	
	/**
	 * To get price for healthy additions
	 */
	@Override
	public double customizedSandwichPrice() {
		double healthyPrice = super.customizedSandwichPrice();
		
		if (healthyFlavorOne!=null) {
			System.out.println("Adding- "+this.healthyFlavorOne+" for "+this.healthyFlavorOnePrice);
			healthyPrice += this.healthyFlavorOnePrice;
		}
		
		if (healthyFlavorTwo!=null) {
			System.out.println("Adding- "+this.healthyFlavorTwo+" for "+this.healthyFlavorTwoPrice);
			healthyPrice += this.healthyFlavorTwoPrice;
		}
		
		return Math.round(healthyPrice*100.0)/100.0;
		
	}
	
}
