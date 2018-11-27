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

        User user = userDbContext.findFirst();
        user.setLastName("Goshov");
        userDbContext.persist(user);
        System.out.println(userDbContext.findFirst());


//        DbContext<Room> roomDbContext =
//                getDbContext(connection, Room.class);
//        roomDbContext.find()
//                .forEach(System.out::println);

        connection.close();
    }

    private static <T> DbContext<T> getDbContext(Connection connection, Class<T> klass){
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
