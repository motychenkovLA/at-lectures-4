package tracker.jdbc;

import java.sql.*;

public class JDBCExample {
    private static String URL = "jdbc:postgresql://localhost:5432/vsmg";
    private static String USER = "postgres";
    private static String PASSWORD = "postgres";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void executeQuery(String sqlQuery) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            statement.execute(sqlQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static int updateTable(String sqlQuery) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            return statement.executeUpdate(sqlQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

}
