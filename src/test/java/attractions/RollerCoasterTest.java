package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollerCoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1, visitor2, visitor3, visitor4;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(10, 1.2, 50.00);
        visitor2 = new Visitor(10, 1.68, 20.00);
        visitor3 = new Visitor(15, 1.3, 40.00);
        visitor4 = new Visitor(20, 2.05, 250.00);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void returnFalseWhenUnder12andUnder145() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitor1));
    }

    @Test
    public void returnFalseWhenUnder12andOver145() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitor2));
    }

    @Test
    public void returnFalseWhenOver12andUnder145() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitor3));
    }

    @Test
    public void returnTrueWhenOver12andOver145() {
        assertEquals(true, rollerCoaster.isAllowedTo(visitor4));
    }

    @Test
    public void hasDefaultPrice() {
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.01);
    }

    @Test
    public void chargesDoubleForVisitorsOver200() {
        assertEquals(16.80, rollerCoaster.priceFor(visitor4), 0.01);
    }
}
