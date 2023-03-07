package MyTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {
    protected void testDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/vacancies";
            String login = "postgres";
            String password = "postgres";
            Connection connection = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = connection.createStatement();

                stmt.close();
            } finally {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
