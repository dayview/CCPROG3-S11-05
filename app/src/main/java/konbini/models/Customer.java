package konbini.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer class representing store customers in the convenience store system
 * Handles customer operations including shopping cart, membership, and points
 * @author Leon Pavino
 * @version 1.0
 */
public class Customer {
    private String customerID;
    private String name;
    private String password;
    private boolean isMember;
    private int points;

    /**
     * Constructor to create a new Customer
     * @param customerID The unique ID for the customer
     * @param name The customer's name
     * @param password The customer's login password
     * @param isMember Whether the customer has membership status
     * @param points The customer's loyalty points balance
     */
    public Customer(String customerID, String name, String password, boolean isMember, int points) {
        this.customerID = customerID;
        this.name = name;
        this.password = password;
        this.isMember = isMember;
        this.points = points;
    }

    /**
     * Simplified constructor for basic customer creation
     * @param customerID The unique ID for the customer
     * @param password The customer's login password
     */
    public Customer(String customerID, String password) {
        this.customerID = customerID;
        this.password = password;
        this.name = "";
        this.isMember = false;
        this.points = 0;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isMember() {
        return isMember;
    }

    public int getPoints() {
        return points;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMember(boolean isMember) {
        this.isMember = isMember;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Adds a new product to the inventory
     * @param p The Product to add
     * @param quantity The quantity of the product to add
     */
    public void addToCart(Product p, int quantity) {
        if (p != null && quantity > 0) {
            System.out.println("Added " + quantity + " of " + p.toString() + " to cart");
            // TODO: To be implemented + should interact with ShoppingCart class
        } else {
            System.out.println("Invalid product or quantity.");
        }
    }

    /**
     * Checks if the customer has an active membership
     */
    public void checkMembership() {
        if (isMember) {
            System.out.println("Customer " + customerID + " is a member.");
        } else {
            System.out.println("Customer " + customerID + " is not a member.");
        }
    }

    /**
     * Redeems loyalty points for rewards or discounts
     * @param points The number of points to redeem
     */
    public void redeemPoints(int points) {
        if (points > 0 && points <= this.points) {
            this.points -= points;
            System.out.println("Redeemed " + points + " points. Remaining: " + this.points);
        } else {
            System.out.println("Invalid points amount or insufficient points.");
        }
    }
}

    /**
     * Allows customer to browse products by categories
     * @param categories List of product categories to browse
     */
    public void browseCatalog(List<Category> categories) {
        if (categories != null && !categories.isEmpty()) {
            System.out.println("Browsing catalog with " + categories.size() + " categories.");
            // TODO: To be implemented + display products filtered by categories
        } else {
            System.out.println("No categories available.");
        }
    }

    /**
     * Authenticates customer login credentials
     * @param customerID The customer's ID
     * @param password The customer's password
     * @return true if credentials are valid, false otherwise
     */
    public boolean login(String customerID, String password) {
        return this.customerID.equals(customerID) && this.password.equals(password);
    }

    /**
     * Validates customer information for updates or verification
     * @param customerID The customerID to validate
     * @param password The password to validate
     * @return true if information is valid, false otherwise
     */
    public boolean validateInfo(String customerID, String password) {
        return this.customerID.equals(customerID) && this.password.equals(password);
    }

    /**
     * Calculates and adds earned points based on purchase total
     * @param total The total amount of the purchase
     * @return The number of points earned
     */
    public int computeEarnedPoints(double total) {
        int earnedPoints = 0;
        if (isMember && total > 0) {
            // Example: 1 point per dollar spent for members
            earnedPoints = (int) total;
            this.points += earnedPoints;
            System.out.println("Earned " + earnedPoints + " points. Total: " + this.points);
        }
        return earnedPoints;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", name='" + name + '\'' + ", isMember=" + role + '\'' + '}';
    }
}