package com.vote;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private final double tshirtPrice = 50.00;
	private final double jeansPrice = 80.00;
	private final double jacketPrice = 100.00;
	private final double budget = 600;

	public static void main(String[] args) {

		Main main = new Main();
		List<String> list = main.calculate();
		main.printResult(list);

	}

	public List<String> calculate() {

		List<String> list = new ArrayList<>();

		double minPrice = Math.min(tshirtPrice, Math.min(jeansPrice, jacketPrice));

		int maxTshirt = (int) Math.floor(budget / tshirtPrice);

		int maxJeans = (int) Math.floor(budget / jeansPrice);

		for (int i = 1; i <= maxTshirt; i++) {
			for (int j = 1; j <= maxJeans; j++) {
				int jackets = (int) Math.floor((budget - (i * tshirtPrice + j * jeansPrice)) / jacketPrice);
				double totalPrice = (i * tshirtPrice) + (j * jeansPrice) + (jackets * jacketPrice);
				double remainingBudget = budget - totalPrice;
				if (jackets >= 1 && minPrice > remainingBudget) {
					list.add("TShirt: " + i + ", Jeans: " + j + ", Jackets: " + jackets + ", Total Price:  "
							+ totalPrice + ", Remaining Budget: " + remainingBudget);
				}

			}
		}

		return list;
	}

	public void printResult(List<String> list) {

		System.out.println("The Combination of items: "+"\n");
		
		for (String data : list) {
			System.out.println(data);
		}

		System.out.println("\n"+"Total Combination of Items is: " + list.size());
	}

}
