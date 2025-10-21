package konbini.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Category class representing product categories in the store
 * Manages grouping and retrieval of products by category
 * @author Leon Pavino
 * @version 1.0
 */
public class Category {
    private int categoryID;
    private String name;
    private List<Product> subProducts;

    /**
     * Constructor for Category
     * @param categoryID Unique category identifier
     * @param name Category name (e.g., "Food", "Beverages")
     */
    public Category(int categoryID, String name) {
        this.categoryID = categoryID;
        this.name = name;
        this.subProducts = new ArrayList<>();
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getName() {
        return name;
    }

    public List<Product> getSubProducts() {
        return subProducts;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds a product to this category
     * @param product Product to add
     */
    public void addSubCategory(Category c) {
        // TODO: To implement subcategory support (if necessary + talk to Doc Maan & Massi first)
        System.out.println("test input to show it works lol");
    }

    /**
     * Adds a product to this category
     * @param product The product to add
     */
    public void addProduct(Product product) {
        if (product != null && !subProducts.contains(product)) {
            subProducts.add(product);
        }
    }

    /** Gets all products in this category
     * @return List of products
     */
    public List<Product> getProducts() {
        return new ArrayList<>(subProducts);
    }

    /**
     * Checks if this category has any products with subcategories
     * @return true if it has subcategories
     */
    public boolean hasSubCategories() {
        return !subProducts.isEmpty();
    }

    /**
     * Checks if this category contains products
     * @return true if the category has products
     */
    public boolean hasProducts() {
        return !subProducts.isEmpty();
    }

    @Override
    public String toString() {
        return String.format("Category[%d]: %s (%d products)",
                categoryID, name, subProducts.size());
    }
}
