package konbini.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Cart class representing a customer's shopping cart
 * Manages cart items, quantities, and calculations
 * @author Leon Pavino
 * @version 1.1
 */
public class Cart {
    private List<CartItem> items;

    /**
     * Constructor initializes empty cart
     */
    public Cart() {
        this.items = new ArrayList<>();
    }

    /**
     * Gets all items in cart
     * @return List of cart items
     */
    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    /**
     * Adds item to cart
     * @param product Product to add
     * @param quantity Quantity to add
     */
    public void addItem(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            System.out.println("Invalid product or quantity");
            return;
        }

        for (CartItem item : items) {
            if (item.getProduct().getProductID().equals(product.getProductID())) {
                item.setQuantity(item.getQuantity() + quantity);
                System.out.println("Updated quantity for: " + product.getName());
                return;
            }
        }

        items.add(new CartItem(product, quantity));
        System.out.println("Added to cart: " + product.getName() + " x" + quantity);
    }

    /**
     * Removes item from cart
     * @param productID Product ID to remove
     */
    public void removeItem(String productID) {
        items.removeIf(item -> item.getProduct().getProductID().equals(productID));
    }

    /**
     * Updates quantity of an item in cart
     * @param productID Product to update
     * @param newQuantity New quantity
     */
    public void updateQuantity(String productID, int newQuantity) {
        for (CartItem item : items) {
            if (item.getProduct().getProductID().equals(productID)) {
                if (newQuantity > 0) {
                    item.setQuantity(newQuantity);
                } else {
                    removeItem(productID);
                }
                return;
            }
        }
    }

    /**
     * Calculates subtotal before tax and discounts
     * @return Subtotal amount
     */
    public double getSubtotal() {
        double subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.getSubtotal();
        }
        return subtotal;
    }

    /**
     * Applies discount to cart total
     * @param discountAmount Amount to discount
     */
    public double applyDiscount(Customer c) {
        if (c != null && c.isMember()) {
            return Math.min(c.getPoints(), getSubtotal());
        }
        return 0;
    }

    /**
     * Clears all items from cart
     */
    public void clear() {
        items.clear();
    }

    /**
     * Checks if cart is empty
     * @return true if empty
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Gets item count
     * @return Number of items in cart
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Displays cart contents
     */
    public void viewCart() {
        if (isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        System.out.println("\n=== SHOPPING CART ===");
        for (CartItem item : items) {
            System.out.println(item);
        }
        System.out.printf("Subtotal: ₱%.2f\n", getSubtotal());
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Cart is empty";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("=== CART ITEMS ===\n");
        for (CartItem item : items) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }
}