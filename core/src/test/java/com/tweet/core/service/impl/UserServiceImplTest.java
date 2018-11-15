package com.tweet.core.service.impl;

import com.tweet.core.model.User;
import com.tweet.core.model.UserRole;
import com.tweet.core.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    private UserRole role;

    @BeforeEach
    void setUp() {
        role = new UserRole();
        role.setName(UserRole.Name.USER);
    }

    @Test
    void getById_existingUser_returnUser() {
        Long dbUserId = createCorrectUser("Test F", "Test S", "test", "test@te.co", Collections.singleton(role), "pass12345");
        User user = new User();
        user.setFirstName("Test F");
        user.setSurname("Test S");
        user.setUsername("test");
        user.setEmail("test@te.co");
        user.setPassword("pass12345");

        UserRole role = new UserRole();
        role.setName(UserRole.Name.USER);
        user.setUserRoles(Collections.singleton(role));

        User userFromDb = userService.getById(dbUserId);
        // We want to ignore user roles in this assertion as it will have auto generated id, same with id, better
        // skip it even taking into consideration that we have it.
        assertThat(userFromDb)
                .isEqualToIgnoringGivenFields(user, "id", "userRoles");
        assertThat(userFromDb.getUserRoles())
                .usingElementComparatorIgnoringFields("roleId")
                .containsExactlyInAnyOrder(role);
    }

    @Test
    void getAll_returnAllUsers() {
        createCorrectUser("Test F", "Test S", "test", "test@te.co", Collections.singleton(role), "pass12345");
        createCorrectUser("Test F", "Test S", "test", "test@te.co", Collections.singleton(role), "pass12345");
        User user = new User();
        user.setFirstName("Test F");
        user.setSurname("Test S");
        user.setUsername("test");
        user.setEmail("test@te.co");
        user.setPassword("pass12345");

        User user2 = new User();
        user2.setFirstName("Test F");
        user2.setSurname("Test S");
        user2.setUsername("test");
        user2.setEmail("test@te.co");
        user2.setPassword("pass12345");

        UserRole role = new UserRole();
        role.setName(UserRole.Name.USER);
        user.setUserRoles(Collections.singleton(role));

        assertThat(userService.getAll())
                .usingElementComparatorIgnoringFields("id", "userRoles")
                .containsExactly(user, user2);
    }

    @Test
    void getUserById_notExisting_throwsException() {
        assertThat(catchThrowable(
                () -> userService.getById(-1L)))
                .isInstanceOf(IllegalStateException.class);
    }

    private Long createCorrectUser(String firstName, String surname, String username, String email, Set<UserRole> roles, String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setSurname(surname);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setUserRoles(roles);

        return userService.create(user).getId();
    }

}