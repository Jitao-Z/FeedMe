package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantTest {
    private Restaurant testRestaurant;

    @BeforeEach
    public void runBefore() {
        testRestaurant = new Restaurant("KFC", "Vancouver", "Yummy!");
    }

    @Test
    public void testConstructor() {
        assertEquals("KFC", testRestaurant.getName());
        assertEquals("Vancouver", testRestaurant.getLocation());
        assertEquals("Yummy!", testRestaurant.getInformation());
    }

    @Test
    public void testLondonRestaurant() {
        testRestaurant = new Restaurant("MyKitchen", "London", "Delicious!");
        assertEquals("MyKitchen", testRestaurant.getName());
        assertEquals("London", testRestaurant.getLocation());
        assertEquals("Delicious!", testRestaurant.getInformation());
    }

    @Test
    public void testNewYorkCityRestaurant() {
        testRestaurant = new Restaurant("Brooklyn Taste", "New York City", "Good!");
        assertEquals("Brooklyn Taste", testRestaurant.getName());
        assertEquals("New York City", testRestaurant.getLocation());
        assertEquals("Good!", testRestaurant.getInformation());
    }

    @Test
    public void testConstructorInvalidLocation() {
        testRestaurant = new Restaurant("Burger King", "Montreal", "Weird?");
        assertEquals("Burger King", testRestaurant.getName());
        assertEquals("Invalid Location", testRestaurant.getLocation());
        assertEquals("Weird?", testRestaurant.getInformation());
    }

}

