package konbini.controllers;

import konbini.models.*;
import konbini.services.*;
import konbini.views.StoreView;
import java.util.List;

/**
 * StoreController manages business logic and coordinates between Model and View
 * Implements MVC pattern for the convenience store application
 * @author Leon Pavino
 * @version 1.1
 */
public class StoreController {
    private Inventory inventory;
    private StoreView view;
    private Customer currentCustomer;
    private Employee currentEmployee;
    private Cart currentCart;

    /**
     * Constructor initializes controller
     */
    public StoreController() {
        this.inventory = new Inventory();
        this.view = new StoreView();
        this.currentCart = new Cart();
    }

    /**
     * Handles adding new product (Employee function)
     * @param product Product to add
     */
    public void handleAddProduct(Product product, int quantity) {
        if (currentEmployee == null) {
            view.displayMessage("Access denied: Employee login required");
            return;
        }
        inventory.addProduct(product, quantity);
        view.displayMessage("Product added successfully");
    }

    /**
     * Handles purchase transaction
     * @param customer Customer making purchase
     * @param cart Shopping cart
     * @param payment Payment details
     */
    public void handlePurchase(Customer customer, Cart cart, Payment payment) {
        if (cart.isEmpty()) {
            view.displayMessage("Cart is empty");
            return;
        }

        List<CartItem> cartItems = cart.getItems();

        Transaction transaction = new Transaction(customer, cart);
        transaction.processTransaction(payment);

        if (transaction.getPayment() == null || !transaction.getPayment().validatePayment()) {
            view.displayMessage("Transaction failed: Insufficient payment");
            for (CartItem item : cartItems) {
                inventory.restoreStock(item.getProduct().getProductID(), item.getQuantity());
            }
            view.displayMessage("Items returned to inventory");
            return;
        }

        Receipt receipt = transaction.generateReceipt();
        if (receipt != null) {
            view.displayReceipt(receipt);
            try {
                receipt.saveFile("receipts/" + transaction.getTransactionID() + ".txt");
            } catch (Exception e) {
                view.displayMessage("Error saving receipt: " + e.getMessage());
            }
        }
        cart.clear();
    }

    /**
     * Handles product restocking
     * @param productID Product to restock
     * @param amount Amount to add
     */
    public void handleRestock(String productID, int amount) {
        if (currentEmployee == null) {
            view.displayMessage("Access denied: Employee login required");
            return;
        }
        inventory.restockProduct(productID, amount);
    }

    /**
     * Handles loading inventory from file
     * @param path File path
     */
    public void handleLoadInventory(String path) {
        inventory.loadFile(path);
        view.displayMessage("Inventory loaded");
    }

    /**
     * Handles saving inventory to file
     * @param path File path
     */
    public void handleSaveInventory(String path) {
        inventory.saveFile(path);
        view.displayMessage("Inventory saved");
    }

    /**
     * Handles browsing catalog
     * @param categories Categories to display
     */
    public void handleBrowseCatalog(List<Category> categories) {
        view.displayCategories(categories);
    }

    /**
     * Handles customer login
     * @param customerID Customer ID
     * @param password Password
     * @return true if login successful
     */
    public boolean handleCustomerLogin(String customerID, String password) {
        currentCustomer = new Customer(customerID, password);
        return true;
    }

    /**
     * Handles employee login
     * @param employeeID Employee ID
     * @param password Password
     * @return true if login successful
     */
    public boolean handleEmployeeLogin(int employeeID, String password) {
        currentEmployee = new Employee(employeeID, "Employee", "Staff", password);
        return true;
    }

    /**
     * Adds product to current cart
     * @param productID Product to add
     * @param quantity Quantity
     */
    public void addToCart(String productID, int quantity) {
        Product product = inventory.getProductByID(productID);
        if (product != null) {
            if (product.getQuantityStock() >= quantity) {
                currentCart.addItem(product, quantity);
                inventory.reduceStock(productID, quantity);
            } else {
                view.displayMessage(String.format("Insufficient stock. Available: %d", product.getQuantityStock()));
            }
        } else {
            view.displayMessage("Product not found");
        }
    }

    /**
     * Gets current inventory
     * @return Inventory object
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Gets current cart
     * @return Cart object
     */
    public Cart getCurrentCart() {
        return currentCart;
    }
}