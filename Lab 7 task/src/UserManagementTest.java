import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class UserManagementTest {
    private static UserManager userManager;

    @BeforeAll
    static void setup() {
        userManager = UserManager.getInstance();
    }

    @Test
    void testSingletonInstance() {
        UserManager instance1 = UserManager.getInstance();
        UserManager instance2 = UserManager.getInstance();
        assertSame(instance1, instance2);
    }



    @Test
    void testAdminAuthentication() throws IOException {
        Authentication auth = new AuthenticateAdmin();
        boolean isAuthenticated = auth.authenticate("admin1", "adminpass");
        assertTrue(isAuthenticated);
    }

    @Test
    void testUserAuthentication() throws IOException {
        Authentication auth = new AuthenticateUser();
        boolean isAuthenticated = auth.authenticate("user1", "userpass");
        assertTrue(isAuthenticated);
    }

    @Test
    void testAuthenticationFailure() throws IOException {
        Authentication auth = new AuthenticateUser();
        boolean isAuthenticated = auth.authenticate("unknownUser", "wrongpass");
        assertFalse(isAuthenticated);
    }

    @Test
    void testCheckEmailExists() throws IOException {
        Checkmail checkmail = new Checkmail();
        boolean emailExists = checkmail.isEmailExists("user.csv", "user1@example.com");
        assertTrue(emailExists);
    }

    @Test
    void testCheckEmailNotExists() throws IOException {
        Checkmail checkmail = new Checkmail();
        boolean emailExists = checkmail.isEmailExists("user.csv", "nonexistent@example.com");
        assertFalse(emailExists);
    }

    @Test
    void testWriteToCSV() throws IOException {
        CreateAccount createAccount = new CreateAccount("testuser", "testuser@example.com", "password", "regular");
        Checkmail checkmail = new Checkmail();
        boolean emailExists = checkmail.isEmailExists("user.csv", "testuser@example.com");
        assertTrue(emailExists);
    }


}
