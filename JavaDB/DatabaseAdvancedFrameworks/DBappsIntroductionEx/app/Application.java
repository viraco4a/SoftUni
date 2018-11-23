package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    public static void main(String[] args) throws SQLException {
        String user = "root";
        String password = "usaluboa";

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager
                .getConnection(URL, properties);

        Engine engine = new Engine(connection);
        engine.run();
    }
}
