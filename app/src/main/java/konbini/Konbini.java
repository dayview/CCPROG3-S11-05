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

        // Toiletries category products
        Category toiletries = inventory.getCategoryByName("Toiletries");
        Product t1 = new Product("T001", "Green Cross Isopropyl Alcohol", 150.00, 10);
        Product t2 = new Product("T002", "Cleene Ethyl Alcohol 70% Solution", 175.00, 10);
        Product t3 = new Product("T003", "SM Bonus Isopropyl Alcohol 70% Solution", 125.00, 10);
        Product t4 = new Product("T004", "Alcoplus Ethyl Alcohol", 200.00, 10);
        Product t5 = new Product("T005", "Green Cross Isopropyl Alcohol with Moisturizer", 150.00, 10);
        Product t6 = new Product("T006", "Value Alcohol 70% Ethyl", 125.00, 10);
        Product t7 = new Product("T007", "Green Cross Total Defense 5 in 1 Alcohol", 130.00, 10);
        Product t8 = new Product("T008", "Casino Alcohol 70% Femme with Moisturizer", 170.00, 10);
        Product t9 = new Product("T009", "Casino Ethyl Alcohol 70% Femme", 150.00, 10);
        Product t10 = new Product("T010", "Casino Alcohol 70% Regular", 130.00, 10);
        Product t11 = new Product("T011", "Biogenic Isopropyl 70% Regular", 110.00, 10);
        Product t12 = new Product("T012", "Biogenic Ethyl 70%", 110.00, 10);
        Product t13 = new Product("T013", "Bestlab Isopropyl 75%", 140.00, 10);
        Product t14 = new Product("T014", "Guardian Iso Alcohol 70%", 130.00, 10);
        Product t15 = new Product("T015", "Naturelab BT21 Alcospray", 130.00, 10);

        toiletries.addProduct(t1);
        toiletries.addProduct(t2);
        toiletries.addProduct(t3);
        toiletries.addProduct(t4);
        toiletries.addProduct(t5);
        toiletries.addProduct(t6);
        toiletries.addProduct(t7);
        toiletries.addProduct(t8);
        toiletries.addProduct(t9);
        toiletries.addProduct(t10);
        toiletries.addProduct(t11);
        toiletries.addProduct(t12);
        toiletries.addProduct(t13);
        toiletries.addProduct(t14);
        toiletries.addProduct(t15);

        // Home Care category products
        Category homeCare = inventory.getCategoryByName("Home Care");
        Product h1 = new Product("H001", "SM Bonus Dishwashing Liquid Lemon", 80.00, 10);
        Product h2 = new Product("H002", "Scotch Brite Heavy Duty Scrubbing Pad", 50.00, 10);
        Product h3 = new Product("H003", "Scotch Brite Scrub Sponge", 40.00, 10);
        Product h4 = new Product("H004", "Femme Bathroom Tissue 2 Ply", 99.00, 10);
        Product h5 = new Product("H005", "SM Bonus Garbage Bag Medium Cross Tie Black", 145.00, 10);
        Product h6 = new Product("H006", "Sanicare Bathroom Tissue 3 Ply", 150.00, 10);
        Product h7 = new Product("H007", "Zonrox Bleach Lemon", 180.00, 10);
        Product h8 = new Product("H008", "Joy Dishwashing Liquid Kalamansi", 250.00, 10);
        Product h9 = new Product("H009", "Smart Dishwashing Paste Kalamansi", 170.00, 10);
        Product h10 = new Product("H010", "Zonrox Bleach Original", 180.00, 10);
        Product h11 = new Product("H011", "SM Bonus Garbage Bag Small Cross Tie Black", 99.00, 10);
        Product h12 = new Product("H012", "Joy Dishwashing Liquid Kalamansi Refill", 180.00, 10);
        Product h13 = new Product("H013", "Domex Ultra Thick Bleach Classic", 312.75, 10);
        Product h14 = new Product("H014", "SM Bonus Bathroom Tissue 2 Ply", 60.00, 10);
        Product h15 = new Product("H015", "Zonrox Bleach Colorsafe Blossom Fresh", 185.00, 10);

        homeCare.addProduct(h1);
        homeCare.addProduct(h2);
        homeCare.addProduct(h3);
        homeCare.addProduct(h4);
        homeCare.addProduct(h5);
        homeCare.addProduct(h6);
        homeCare.addProduct(h7);
        homeCare.addProduct(h8);
        homeCare.addProduct(h9);
        homeCare.addProduct(h10);
        homeCare.addProduct(h11);
        homeCare.addProduct(h12);
        homeCare.addProduct(h13);
        homeCare.addProduct(h14);
        homeCare.addProduct(h15);

        // Medications category products
        Category medications = inventory.getCategoryByName("Medications");
        Product m1 = new Product("M001", "Tylenol", 20.00, 10);
        Product m2 = new Product("M001", "Advil", 15.00, 10);
        Product m3 = new Product("M001", "Motrin", 30.00, 10);
        Product m4 = new Product("M001", "Aleve", 25.00, 10);
        Product m5 = new Product("M001", "Excedrin", 30.00, 10);
        Product m6 = new Product("M001", "Bayer", 40.00, 10);
        Product m7 = new Product("M001", "Midol", 20.00, 10);
        Product m8 = new Product("M001", "Anacin", 30.00, 10);
        Product m9 = new Product("M001", "Percogesic", 50.00, 10);
        Product m10 = new Product("M001", "Aspirin", 20.00, 10);
        Product m11 = new Product("M001", "Rolaids", 50.00, 10);
        Product m12 = new Product("M001", "Maalox", 60.00, 10);
        Product m13 = new Product("M001", "Mylanta", 40.00, 10);
        Product m14 = new Product("M001", "Gaviscon", 20.00, 10);
        Product m15 = new Product("M001", "Benadryl", 15.00, 10);

        medications.addProduct(m1);
        medications.addProduct(m2);
        medications.addProduct(m3);
        medications.addProduct(m4);
        medications.addProduct(m5);
        medications.addProduct(m6);
        medications.addProduct(m7);
        medications.addProduct(m8);
        medications.addProduct(m9);
        medications.addProduct(m10);
        medications.addProduct(m11);
        medications.addProduct(m12);
        medications.addProduct(m13);
        medications.addProduct(m14);
        medications.addProduct(m15);

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

        inventory.addProduct(t1, 10);
        inventory.addProduct(t2, 10);
        inventory.addProduct(t3, 10);
        inventory.addProduct(t4, 10);
        inventory.addProduct(t5, 10);
        inventory.addProduct(t6, 10);
        inventory.addProduct(t7, 10);
        inventory.addProduct(t8, 10);
        inventory.addProduct(t9, 10);
        inventory.addProduct(t10, 10);
        inventory.addProduct(t11, 10);
        inventory.addProduct(t12, 10);
        inventory.addProduct(t13, 10);
        inventory.addProduct(t14, 10);
        inventory.addProduct(t15, 10);

        inventory.addProduct(h1, 10);
        inventory.addProduct(h2, 10);
        inventory.addProduct(h3, 10);
        inventory.addProduct(h4, 10);
        inventory.addProduct(h5, 10);
        inventory.addProduct(h6, 10);
        inventory.addProduct(h7, 10);
        inventory.addProduct(h8, 10);
        inventory.addProduct(h9, 10);
        inventory.addProduct(h10, 10);
        inventory.addProduct(h11, 10);
        inventory.addProduct(h12, 10);
        inventory.addProduct(h13, 10);
        inventory.addProduct(h14, 10);
        inventory.addProduct(h15, 10);

        inventory.addProduct(m1, 10);
        inventory.addProduct(m2, 10);
        inventory.addProduct(m3, 10);
        inventory.addProduct(m4, 10);
        inventory.addProduct(m5, 10);
        inventory.addProduct(m6, 10);
        inventory.addProduct(m7, 10);
        inventory.addProduct(m8, 10);
        inventory.addProduct(m9, 10);
        inventory.addProduct(m10, 10);
        inventory.addProduct(m11, 10);
        inventory.addProduct(m12, 10);
        inventory.addProduct(m13, 10);
        inventory.addProduct(m14, 10);
        inventory.addProduct(m15, 10);
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