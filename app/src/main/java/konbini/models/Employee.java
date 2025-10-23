package konbini.models;

/**
 * Employee class representing store employees in the convenience store system
 * Handles employee operations including project management and authentication
 * @author Leon Pavino
 * @version 1.1
 */
public class Employee {
    private int employeeID;
    private String name;
    private String role;
    private String password;

    /**
     * Constructor to create a new Employee
     * @param employeeID The unique ID for the employee
     * @param name The employee's name
     * @param role The employee's role (e.g., cashier, manager, stocker)
     * @param password The employee's login password
     */
    public Employee(int employeeID, String name, String role, String password) {
        this.employeeID = employeeID;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Adds a new product to the inventory
     * @param p The Product object to add
     */
    public void addNewProduct(Product p) {
        if (p != null) {
            // TODO: To be implemented > dependent on Product and Inventory Management
            System.out.println("Product added: " + p.toString());
        } else {
            System.out.println("Cannot add null product");
        }
    }

    /**
     * Restocks an existing product in the inventory
     * @param productID The ID of the product to restock
     * @param amount The quantity to add to the current stock
     */
    public void restockProduct(String productID, int amount) {
        if (amount > 0) {
            System.out.println("Restocking product " + productID + " with " + amount + " units");
            // TODO: To be implemented > should interact with inventory system
        } else {
            System.out.println("Invalid restock amount");
        }
    }

    /**
     * Updates product information in the system
     * @param productID The ID of the product to update
     */
    public void updateProductInfo(String productID) {
        System.out.println("Updating product information for: " + productID);
        // TODO: To be implemented > editing product details
    }

    /**
     * Authenticates employee login credentials
     * @param employeeID The employee's ID
     * @param password The employee's password
     * @return true if credentials are valid, false otherwise
     */
    public boolean login(int employeeID, String password) {
        return this.employeeID == employeeID && this.password.equals(password);
    }

    /**
     * Validates employee information for updates or verification
     * @param employeeID The employee ID to validate
     * @param password The password to validate
     * @return true if information is valid, false otherwise
     */
    public boolean validateInfo(int employeeID, String password) {
        return this.employeeID == employeeID && this.password.equals(password);
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeID=" + employeeID + ", name='" + name + '\'' + ", role='" + role + '\'' + '}';
    }
}