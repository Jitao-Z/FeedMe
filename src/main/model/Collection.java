package model;

import java.util.ArrayList;

// Represents a collection that is consist of a list of restaurants
public class Collection {
    private ArrayList<Restaurant> listRestaurant;       // a list of restaurants


    // EFFECTS: constructs a new empty list of restaurants
    public Collection() {
        this.listRestaurant = new ArrayList<Restaurant>();
    }


    // MODIFIES: this
    // EFFECTS: add a restaurant r to the list
    public void addRestaurant(Restaurant r) {
        this.listRestaurant.add(r);
    }


    // REQUIRES: there is at least one restaurant existing in the list
    // MODIFIES: this
    // EFFECTS: remove a restaurant r from the list
    public void removeRestaurant(Restaurant r) {
        this.listRestaurant.remove(r);
    }


    public ArrayList<Restaurant> getListRestaurant() {
        return this.listRestaurant;
    }

}
