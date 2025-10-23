package konbini.models;

import java.time.LocalDate;

/**
 * Product class representing items sold in the convenience store
 * Handles product information including pricing, stock, location, and categorization
 * @author Leon Pavino
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
    private ShelfLocation shelfLocation;

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

    /**
     * Simplified constructor for basic product creation
     * @param productID Unique identifier
     * @param name Product name
     * @param price Product price
     * @param quantityStock Initial stock
     */
    public Product(String productID, String name, double price, int quantityStock) {
        this(productID, name, price, "", "", quantityStock, "", null);
    }

    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getVariant() {
        return variant;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public ShelfLocation getShelfLocation() {
        return shelfLocation;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setShelfLocation(ShelfLocation location) {
        this.shelfLocation = location;
    }

    /**
     * Updates product details
     * @param name New product name
     * @param price New price
     * @param brand New brand
     */
    public void updateInfo(String name, double price, String brand) {
        if (name != null && !name.isEmpty())
            this.name = name;
        if (price > 0)
            this.price = price;
        if (brand != null)
            this.brand = brand;
        System.out.println("Product " + productID + " updated successfully.");
    }

    /**
     * Restocks the product by adding quantity
     * @param amount Amount to add to current stock
     * @return true if restock successful, false otherwise
     */
    public boolean restock(int amount) {
        if (amount > 0) {
            this.quantityStock += amount;
            System.out.println("Restocked " + amount + " units. New stock: " + quantityStock);
            return true;
        }
        System.out.println("Invalid restock amount.");
        return false;
    }

    /**
     * Reduces stock quantity (for purchases)
     * @param amount Amount to reduce from stock
     * @return true if stock reduced successfully, false if insufficient stock
     */
    public boolean reduceStock(int amount) {
        if (amount > 0 && amount <= quantityStock) {
            this.quantityStock -= amount;
            return true;
        }
        return false;
    }

    /**
     * Checks if product has expired based on current date
     * @return true if product is expired, false otherwise
     */
    public boolean isExpired() {
        if (expirationDate == null || expirationDate.isEmpty()) {
            return false;
        }
        try {
            LocalDate expDate = LocalDate.parse(expirationDate);
            return LocalDate.now().isAfter(expDate);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("[%s] %s %s %s - ₱%.2f (Stock: %d)",
                productID, brand, name, variant, price, quantityStock);
    }
}