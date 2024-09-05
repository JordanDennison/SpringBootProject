package Fusion.Internship.DAO;

import java.sql.*;
import java.util.ArrayList;
// import java.util.List;

// import org.apache.tomcat.jni.Time;
import org.springframework.stereotype.Repository;

import Fusion.Internship.DAO.User.usersDAO;

@Repository
public class usersDAOImpl implements usersDAO {

    @Override
    public User createUser(User user, String email, String password) throws SQLException, Exception {

        user.setEmail(email);
        user.setPassword(password);

        return user;
    }

    @Override
    public User insertUser(User user) throws SQLException, Exception {

        Timestamp currTimestamp = new Timestamp(System.currentTimeMillis());

        user.setLastLogin(currTimestamp);

        Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root",
                "dbpassword");
        PreparedStatement ps = connect
                .prepareStatement("INSERT INTO users.users (email, password, lastlogin) VALUES (?, ?, ?)");
        ps.setString(1, user.getEmail());
        ps.setString(2, user.getPassword());
        ps.setTimestamp(3, currTimestamp);
        ps.executeUpdate();
        return user;
    }

    @Override
    public User retrieveUser(String email) throws SQLException, Exception {

        // Connect to database and execute search query using email as search criteria
        Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root",
                "dbpassword");
        PreparedStatement ps = connect.prepareStatement("SELECT * FROM users.users WHERE email = ?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        // Create a new User to store results set information
        User user = new User();

        // Store results set information in User object
        while (rs.next()) {
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setLastLogin(rs.getTimestamp("lastLogin"));
            user.setAdmin(rs.getBoolean("ADMIN"));
            user.setUser(rs.getBoolean("USER"));
        }

        // Return User object
        return user;

    }

    @Override
    public ArrayList<User> retrieveAllUsers() throws SQLException, Exception {

        Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root",
                "dbpassword");
        PreparedStatement ps = connect.prepareStatement("SELECT * FROM users.users");
        ResultSet rs = ps.executeQuery();

        ArrayList<User> userArray = new ArrayList<User>();

        while (rs.next()) {
            User user = new User();
            user.setEmail(rs.getString("email"));
            user.setLastLogin(rs.getTimestamp("lastLogin"));
            userArray.add(user);
        }

        return userArray;
    }

    @Override
    public void deleteUser(String email) throws SQLException, Exception {

        Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root",
                "dbpassword");
        PreparedStatement ps = connect.prepareStatement("DELETE FROM users.users WHERE email = ?");
        ps.setString(1, email);
        ps.executeUpdate();

    }

    @Override
    public void updateUserEmail(String email, String newEmail) throws SQLException, Exception {

        Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root",
                "dbpassword");
        PreparedStatement ps = connect.prepareStatement("UPDATE users.users SET email = ? WHERE email = ?");
        ps.setString(1, newEmail);
        ps.setString(2, email);
        ps.executeUpdate();
    }

    @Override
    public void updateTimestamp(String email, Timestamp timestamp) throws SQLException, Exception {

        Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root",
                "dbpassword");
        PreparedStatement ps = connect.prepareStatement("UPDATE users.users SET lastLogin = ? WHERE email = ?");
        ps.setTimestamp(1, timestamp);
        ps.setString(2, email);
        ps.executeUpdate();

    }

}
