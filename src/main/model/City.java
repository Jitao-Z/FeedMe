package model;

import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<Restaurant> internalArray;

    public City(String n) {
        this.name = n;
        this.internalArray = new ArrayList<>();
    }

    public void plusRestaurant(Restaurant r) {
        internalArray.add(r);
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Restaurant> getInternalArray() {
        return this.internalArray;
    }

}
