package model;

import java.util.ArrayList;

public class Collection {
    private ArrayList<Restaurant> listRestaurant;

    public Collection() {
        this.listRestaurant = new ArrayList<Restaurant>();
    }

    public void addRestaurant(Restaurant r) {
        this.listRestaurant.add(r);
    }

    public void removeRestaurant(Restaurant r) {
        this.listRestaurant.remove(r);
    }

    public ArrayList<Restaurant> getListRestaurant() {
        return this.listRestaurant;
    }
}
