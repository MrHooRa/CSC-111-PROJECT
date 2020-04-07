/*
* Salman Alessa
* UID: 439100011
*/
//Packages
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

			// Setter
			Dairy objDairy = new Dairy(numMilk, numCheese, numButter);
			objDairy.prices(priceMilk, priceCheese, priceButter);
			objDairy.age(age);

			// This is complex , this line calc total and sum it with Dairy 
			total = total + objDairy.discountDairy(objDairy.calcDairyPrice(priceMilk, priceCheese, priceButter), age);

			Dairy = objDairy.printDairy();
			options(age, priceMilk, 
					priceCheese, priceButter, priceMuffins,
					priceCroissants, priceBiscuits);


		// If user select Bakery
		}else if (option == 2) {
			System.out.print("Enter number of muffins you want to buy: ");
			int numMuffins = input.nextInt();		
			System.out.print("Enter number of croissants you want to buy: ");
			int numCroissants = input.nextInt();	
			System.out.print("Enter number of biscuits you want to buy: ");
			int numBiscuits = input.nextInt();


			// New object (objDairy) 
			Bakery objBakery = new Bakery(numMuffins, numCroissants, numBiscuits);
			objBakery.prices(priceMilk, priceCheese, priceButter);
			objBakery.age(age);

			// This is complex , this line calc total and sum it with Bakery 
			total = total + objBakery.discountBakery(objBakery.calcBakeryPrice(priceMuffins, priceCroissants, priceBiscuits), age);
			
			Bakery = objBakery.printBakery();
			options(age, priceMilk, 
					priceCheese, priceButter, priceMuffins,
					priceCroissants, priceBiscuits);

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
						+ "\n\n| - - - - - - - - - - - - - - - - - - - |"
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
			options(age, priceMilk, 
					priceCheese, priceButter, priceMuffins,
					priceCroissants, priceBiscuits);
		}
	}
	
	// This method check if user enter incorrect values
	// Set value -> -1
	public static int Check(String text, int min, int max, int value) {
		if (value < min || value > max) {
			System.out.print(text);
			value = input.nextInt();
			Check(text, min, max, value);
		}else return value;
		
		return 0;
		
	}
	
	
	public static void main(String[] args) {
		// Vars
		
		// Local vars
		int day, age;
		double priceMilk, priceCheese, priceButter, priceMuffins, priceCroissants, priceBiscuits;		
		
		// Welcome msg and ask user to enter day, age, price of milk, price of cheese, price of butter, price of muffins, price of croissants and price of biscuits.
		// After that, ask user to choose one option.
		System.out.print("****************************************************************\n" + 
						 "**                Welcome to the CSC 111 store                **\n" + 
						 "****************************************************************\n");
		
		// Method Check(String text, int min, int max, int value)
		// This method check if user enter incorrect values
		
		day = Check("Please enter the day: 1-Sunday, 2-Monday, so on till 7-Saturday: ", 0, 7, -1);
						
		age = Check("Please enter coustmer age: ", 0, 150, -1);

		priceMilk = Check("Enter today's price of milk-> ", 0, 100, -1);
				
		priceCheese = Check("Enter today's price of cheese-> ", 0, 999, -1);
				
		priceButter = Check("Enter today's price of butter-> ", 0, 999, -1);
				
		priceMuffins = Check("Enter today's price of muffin-> ", 0, 999, -1);
				
		priceCroissants = Check("Enter today's price of crosissants-> ", 0, 999, -1);

		priceBiscuits = Check("Enter today's price of biscuit-> ", 0, 999, -1);
				
		options(age, priceMilk, 
				priceCheese, priceButter, priceMuffins,
				priceCroissants, priceBiscuits);

	}

}
