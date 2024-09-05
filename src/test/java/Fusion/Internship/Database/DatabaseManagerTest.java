package Fusion.Internship.Database;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.*;

import org.junit.Test;

public class DatabaseManagerTest {

    @Test
    public void testOpenConnection() throws Exception, SQLException {

        assertNotNull(DatabaseManager.openConnection());

    }

}
