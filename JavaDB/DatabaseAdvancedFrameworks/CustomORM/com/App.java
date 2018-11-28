package com;

import com.db.EntityDbContext;
import com.db.base.DbContext;
import com.entities.Room;
import com.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    private static final String CONNECTION_STRING =
            "jdbc:mysql://localhost:3306/soft_uni";

    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Connection connection = getConnection();
        DbContext<User> userDbContext =
                getDbContext(connection, User.class);

        User user = new User("Pesho", "Peshev");
        user.setAge(25);
        user.setKur("1234567890");

        userDbContext.delete("id = 1");

        connection.close();
    }

    private static <T> DbContext<T> getDbContext(Connection connection, Class<T> klass) throws SQLException {
        return new EntityDbContext<>(connection, klass);
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                CONNECTION_STRING,
                "root",
                "usaluboa"
        );
    }
}
