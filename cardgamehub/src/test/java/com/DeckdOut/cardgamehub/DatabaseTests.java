package com.DeckdOut.cardgamehub;

import java.sql.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The DatabaseTests class contains JUnit tests for verifying the existence of database tables.
 */
@SpringBootTest
public class DatabaseTests {

    // Establish a connection to the MySQL database
    private static Connection connection;

    /**
     * Sets up the connection to the database before running any tests.
     * @throws SQLException if a database access error occurs
     */
    @BeforeAll
    public static void setUp() throws SQLException {
        String url = "jdbc:mysql://cs506-team-33.cs.wisc.edu:3306/DeckdOut";
        String username = "root";
        String password = "verySecurePlainTextPass123";
        connection = DriverManager.getConnection(url, username, password);
    }

    /**
     * Closes the database connection after running all tests.
     * @throws SQLException if a database access error occurs
     */
    @AfterAll
    public static void tearDown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    /**
     * Inserts test data into the Users table.
     * @param email the email address to insert
     * @param username the username to insert
     * @return the ID of the inserted row
     * @throws SQLException if a database access error occurs
     */
    private int insertTestDataIntoUsers(String email, String username) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Users (email, username, verySecurePlainTextPassword) " +
                "VALUES ('" + email + "', '" + username + "', 'password123')", Statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = statement.getGeneratedKeys();
        int insertedId = -1;
        if (generatedKeys.next()) {
            insertedId = generatedKeys.getInt(1);
        }
        statement.close();
        return insertedId;
    }

    /**
     * Deletes test data from the Users table.
     * @param id the ID of the row to delete
     * @throws SQLException if a database access error occurs
     */
    private void deleteTestDataFromUsers(int id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM Users WHERE ID = " + id);
        statement.close();
    }

    /**
     * Inserts test data into the Spades table.
     * @param userId the user ID to associate with the inserted data
     * @return the number of rows affected by the INSERT operation
     * @throws SQLException if a database access error occurs
     */
    private int insertTestDataIntoSpades(int userId) throws SQLException {
        Statement statement = connection.createStatement();
        int rowsAffected = statement.executeUpdate("INSERT INTO Spades (USER_ID, highScore, numGames, gamesWon) " +
                "VALUES (" + userId + ", 0, 0, 0)");
        statement.close();
        return rowsAffected;
    }

    /**
     * Test to verify the existence of the UserSpadesGames table.
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testUserSpadesGamesTableExists() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "UserSpadesGames", null);
        Assertions.assertTrue(resultSet.next(), "Table UserSpadesGames does not exist");
    }

    /**
     * Test to verify the existence of the SpadesGameHistoryTemplate table.
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testSpadesGameHistoryTemplateTableExists() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "SpadesGameHistoryTemplate", null);
        Assertions.assertTrue(resultSet.next(), "Table SpadesGameHistoryTemplate does not exist");
    }

    /**
     * Test to verify the existence of the Euchre table.
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testEuchreTableExists() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "Euchre", null);
        Assertions.assertTrue(resultSet.next(), "Table Euchre does not exist");
    }

    /**
     * Test to verify the existence of the UserEuchreGames table.
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testUserEuchreGamesTableExists() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "UserEuchreGames", null);
        Assertions.assertTrue(resultSet.next(), "Table UserEuchreGames does not exist");
    }

    /**
     * Test to verify the existence of the EuchreGameHistoryTemplate table.
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testEuchreGameHistoryTemplateTableExists() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "EuchreGameHistoryTemplate", null);
        Assertions.assertTrue(resultSet.next(), "Table EuchreGameHistoryTemplate does not exist");
    }
}
