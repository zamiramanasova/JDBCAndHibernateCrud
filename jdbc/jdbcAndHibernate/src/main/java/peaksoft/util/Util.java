package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String login = "postgres";
    private static final String password = "stulchik";


    public static Connection jdbcConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,login,password);
            System.out.println("Connection successfully");
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
