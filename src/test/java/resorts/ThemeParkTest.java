package resorts;

import attractions.*;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {
  ThemePark themePark;
  Dodgems dodgems;
  Park park;
  Playground playground;
  RollerCoaster rollerCoaster;
  CandyflossStall candyflossStall;
  IceCreamStall iceCreamStall;
  TobaccoStall tobaccoStall;
  Visitor visitor1, visitor2;

  @Before
  public void setUp() {
    themePark = new ThemePark();
    dodgems = new Dodgems("Bumper Cars", 5);
    park = new Park("Leafy Meadows", 9);
    playground = new Playground("Fun Zone", 7);
    rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 8);
    iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 7);
    tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 7);
    themePark.addAttraction(dodgems);
    themePark.addAttraction(park);
    themePark.addAttraction(playground);
    themePark.addAttraction(rollerCoaster);
    themePark.addStall(candyflossStall);
    themePark.addStall(iceCreamStall);
    themePark.addStall(tobaccoStall);
    visitor1 = new Visitor(26, 1.67, 243.00);
    visitor2 = new Visitor(13, 1.67, 20.00);
  }

  @Test
  public void hasListOfAttractionsAndStores() {
    assertEquals(7, themePark.placesCount());
  }

  @Test
  public void canGetAllReviewed() {
    assertEquals(7, themePark.getAllReviewed().size());
  }

  @Test
  public void canVisitAttraction() {
    themePark.visit(visitor1, rollerCoaster);
    assertEquals(1, rollerCoaster.getVisitCount());
    assertEquals(1, visitor1.getVisitedAttractions().size());
  }

  @Test
  public void canReturnReviewHashMap() {
    assertEquals(new Integer(10), themePark.getAllReviewedHash().get("Blue Ridge"));
  }

  @Test
  public void canReturnAllPlacesVisitorIsAllowed() {
    assertEquals(2, themePark.getAllAllowedFor(visitor2));
  }
}
