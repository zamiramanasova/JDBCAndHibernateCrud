package peaksoft;

import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        //алгоритм jdbc
        // Util.jdbcConnection();
        //userService.createUsersTable();
        //userService.saveUser();
        //userService.getAllUsers();
        //userService.removeUserById(2);
        //userService.cleanUsersTable();
        //userService.dropUsersTable();


        //АЛГОРИТМ HIBERNATE
        //Util.getSession();
        userService.createUsersTable();
        //userService.saveUser("Alisa","Milano",(byte)41);
        //userService.getAllUsers();
        //userService.removeUserById(2);
        //userService.cleanUsersTable();
        //userService.dropUsersTable();
        //Util.shutDown();

        User user1 = new User("Alisa","Milano",(byte)41);
        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        User user2 = new User("Holli","Kombs",(byte)44);
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        User user3 = new User("Ashli", "Jadd",(byte)32);
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        User user4 = new User("Britney", "Spears",(byte)40);
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());


        //userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
       // userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
       // userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
       // userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        userService.getAllUsers();
        List<User> userlist = userService.getAllUsers();
         for (User user: userlist) {
            System.out.println(user);
       }

        userService.removeUserById(2);
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
