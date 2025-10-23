package konbini.models;

import konbini.models.enums.UserRole;

/**
 * Represents a generic system user within the Konbini application
 * Stores basic authentication details and a role identifier used for access control
 * @author Leon Pavino
 * @version 1.1
 */
public class User {
    private String id;
    private String password;
    private UserRole role;

    /**
     * Constructor for User
     * @param id User ID
     * @param password User password
     * @param role User role
     */
    public User (String id, String password, UserRole role) {
        this.id = id;
        this.password = password;
        this.role = role;
    }

    public String getID() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole (UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{id='" + id + "', role=" + role + "}";
    }
}
