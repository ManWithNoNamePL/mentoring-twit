-- start filling USER Table
INSERT INTO user (id, username, email, first_name,  surname) VALUES (1, 'user_1', 'test_1@t.com', 'Test', 'Test');
INSERT INTO user (id, username, email, first_name,  surname) VALUES (2, 'user_2', 'test_2@t.com', 'Test', 'Test');
INSERT INTO user (id, username, email, first_name,  surname) VALUES (3, 'user_3', 'test_3@t.com', 'Test', 'Test');
INSERT INTO user (id, username, email, first_name,  surname) VALUES (4, 'user_4', 'test_4@t.com', 'Test', 'Test');
INSERT INTO user (id, username, email, first_name,  surname) VALUES (5, 'user_5', 'test_5@t.com', 'Test', 'Test');
-- end filling USER Table

-- start
INSERT INTO user_role (role_id, name) VALUES (1, 'ADMINISTRATOR');
INSERT INTO user_role (role_id, name) VALUES (2, 'USER');
-- end

-- start
INSERT INTO role_mapping (user_id, role_id) VALUES (1, 1);
INSERT INTO role_mapping (user_id, role_id) VALUES (2, 2);
INSERT INTO role_mapping (user_id, role_id) VALUES (3, 2);
INSERT INTO role_mapping (user_id, role_id) VALUES (4, 2);
INSERT INTO role_mapping (user_id, role_id) VALUES (5, 2);
-- end

-- start filling Tweet Table
INSERT INTO tweet (tweet_id, user, content, created_date) VALUES (1, 1, 'Hello, world!', CURRENT_TIMESTAMP);
INSERT INTO tweet (tweet_id, user, content, created_date) VALUES (2, 2, 'Hello, world!', CURRENT_TIMESTAMP);
INSERT INTO tweet (tweet_id, user, content, created_date) VALUES (3, 3, 'Hello, world!', CURRENT_TIMESTAMP);
INSERT INTO tweet (tweet_id, user, content, created_date) VALUES (4, 4, 'Hello, world!', CURRENT_TIMESTAMP);
INSERT INTO tweet (tweet_id, user, content, created_date) VALUES (5, 5, 'Hello, world!', CURRENT_TIMESTAMP);
-- end filling Tweet Table


