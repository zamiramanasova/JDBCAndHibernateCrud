package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS users"+
                "(id serial PRIMARY KEY NOT NULL,"+
                "name text,"+
                "lastName text,"+
                "age integer);";
        Connection connection = null;
        try {
            connection = Util.jdbcConnection();
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.executeUpdate();
            System.out.println("CREATE TABLE successfully");
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public void dropUsersTable() {
        String SQL = "DROP TABLE IF EXISTS Users;";
        try( Connection connection = Util.jdbcConnection();
            Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(SQL);
            System.out.println("Drop Users table successfully!");
        }catch (SQLException e) {
            e.getMessage();
        }

    }

    public void saveUser(String name, String lastName, Byte age) {
        String saveUser = "INSERT INTO users(name,lastName,age)VALUES(?,?,?)";
        try (Connection connection = Util.jdbcConnection()) {
            PreparedStatement psmt = connection.prepareStatement(saveUser);
            psmt.setString(1, name);
            psmt.setString(2, lastName);
            psmt.setInt(3, age);
            psmt.executeUpdate();
            System.out.println(name + " successfully added");
        } catch (SQLException e) {
            e.getMessage();
        }

    }

    public void removeUserById(long id) {
        String removeUserById = "DELETE FROM users WHERE id = ?";
       try(Connection connection = Util.jdbcConnection()) {
           PreparedStatement preparedStatement = connection.prepareStatement(removeUserById);
           preparedStatement.setLong(1, id);
           preparedStatement.executeUpdate();
           System.out.println("Remove user by Id successfully!");
       }catch (SQLException e) {
           e.getMessage();
       }

    }

    public List<User> getAllUsers() {
        String getAllUsers = "SELECT * FROM users";
        List<User> userList = new ArrayList<>();
        try(Connection conn = Util.jdbcConnection()){
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllUsers);
           while(resultSet.next()) {
               User user = new User();

               user.setId(resultSet.getLong("id"));
               user.setName(resultSet.getString("name"));
               user.setLastName(resultSet.getString("lastName"));
               user.setAge(resultSet.getByte("age"));
               userList.add(user);

               System.out.println(userList);
               System.out.println("Successfully!");

           }
        }catch (SQLException e) {
            e.getMessage();
        }return userList;

    }

    public void cleanUsersTable() {
        String cleanUsersTable = "DELETE FROM users";
        try(Connection connection = Util.jdbcConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(cleanUsersTable);
            System.out.println("Clean Users table successfully!");
        }catch (SQLException e) {
            e.getMessage();
        }

    }
}