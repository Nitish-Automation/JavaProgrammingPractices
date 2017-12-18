package com.java.oop;

/**
 * 
 * @author Nitish Sharma
 * Base class for Sandwich
 */
public class Sandwich {

	private String sandwichName;
	private String flavorOne;
	private String flavorTwo;
	private String flavorThree;

	private double basePrice;
	private double flavorOnePrice;
	private double flavorTwoPrice;
	private double flavorThreePrice;

	private String filling;
	private String breadType;
	
	/**
	 * Base constructor to record base fields
	 * @param baseFlavour
	 * @param basePrice
	 * @param filling
	 * @param breadType
	 */
	public Sandwich(String sandwichName, double basePrice, String filling, String breadType) {
		this.sandwichName=sandwichName;
		this.basePrice=basePrice;
		this.filling=filling;
		this.breadType=breadType;
		baseIngredients();
	}
	
	/**
	 * To find base ingredients
	 */
	private void baseIngredients () {
		System.out.println("Prepared "+sandwichName+" with "+filling+" in "+breadType+" for "+basePrice);
	}
	
	/**
	 * To record addition for flavor one
	 * @param flavorOne
	 * @param flavorOnePrice
	 */
	public void addFlavorOne(String flavorOne, double flavorOnePrice) {
		this.flavorOne=flavorOne;
		this.flavorOnePrice=flavorOnePrice;
	}
	
	/**
	 * To record addition for flavor two
	 * @param flavorTwo
	 * @param flavorTwoPrice
	 */
	public void addFlavorTwo(String flavorTwo, double flavorTwoPrice) {
		this.flavorTwo=flavorTwo;
		this.flavorTwoPrice=flavorTwoPrice;
	}
	
	/**
	 * To record addition for flavor three
	 * @param flavorThree
	 * @param flavorThreePrice
	 */
	public void addFlavorThree(String flavorThree, double flavorThreePrice) {
		this.flavorThree=flavorThree;
		this.flavorThreePrice=flavorThreePrice;
	}
	
	/**
	 * To get the current price of sandwich after 
	 * @return
	 */
	public double customizedSandwichPrice() {
		double currentPrice = this.basePrice;
		
		if(this.flavorOne!=null) {
			System.out.println("Adding- "+this.flavorOne+" for "+this.flavorOnePrice);
			currentPrice += this.flavorOnePrice;
		}
		
		if(this.flavorTwo!=null) {
			System.out.println("Adding- "+this.flavorTwo+" for "+this.flavorTwoPrice);
			currentPrice += this.flavorTwoPrice;
		}
		
		if(this.flavorThree!=null) {
			System.out.println("Adding- "+this.flavorThree+" for "+this.flavorThreePrice);
			currentPrice += this.flavorThreePrice;
		}
		
		System.out.println("Current Price for sandwich is: "+Math.round(currentPrice*100.00)/100.00);
		
		return Math.round(currentPrice*100.00)/100.00;
	}
	
}
