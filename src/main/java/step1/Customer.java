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

	public String htmlStatement() {
	    Iterator<Rental>iterator = rentals.iterator();
	    String result = "<H1><EM" + getName() + " 고객님의 대여 기록 </EM></H1><P>\n";
	    while(iterator.hasNext()){
	        Rental each = (Rental) iterator.next();

	        // show figures
	        result += each.getMovie().getTitle() + ": "  +
                    String.valueOf(each.getCharge()) + "<BR>\n";
        }

        // add footer
        result += "<P>누적 대여료 <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
	    result += "적립 포인트 <EM>" + String.valueOf(getFrequentRenterPoints()) + "</EM><P>";
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