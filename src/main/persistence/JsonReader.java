package persistence;

import model.Collection;
import model.Restaurant;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads collection from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs a reader to read from the
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads collection from file and returns it;
    //          throws IOException if there is an error occurring when reading data from file
    public Collection read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCollection(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses collection from JSON object and returns it
    private Collection parseCollection(JSONObject jsonObject) {
        Collection collection = new Collection();
        addRestaurants(collection, jsonObject);
        return collection;
    }

    // MODIFIES: collection
    // EFFECTS: parses all restaurants from JSON object and adds them back to the newly built collection above
    private void addRestaurants(Collection collection, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("listRestaurant");
        for (Object json : jsonArray) {
            JSONObject nextRestaurant = (JSONObject) json;
            addRestaurant(collection, nextRestaurant);
        }
    }

    // MODIFIES: collection
    // EFFECTS: parse restaurant from JSON object and adds it to collection
    private void addRestaurant(Collection collection, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String location = jsonObject.getString("location");
        String information = jsonObject.getString("information");
        Restaurant restaurant = new Restaurant(name, location, information);
        collection.addRestaurant(restaurant);
    }
    
}

// Claim: The heavy amount of the above code is referred to the
//        sample code that is given with the phase 2 project