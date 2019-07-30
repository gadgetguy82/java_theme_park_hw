package resorts;

import attractions.*;
import behaviours.IReviewed;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;
import java.util.HashMap;

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

  public void visit(Visitor visitor, Attraction attraction) {
    attraction.addVisitCount();
    visitor.addAttraction(attraction);
  }


}
