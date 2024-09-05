package Fusion.Internship.Service;

import java.sql.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import Fusion.Internship.DAO.User;
import Fusion.Internship.DAO.usersDAOImpl;
import org.springframework.stereotype.Repository;

@Repository
public class HomeServiceImpl implements HomeService {

    // usersDAOImpl for funcitons
    @Autowired
    private usersDAOImpl userDAO;

    @Override
    public User createGoogleUser(OAuth2AuthenticationToken authToken) throws SQLException, Exception {

        // Create User object
        User user = new User();

        // Set User object attributes
        user.setEmail(authToken.getPrincipal().getAttribute("email"));
        user.setPassword("password");

        // If user does not exist, insert user into database
        userDAO.insertUser(user);

        // Rteturn User
        return user;
    }

}
