package persistence;

import model.Collection;
import model.Restaurant;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest {

    @Test
    public void testWriterInvalidFile() {
        try {
            Collection collection = new Collection();
            JsonWriter writer = new JsonWriter("./data/syn?tax!\0error.json");
            writer.open();
            fail("IOException should be thrown");
        } catch (IOException e) {
            // right place to go
        }
    }

    @Test
    public void testWriterEmptyCollection() {
        try {
            Collection collection = new Collection();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCollection.json");
            writer.open();
            writer.write(collection);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCollection.json");
            collection = reader.read();
            assertEquals(0, collection.getListRestaurant().size());
        } catch (IOException e) {
            fail("IOException should not be thrown here");
        }
    }

    @Test
    public void testWriteGeneralCollection() {
        try {
            Collection collection = new Collection();
            collection.addRestaurant(new Restaurant("KFC", "Vancouver"));
            collection.addRestaurant(new Restaurant("Piazza Hut", "London"));
            JsonWriter writer = new JsonWriter("./data/testWriteGeneralCollection.json");
            writer.open();
            writer.write(collection);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriteGeneralCollection.json");
            collection = reader.read();
            assertEquals(2, collection.getListRestaurant().size());
            assertEquals("KFC", collection.getListRestaurant().get(0).getName());
            assertEquals("Vancouver", collection.getListRestaurant().get(0).getLocation());
            assertEquals("Piazza Hut", collection.getListRestaurant().get(1).getName());
            assertEquals("London", collection.getListRestaurant().get(1).getLocation());
        } catch (IOException e) {
            fail("IOException should not be thrown here");
        }
    }

}
