package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CityTest {
    private City c1;
    private Restaurant r1;
    private Restaurant r2;
    private Restaurant r3;
    private Restaurant r4;

    @BeforeEach
    public void runBefore() {
        c1 = new City("Vancouver");
        r1 = new Restaurant("KFC", "Vancouver");
        r2 = new Restaurant("Piazza Hut", "Vancouver");
        r3 = new Restaurant("Burger King", "Vancouver");
        r4 = new Restaurant("Corner UBC", "Vancouver");
    }

    @Test
    public void testConstructor() {
        assertEquals("Vancouver", c1.getName());
        assertTrue(c1.getInternalArray().isEmpty());
    }

    @Test
    public void testPlusOneRestaurant() {
        c1.plusRestaurant(r1);
        assertEquals(r1, c1.getInternalArray().get(0));
        assertEquals(1, c1.getInternalArray().size());
    }

    @Test
    public void testPlusTwoRestaurant() {
        c1.plusRestaurant(r1);
        assertEquals(r1, c1.getInternalArray().get(0));
        c1.plusRestaurant(r2);
        assertEquals(r2, c1.getInternalArray().get(1));
        assertEquals(2, c1.getInternalArray().size());
    }

    @Test
    public void testPlusThreeRestaurant() {
        c1.plusRestaurant(r1);
        assertEquals(r1, c1.getInternalArray().get(0));
        c1.plusRestaurant(r2);
        assertEquals(r2, c1.getInternalArray().get(1));
        c1.plusRestaurant(r3);
        assertEquals(r3, c1.getInternalArray().get(2));
        assertEquals(3, c1.getInternalArray().size());
    }

    @Test
    public void testPlusFourRestaurant() {
        c1.plusRestaurant(r1);
        assertEquals(r1, c1.getInternalArray().get(0));
        c1.plusRestaurant(r2);
        assertEquals(r2, c1.getInternalArray().get(1));
        c1.plusRestaurant(r3);
        assertEquals(r3, c1.getInternalArray().get(2));
        c1.plusRestaurant(r4);
        assertEquals(r4, c1.getInternalArray().get(3));

        assertEquals(4, c1.getInternalArray().size());
    }

}