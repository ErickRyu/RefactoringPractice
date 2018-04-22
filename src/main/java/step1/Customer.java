package step1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		Iterator<Rental> iterator = rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";

		while (iterator.hasNext()) {
			Rental each = (Rental) iterator.next();

			// show figures
			result += "\t" + String.valueOf(each.getCharge()) + "(" + each.getMovie().getTitle() + ")" + "\n";
		}

		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter pointers";

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

	private int getFrequentRenterPoints(){
		int result = 0;
		Iterator<Rental> iterator = rentals.iterator();
		while (iterator.hasNext()) {
			Rental each = (Rental) iterator.next();
			result = each.getFrequentRenterPoints();
		}
		return result;
	}
}