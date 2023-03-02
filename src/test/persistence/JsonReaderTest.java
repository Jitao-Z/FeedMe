package persistence;

import model.Collection;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {

    @Test
    public void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/madeItUp.json");
        try {
            Collection collection = reader.read();
            fail("IOException should be thrown");
        } catch (IOException e) {
            // right place to go
        }
    }

    @Test
    public void testReaderEmptyCollection() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCollection.json");
        try {
            Collection collection = reader.read();
            assertEquals(0, collection.getListRestaurant().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    public void testReaderGeneralCollection() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCollection.json");
        Collection collection = null;
        try {
            collection = reader.read();
            assertEquals(2, collection.getListRestaurant().size());
            assertEquals("Burger King", collection.getListRestaurant().get(0).getName());
            assertEquals("London", collection.getListRestaurant().get(0).getLocation());
            assertEquals("Subway", collection.getListRestaurant().get(1).getName());
            assertEquals("New York City", collection.getListRestaurant().get(1).getLocation());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
