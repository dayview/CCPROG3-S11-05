package konbini.models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Inventory class managing all products and categories in the store
 * Handles product operations, category management, and file persistence
 * @author Leon Pavino
 * @version 1.1
 */

public class Inventory {
    private List<Product> products;
    private List<Category> categories;

    /**
     * Constructor initializes empty inventory
     */
    public Inventory() {
        this.products = new ArrayList<>();
        this.categories = new ArrayList<>();
        initializeDefaultCategories();
    }

    /**
     * Initializes the 5 required product categories
     */
    private void initializeDefaultCategories() {
        categories.add(new Category(1, "Food"));
        categories.add(new Category(2, "Beverages"));
        categories.add(new Category(3, "Toiletries"));
        categories.add(new Category(4, "Home Care"));
        categories.add(new Category(5, "Medications"));
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    /**
     * Adds a new product to inventory
     * @param p Product to add
     * @param quantity Initial quantity
     */
    public void addProduct(Product p, int quantity) {
        if (p != null) {
            p.setQuantityStock(quantity);
            products.add(p);
            System.out.println("Product added: " + p.getName() + " (Qty: " + quantity + ")");
        }
    }

    /**
     * Removes a product from inventory by product object
     * @param productID Product ID to remove
     * @return true if removed, false otherwise
     */
    public boolean removeProduct(String productID) {
        Product product = getProductByID(productID);
        if (product != null) {
            products.remove(product);
            System.out.println("Product removed: " + productID);
            return true;
        }
        return false;
    }

    /**
     * Gets product by ID
     * @param productID Product identifier
     * @return Product object or null if not found
     */
    public Product getProductByID(String productID) {
        for (Product p : products) {
            if (p.getProductID().equals(productID)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Gets all products belonging to a specific category
     * @param categoryName Category name to filter by
     * @return List of products in that category
     */
    public List<Product> getProductsByCategory(String categoryName) {
        Category category = getCategoryByName(categoryName);
        if (category != null) {
            return category.getProducts();
        }
        return new ArrayList<>();
    }

    /**
     * Gets category by name
     * @param name Category name
     * @return Category object or null
     */
    public Category getCategoryByName(String name) {
        for (Category c : categories) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Updates product information
     * @param productID Product to update
     * @param name New name
     * @param price New price
     * @param brand New brand
     */
    public void updateProductInfo(String productID, String name, double price, String brand) {
        Product product = getProductByID(productID);
        if (product != null) {
            product.updateInfo(name, price, brand);
        } else {
            System.out.println("Product not found: " + productID);
        }
    }

    /**
     * Restocks a product
     * @param productID Product to restock
     * @param amount Amount to add
     */
    public void restockProduct(String productID, int amount) {
        Product product = getProductByID(productID);
        if (product != null) {
            product.restock(amount);
        } else {
            System.out.println("Product not found for restocking: " + productID);
        }
    }

    /**
     * Reduces stock for a purchase
     * @param productID Product being purchased
     * @param amount Quantity purchased
     * @return true if stock reduced successfully
     */
    public boolean reduceStock(String productID, int amount) {
        Product product = getProductByID(productID);
        if (product != null) {
            return product.reduceStock(amount);
        }
        return false;
    }

    /**
     * Checks and removes all expired products
     */
    public void handleExpiredInventory() {
        List<Product> expiredProducts = new ArrayList<>();
        for (Product p : products) {
            if (p.isExpired()) {
                expiredProducts.add(p);
            }
        }

        for (Product p : expiredProducts) {
            removeProduct(p.getProductID());
            System.out.println("Expired product removed: " + p.getName());
        }
    }

    /**
     * Saves inventory to file
     * @param path File path to save to
     */
    public void saveFile(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("=== PRODUCTS ===\n");
            for (Product p : products) {
                writer.write(String.format("%s|%s|%.2f|%s|%s|%d|%s\n",
                        p.getProductID(), p.getName(), p.getPrice(),
                        p.getBrand(), p.getVariant(), p.getQuantityStock(),
                        p.getExpirationDate()));
            }
            System.out.println("Inventory saved to: " + path);
        } catch (IOException e) {
            System.err.println("Error saving inventory: " + e.getMessage());
        }
    }

    /**
     * Loads inventory from file
     * @param path File path to load from
     */
    public void loadFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            boolean readingProducts = false;

            while ((line = reader.readLine()) != null) {
                if (line.equals("=== PRODUCTS ===")) {
                    readingProducts = true;
                    continue;
                }

                if (readingProducts && !line.trim().isEmpty()) {
                    String[] parts = line.split("\\|");
                    if (parts.length >= 6) {
                        Product p = new Product(
                                parts[0], // productID
                                parts[1], // name
                                Double.parseDouble(parts[2]), // price
                                parts[3], // brand
                                parts[4], // variant
                                Integer.parseInt(parts[5]), // quantity
                                parts.length > 6 ? parts[6] : "", // expiration
                                null // shelf location
                        );
                        products.add(p);
                    }
                }
            }
            System.out.println("Inventory loaded from: " + path);
        } catch (IOException e) {
            System.err.println("Error loading inventory: " + e.getMessage());
        }
    }

    /**
     * Displays all inventory products
     */
    public void displayInventory() {
        System.out.println("\n=== INVENTORY ===");
        for (Category category : categories) {
            System.out.println("\n" + category.getName() + ":");
            List<Product> categoryProducts = getProductsByCategory(category.getName());
            if (categoryProducts.isEmpty()) {
                System.out.println("No products in this category");
            } else {
                for (Product p : categoryProducts) {
                    System.out.println(" " + p);
                }
            }
        }
    }
}