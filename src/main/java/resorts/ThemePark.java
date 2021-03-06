package resorts;

import attractions.*;
import behaviours.IReviewed;
import behaviours.ISecurity;
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

  public HashMap<String, Integer> getAllReviewedHash() {
    HashMap<String, Integer> reviewHash = new HashMap<String, Integer>();
    for (IReviewed review : getAllReviewed()) {
      reviewHash.put(review.getName(), review.getRating());
    }
    return reviewHash;
  }

  public ArrayList<ISecurity> getAllAllowedFor(Visitor visitor) {
    ArrayList<ISecurity> securityList = new ArrayList<ISecurity>();
    for (IReviewed review : getAllReviewed()) {
      if (review instanceof ISecurity) {
        if (((ISecurity) review).isAllowedTo(visitor)) {
          securityList.add((ISecurity) review);
        }
      }
    }
    return securityList;
  }
}
