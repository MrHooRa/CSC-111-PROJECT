/*
* Salman Alessa
* UID: 439100011
*/

// Packages
import java.util.Scanner;

public class Bakery {
	// Variables
	private int numMuffins;
	private int numCroissants;
	private int numBiscuits;
	private double priceMuffins;
	private double priceCroissants;
	private double priceBiscuits;

	// Methods
	static Scanner input = new Scanner(System.in);

	// Setter methods
	public void prices(double priceMuffins, double priceCroissants, double priceBiscuits) {
		this.priceMuffins = priceMuffins;
		this.priceCroissants = priceCroissants;
		this.priceBiscuits = priceBiscuits;
	}

	public Bakery(int numMuffins, int numCroissants, int numBiscuits) {
		this.numMuffins = numMuffins;
		this.numCroissants = numCroissants;
		this.numBiscuits = numBiscuits;
	}

	// Calculate bakery price 
	public double calcBakeryPrice(double priceMuffins, double priceCroissants, double priceBiscuits) {
		double total;
		
		priceMuffins = this.numMuffins * this.priceMuffins;
		priceCroissants = this.numCroissants * this.priceCroissants;
		priceBiscuits = this.numBiscuits * this.priceBiscuits;
		total = priceMuffins + priceCroissants + priceBiscuits;
		
		return total;
	}

	public double discountBakery(double total, int age) {
		// If age >= 65 applied discount
		if (age >= 65)
			total = total - (total * 0.20);
		
		return total;
	}

	//return bakery
	public String printBakery() {
		String output = "\n|\t" + this.numMuffins + " - Muffins for " + priceMuffins + "\t\t|"
				 	  + "\n|\t" + this.numCroissants + " - Croissants for " + priceCroissants + "\t\t|"
				 	  + "\n|\t" + this.numBiscuits + " - Biscuits for " + priceBiscuits + "\t\t|";
		return output;
	}

}
