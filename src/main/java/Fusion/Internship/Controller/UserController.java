package Fusion.Internship.Controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.ModelAndView;

import Fusion.Internship.DAO.User;
import Fusion.Internship.DAO.usersDAOImpl;
// import Fusion.Internship.DAO.User.usersDAO;

// import Fusion.Internship.Service.HomeService;
// import Fusion.Internship.Service.HomeServiceImpl;

// import java.sql.Timestamp;
import java.util.ArrayList;
// import java.util.List;
import java.sql.SQLException;

// import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private usersDAOImpl userDAO;

    // Function to return all users for the table page
    @GetMapping("/users")
    public ArrayList<User> getAllUsers() throws SQLException, Exception {
        return userDAO.retrieveAllUsers();
    }

    // Function to delete a user from the table page
    @DeleteMapping("/users/{email}")
    public void deleteUser(@PathVariable String email) throws SQLException, Exception {
        userDAO.deleteUser(email);
    }
}
