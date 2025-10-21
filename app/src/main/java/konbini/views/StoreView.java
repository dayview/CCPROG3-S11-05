package konbini.views;

import konbini.models.*;
import java.util.List;
import java.util.Scanner;

/**
 * StoreView handles all console-based user interface
 * Displays information and captures user input
 * @author Leon Pavino
 * @version 1.0
 */

public class StoreView {
    private Scanner scanner;

    /**
     * Constructor initializes view
     */
    public StoreView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays main menu
     */
    public void displayMainMenu() {
        System.out.println("\n=== CONVENIENCE STORE SYSTEM ===");
        System.out.println("1. Customer Login");
        System.out.println("2. Employee Login");
        System.out.println("3. Exit");
        System.out.println("Select option: " );
    }

    /**
     * Displays customer menu
     */
    public void displayCustomerMenu() {
        System.out.println("\n=== CUSTOMER MENU ===");
        System.out.println("1. Browse Products");
        System.out.println("2. View Cart");
        System.out.println("3. Checkout");
        System.out.println("4. Logout");
        System.out.println("Select option: ");
    }

    /**
     * Displays employee menu
     */
    public void displayEmployeeMenu() {
        System.out.println("\n=== EMPLOYEE MENU ===");
        System.out.println("1. Add Product");
        System.out.println("2. Restock Product");
        System.out.println("3. Update Product");
        System.out.println("4. View Inventory");
        System.out.println("5. Save Inventory");
        System.out.println("6. Load Inventory");
        System.out.println("7. Logout");
        System.out.println("Select option: ");
    }

    /**
     * Displays categories
     * @param categories List of categories to display
     */
    public void displayCategories(List<Category> categories) {
        System.out.println("\n=== PRODUCT CATEGORIES ===");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName());
        }
    }

    /**
     * Displays products
     * @param products List of products to display
     */
    public void displayProducts(List<Product> products) {
        System.out.println("\n=== PRODUCTS ===");
        if (products.isEmpty()) {
            System.out.println("No products available");
            return;
        }

        for (Product p : products) {
            System.out.println(p);
        }
    }

    /**
     * Displays receipt
     * @param receipt Receipt to display
     */


    /**
     * Displays generic message
     * @param message Message to display
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Gets user input as string
     * @param prompt Prompt message
     * @return User input
     */
    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    /**
     * Gets user input as integer
     * @param prompt Prompt message
     * @return User input as int
     */
    public int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Invalid input. " + prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    /**
     * Gets user input as double
     * @param prompt Prompt message
     * @return User input as double
     */
    public double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.print("Invalid input. " + prompt);
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    /**
     * Closes scanner
     */
    public void close() {
        scanner.close();
    }
}
