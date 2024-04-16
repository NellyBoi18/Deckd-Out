package com.DeckdOut.cardgamehub;

import java.sql.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The DatabaseTests class contains JUnit tests for verifying the existence of database tables.
 */
@SpringBootTest
public class DBUsersTableTests {

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
    public int insertTestDataIntoUsers(String email, String username) throws SQLException {
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
    public void deleteTestDataFromUsers(int id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM Users WHERE ID = " + id);
        statement.close();
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
     * Test to verify the insertion of data into the Users table.
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testInsertIntoUsers() throws SQLException {
        // Perform INSERT operation
        int insertedId = insertTestDataIntoUsers("test_insert@example.com", "testuser_insert");

        // Verify the INSERT operation
        Assertions.assertTrue(insertedId > 0, "Failed to insert into Users table");

        // Delete inserted data
        deleteTestDataFromUsers(insertedId);
    }

    /**
     * Test to verify the selection of data from the Users table.
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testSelectFromUsers() throws SQLException {
        // Insert test data
        int insertedId = insertTestDataIntoUsers("test@example.com", "testuser");

        // Perform SELECT operation
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE ID = " + insertedId);
        Assertions.assertTrue(resultSet.next(), "Failed to select from Users table");
        
        // Delete inserted data
        deleteTestDataFromUsers(insertedId);
    }

    /**
     * Test to verify the update of data in the Users table.
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testUpdateUsers() throws SQLException {
        // Insert test data
        int insertedId = insertTestDataIntoUsers("test_update@example.com", "testuser_update");

        // Perform UPDATE operation
        Statement statement = connection.createStatement();
        int rowsAffected = statement.executeUpdate("UPDATE Users SET username = 'JaneDoe' WHERE ID = " + insertedId);
        statement.close();

        // Verify the UPDATE operation
        Assertions.assertEquals(1, rowsAffected, "Failed to update Users table");

        // Delete inserted data
        deleteTestDataFromUsers(insertedId);
    }

    /**
     * Test to verify the deletion of data from the Users table.
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testDeleteFromUsers() throws SQLException {
        // Insert test data
        int insertedId = insertTestDataIntoUsers("test_delete@example.com", "testuser_delete");

        // Perform DELETE operation
        Statement statement = connection.createStatement();
        int rowsAffected = statement.executeUpdate("DELETE FROM Users WHERE ID = " + insertedId);
        statement.close();

        // Verify the DELETE operation
        Assertions.assertEquals(1, rowsAffected, "Failed to delete from Users table");

        // Verify the deleted row does not exist
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE ID = " + insertedId);
        Assertions.assertFalse(resultSet.next(), "Failed to delete row from Users table");

        // No need to delete inserted data, as it's already deleted in the test
    }
}