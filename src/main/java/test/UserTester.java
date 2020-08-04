package test;

import database.dto.User;
import service.UserService;

import java.util.List;

public class UserTester {


    private void printUser(UserService userService, Long id) {
        User user = userService.getUserById(id);
        if (user != null)
            System.out.println(user);
    }

    private void printAllUsers(UserService userService) {
        List<User> userList = userService.getAllUsers();
        if (userList != null && !userList.isEmpty())
            userList.forEach(System.out::println);
    }

    private void saveUser(UserService userService, User user) {
        userService.saveUser(user);
    }

    public void testUser(UserService userService) {
        printAllUsers(userService);
        printUser(userService, 1L);
        saveUser(userService, new User("Charles", (short) 33));
    }

}
