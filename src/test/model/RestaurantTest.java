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

    @Test
    public void testConstructorInvalidLocation() {
        testRestaurant = new Restaurant("Burger King", "Montreal");
        assertEquals("Burger King", testRestaurant.getName());
        assertEquals("Invalid Location", testRestaurant.getLocation());
    }

}
