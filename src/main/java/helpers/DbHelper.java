package helpers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHelper {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/study";

    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void executeQuery(String sqlQuery) {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_UPDATABLE
            );
            statement.executeQuery(sqlQuery);
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public static List<Object> executeQueryWithResult(String sqlQuery) {
        List<Object> result = new ArrayList<>();
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_UPDATABLE
            );
            statement.executeQuery(sqlQuery);
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()){
                List<Object> temp = new ArrayList<>();
                temp.add(resultSet.getObject("username"));
                temp.add(resultSet.getObject("password"));
                result.add(temp);
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return result;
    }
}