package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor visitor1, visitor2;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1);
        visitor1 = new Visitor(10, 1.2, 50.00);
        visitor2 = new Visitor(20, 1.68, 250.00);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void canReturnFalseWhenVisitorUnder18() {
        assertEquals(false, tobaccoStall.isAllowedTo(visitor1));
    }

    @Test
    public void canReturnTrueWhenVisitorOver17() {
        assertEquals(true, tobaccoStall.isAllowedTo(visitor2));
    }
}
