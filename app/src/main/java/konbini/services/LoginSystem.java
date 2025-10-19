package konbini.services;

import konbini.models.User;

import java.util.List;

public class LoginSystem {
    private List<User> users;

    public User login(String id, String password UserRole expectedRole) {
        for (User user : users) {
            if (user.getID.equals(id) &&
                user.getPassword().equals(password) &&
                user.getRole() == expectedRole) {
                return user;
            }
        }
        return null;
    }
}
