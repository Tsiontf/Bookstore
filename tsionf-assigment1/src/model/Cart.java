/*
 * The Cart class represents a shopping cart. It contains an ArrayList of ItemOrder objects, which contains an item and its quantity.
The class has various methods for manipulating the cart, such as adding an item, calculating the total cost of the items in the cart,
clearing the cart, and getting the size of the cart. It also has a boolean variable "membership" that checks if the customer is a member,
and if so, calculates the total cost of the items in the cart with bulk discounts.
The toString() method is overridden to return a string representation of the items in the cart.
 * 
 * @author Tsion Fufa (Student)
 * @version Winter 2023 
 * Assignment 1 
 */

package model;

import java.math.BigDecimal;
import java.util.ArrayList;  

public class Cart {

    private ArrayList<ItemOrder> cart;
    private boolean membership;
    
    public Cart() {
        cart = new ArrayList<ItemOrder>();
    }
    
    /**
    @param theOrder The ItemOrder to be added to the cart.
    This method adds an ItemOrder to the cart. If an ItemOrder with the same item already exists in the cart, it replaces it with the new ItemOrder.
    */
    
    public void add(final ItemOrder theOrder) {
        boolean replaced = false;
        int index = 0;
        for(ItemOrder order: cart) {
            if(order.getItem().equals(theOrder.getItem())) {
                cart.set(index, theOrder);
                replaced = true;
            }
            index+=1;
        }
        
        if(!replaced) {
            cart.add(theOrder);
        }
    }

   /**
    @param theMembership boolean value to set the customer membership status
    This method sets the membership status of the customer, which is used to calculate the total cost of the items in the cart with bulk discounts.
    */
    
    public void setMembership(final boolean theMembership) {
        this.membership = theMembership;
    }

    /**
    This method calculates the total cost of the items in the cart. If the customer is a member and an item in the cart is eligible for bulk discounts,
    the bulk discount price is used to calculate the total.
    @return total cost of the items in the cart.
    */
    
    public BigDecimal calculateTotal() {
        BigDecimal total = new BigDecimal("0");
        int qty;
        for(ItemOrder order: cart) {
            qty = order.getQuantity();
            if(membership && order.getItem().isBulk()) {
                int bulkQty = order.getItem().getBulkQuantity();
                while(qty > bulkQty) {
                    total = total.add(order.getItem().getBulkPrice());
                    qty-=bulkQty;
                }
                total = total.add(order.getItem().getPrice().multiply(new BigDecimal(qty)));
            }else {
                total = total.add(order.getItem().getPrice().multiply(new BigDecimal(qty)));
            }
            
        }
        return total;
    }
    
    /**

    This method clears all the items from the cart.
    */
    
    public void clear() {
        cart.clear();
    }
    
    /**

    This method returns the number of items in the cart
    @return the number of items in the cart
    */
    
    public int getCartSize() {
        return cart.size();
    }

    /**

    This method returns a string representation of the items in the cart.
    @return string representation of the items in the cart.
    */
    
    @Override
    public String toString() {
        String str = "Items in cart:\n";
        for(ItemOrder order: cart) {
            str+="\t"+order.toString()+"\n";
        }
        return str;
    }

}
