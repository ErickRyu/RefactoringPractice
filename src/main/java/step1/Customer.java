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
	};

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	};

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> iterator = rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";

		while ( iterator.hasNext() ) {
			double thisAmount = 0;
			Rental each = (Rental) iterator.next();
			// determine amounts for each line

			// add frequent renter points
			frequentRenterPoints = each.getFrequentRenterPoints();
			// show figures
			result += "\t" +  String.valueOf(each.getCharge()) + "(" + each.getMovie().getTitle() + ")" + "\n";

			totalAmount += each.getCharge();
		}

		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter pointers";

		return result;
	}


}