package tests;

import model.Cart;
import model.Item;
import model.ItemOrder;

import static org.junit.Assert.*;

import java.math.BigDecimal;

public class CartTest {

    @org.junit.Test
    public void add() {
        Cart cart = new Cart();
        cart.add(new ItemOrder(new Item("Bread", new BigDecimal(10.5)), 5));
        cart.add(new ItemOrder(new Item("Butter", new BigDecimal(10.5)), 5));
        cart.add(new ItemOrder(new Item("Knife", new BigDecimal(10.5)), 5));

        assertEquals(3, cart.getCartSize());
    }


    @org.junit.Test
    public void calculateTotal() {
        Item item = new Item("Bread", new BigDecimal(25));
        Item item2 = new Item("Bread", new BigDecimal(25), 3, new BigDecimal(50));

        BigDecimal t1 = new BigDecimal(50);
        BigDecimal t2 = new BigDecimal(100);
        BigDecimal t3 = new BigDecimal(75);

        Cart cart = new Cart();
        cart.add(new ItemOrder(item, 2));
        assertEquals(t1, cart.calculateTotal());
        cart.clear();
        cart.add(new ItemOrder(item2, 4));
        assertEquals(t2, cart.calculateTotal());
        cart.setMembership(true);
        cart.add(new ItemOrder(item2, 4));
        assertEquals(t3, cart.calculateTotal());
    }

    @org.junit.Test
    public void clear() {
        Cart cart = new Cart();
        cart.add(new ItemOrder(new Item("Bread", new BigDecimal(10.5)), 5));
        cart.add(new ItemOrder(new Item("Butter", new BigDecimal(10.5)), 5));
        cart.add(new ItemOrder(new Item("Knife", new BigDecimal(10.5)), 5));

        assertEquals(3, cart.getCartSize());
        cart.clear();
        assertEquals(0, cart.getCartSize());
    }

}