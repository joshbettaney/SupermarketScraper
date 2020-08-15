package model;

/**
 * @author Joshua Bettaney*
 * A class to model the products that are scraped from the supermarket websites.
 */
public class Product {


    /** Name identifier for product object. */
    private String name;
    /** Price of product object. */
    private float price;
    /** Supermarket identifier for product object. */
    private int supermarketID;

    /**
     * Constructor for product object.
     * @param productName - Name identifier for product object.
     * @param productPrice - Price of product object.
     * @param productSupermarketID - Supermarket identifier for product object.
     */
    public Product(final String productName,
                   final float productPrice,
                   final int productSupermarketID) {
        this.name = productName;
        this.price = productPrice;
        this.supermarketID = productSupermarketID;
    }
    /**
     * Getter method for getting the products name.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for getting the products price.
     * @return float
     */
    public float getPrice() {
        return price;
    }

    /**
     * Getter method for getting the id of the supermarket the product is from.
     * @return int
     */
    public int getSupermarketID() {
        return supermarketID;
    }

    /**
     * Setter method for product name.
     * @param productName String
     */
    public void setName(final String productName) {
        this.name = productName;
    }

    /**
     * Setter method for product price.
     * @param productPrice float.
     */
    public void setPrice(final float productPrice) {
        this.price = productPrice;
    }
}
