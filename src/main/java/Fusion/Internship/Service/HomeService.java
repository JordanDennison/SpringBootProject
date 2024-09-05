package Fusion.Internship.Service;

import Fusion.Internship.DAO.User;
import java.sql.*;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

public interface HomeService {

    // Function to create google user after google login
    User createGoogleUser(OAuth2AuthenticationToken authToken) throws SQLException, Exception;

}
