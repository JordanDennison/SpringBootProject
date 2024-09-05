package Fusion.Internship.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
// import static org.junit.Assert.assertNull;

// import java.lang.reflect.Array;
// import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.*;

public class usersDAOImplTest {

    User testUser = new User();

    @Before
    public void testCreateUser() throws SQLException, Exception {

        // User testUser = new User();
        usersDAOImpl dao = new usersDAOImpl();

        testUser = dao.createUser(testUser, "test@gmail.com", "password");

        assertEquals(testUser.getEmail(), "test@gmail.com");

    }

    @Test
    public void testInsertUser() throws SQLException, Exception {

        usersDAOImpl dao = new usersDAOImpl();
        User insertedUser = dao.insertUser(testUser);

        assertNotNull(insertedUser);

    }

    @Test
    public void testRetrieveUser() throws SQLException, Exception {

        usersDAOImpl dao = new usersDAOImpl();
        User insertedUser = dao.retrieveUser("test@gmail.com");

        assertNotNull(insertedUser);

    }

    @Test
    public void testRetrieveAllUsers() throws SQLException, Exception {

        usersDAOImpl dao = new usersDAOImpl();

        ArrayList<User> users = dao.retrieveAllUsers();

        users.forEach(user -> {
            assertNotNull(user);
        });

    }

    @Test
    public void testUpdateUserEmail() throws SQLException, Exception {

        usersDAOImpl dao = new usersDAOImpl();
        testUser.setEmail("newEmail@gmail.com");
        dao.updateUserEmail("test@gmail.com", "newEmail@gmail.com");
        assertEquals(dao.retrieveUser("newEmail@gmail.com").getEmail(), "newEmail@gmail.com");
    }

    @Test
    public void testDeleteUser() throws SQLException, Exception {

        usersDAOImpl dao = new usersDAOImpl();
        dao.deleteUser("newEmail@gmail.com");
        assertNotEquals(dao.retrieveUser("newEmail@gmail.com"), testUser.getEmail());

    }

}
