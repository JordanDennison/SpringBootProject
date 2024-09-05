package Fusion.Internship.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Fusion.Internship.DAO.User;
import Fusion.Internship.DAO.usersDAOImpl;
// import Fusion.Internship.DAO.User.usersDAO;

import Fusion.Internship.Service.HomeService;
// import Fusion.Internship.Service.HomeServiceImpl;

import java.sql.Timestamp;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = { "/" })
public class HomeController {

	@Autowired
	private HomeService homeService;

	@Autowired
	private usersDAOImpl userDAO;

	User tempUser = new User();

	@GetMapping
	public String homeView() {

		return "Home";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest request)
			throws Exception {

		ModelAndView model = new ModelAndView();

		try {

			// Retrieve user from database
			tempUser = userDAO.retrieveUser(email);

			// Check if password matches
			if (tempUser.getPassword().equals(password)) {

				// Set session attributes
				request.getSession().setAttribute("email", (Object) tempUser.getEmail());

				// Check if the user has logged in before
				if (tempUser.getLastLogin() != null) {

					// Get current timestamp
					Timestamp currTimestamp = new Timestamp(System.currentTimeMillis());

					// Update Timestamp
					userDAO.updateTimestamp("email", currTimestamp);

					((Model) model).addAttribute("firstLogin", 0);

				}

				model.setViewName("Welcome");

			} else {

				model.setViewName("incorrectLogin");

			}

		} catch (Exception e) {

			model.setViewName("incorrectLogin");

		}

		return model;

	}

	@GetMapping("/GoogleLogin")
	public String googleLogin(Model model, OAuth2AuthenticationToken authentication) throws SQLException, Exception {

		// Retrieve user from database
		tempUser = userDAO.retrieveUser(authentication.getName());

		// Set userName attribute from authentication token
		model.addAttribute("userName", authentication.getName());

		// Check if user has logged in before
		if (tempUser.getLastLogin() == null) {

			// Set flag to indicate first login
			model.addAttribute("firstLogin", 1);

			// Create google user
			homeService.createGoogleUser(authentication);

		} else {

			// Get current timestamp
			Timestamp currTimestamp = new Timestamp(System.currentTimeMillis());

			// Update Timestamp
			userDAO.updateTimestamp(authentication.getName(), currTimestamp);

			// Set flag to indicate not first login
			model.addAttribute("firstLogin", 0);
		}

		return "GoogleLogin";
	}

	@GetMapping("/allUserPage")
	public String allUserPage(Model model) throws SQLException, Exception {

		if (tempUser.isAdmin() == true) {

			// Retrieve all users from database
			model.addAttribute("users", userDAO.retrieveAllUsers());

			return "AllUserPage";

		} else {

			return "AccessRestricted";
		}

	}

}
