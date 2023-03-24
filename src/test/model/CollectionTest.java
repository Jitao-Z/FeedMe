package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollectionTest {
    private Collection co1;
    private Restaurant r1;
    private Restaurant r2;
    private Restaurant r3;

    @BeforeEach
    public void runBefore() {
        co1 = new Collection();
        r1 = new Restaurant("KFC", "Vancouver", "Beautiful!");
        r2 = new Restaurant("Piazza Hut", "Vancouver", "Fantastic!");
        r3 = new Restaurant("Burger King", "Vancouver", "Fabulous");
    }

    @Test
    public void testConstructor() {
        assertTrue(co1.getListRestaurant().isEmpty());
        assertEquals(0, co1.getListRestaurant().size());
    }

    @Test
    public void testAddOneRestaurant() {
        co1.addRestaurant(r1);
        assertEquals(r1, co1.getListRestaurant().get(0));
    }

    @Test
    public void testAddTwoRestaurant() {
        co1.addRestaurant(r1);
        assertEquals(r1, co1.getListRestaurant().get(0));
        co1.addRestaurant(r2);
        assertEquals(r2, co1.getListRestaurant().get(1));
        assertEquals(2, co1.getListRestaurant().size());
    }

    @Test
    public void testAddThreeRestaurant() {
        co1.addRestaurant(r1);
        assertEquals(r1, co1.getListRestaurant().get(0));
        co1.addRestaurant(r2);
        assertEquals(r2, co1.getListRestaurant().get(1));
        co1.addRestaurant(r3);
        assertEquals(r3, co1.getListRestaurant().get(2));

        assertEquals(3, co1.getListRestaurant().size());
    }

    @Test
    public void testRemoveOneRestaurant() {
        co1.addRestaurant(r1);
        co1.addRestaurant(r2);
        co1.addRestaurant(r3);
        co1.removeRestaurant(r1);
        assertEquals(r2, co1.getListRestaurant().get(0));
        assertEquals(2, co1.getListRestaurant().size());
    }

    @Test
    public void testRemoveTwoRestaurant() {
        co1.addRestaurant(r1);
        co1.addRestaurant(r2);
        co1.addRestaurant(r3);
        co1.removeRestaurant(r1);
        assertEquals(r2, co1.getListRestaurant().get(0));
        co1.removeRestaurant(r3);
        assertEquals(r2, co1.getListRestaurant().get(0));
        assertEquals(1, co1.getListRestaurant().size());
    }

    @Test
    public void testRemoveThreeRestaurant() {
        co1.addRestaurant(r1);
        co1.addRestaurant(r2);
        co1.addRestaurant(r3);
        co1.removeRestaurant(r3);
        co1.removeRestaurant(r2);
        co1.removeRestaurant(r1);
        assertEquals(0, co1.getListRestaurant().size());
    }

    @Test
    public void testRemoveVeryFirstRestaurant() {
        co1.addRestaurant(r1);
        co1.addRestaurant(r2);
        co1.addRestaurant(r3);
        co1.removeRestaurant(r1);
        assertEquals(r2, co1.getListRestaurant().get(0));
        assertEquals(2, co1.getListRestaurant().size());
    }

    @Test
    public void testRemoveTheSecondRestaurant() {
        co1.addRestaurant(r1);
        co1.addRestaurant(r2);
        co1.addRestaurant(r3);
        co1.removeRestaurant(r2);
        assertEquals(r3, co1.getListRestaurant().get(1));
        assertEquals(2, co1.getListRestaurant().size());
    }

}
