package konbini.services;

import konbini.models.*;
import java.util.ArrayList;
import java.util.List;

/**
 * LoginSystem handles user authentication
 * Manages employee and customer login validation
 * @author Leon Pavino
 * @version 1.0
 */

public class LoginSystem {
    private List<Employee> employees;
    private List<Customer> customers;

    /**
     * Constructor initializes login system
     */
    public LoginSystem() {
        this.employees = new ArrayList<>();
        this.customers = new ArrayList<>();
        initializeDefaultUsers();
    }

    /**
     * Initializes some default users for testing
     */
    private void initializeDefaultUsers() {
        employees.add(new Employee(1001, "Leon Pavino", "Manager", "admin123"));

        customers.add(new Customer("CUST001", "Massi Colcol", "pass123", true, 50));
    }

    /**
     * Employee login
     * @param employeeID Employee ID
     * @param password Password
     * @return Employee object if successful, null otherwise
     */
    public Employee loginEmployee(int employeeID, String password) {
        for (Employee emp : employees) {
            if (emp.login(employeeID, password)) {
                System.out.println("Employee login successful: " + emp.getName());
                return emp;
            }
        }
        System.out.println("Invalid employee credentials");
        return null;
    }

    /**
     * Customer login
     * @param customerID Customer ID
     * @param password Password
     * @return Customer object if successful, null otherwise
     */
    public Customer loginCustomer(String customerID, String password) {
        for (Customer cust : customers) {
            if (cust.login(customerID, password)) {
                System.out.println("Customer login successful: " + cust.getName());
                return cust;
            }
        }
        System.out.println("Invalid customer credentials");
        return null;
    }

    /**
     * Registers new employee
     * @param employee Employee to register
     */
    public void registerEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee registered: " + employee.getEmployeeID());
    }

    /**
     * Validates employee info
     * @param employeeID Employee ID
     * @param password Password
     * @return true if valid
     */
    public boolean validateEmployee(int employeeID, String password) {
        return loginEmployee(employeeID, password) != null;
    }

    /**
     * Validates customer info
     * @param customerID Customer ID
     * @param password Password
     * @return true if valid
     */
    public boolean validateCustomer(String customerID, String password) {
        return loginCustomer(customerID, password) != null;
    }
}