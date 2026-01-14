package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

    private static final String CONNECTION_URL =
            "jdbc:sqlserver://cname-qadb-mssql-ivydev01-in.ivyops.com;" +
            "databaseName=IvyCpg_BimboCostaRica;" +
            "user=IvyCPG_BimboCostaRica_QAuser;" +
            "password=IvyCPG_BimboCostaRica_QAuserfbhfdgyuo;" +
            "encrypt=false;";

    /**
     * Get DB Connection
     */
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(CONNECTION_URL);
            System.out.println("✅ Connected to SQL Server successfully!");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("❌ Failed to connect to DB", e);
        }
    }

    /**
     * Execute Select Query
     */
    public static ResultSet executeQuery(Connection connection, String query) {
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException("❌ Failed to execute query", e);
        }
    }

    /**
     * Wait until expected DB value is available
     */
    public static String waitForDBValue(String query, String expectedValue, int timeoutInSeconds) {

        long endTime = System.currentTimeMillis() + (timeoutInSeconds * 1000);

        while (System.currentTimeMillis() < endTime) {

            Connection connection = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                connection = getConnection();
                stmt = connection.createStatement();
                rs = stmt.executeQuery(query);

                if (rs.next()) {
                    String actualValue = rs.getString(1);

                    if (actualValue != null && actualValue.equals(expectedValue)) {
                        return actualValue;
                    }
                }

                // Polling interval
                Thread.sleep(1000);

            } catch (Exception e) {
                throw new RuntimeException("❌ Error while waiting for DB value", e);
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    closeConnection(connection);
                } catch (Exception ignored) {}
            }
        }
        return null;
    }

    /**
     * Close DB Connection
     */
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("✅ DB Connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
