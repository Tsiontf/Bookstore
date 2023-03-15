package tests;

import org.junit.Test;

import model.Item;
import model.ItemOrder;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ItemOrderTest {

    @Test
    public void getItem() {
        Item item = new Item("Bread", new BigDecimal(32.55));
        ItemOrder itemOrder = new ItemOrder(item, 4);
        assertEquals(item, itemOrder.getItem());
    }

    @Test
    public void getQuantity() {
        Item item = new Item("Bread", new BigDecimal(32.55));
        ItemOrder itemOrder = new ItemOrder(item, 4);
        assertEquals(4, itemOrder.getQuantity());
    }
}