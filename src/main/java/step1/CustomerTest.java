package step1;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void testX(){
        String name = null;
        Customer customer = new Customer(name);
        assertEquals("Rental Record for null\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter pointers", customer.statement());
    }

    @Test
    public void testY(){
        String name = null;
        Customer customer = new Customer(name);
        int daysRented = 0;
        int priceCode = 0;
        String title = null;
        Movie moview = new Movie(title, priceCode);
        Rental rental = new Rental(moview, daysRented);
        customer.addRental(rental);
        assertEquals("Rental Record for null\n" +
                "\t2.0(null)\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter pointers", customer.statement());
    }
}
