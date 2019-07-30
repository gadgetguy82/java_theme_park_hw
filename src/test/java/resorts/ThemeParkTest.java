package resorts;

import attractions.*;
import org.junit.Before;
import org.junit.Test;
import stalls.*;

public class ThemeParkTest {
  ThemePark themePark;
  Dodgems dodgems;
  Park park;
  Playground playground;
  RollerCoaster rollerCoaster;
  CandyflossStall candyflossStall;
  IceCreamStall iceCreamStall;
  TobaccoStall tobaccoStall;

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
  }

  @Test
  public void hasListOfAttractionsAndStores() {

  }
}
