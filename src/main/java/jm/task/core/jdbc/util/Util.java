package jm.task.core.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД

    private static final String url = "jdbc:mysql://127.0.0.1:3306/my_db_users";
    private static final String username = "root";
    private static final String password = "aurum_kata_sql_root_447_2022";

    public static void main(String[] args) throws SQLException {
        Util util = new Util();
        util.getConnection();
    }
    public static Connection getConnection() {

        Connection connection = null;
        Driver driver = null;
        try {
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    //private static Connection connection = null;
    //private static Util util = null;

    /*private Util(){
        try {
            if ((connection == null) || (connection.isClosed())) {
                Properties properties = getProperties();
                connection = DriverManager.getConnection(
                        properties.getProperty("db.url"),
                        properties.getProperty("db.username"),
                        properties.getProperty("db.password")
                );
            }
        } catch (Throwable ignore) {

        }
    }*/
    /*public static Util getUtil() {
        if (util == null) {
            util = new Util();
        }
        return util;
    }*/

   /* private static Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get(
                Util.class.getResource("/database.properties").toURI()))) {
            properties.load(in);
        } catch (Throwable ignore) {

        }
        return properties;
    }*/


}
