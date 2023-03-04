package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a restaurant with its name and located city
public class Restaurant implements Writable {
    private String name;             // restaurant name
    private String location;         // located city of the restaurant


    // REQUIRES: both name and location should have a non-zero length
    // EFFECTS: constructs a new restaurant;
    //          set name to be name;
    //          set location to be location if location is either "Vancouver", "London", or
    //          "New York City"; otherwise, let location be "Invalid Location"
    public Restaurant(String name, String location) {
        this.name = name;
        if (location.equals("Vancouver") || location.equals("London") || location.equals("New York City")) {
            this.location = location;
        } else {
            this.location = "Invalid Location";
        }
    }


    public String getName() {
        return this.name;
    }


    public String getLocation() {
        return this.location;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("location", location);
        return json;
    }

}
