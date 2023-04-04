package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// Represents a collection that is consist of a list of restaurants
public class Collection implements Writable {
    private ArrayList<Restaurant> listRestaurant;       // a list of restaurants


    // EFFECTS: constructs a new empty list of restaurants
    public Collection() {
        this.listRestaurant = new ArrayList<Restaurant>();
    }


    // MODIFIES: this
    // EFFECTS: add a restaurant to the list
    public void addRestaurant(Restaurant restaurant) {
        this.listRestaurant.add(restaurant);
        EventLog.getInstance().logEvent(new Event(restaurant.getName() + " was added to collection."));
    }


    // REQUIRES: there is at least one restaurant existing in the list
    // MODIFIES: this
    // EFFECTS: remove a restaurant from the list
    public void removeRestaurant(Restaurant restaurant) {
        this.listRestaurant.remove(restaurant);
        EventLog.getInstance().logEvent(new Event(restaurant.getName() + " was removed from collection."));
    }


    public ArrayList<Restaurant> getListRestaurant() {
        return this.listRestaurant;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("listRestaurant", listRestaurantToJson());
        return json;
    }


    // EFFECTS: returns restaurants in this collection as a JSON array
    private JSONArray listRestaurantToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Restaurant r : listRestaurant) {
            jsonArray.put(r.toJson());
        }

        return jsonArray;
    }

}
