package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    User userNotAdmin;
    User userAdmin;

    User userNotAuthenticate;
    UserRepository users;

    @BeforeEach
    void setUp() {
        userNotAdmin = new User("Ivan", "12345", false);
        userNotAdmin.isAuthenticate = true;
        userAdmin = new User("Anna", "46358", true);
        userAdmin.isAuthenticate = true;
        userNotAuthenticate = new User("Tom", "47632", false);
        users = new UserRepository();
    }

    @Test
    void correctedLoginAndPasswordReturnTrue() {
        assertTrue(userNotAdmin.authenticate("Ivan", "12345"));
    }

    @Test
    void incorrectedLoginReturnFalse() {
        assertFalse(userNotAdmin.authenticate("Anna", "12345"));
    }

    @Test
    void incorrectedPasswordReturnFalse() {
        assertFalse(userNotAdmin.authenticate("Ivan", "ewe23"));
    }

    @Test
    void correctedAddAuthenticateUser() {
        users.addUser(userNotAdmin);

        assertThat(users.data.size()).isEqualTo(1);
    }

    @Test
    void correctedNotAddExistingAuthenticateUser() {
        users.addUser(userNotAdmin);
        users.addUser(userNotAdmin);

        assertThat(users.data.size()).isEqualTo(1);
    }

    @Test
    void correctedNotAddNotAuthenticateUser() {
        users.addUser(userNotAuthenticate);

        assertThat(users.data.size()).isEqualTo(0);
    }

    @Test
    void correctedLogoutAuthenticateNotAdminUser() {
        assertTrue(users.logoutUser(userNotAdmin));
    }

    @Test
    void correctedNotLogoutAuthenticateAdminUser() {
        assertFalse(users.logoutUser(userAdmin));
    }

    @Test
    void correctedNotLogoutNotAuthenticateNotAdminUser() {
        assertFalse(users.logoutUser(userNotAuthenticate));
    }
}