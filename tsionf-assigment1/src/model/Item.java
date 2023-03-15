/*
 * 
The Item class represents an item that can be added to a shopping cart. It has a name, price, and optional bulk purchase quantity and price.
The class also provides methods to check if the item is eligible for bulk purchase, get the price, bulk purchase quantity, and bulk purchase price of the item.
The class also overrides the equals, hashCode, compareTo and toString methods for comparing and displaying the items.
 *  * @author Tsion Fufa (Student)
 * @version Winter 2023 
 * Assignment 1 
 */

package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public final class Item implements Comparable<Item>{
    
    private String name;
    private BigDecimal price;
    private int bulkQuantity;
    private BigDecimal bulkPrice;
    private static NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    public Item(final String theName, final BigDecimal thePrice) {
        if(thePrice == null || theName == null) throw new NullPointerException();
        if(thePrice.signum() == 0 || theName.length() == 0) throw new IllegalArgumentException();
        this.name = theName;
        this.price = thePrice;
        this.bulkQuantity = 0;
    }

    /**
    @param theName the name of the item
    @param thePrice the price of the item
    @param theBulkQuantity the bulk purchase quantity of the item
    @param theBulkPrice the bulk purchase price of the item
    Constructor that creates an Item object with name, price, bulk purchase quantity, and bulk purchase price
    @throws NullPointerException if theName, thePrice or theBulkPrice is null
    @throws IllegalArgumentException if thePrice is zero or theName is empty, theBulkQuantity is negative or theBulkPrice is zero
    */
    
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {
        if(thePrice == null || theName == null || theBulkPrice == null) throw new NullPointerException();
        if(thePrice.signum() == 0 || theName.length() == 0 || theBulkQuantity < 0 || theBulkPrice.signum() == 0) throw new IllegalArgumentException();
        
        this.name = theName;
        this.price = thePrice;
        this.bulkQuantity = theBulkQuantity;
        this.bulkPrice = theBulkPrice;
    }

    /**
    This method returns the price of the item
    @return price of the item
    */
    
    public BigDecimal getPrice() {
        return price;
    }

    /**
    This method returns the bulk purchase quantity of the item
    @return bulk purchase quantity of the item
    */
    
    public int getBulkQuantity() {
        return bulkQuantity;
    }

    /**
    This method returns the bulk purchase price of the item
    @return bulk purchase price of the item
    */
    
    public BigDecimal getBulkPrice() {
        return bulkPrice;
    }

    /**
    This method checks if the item is eligible for bulk purchase
    @return true if item is eligible for bulk purchase, false otherwise
    */
    
    public boolean isBulk() {
        return bulkQuantity > 0;
    }

    /**
    This method returns a string representation of the item, including its name, price, and if applicable, its bulk purchase details
    @return string representation of the item
    */
    
    @Override
    public String toString() {
        String str = name+", "+Item.formatter.format(price);
        if(isBulk()) {
            str+=" ("+bulkQuantity+" for "+Item.formatter.format(bulkPrice)+")";
        }
        return str;
    }

    /**
    This method compares the current item with the specified object for equality
    @param theOther the object to be compared for equality
    @return true if the specified object is equal to the current object, false otherwise
    */
    
    @Override
    public boolean equals(final Object theOther) {
        if(theOther instanceof Item) {
            return theOther.hashCode() == hashCode();
        }
        return false;
    }

    /**
    This method returns the hash code value for the current object
    @return hash code value for the current object
    */
    
    @Override
    public int hashCode() {

        return toString().hashCode();
    }


    @Override
    public int compareTo(Item o) {
        if(name.compareTo(o.name) == 0)
            return getPrice().compareTo(o.getPrice());
        return name.compareTo(o.name);
    }
    
    public boolean orderByPrice(Item other) {
        return price.compareTo(other.getPrice()) > 0;
    }

}
