package in.stackroute.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig {

    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/batch_111"; 
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "password";

   /**
    * 
        Create a connection to the database
        java.sql package contains all the JDBC related classes and interfaces.
        java.sql.DriverManager is used to create a connection to the database.
        
        Steps involved in creating a connection to the database:
        1. Register the driver - java.sql.DriverManager.registerDriver(driver) is used to register the driver.
        2. Obtains a connection - java.sql.DriverManager.getConnection(url, user, password) is used to create a connection to the database.
    */

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER); // loading the driver
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}
