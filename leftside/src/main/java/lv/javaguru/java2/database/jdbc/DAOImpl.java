package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Viktor on 01/07/2014.
 */
public class DAOImpl {

    private static final String DB_CONFIG_FILE = "database.properties";

    private String dbUrl = null;
    private String userName = null;
    private String password = null;
    private String driverClass = null;


    public DAOImpl() {
        initDatabaseConnectionProperties();
        registerJDBCDriver();
    }

    private void registerJDBCDriver() {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            System.out.println("Exception while registering JDBC driver!");
            e.printStackTrace();
        }
    }

    private void initDatabaseConnectionProperties() {
        Properties properties = new Properties();
        try {
            properties.load(DAOImpl.class.getClassLoader().getResourceAsStream(DB_CONFIG_FILE));

            dbUrl = properties.getProperty("dbUrl");
            userName = properties.getProperty("userName");
            password = properties.getProperty("password");
            driverClass = properties.getProperty("driverClass");
        } catch (IOException e) {
            System.out.println("Exciption while reading JDBC configuration from file = " + DB_CONFIG_FILE);
            e.printStackTrace();
        }
    }

    protected Connection getConnection() throws DBException {
        try {
            return DriverManager.getConnection(dbUrl, userName, password);
        } catch (SQLException e) {
            System.out.println("Exciption while getting connection to database");
            e.printStackTrace();
            throw new DBException(e);
        }
    }

    protected void closeConnection(Connection connection) throws DBException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Exciption while closing connection to database");
            e.printStackTrace();
            throw new DBException(e);
        }
    }

}
