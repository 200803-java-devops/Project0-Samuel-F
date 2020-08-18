package jar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnect {
	
	private static final String username = "journaldb";
	private static final String password = "password";
	private static final String url = "jdbc:postgresql://localhost:5431/journaldb";
	private static Connection connection;

    public Connection getConnect() {
        if(connection == null)
        {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection Successful");
            } catch (SQLException se) {
                System.out.println("Connection failed");
                se.printStackTrace();
            }
            catch(Exception e){
                System.out.println("Could not load driver");
                e.printStackTrace();
            }
        }
        return connection;
    }
}