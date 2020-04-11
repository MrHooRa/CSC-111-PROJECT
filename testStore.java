/*
* Salman Alessa
* UID: 439100011
*/

// Packages
import java.util.Scanner;
public class testStore {
	static Scanner input = new Scanner(System.in);
	static String Dairy;
	static String Bakery;
	static double total = 0;
	public static void options(int age, double priceMilk, 
			double priceCheese, double priceButter, double priceMuffins,
			double priceCroissants, double priceBiscuits) {

		System.out.print("\n********************************************\n" +
				 		 "** Enter [1]-Dairy   [2]-Bakery  [0]-Exit **\n" + 
						 "********************************************\n > ");
		int option = input.nextInt();

		// If user select Dairy
		if (option == 1) {

			// Ask user..
			System.out.print("Enter number of milk you want to buy: ");
			int numMilk = input.nextInt();		
			System.out.print("Enter number of cheese you want to buy: ");
			int numCheese = input.nextInt();	
			System.out.print("Enter number of butter you want to buy: ");
			int numButter = input.nextInt();	

			// New object (objDairy)
			Dairy objDairy = new Dairy(numMilk, numCheese, numButter);
			objDairy.prices(priceMilk, priceCheese, priceButter);

			// This is complex , this line calculate total and sum it with Dairy 
			total = total + objDairy.discountDairy(objDairy.calcDairyPrice(priceMilk, priceCheese, priceButter), age);

			Dairy = objDairy.printDairy();
			options(age, 
					priceMilk, priceCheese, priceButter, 
					priceMuffins, priceCroissants, priceBiscuits);

		// If user select Bakery
		}else if (option == 2) {
			System.out.print("Enter number of muffins you want to buy: ");
			int numMuffins = input.nextInt();		
			System.out.print("Enter number of croissants you want to buy: ");
			int numCroissants = input.nextInt();	
			System.out.print("Enter number of biscuits you want to buy: ");
			int numBiscuits = input.nextInt();

			// New object (objBakery) 
			Bakery objBakery = new Bakery(numMuffins, numCroissants, numBiscuits);
			objBakery.prices(priceMuffins, priceCroissants, priceBiscuits);

			// This is complex , this line calculate total and sum it with Bakery 
			total = total + objBakery.discountBakery(objBakery.calcBakeryPrice(priceMuffins, priceCroissants, priceBiscuits), age);

			Bakery = objBakery.printBakery();
			options(age, 
					priceMilk, priceCheese, priceButter, 
					priceMuffins, priceCroissants, priceBiscuits);

		// If user select exit
		}else if (option == 0) {
			
			if (Bakery == null && Dairy == null) {
				System.out.print(
						"\n* Your purchase detail is as follows * "
						+ "\n| - - - - - - - - - - - - - - - - - - - |"
						+ "\n|                 Empty!                |"
						+ "\n| - - - - - - - - - - - - - - - - - - - |");
			}else {
				// If Dairy is null
				// If Bakery is null
				if(Dairy == null) Dairy = "";
				if(Bakery == null) Bakery = "";
				System.out.print(
						  "\n  Thanks  for  shopping,  Come  again!!"
						+ "\n\n*  Your purchase detail is as follows   *"
						+ "\n| - - - - - - - - - - - - - - - - - - - |"
						+ Dairy
						+ "\n|\t\t\t\t\t|"
						+ Bakery
						+ "\n| - - - - - - - - - - - - - - - - - - - |"
						+ "\n\nYour total after discount: "
						+ total);
			}

		// If user select wrong option
		}else {
			System.out.print("Please select the correct option from menu");
			options(age, 
					priceMilk, priceCheese, priceButter, 
					priceMuffins, priceCroissants, priceBiscuits);
		}
	}

	// This method return integer
	// This method check if user enter incorrect values
	// Set default value -> -1
	public static int CheckInt(String text, int min, int max, int value) {
		if (value < min || value > max) {
			System.out.print(text);
			value = input.nextInt();
			CheckInt(text, min, max, value);
		}else return value;
		return value;
	}

	// This method return double
	// This method check if user enter incorrect values
	// Set default value -> -1
	public static double CheckDouble(String text, int min, int max, double value) {
		if (value < min || value > max) {
			System.out.print(text);
			value = input.nextDouble();
			CheckDouble(text, min, max, value);
		}else return value;
		return value;
	}

	public static void main(String[] args) {
		// Local Variables
		int age;
		double priceMilk, priceCheese, priceButter, priceMuffins, priceCroissants, priceBiscuits;		

		// Welcome message then ask user to enter day, age, price of milk, cheese, butter, muffins, croissants and biscuits.
		// After that, ask user to choose one option.
		System.out.print("****************************************************************\n" + 
						 "**                Welcome to the CSC 111 store                **\n" + 
						 "****************************************************************\n");

		// Method Check***(String text, int min, int max, int value)
		// This method check if user enter incorrect values

		// I think we do not need day variable, so I put checkInt without variable!
		CheckInt("Please enter the day: 1-Sunday, 2-Monday, so on till 7-Saturday: ", 1, 7, -1);

		age = CheckInt("Please enter coustmer age: ", 1, 150, -1);

		priceMilk = CheckDouble("Enter today's price of milk-> ", 0, 100, -1);

		priceCheese = CheckDouble("Enter today's price of cheese-> ", 0, 999, -1);

		priceButter = CheckDouble("Enter today's price of butter-> ", 0, 999, -1);

		priceMuffins = CheckDouble("Enter today's price of muffin-> ", 0, 999, -1);

		priceCroissants = CheckDouble("Enter today's price of crosissants-> ", 0, 999, -1);

		priceBiscuits = CheckDouble("Enter today's price of biscuit-> ", 0, 999, -1);

		options(age, 
				priceMilk, priceCheese, priceButter, 
				priceMuffins, priceCroissants, priceBiscuits);

	}

}
