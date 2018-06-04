package javafxmvc.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DatabaseMySQL {

    private static Connection connection;
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";
//    private static String USERNAME = "user";
//    private static String PASSWORD = "";
    private static String MAX_POOL = "25";
    private static Properties props;
    
    private static Properties getProperties() {
        if (props == null) {
            props = new Properties();
            props.setProperty("user", USERNAME);
            props.setProperty("password", PASSWORD);
            props.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return props;
    }
    
    
    public static Connection conectar() {
        try {
            if (connection == null) {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, getProperties());
                connection.setAutoCommit(false);
            }
        } catch (ClassNotFoundException | SQLException err) {
            err.printStackTrace();
        }
        return connection;
    }

    
    public void desconectar(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
