/*  
     *The ItemOrder class represents an order of an item and its quantity. It contains an item object and an int variable for the quantity.
The class provides methods to get the item and quantity of the order and also overrides the toString method for displaying the order.
     * TCSS 305 – Winter 2023 
     * Assignment 1 
     */

package model;

public final class ItemOrder {
    
    private Item item;
    private int quantity;
    
    /*
    @param theItem the item in the order
    @param theQuantity the quantity of the item in the order
    Constructor that creates an ItemOrder object with an item and its quantity
    @throws NullPointerException if theItem is null
    @throws IllegalArgumentException if theQuantity is negative
    */
    
    public ItemOrder(final Item theItem, final int theQuantity) {
        if(theItem == null) throw new NullPointerException();
        if(theQuantity < 0) throw new IllegalArgumentException();
        item = theItem;
        quantity = theQuantity;
    }

    /**
    This method returns the item of the order
    @return item of the order
    */
    
    public Item getItem() {
        return item;
    }
    
    /**
    This method returns the quantity of the item in the order
    @return quantity of the item in the order
    */
    
    public int getQuantity() {
        return quantity;
    }

    /**
    This method returns a string representation of the item order, including its item and its quantity
    @return string representation of the item order
    */
    
    @Override
    public String toString() {
        String str = "Item: "+item.toString()+" Quantity: "+quantity;
        return str;
    }

}
