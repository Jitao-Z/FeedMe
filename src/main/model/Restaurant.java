package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a restaurant with its name and located city
public class Restaurant implements Writable {
    private String name;             // restaurant name
    private String location;         // located city of the restaurant


    // REQUIRES: both n and l should have a non-zero length
    // EFFECTS: constructs a new restaurant;
    //          set name to be n;
    //          set location to be l if l is either "Vancouver", "London", or
    //          "New York City"; otherwise, let l be "Invalid Location"
    public Restaurant(String n, String l) {
        this.name = n;
        if (l.equals("Vancouver") || l.equals("London") || l.equals("New York City")) {
            location = l;
        } else {
            location = "Invalid Location";
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
