package com.oop.demo;

public class SandwichSales {
	
	public static void main(String[] args) {
		
		Sandwich regularSandwich = new Sandwich("Classic Sandwich", 1.34, "Cheese", "White Bread");
		
		regularSandwich.addFlavorOne("Chicken", 00.98);
		regularSandwich.addFlavorTwo("Eggs", 00.25);
		regularSandwich.addFlavorThree("Fish", 00.76);
		regularSandwich.customizedSandwichPrice();

		HealthySandwich healthySandwich = new HealthySandwich("Avacado", 1.32);
		
		healthySandwich.addFlavorOne("Bacon", 2.34);
		healthySandwich.addFlavorOne("Spanich", 1.21);
		healthySandwich.customizedSandwichPrice();
		
		DeluxeSandwich deluxSandwich = new DeluxeSandwich("Tuna Fish", 3.45);
		deluxSandwich.addFlavorOne("Kale", .05);
		deluxSandwich.customizedSandwichPrice();
	}
	

}
