package attractions;

import behaviours.ISecurity;

public class Playground extends Attraction implements ISecurity {

    public Playground(String name, int rating) {
        super(name, rating);
    }
}
