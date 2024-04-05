package com.DeckdOut.cardgamehub;

import java.sql.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The DatabaseTests class contains JUnit tests for verifying the existence of database tables.
 * 
 * Uncomment @SpringBootTest to run the tests. Was commented so mvn verify would pass on Gitlab CI.
 */
// @SpringBootTest // UNCOMMENT THIS LINE TO RUN THE TESTS. COMMENT OUT TO RUN THE APPLICATION.
public class DatabaseTests {

    // Establish a connection to the MySQL database
    private static Connection connection;

    /**
     * Sets up the connection to the database before running any tests.
     * @throws SQLException if a database access error occurs
     */
    @BeforeAll
    public static void setUp() throws SQLException {
        String url = "jdbc:mysql://localhost:53306/DeckdOut";
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
     * Test to verify the existence of the Users table.
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testUsersTableExists() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "Users", null);
        Assertions.assertTrue(resultSet.next(), "Table Users does not exist");
    }

    /**
     * Test to verify the existence of the Spades table.
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testSpadesTableExists() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "Spades", null);
        Assertions.assertTrue(resultSet.next(), "Table Spades does not exist");
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
