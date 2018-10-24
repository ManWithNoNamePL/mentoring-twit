package com.tweet.core.service.impl;

import com.tweet.core.model.User;
import com.tweet.core.model.UserRole;
import com.tweet.core.service.UserService;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class UserServiceImplTest {

    private static final UserService userService = new UserServiceImpl();

    public void setUp() {
        UserRole role = new UserRole();
        role.setName(UserRole.Name.USER);
        createCorrectUser(1L, "Test F", "Test S", "test", "test@te.co", Collections.singleton(role));
    }

    @Test
    public void getByName_existingUser_returnUser() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Test F");
        user.setSurname("Test S");
        user.setUsername("test");
        user.setEmail("test@te.co");

        UserRole role = new UserRole();
        role.setName(UserRole.Name.USER);
        user.setUserRoles(Collections.singleton(role));

        assertThat(userService.getByName("test"))
                .isEqualToComparingFieldByField(user);
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