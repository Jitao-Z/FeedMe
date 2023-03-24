package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a restaurant with its name and located city
public class Restaurant implements Writable {
    private String name;             // restaurant name
    private String location;         // located city of the restaurant
    private String information;


    // REQUIRES: both name and location should have a non-zero length
    // EFFECTS: constructs a new restaurant;
    //          set restaurant name to name;
    //          set located city of the restaurant to location if location is either "Vancouver", "London", or
    //          "New York City"; otherwise, let location be "Invalid Location"
    public Restaurant(String name, String location, String information) {
        this.name = name;
        if (location.equals("Vancouver") || location.equals("London") || location.equals("New York City")) {
            this.location = location;
        } else {
            this.location = "Invalid Location";
        }
        this.information = information;
    }


    public String getName() {
        return this.name;
    }


    public String getLocation() {
        return this.location;
    }

    public String getInformation() {
        return this.information;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("location", location);
        json.put("information", information);
        return json;
    }

}
