package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		//Accepting inputs
		Scanner in =new Scanner(System.in);
		System.out.println("What is your starting ammount? : ");
		double startingAmount = in.nextDouble();
		System.out.println("What is the chance of winning the game? : ");
		double winChance = in.nextDouble();
		System.out.println("What is your win limit? : ");
		double winLimit = in.nextDouble();
		int numberPlays = 0;
		double successfulDays = 0;
		double ruinDays = 0;
		int numberOfDays = 0;
		//Multiple days of simulations
		for (int totalSimulations = 1; totalSimulations <= 100; totalSimulations++) {
			System.out.println("It is day " + totalSimulations + "!");
			double amountOfMoney = startingAmount;
			// one day of gambling
			while(amountOfMoney > 0 && amountOfMoney < winLimit) {
				double chance = Math.random();
				if (chance > (1-winChance)) {
					amountOfMoney++;
					numberPlays++;
				}
				else {
					amountOfMoney--;
					numberPlays++;
				}
			}
			System.out.println(numberPlays);
			if (amountOfMoney >= winLimit) {
				System.out.println("Congrats, the day was a success!");
				successfulDays++;
			}
			else {
				System.out.println("Sorry, day was a ruin!");
				ruinDays++;
			}
			numberPlays = 0;
			numberOfDays++;
		}
		double percentRuin = (ruinDays/(successfulDays + ruinDays)) * 100;
		System.out.println(ruinDays + " number of days were a ruin");
		System.out.println(successfulDays + " number of days were a success");
		System.out.println(percentRuin + " % of days were a ruin");

		double alpha = ((1-winChance)/ winChance);
		System.out.println("Alpha is " + alpha);

		if(winChance == .5) {
			
			double expectedRuin = (1 - (startingAmount/ winLimit));
			System.out.println("Our Expected Ruin was " + expectedRuin);
		}
		else {
			double expectedRuin = ((((Math.pow(alpha, startingAmount)) - (Math.pow(alpha, winLimit)))/(1 - (Math.pow(alpha, winLimit)))));
			System.out.println("Our Expected Ruin was " + expectedRuin);

		}
		
		

	}
}
