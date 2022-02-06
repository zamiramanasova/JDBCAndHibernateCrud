package peaksoft;

import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util.jdbcConnection();
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        User user1 = new User("Alisa","Milano",(byte)41);
        User user2 = new User("Holli","Kombs",(byte)44);
        User user3 = new User("Ashli", "Jadd",(byte)32);
        User user4 = new User("Britney", "Spears",(byte)40);


        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        userService.getAllUsers();
        userService.removeUserById(1L);
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
