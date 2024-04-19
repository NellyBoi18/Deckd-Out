package com.DeckdOut.cardgamehub.Database;

// THE FOLLOWING REQUIRES THE PLATFORM INDEPENDENT CONNECTOR/J 
// LIBRARY TO BE INSTALLED IN THE WORKING DIRECTORY
import java.sql.*;

class MysqlCon {
    public static void main(String args[]) {
        try {
            Connection dbCxn = DriverManager.getConnection(
                "jdbc:mysql://localhost:53306/deckdout", "root", "verySecurePlainTextPass123"
                // spring.datasource.url=jdbc:mysql://localhost:53306/DeckdOut
            );
            Statement select = dbCxn.createStatement();
            // ResultSet rs = select.executeQuery("select * from users");
            dbCxn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}