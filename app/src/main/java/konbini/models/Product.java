package konbini.models;

import java.time.LocalDate;

/**
 * Product class representing items sold in the convenience store
 * Handles product information including pricing, stock, location, and categorization
 * @author Leon Pavino and Massi Colcol
 * @version 1.0
 */
public class Product {
    private String productID;
    private String name;
    private double price;
    private String brand;
    private String variant;
    private int quantityStock;
    private String expirationDate;
    private ShelfLocation shelflocation;

    /**
     * Full constructor for creating a Product with all attributes
     * @param productID Unique identifier for the product
     * @param name Product name
     * @param price Product price in pesos
     * @param brand Product brand
     * @param variant Product variant (e.g., "Zero", "Light", "Regular")
     * @param quantityStock Current stock quantity
     * @param expirationDate ExpirationDate (if applicable)
     * @param shelfLocation Physical location in store
     */
    public Product(String productID, String name, double price, String brand,
                   String variant, int quantityStock, String expirationDate,
                   ShelfLocation shelfLocation) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.variant = variant;
        this.quantityStock = quantityStock;
        this.expirationDate = expirationDate;
        this.shelfLocation = shelfLocation;
    }
}
