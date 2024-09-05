package Fusion.Internship.DAO;

import java.util.ArrayList;
// import java.util.List;

// import org.apache.tomcat.jni.Time;

import java.sql.Timestamp;
import java.sql.*;

public class User {
    int id;
    String email;
    String password;
    Timestamp lastLogin;
    Boolean ADMIN;
    Boolean USER;

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setAdmin(Boolean admin) {
        this.ADMIN = admin;
    }

    public Boolean isAdmin() {
        return this.ADMIN;
    }

    public void setUser(Boolean user) {
        this.USER = user;
    }

    public Boolean isUser() {
        return this.USER;
    }

    public interface usersDAO {

        public User createUser(User user, String email, String password) throws SQLException, Exception;

        public User insertUser(User user) throws SQLException, Exception;

        User retrieveUser(String email) throws SQLException, Exception;

        ArrayList<User> retrieveAllUsers() throws SQLException, Exception;

        void deleteUser(String email) throws SQLException, Exception;

        void updateUserEmail(String email, String newEmail) throws SQLException, Exception;

        void updateTimestamp(String email, Timestamp timestamp) throws SQLException, Exception;

    }

}