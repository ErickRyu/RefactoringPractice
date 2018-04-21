package step1;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {

    public static final int TWO_DAYS = 2;
    public static final int THREE_DAYS = 3;
    String name = null;
    Customer customer = new Customer(name);

    @Test
    public void testX(){
        assertEquals("Rental Record for null\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter pointers", customer.statement());
    }

    @Test
    public void testY(){
        Rental rental = createRental(TWO_DAYS);
        customer.addRental(rental);
        assertEquals("Rental Record for null\n" +
                "\t2.0(null)\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter pointers", customer.statement());
    }


    @Test
    public void regularMovieTest(){
        Rental rental = createRental(THREE_DAYS);
        customer.addRental(rental);
        assertEquals("Rental Record for null\n" +
                "\t3.5(null)\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter pointers", customer.statement());
    }

    private Rental createRental(int daysRented) {
        int priceCode = 0;
        String title = null;
        Movie movie = new Movie(title, priceCode);
        Rental rental = new Rental(movie, daysRented);
        return rental;
    }

}
