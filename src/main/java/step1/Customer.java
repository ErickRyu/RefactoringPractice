package step1;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	;

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	;

	public String statement() {
		int frequentRenterPoints = 0;
		Iterator<Rental> iterator = rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";

		while (iterator.hasNext()) {
			Rental each = (Rental) iterator.next();
			// determine amounts for each line

			// add frequent renter points
			frequentRenterPoints = each.getFrequentRenterPoints();
			// show figures
			result += "\t" + String.valueOf(each.getCharge()) + "(" + each.getMovie().getTitle() + ")" + "\n";

		}

		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter pointers";

		return result;
	}

	private double getTotalCharge() {
		double result = 0;
		Iterator<Rental> iterator = rentals.iterator();
		while (iterator.hasNext()) {
			Rental each = (Rental) iterator.next();
			result += each.getCharge();
		}
		return result;
	}

}