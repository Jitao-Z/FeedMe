package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantTest {
    private Restaurant testRestaurant;

    @BeforeEach
    public void runBefore() {
        testRestaurant = new Restaurant("KFC", "Vancouver");
    }

    @Test
    public void testConstructor() {
        assertEquals("KFC", testRestaurant.getName());
        assertEquals("Vancouver", testRestaurant.getLocation());
    }

}
