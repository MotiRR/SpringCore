package service;

import database.dto.User;
import database.repository.UserDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

}
