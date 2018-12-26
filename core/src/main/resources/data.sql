-- start
INSERT INTO user (user_id, isbn, username, password, email, first_name, surname, active) VALUES (1, '123as', 'user_1', '1', 'test_1@t.com', 'Test', 'Test', 1);
INSERT INTO user (user_id, isbn, username, password, email, first_name, surname, active) VALUES (2, '123ac', 'user_2', '1', 'test_2@t.com', 'Test', 'Test', 1);
INSERT INTO user (user_id, isbn, username, password, email, first_name, surname, active) VALUES (3, '123ad', 'user_3', '1', 'test_3@t.com', 'Test', 'Test', 1);
INSERT INTO user (user_id, isbn, username, password, email, first_name, surname, active) VALUES (4, '123af', 'user_4', '1', 'test_4@t.com', 'Test', 'Test', 1);
INSERT INTO user (user_id, isbn, username, password, email, first_name, surname, active) VALUES (5, '123ag', 'user_5', '1', 'test_5@t.com', 'Test', 'Test', 1);
-- end

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

-- start
INSERT INTO followers_mapping (follower_id, followed_id) VALUES (1, 2);
INSERT INTO followers_mapping (follower_id, followed_id) VALUES (1, 3);
INSERT INTO followers_mapping (follower_id, followed_id) VALUES (3, 2);
INSERT INTO followers_mapping (follower_id, followed_id) VALUES (4, 2);
INSERT INTO followers_mapping (follower_id, followed_id) VALUES (5, 4);
-- end

-- start
INSERT INTO tweet (tweet_id, user_id, content, created_date) VALUES (1, 1, 'Hello, world!', CURRENT_TIMESTAMP);
INSERT INTO tweet (tweet_id, user_id, content, created_date) VALUES (2, 2, 'Hello, world!', CURRENT_TIMESTAMP);
INSERT INTO tweet (tweet_id, user_id, content, created_date) VALUES (3, 3, 'Hello, world!', CURRENT_TIMESTAMP);
INSERT INTO tweet (tweet_id, user_id, content, created_date) VALUES (4, 4, 'Hello, world!', CURRENT_TIMESTAMP);
INSERT INTO tweet (tweet_id, user_id, content, created_date) VALUES (5, 5, 'Hello, world!', CURRENT_TIMESTAMP);
-- end

-- start
INSERT INTO user_settings (settings_id, user_id, country, language) VALUES (1, 1, 'Poland', 'Polish');
-- end
