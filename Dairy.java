/*
* Salman Alessa
* UID: 439100011
*/

// Packages
import java.util.Scanner;

public class Dairy {
	// Variables
	private int numMilk;
	private int numCheese;
	private int numButter;
	private double priceMilk;
	private double priceCheese;
	private double priceButter;

	// Methods
	static Scanner input = new Scanner(System.in);

	// Setter methods
	public void prices(double priceMilk, double priceCheese, double priceButter) {
		this.priceMilk = priceMilk;
		this.priceCheese = priceCheese;
		this.priceButter = priceButter;
	}

	public Dairy(int numMilk, int numCheese, int numButter) {
		this.numMilk = numMilk;
		this.numCheese = numCheese;
		this.numButter = numButter;
	}

	// Calculate dairy price 
	public double calcDairyPrice(double priceMilk, double priceCheese, double priceButter) {
		double total;

		priceMilk = this.numMilk * this.priceMilk;
		priceCheese = this.numCheese * this.priceCheese;
		priceButter = this.numButter * this.priceButter;
		total = priceMilk + priceCheese + priceButter;

		return total;
	}

	public double discountDairy(double total, int age) {
		// If age >= 65 applied discount
		if (age >= 65)
			total = total - (total * 0.20);
		
		return total;
	}

	//return dairy
	public String printDairy() {
		String output = "\n|\t" + this.numMilk + " - Milk for " + priceMilk + "\t\t|"
				 	  + "\n|\t" + this.numCheese + " - Cheese for " + priceCheese + "\t\t|"
				 	  + "\n|\t" + this.numButter + " - Butter for " + priceButter + "\t\t|";
		return output;	
	}

}
