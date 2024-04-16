package com.DeckdOut.cardgamehub;

import java.sql.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The DatabaseTests class contains JUnit tests for verifying the existence of database tables.
 */
@SpringBootTest
public class DBEuchreTableTests {

    // Import the DBUsersTableTests class 
    private DBUsersTableTests Users = new DBUsersTableTests();

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
     * Inserts test data into the Euchre table.
     * @param userId the user ID to associate with the inserted data
     * @return the number of rows affected by the INSERT operation
     * @throws SQLException if a database access error occurs
     */
    private int insertTestDataIntoEuchre(int userId) throws SQLException {
        Statement statement = connection.createStatement();
        int rowsAffected = statement.executeUpdate("INSERT INTO Euchre (USER_ID, highScore, numGames, gamesWon) " +
                "VALUES (" + userId + ", 0, 0, 0)");
        statement.close();
        return rowsAffected;
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
     * Test to verify the selection of data from the Euchre table.
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testSelectFromEuchre() throws SQLException {
        // Insert test data
        int userId = Users.insertTestDataIntoUsers("test_euchre@example.com", "testuser_euchre");
        insertTestDataIntoEuchre(userId);

        // Perform SELECT operation
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Euchre WHERE USER_ID = " + userId);
        Assertions.assertTrue(resultSet.next(), "Failed to select from Euchre table");
        statement.close();

        // Delete inserted data
        Users.deleteTestDataFromUsers(userId);
    }

    /**
     * Test method to verify the insertion of data into the Euchre table.
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testInsertIntoEuchre() throws SQLException {
        // Insert test data
        int userId = Users.insertTestDataIntoUsers("test_insert_euchre@example.com", "testuser_insert_euchre");

        // Perform INSERT operation
        int rowsAffected = insertTestDataIntoEuchre(userId);

        // Verify the INSERT operation
        Assertions.assertEquals(1, rowsAffected, "Failed to insert into Euchre table");

        // Delete inserted data
        Users.deleteTestDataFromUsers(userId);
    }

    /**
     * Test method to verify the update of data in the Euchre table.
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testUpdateEuchre() throws SQLException {
        // Insert test data
        int userId = Users.insertTestDataIntoUsers("test_update_euchre@example.com", "testuser_update_euchre");
        insertTestDataIntoEuchre(userId);

        // Perform UPDATE operation
        Statement statement = connection.createStatement();
        int rowsAffected = statement.executeUpdate("UPDATE Euchre SET highScore = 100 WHERE USER_ID = " + userId);
        statement.close();

        // Verify the UPDATE operation
        Assertions.assertEquals(1, rowsAffected, "Failed to update Euchre table");

        // Delete inserted data
        Users.deleteTestDataFromUsers(userId);
    }

    /**
     * Test method to verify the deletion of data from the Euchre table.
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testDeleteFromEuchre() throws SQLException {
        // Insert test data
        int userId = Users.insertTestDataIntoUsers("test_delete_euchre@example.com", "testuser_delete_euchre");
        insertTestDataIntoEuchre(userId);

        // Perform DELETE operation
        Statement statement = connection.createStatement();
        int rowsAffected = statement.executeUpdate("DELETE FROM Euchre WHERE USER_ID = " + userId);
        statement.close();

        // Verify the DELETE operation
        Assertions.assertEquals(1, rowsAffected, "Failed to delete from Euchre table");

        // Verify the deleted row does not exist
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Euchre WHERE USER_ID = " + userId);
        Assertions.assertFalse(resultSet.next(), "Failed to delete row from Euchre table");

        // Delete inserted data
        Users.deleteTestDataFromUsers(userId);
    }
}