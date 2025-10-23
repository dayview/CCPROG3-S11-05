package konbini;

import konbini.controllers.StoreController;
import konbini.models.*;
import konbini.services.*;
import konbini.views.StoreView;

/**
 * Main application class for Convenience Store Simulation (named Konbini for cute purposes ;3)
 * Provides console-based interface for MCO1
 * @author Leon Pavino
 * @version 1.0
 */
public class Konbini {
    private StoreController controller;
    private StoreView view;
    private LoginSystem loginSystem;

    /**
     * Constructor initializes application
     */
    public Konbini() {
        this.controller = new StoreController();
        this.view = new StoreView();
        this.loginSystem = new LoginSystem();
        initializeInventory();
    }

    /**
     * Initializes inventory with default products
     */
    private void initializeInventory() {
        Inventory inventory = controller.getInventory();

        // Food category products
        Category food = inventory.getCategoryByName("Food");
        Product p1 = new Product("F001", "Tomato", 45.00, 10);
        Product p2 = new Product("F002", "Onion", 25.00, 10);
        Product p3 = new Product("F003", "Cucumber", 85.00, 10);
        Product p4 = new Product("F004", "Calamansi", 65.00, 10);
        Product p5 = new Product("F005", "Eggplant", 55.00, 10);
        Product p6 = new Product("F006", "Okra", 35.00, 10);
        Product p7 = new Product("F007", "Guyabano", 40.00, 10);
        Product p8 = new Product("F008", "Dragonfruit", 60.00, 10);
        Product p9 = new Product("F009", "Lemon", 50.00, 10);
        Product p10 = new Product("F010", "Baguio Beans", 65.00, 10);
        Product p11 = new Product("F011", "Tokwa (Tofu)", 35.00, 10);
        Product p12 = new Product("F012", "Apple", 50.00, 10);
        Product p13 = new Product("F013", "Cabbage", 80.00, 10);
        Product p14 = new Product("F014", "Garlic", 40.00, 10);
        Product p15 = new Product("F015", "Potato", 55.00, 10);
        food.addProduct(p1);
        food.addProduct(p2);
        food.addProduct(p3);
        food.addProduct(p4);
        food.addProduct(p5);
        food.addProduct(p6);
        food.addProduct(p7);
        food.addProduct(p8);
        food.addProduct(p9);
        food.addProduct(p10);
        food.addProduct(p11);
        food.addProduct(p12);
        food.addProduct(p13);
        food.addProduct(p14);
        food.addProduct(p15);

        // Beverage category products
        Category beverages = inventory.getCategoryByName("Beverages");
        Product b1 = new Product("B001", "Nescafe Classic", 35.00, 10);
        Product b2 = new Product("B002", "Coffeemate Coffee Creamer", 45.00, 10);
        Product b3 = new Product("B003", "Kopiko Brown 3-in-1", 40.00, 10);
        Product b4 = new Product("B004", "Nescafe Classic Refill", 20.00, 10);
        Product b5 = new Product("B005", "San Mig Coffee 3-in-1 Sugar Free", 55.00, 10);
        Product b6 = new Product("B006", "Great Taste Granules", 30.00, 10);
        Product b7 = new Product("B007", "Alaska Krem Top Coffee Creamer", 45.00, 10);
        Product b8 = new Product("B008", "Kopiko Black 3-in-1", 40.00, 10);
        Product b9 = new Product("B009", "Nescafe 3-in-1 Original", 30.00, 10);
        Product b10 = new Product("B010", "Nescafe 3-in-1 Creamy Latte", 30.00, 10);
        Product b11 = new Product("B011", "C2 Green Tea Apple", 50.00, 10);
        Product b12 = new Product("B012", "Nestea Iced Tea Honey Blend", 25.00, 10);
        Product b13 = new Product("B013", "Twinings Earl Grey Tea", 60.00, 10);
        Product b14 = new Product("B014", "Twinings Lemon Ginger Tea", 65.00, 10);
        Product b15 = new Product("B015", "Twinings Green Tea", 70.00, 10);

        beverages.addProduct(b1);
        beverages.addProduct(b2);
        beverages.addProduct(b3);
        beverages.addProduct(b4);
        beverages.addProduct(b5);
        beverages.addProduct(b6);
        beverages.addProduct(b7);
        beverages.addProduct(b8);
        beverages.addProduct(b9);
        beverages.addProduct(b10);
        beverages.addProduct(b11);
        beverages.addProduct(b12);
        beverages.addProduct(b13);
        beverages.addProduct(b14);
        beverages.addProduct(b15);

        inventory.addProduct(p1, 10);
        inventory.addProduct(p2, 10);
        inventory.addProduct(p3, 10);
        inventory.addProduct(p4, 10);
        inventory.addProduct(p5, 10);
        inventory.addProduct(p6, 10);
        inventory.addProduct(p7, 10);
        inventory.addProduct(p8, 10);
        inventory.addProduct(p9, 10);
        inventory.addProduct(p10, 10);
        inventory.addProduct(p11, 10);
        inventory.addProduct(p12, 10);
        inventory.addProduct(p13, 10);
        inventory.addProduct(p14, 10);
        inventory.addProduct(p15, 10);

        inventory.addProduct(b1, 10);
        inventory.addProduct(b2, 10);
        inventory.addProduct(b3, 10);
        inventory.addProduct(b4, 10);
        inventory.addProduct(b5, 10);
        inventory.addProduct(b6, 10);
        inventory.addProduct(b7, 10);
        inventory.addProduct(b8, 10);
        inventory.addProduct(b9, 10);
        inventory.addProduct(b10, 10);
        inventory.addProduct(b11, 10);
        inventory.addProduct(b12, 10);
        inventory.addProduct(b13, 10);
        inventory.addProduct(b14, 10);
        inventory.addProduct(b15, 10);
    }

        /**
         * Runs the main application loop
         */
        public void run() {
            boolean running = true;

            while (running) {
                view.displayMainMenu();
                int choice = view.getIntInput("");

                switch (choice) {
                    case 1:
                        customerMode();
                        break;
                    case 2:
                        employeeMode();
                        break;
                    case 3:
                        running = false;
                        view.displayMessage("Thank you for using the system!");
                        break;
                    default:
                        view.displayMessage("Invalid option");
                }
            }
            view.close();
        }

    /**
     * Customer interaction mode
     */
    private void customerMode(){
        String customerID = view.getInput("Enter Customer ID: ");
        String password = view.getInput("Enter Password: ");

        Customer customer = loginSystem.loginCustomer(customerID, password);
        if (customer == null) {
            return;
        }

        boolean loggedIn = true;
        Cart cart = controller.getCurrentCart();

        while (loggedIn) {
            view.displayCustomerMenu();
            int choice = view.getIntInput("");

            switch (choice) {
                case 1:
                    view.displayProducts(controller.getInventory().getProducts());
                    String productID = view.getInput("Enter Product ID to add (or 'back'): ");
                    if (!productID.equalsIgnoreCase("back")) {
                        int qty = view.getIntInput("Enter quantity: ");
                        controller.addToCart(productID, qty);
                    }
                    break;

                case 2:
                    cart.viewCart();
                    break;

                case 3:
                    if (cart.isEmpty()) {
                        view.displayMessage("Cart is empty");
                    } else {
                        cart.viewCart();
                        double total = cart.getSubtotal() * 1.12;
                        double payment = view.getDoubleInput("Enter payment amount: ₱");

                        Payment pay = new Payment(total, payment, new PaymentMethod(PaymentMethod.CASH));
                        controller.handlePurchase(customer, cart, pay);
                    }
                    break;

                case 4:
                    loggedIn = false;
                    view.displayMessage("Logged out successfully");
                    break;

                default:
                    view.displayMessage("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Employee interaction mode
     */
    private void employeeMode() {
        int employeeID = view.getIntInput("Enter Employee ID: ");
        String password = view.getInput("Enter Password: ");

        Employee employee = loginSystem.loginEmployee(employeeID, password);
        if (employee == null) {
            return;
        }

        boolean loggedIn = true;

        while (loggedIn) {
            view.displayEmployeeMenu();
            int choice = view.getIntInput("");

            switch (choice) {
                case 1:
                    String id = view.getInput("Product ID: ");
                    String name = view.getInput("Product Name: ");
                    double price = view.getDoubleInput("Price: ₱");
                    int qty = view.getIntInput("Initial Quantity: ");

                    Product newProduct = new Product(id, name, price, qty);
                    controller.handleAddProduct(newProduct, qty);
                    break;

                case 2:
                    String prodID = view.getInput("Product ID to restock: ");
                    int amount = view.getIntInput("Amount to add: ");
                    controller.handleRestock(prodID, amount);
                    break;

                case 3:
                    view.displayMessage("Update feature: Enter product details");
                    // TODO
                    break;

                case 4:
                    controller.getInventory().displayInventory();
                    break;

                case 5:
                    String savePath = view.getInput("Enter file path: ");
                    controller.handleSaveInventory(savePath);
                    break;

                case 6:
                    String loadPath = view.getInput("Enter file path: ");
                    controller.handleLoadInventory(loadPath);
                    break;

                case 7:
                    loggedIn = false;
                    view.displayMessage("Logged out successfully");
                    break;

                default:
                    view.displayMessage("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Main entry point
     * @param args CLI arguments
     */
    public static void main(String[] args){
        Konbini app = new Konbini();
        app.run();
    }
}