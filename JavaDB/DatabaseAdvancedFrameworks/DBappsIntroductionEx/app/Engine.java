package app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {

    private Connection connection;

    public Engine(Connection connection) {
        this.connection = connection;
    }

    public void run() {
        try {
            this.increaseAgeStoredProcedure();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Problem 2. Get Villans' Names
     */
    private void getVillainsName() throws SQLException {
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

        if (!resultSetVillain.isBeforeFirst()){
            System.out.printf("No villain with ID %s exists in the database.%n", villainId);
            return;
        }

        resultSetVillain.next();

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

    /**
     * Problem 4. Add Minion
     */
    private void addMinion() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String[] minionParams = scanner.nextLine().split("\\s+");
        String[] villainParams = scanner.nextLine().split("\\s+");

        String minionName = minionParams[1];
        int minionAge = Integer.parseInt(minionParams[2]);
        String townName = minionParams[3];
        String villainName = villainParams[1];

        if (!this.checkIfEntityExists(townName, "towns")){
            this.insertTown(townName);
        }

        if (!this.checkIfEntityExists(villainName, "villains")){
            this.insertVillain(villainName);
        }

        int townId = getEntityId(townName,"towns");
        this.insertMinion(minionName, minionAge,townId);

        int minionId = this.getEntityId(minionName, "minions");
        int villainId = this.getEntityId(villainName, "villains");
        this.hireMinion(minionId, villainId);

        System.out.println(String
                .format("Successfully added %s to be minion of %s.", minionName, villainName));
    }

    private boolean checkIfEntityExists(String name, String tableName) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE name = ?";
        PreparedStatement preparedStatement = this.connection
                .prepareStatement(query);

        preparedStatement.setString(1, name);

        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();
    }

    private void insertTown(String townName) throws SQLException {
        String query = "INSERT INTO towns (name, country) VALUES('" + townName + "', NULL )";
        PreparedStatement statement = this.connection
                .prepareStatement(query);

        statement.execute();

        System.out.println(String
                .format("Town %s was added to the database.", townName));
    }

    private void insertVillain(String villainName) throws SQLException {
        String query = String
                .format("INSERT INTO villains (name, evilness_factor) VALUES('%s', 'evil')", villainName);
        PreparedStatement statement = this.connection
                .prepareStatement(query);

        statement.execute();

        System.out.println(String
                .format("Villain %s was added to the database.", villainName));
    }

    private int getEntityId(String name, String tableName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = '%s'", tableName, name);
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return resultSet.getInt(1);
    }

    private void insertMinion(String minionName, int age, int townId) throws SQLException {
        String query = String
                .format("INSERT INTO minions (name, age, town_id) VALUES('%s', '%d', '%d')",
                        minionName, age, townId);
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.execute();
    }

    private void hireMinion(int minionId, int villainId) throws SQLException {
        String query = String
                .format("INSERT INTO minions_villains (minion_id, villain_id) VALUES('%d', '%d')",
                        minionId, villainId);
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.execute();
    }

    /**
     * Problem 5. Change Town Names Casing
     */
    private void changeTownNamesCasing() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();

        String query = "SELECT t.id, t.name FROM towns AS t WHERE country = ?";

        PreparedStatement preparedStatement = this.connection.prepareStatement(
                query,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
        );

        preparedStatement.setString(1, country);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.isBeforeFirst()){
            System.out.println("No town names were affected.");
        }

        List<String> listOfTowns = new ArrayList<String>();

        while (resultSet.next()){
            String oldTown = resultSet.getString("name");
            resultSet.updateString("name", oldTown.toUpperCase());
            listOfTowns.add(oldTown.toUpperCase());
            resultSet.updateRow();
        }

        System.out.println(String
                .format("%d town names were affected.", listOfTowns.size()));
        System.out.println(listOfTowns);
    }

    /**
     * Problem 6. Remove Villain
     */
    private void removeVillain() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String villainId = scanner.nextLine();

        String getVillainNameSQL = "SELECT * FROM villains WHERE id = ?";
        String countMinionToReleaseSQL = "" +
                "SELECT COUNT(mv.villain_id) AS cnt\n" +
                "FROM villains AS v JOIN minions_villains mv on v.id = mv.villain_id\n" +
                "WHERE mv.villain_id = ?";
        String releaseMinionsSQL = "DELETE FROM minions_villains WHERE villain_id = ?";
        String deleteVillainSQL = "DELETE FROM villains WHERE id = ?";

        PreparedStatement statementGetVillainName = this.connection
                .prepareStatement(getVillainNameSQL);
        PreparedStatement statementCountMinions = this.connection
                .prepareStatement(countMinionToReleaseSQL);
        PreparedStatement statementReleaseMinions = this.connection
                .prepareStatement(releaseMinionsSQL);
        PreparedStatement statementDeleteVillain = this.connection
                .prepareStatement(deleteVillainSQL);

        statementGetVillainName.setString(1, villainId);
        statementCountMinions.setString(1, villainId);
        statementReleaseMinions.setString(1, villainId);
        statementDeleteVillain.setString(1, villainId);

        ResultSet villain = statementGetVillainName.executeQuery();

        if (!villain.isBeforeFirst()){
            System.out.println("No such villain was found");
            return;
        }

        villain.first();

        String villainName = villain.getString("name");
        int minionsCount = 0;

        this.connection.setAutoCommit(false);

        ResultSet minionsResSet = statementCountMinions.executeQuery();

        if (minionsResSet.isBeforeFirst()){
            minionsResSet.first();
            minionsCount = minionsResSet.getInt("cnt");
        }

        statementReleaseMinions.executeUpdate();
        statementDeleteVillain.executeUpdate();

        this.connection.commit();

        System.out.println(String.format("%s was deleted", villainName));
        System.out.println(String.format("%d minions released", minionsCount));
        this.connection.setAutoCommit(true);
    }

    /**
     * Problem 7. Print All Minion Names
     */
    private void printAllMinionNames() throws SQLException {
        String query = "SELECT m.name FROM minions AS m";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet minions = preparedStatement.executeQuery();

        int minionsCount = 0;

        while (minions.next()){
            minionsCount++;
        }
        minions.beforeFirst();

        int firstMinion = 1;
        int lastMinion = minionsCount;

        for (int i = 0; i < minionsCount; i++) {
            if (i % 2 == 0){
                minions.absolute(firstMinion);
                firstMinion++;
            } else {
                minions.absolute(lastMinion);
                lastMinion--;
            }
            System.out.println(minions.getString(1));
            minions.next();
        }

    }

    /**
     * Problem 8. Increase Minions Age
     */
    private void increaseMinionsAge() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String[] ids = scanner.nextLine().split("\\s+");

        Statement statement = this.connection.createStatement();

        for (String id : ids) {
            String query = "" +
                    "UPDATE minions\n" +
                    "SET age = age + 1,\n" +
                    "name = CONCAT(UPPER(SUBSTR(name, 1, 1)) + LOWER(SUBSTR(name, 2)))\n" +
                    "WHERE id = " + id;
            statement.executeUpdate(query);
        }

        String query = "SELECT CONCAT_WS(' ', m.name, m.age) AS output FROM minions AS m";

        ResultSet rs = statement.executeQuery(query);

        while (rs.next()){
            System.out.println(rs.getString("name") + " " +
                    rs.getInt("id"));
        }

        rs.close();
        this.connection.close();
    }

    /**
     * Problem 9. Increase Age Stored Procedure
     */
    private void increaseAgeStoredProcedure() throws SQLException {
        String getOlderSQL = "{CALL usp_get_older (?)}";
        String minionSQL = "SELECT m.name, m.age FROM minions AS m WHERE id = ?";

        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        CallableStatement getOlderStoredProcedure = this.connection
                .prepareCall(getOlderSQL);
        PreparedStatement minionsStatement = this.connection
                .prepareStatement(minionSQL);

        getOlderStoredProcedure.setInt(1, id);
        getOlderStoredProcedure.execute();

        minionsStatement.setInt(1, id);
        ResultSet rs = minionsStatement.executeQuery();
        rs.first();
        System.out.println(rs.getString("name") + " " + rs.getInt("age"));
    }

    private void test() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        String callProcedureSQL = "{CALL usp_get_older (?)}";
        String minionsSQL = "SELECT m.name, m.age FROM minions AS m WHERE m.id = ?";

        CallableStatement callableStatement = this.connection.prepareCall(callProcedureSQL);
        PreparedStatement preparedStatement = this.connection.prepareStatement(minionsSQL);

        callableStatement.setInt(1, id);
        preparedStatement.setInt(1, id);

        callableStatement.execute();

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()){
            System.out.println(rs.getString("name") + " " + rs.getInt("age"));
        }
    }
}