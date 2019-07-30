package resorts;

import attractions.Attraction;
import behaviours.IReviewed;
import org.w3c.dom.Attr;
import stalls.Stall;

import java.util.ArrayList;
import java.util.BitSet;

public class ThemePark {
  private ArrayList<Attraction> attractions;
  private ArrayList<Stall> stalls;

  public ThemePark() {
    this.attractions = new ArrayList<Attraction>();
    this.stalls = new ArrayList<Stall>();
  }

  public void addAttraction(Attraction attraction) {
    this.attractions.add(attraction);
  }

  public void addStall(Stall stall) {
    this.stalls.add(stall);
  }

  public int placesCount() {
    return this.attractions.size() + this.stalls.size();
  }

  public ArrayList<IReviewed> getAllReviewed() {
    ArrayList<IReviewed> reviewedList = new ArrayList<IReviewed>(this.attractions);
    reviewedList.addAll(this.stalls);
    return reviewedList;
  }
}
