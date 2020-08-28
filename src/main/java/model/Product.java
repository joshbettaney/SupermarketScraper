package model;

import javax.persistence.*;

/**
 * @author Joshua Bettaney*
 * A class to model the products that are scraped from the supermarket websites.
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private int id;
    /** Name identifier for product object. */
    @Column(name = "prod_name")
    private String name;
    /** Price of product object. */
    @Column(name = "prod_price")
    private double price;
    /** Supermarket identifier for product object. */
    private int supermarketID;

    /**
     * Constructor for product object.
     * @param productName - Name identifier for product object.
     * @param productPrice - Price of product object.
     * @param productSupermarketID - Supermarket identifier for product object.
     */
    public Product(final String productName,
                   final double productPrice,
                   final int productSupermarketID) {
        this.name = productName;
        this.price = productPrice;
        this.supermarketID = productSupermarketID;
    }



    /**
     * Default Constructor for Hibernate to generate objects.
     */
    public Product() {
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
    public double getPrice() {
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
    public void setPrice(final double productPrice) {
        this.price = productPrice;
    }

    public int getId() {
        return id;
    }
}
