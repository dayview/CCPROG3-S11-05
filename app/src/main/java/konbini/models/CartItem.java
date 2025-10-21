package konbini.models;

/**
 * CartItem class representing a single item in the shopping cart
 * Links product with purchase quantity
 * @author Leon Pavino
 * @version 1.0
 */
public class CartItem {
    private Product product;
    private int quantity;

    /**
     * Constructor for CartItem
     * @param product Product being purchased
     * @param quantity Quantity to purchase
     */
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    /**
     * Calculates subtotal for this cart item
     * @return Subtotal (price * quantity)
     */
    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s x%d @ ₱%.2f = ₱%.2f",
                product.getName(), quantity, product.getPrice(), getSubtotal());
    }
}
