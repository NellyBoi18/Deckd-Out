package com.DeckdOut.cardgamehub;

import java.sql.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DatabaseTests {

    // Establish a connection to the MySQL database
    private static Connection connection;

    @BeforeAll
    public static void setUp() throws SQLException {
        String url = "jdbc:mysql://localhost:53306/DeckdOut";
        String username = "root";
        String password = "verySecurePlainTextPass123";
        connection = DriverManager.getConnection(url, username, password);
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testUsersTableExists() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "Users", null);
        Assertions.assertTrue(resultSet.next(), "Table Users does not exist");
    }

    @Test
    public void testSpadesTableExists() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "Spades", null);
        Assertions.assertTrue(resultSet.next(), "Table Spades does not exist");
    }

    @Test
    public void testUserSpadesGamesTableExists() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "UserSpadesGames", null);
        Assertions.assertTrue(resultSet.next(), "Table UserSpadesGames does not exist");
    }

    @Test
    public void testSpadesGameHistoryTemplateTableExists() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "SpadesGameHistoryTemplate", null);
        Assertions.assertTrue(resultSet.next(), "Table SpadesGameHistoryTemplate does not exist");
    }

    @Test
    public void testEuchreTableExists() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "Euchre", null);
        Assertions.assertTrue(resultSet.next(), "Table Euchre does not exist");
    }

    @Test
    public void testUserEuchreGamesTableExists() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "UserEuchreGames", null);
        Assertions.assertTrue(resultSet.next(), "Table UserEuchreGames does not exist");
    }

    @Test
    public void testEuchreGameHistoryTemplateTableExists() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "EuchreGameHistoryTemplate", null);
        Assertions.assertTrue(resultSet.next(), "Table EuchreGameHistoryTemplate does not exist");
    }
}
