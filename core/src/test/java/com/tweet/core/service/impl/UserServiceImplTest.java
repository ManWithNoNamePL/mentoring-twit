package com.tweet.core.service.impl;

import com.tweet.core.model.User;
import com.tweet.core.model.UserRole;
import com.tweet.core.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private static UserService userService;

    public void setUp() {
        UserRole role = new UserRole();
        role.setName(UserRole.Name.USER);
        createCorrectUser(1L, "Test F", "Test S", "test", "test@te.co", Collections.singleton(role));
    }

    @Test
    public void getById_existingUser_returnUser() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Test F");
        user.setSurname("Test S");
        user.setUsername("test");
        user.setEmail("test@te.co");

        UserRole role = new UserRole();
        role.setName(UserRole.Name.USER);
        user.setUserRoles(Collections.singleton(role));

        assertThat(userService.getById(1L))
                .isEqualToComparingFieldByField(user);
    }

    @Test
    public void getAll_returnAllUsers() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Test F");
        user.setSurname("Test S");
        user.setUsername("test");
        user.setEmail("test@te.co");

        User user2 = new User();
        user2.setId(2L);
        user2.setFirstName("Test F");
        user2.setSurname("Test S");
        user2.setUsername("test");
        user2.setEmail("test@te.co");

        UserRole role = new UserRole();
        role.setName(UserRole.Name.USER);
        user.setUserRoles(Collections.singleton(role));

        assertThat(userService.getAll())
                .containsExactly(user, user2);
    }

    public void getUserById_notExisting_returnNull() {
        assertThat(userService.getById(-1L))
                .isNull();
    }

    private static void createCorrectUser(Long id, String firstName, String surname, String username, String email, Set<UserRole> roles) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setSurname(surname);
        user.setUsername(username);
        user.setEmail(email);
        user.setUserRoles(roles);

        userService.create(user);
    }

}