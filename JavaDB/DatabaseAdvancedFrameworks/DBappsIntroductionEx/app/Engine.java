package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Engine implements Runnable {

    private Connection connection;

    public Engine(Connection connection) {
        this.connection = connection;
    }

    public void run() {
        try {
            this.getMinionNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Problem 2. Get Villans' Names
     */
    private void getVilliansName() throws SQLException {
        String query = "SELECT v.name, COUNT(v2.minion_id) FROM villains v JOIN minions_villains v2 on v.id = v2.villain_id group by v.name HAVING COUNT(v2.minion_id) > ? ORDER BY COUNT(v2.minion_id) DESC";
        PreparedStatement preparedStatement = this.connection
                .prepareStatement(query);
        preparedStatement.setInt(1, 10);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            String name = resultSet.getString(1);
            int count = resultSet.getInt(2);
            System.out.println(String.format("%s %d", name, count));
        }
    }

    /**
     * Problem 3. Get Minion Names
     */
    private void getMinionNames() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int villainId = Integer.parseInt(scanner.nextLine());
        String queryMain = "SELECT m.name, m.age FROM minions AS m JOIN minions_villains mv ON m.id = mv.minion_id JOIN villains v ON mv.villain_id = v.id WHERE v.id = ?";
        String villainQuery = "SELECT v.name FROM villains AS v WHERE v.id = ?";

        PreparedStatement preparedStatementMain = this.connection.prepareStatement(queryMain);
        PreparedStatement preparedStatementVil = this.connection.prepareStatement(villainQuery);

        preparedStatementMain.setInt(1, villainId);
        preparedStatementVil.setInt(1, villainId);

        ResultSet resultSet = preparedStatementMain.executeQuery();
        ResultSet resultSetVillain = preparedStatementVil.executeQuery();

        String villain = resultSetVillain.getString(1);
        System.out.println(String.format("Villain: %s", villain));

        int counter = 1;
        while (resultSet.next()){
            String name = resultSet.getString(1);
            int age = resultSet.getInt(2);
            System.out.println(String.format("%d. %s %d", counter, name, age));
            counter++;
        }
    }
}
