package step1;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {

    public static final int TWO_DAYS = 2;
    public static final int THREE_DAYS = 3;
    public static final int FOUR_DAYS = 4;
    String name = null;
    Customer customer = new Customer(name);

    @Test
    public void testX(){
        assertEquals("Rental Record for null\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter pointers", customer.statement());
    }

    @Test
    public void regularMovie_in_statement_less_than_three_days(){
        Rental rental = createRental(TWO_DAYS, Movie.REGULAR);
        customer.addRental(rental);
        assertEquals("Rental Record for null\n" +
                "\t2.0(null)\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter pointers", customer.statement());
    }


    @Test
    public void regularMovie_in_statement_more_than_two_days(){
        Rental rental = createRental(THREE_DAYS, Movie.REGULAR);
        customer.addRental(rental);
        assertEquals("Rental Record for null\n" +
                "\t3.5(null)\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter pointers", customer.statement());
    }

    @Test
    public void newReleaseMovie_in_statement(){
        Rental rental = createRental(THREE_DAYS, Movie.NEW_RELEASE);
        customer.addRental(rental);
        assertEquals("Rental Record for null\n" +
                "\t9.0(null)\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter pointers", customer.statement());
    }

    @Test
    public void childrenMovie_in_statement_less_than_four_days(){
        Rental rental = createRental(THREE_DAYS, Movie.CHILDRENS);
        customer.addRental(rental);
        assertEquals("Rental Record for null\n" +
                "\t1.5(null)\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter pointers", customer.statement());
    }

    @Test
    public void childrenMovie_in_statement_more_than_three_days(){
        Rental rental = createRental(FOUR_DAYS, Movie.CHILDRENS);
        customer.addRental(rental);
        assertEquals("Rental Record for null\n" +
                "\t3.0(null)\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter pointers", customer.statement());
    }

    @Test
    public void htmlStatement_childrenMovie_with_more_than_three_days(){
        Rental rental = createRental(FOUR_DAYS, Movie.CHILDRENS);
        customer.addRental(rental);
        assertEquals("<H1><EMnull 고객님의 대여 기록 </EM></H1><P>\n" +
                "null: 3.0<BR>\n" +
                "<P>누적 대여료 <EM>3.0</EM><P>\n" +
                "적립 포인트 <EM>1</EM><P>", customer.htmlStatement());
    }

    private Rental createRental(int daysRented, int priceCode) {
        String title = null;
        Movie movie = new Movie(title, priceCode);
        Rental rental = new Rental(movie, daysRented);
        return rental;
    }

}
