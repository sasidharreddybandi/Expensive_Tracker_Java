import java .sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Databaseconnection {

        private static final String  URL="jdbc:mysql://localhost:3306/expenses_db";
        private static final String USER = "root";
        private static final String PASSWORD = "root"; // change if needed

        public static Connection getConnection() throws Exception {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }


