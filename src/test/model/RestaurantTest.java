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
    public void testLondonRestaurant() {
        testRestaurant = new Restaurant("MyKitchen", "London");
        assertEquals("MyKitchen", testRestaurant.getName());
        assertEquals("London", testRestaurant.getLocation());
    }

    @Test
    public void testNewYorkCityRestaurant() {
        testRestaurant = new Restaurant("Brooklyn Taste", "New York City");
        assertEquals("Brooklyn Taste", testRestaurant.getName());
        assertEquals("New York City", testRestaurant.getLocation());
    }

    @Test
    public void testConstructorInvalidLocation() {
        testRestaurant = new Restaurant("Burger King", "Montreal");
        assertEquals("Burger King", testRestaurant.getName());
        assertEquals("Invalid Location", testRestaurant.getLocation());
    }

}

