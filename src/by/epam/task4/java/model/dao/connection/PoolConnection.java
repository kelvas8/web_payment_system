package by.epam.task4.java.model.dao.connection;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;
public class PoolConnection {
    private static Connection conn;
    public static PoolConnection db;
    private static DataSource ds;
    private static String url;
    private static String driver;
    private static String user;
    private static String pass;
    private static String base;
    private PoolConnection()  {
        Locale locale = new Locale("en", "US");
        ResourceBundle resource = ResourceBundle.getBundle("by.epam.task4.resources.database.connection", locale);
        this.url = resource.getString("mysql.url");
        this.driver = resource.getString("mysql.driver");
        this.user = resource.getString("mysql.user");
        this.pass = resource.getString("mysql.password");
        this.base = resource.getString("mysql.schema");

    }

    private void createConn() {
        try {
            Context envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/payment_system");
            System.out.println(url+base+user+pass);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Connection getConn() {
        try {
            return conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static synchronized Connection getConnection() {
        if ( db == null ) {
            db = new PoolConnection();
            db.createConn();
            try {
                ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return getConn();
    }


}
