package tests;

import org.junit.Test;

import model.Item;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void getPrice() {
        Item item = new Item("Bread", new BigDecimal(25.75));
        assertEquals(new BigDecimal(25.75), item.getPrice());
    }

    @Test
    public void getBulkQuantity() {
        Item item = new Item("Bread", new BigDecimal(25.75), 10, new BigDecimal(200.57));
        assertEquals(10, item.getBulkQuantity());
    }

    @Test
    public void getBulkPrice() {
        Item item = new Item("Bread", new BigDecimal(25.75), 10, new BigDecimal(200.57));
        assertEquals(new BigDecimal(200.57), item.getBulkPrice());
    }

    @Test
    public void isBulk() {
        Item item = new Item("Bread", new BigDecimal(25.75), 10, new BigDecimal(200.57));
        assertTrue(item.isBulk());
    }

    @Test
    public void isNotBulk() {
        Item item = new Item("Bread", new BigDecimal(25.75));
        assertTrue(!item.isBulk());
    }

    @Test
    public void testToString() {
        Item item = new Item("Bread", new BigDecimal(25.75));
        assertEquals(item.toString(), "Bread, $25.75");
    }

    @Test
    public void testToStringBulk() {
        Item item = new Item("Bread", new BigDecimal(25.75), 10, new BigDecimal(200.57));
        assertEquals(item.toString(), "Bread, $25.75 (10 for $200.57)");
    }

    @Test
    public void testEquals() {
        Item item = new Item("Bread", new BigDecimal(25.75));
        Item item2 = new Item("Bread", new BigDecimal(25.75), 10, new BigDecimal(200.57));
        Item item3 = new Item("Bread", new BigDecimal(25.75));
        Item item4 = new Item("Bread", new BigDecimal(25.75), 10, new BigDecimal(200.57));
        Item item5 = new Item("Bread", new BigDecimal(25.80), 10, new BigDecimal(200.57));

        assertTrue(item.equals(item3));
        assertTrue(item2.equals(item4));
        assertFalse(item.equals(item2));
        assertFalse(item2.equals(item5));
    }
}