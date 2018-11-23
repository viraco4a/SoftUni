import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    private static final String connectionString = "jdbc:mysql://localhost:3306/diablo";
    private static final String USER = "root";
    private static final String PASSWORD = "usaluboa";

    private static final String SQL =
            "" +
                    "SELECT " +
                    "   CONCAT_WS(' ', u.first_name, u.last_name) AS full_name, " +
                    "   COUNT(ug.id) AS games " +
                    "FROM " +
                    "   users AS u " +
                    "       JOIN " +
                    "   users_games AS ug ON ug.user_id = u.id " +
                    "WHERE " +
                    "   u.user_name = ?" +
                    "GROUP BY u.id";

    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASSWORD);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter player name: ");
        String userName = scanner.nextLine();

        Connection connection =
                DriverManager.getConnection(connectionString, properties);
        var preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setString(1, userName);
        ResultSet resultSet = preparedStatement.executeQuery();

        boolean found = false;
        while (resultSet.next()){
            String fullName = resultSet.getString("full_name");
            int games = resultSet.getInt("games");
            System.out.printf("User: %s%n%s has played %d games",
                    userName,
                    fullName,
                    games);
            found = true;
        }
        if (!found){
            System.out.println("No such user exists");
        }
    }
}
