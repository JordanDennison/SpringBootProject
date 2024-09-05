package Fusion.Internship.Database;

import java.sql.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })

public class DatabaseManager {
    public static DatabaseManager instance = new DatabaseManager();
    public static Connection connect;

    public static Connection openConnection() throws Exception {

        try {
            connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "dbpassword");
            System.out.println("Connection Successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed!");
        }

        return connect;
    }
}
