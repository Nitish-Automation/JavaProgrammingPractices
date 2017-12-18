package com.java.oop;

public class DeluxeSandwich extends Sandwich {

	public DeluxeSandwich(String filling, double basePrice) {
		super("Delux Sandwich", basePrice, filling, "Organic Wheat Bread");
		super.addFlavorOne("Potato Chips", 1.12);
		super.addFlavorTwo("Diet Coke", 00.54);
	}
	
	/**
	 * To record addition for flavor one
	 * @param flavorOne
	 * @param flavorOnePrice
	 */
	public void addFlavorOne(String flavorOne, double flavorOnePrice) {
		System.out.println("Adding "+flavorOne+" to Deluxe Sandwich is Not Allowed!!!");
	}
	
	/**
	 * To record addition for flavor two
	 * @param flavorTwo
	 * @param flavorTwoPrice
	 */
	public void addFlavorTwo(String flavorTwo, double flavorTwoPrice) {
		System.out.println("Not Allowed!!!");
	}
	
	/**
	 * To record addition for flavor three
	 * @param flavorThree
	 * @param flavorThreePrice
	 */
	public void addFlavorThree(String flavorThree, double flavorThreePrice) {
		System.out.println("Not Allowed!!!");
	}

}
