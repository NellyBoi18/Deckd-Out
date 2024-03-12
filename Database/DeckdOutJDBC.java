import java.sql.*;

class MysqlCon {
    public static void main(String args[]) {
        try {
            Connection dbCxn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/deckdout", "root", "verySecurePlainTextPass123"
            );
            Statement select = dbCxn.createStatement();
            // ResultSet rs = select.executeQuery("select * from users");
            dbCxn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}