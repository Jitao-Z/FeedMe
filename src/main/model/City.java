package model;

import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<Restaurant> internalArray;    //this can be understood as a field, which will need to initiate

    public City(String n) {
        this.name = n;
        this.internalArray = new ArrayList<>();     // this could also be understood as an object of a class which
    }                                               // needs to be instantiated in the constructor

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
