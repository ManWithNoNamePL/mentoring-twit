--CREATE TABLE USER (username varchar(100) primary key, email varchar(100), firstName varchar(100), surname varchar(100));

-- start filling USER Table
INSERT INTO user (username, email, first_name,  surname) VALUES ('user_1', 'test_1@t.com', 'Test', 'Test');
INSERT INTO user (username, email, first_name,  surname) VALUES ('user_2', 'test_2@t.com', 'Test', 'Test');
INSERT INTO user (username, email, first_name,  surname) VALUES ('user_3', 'test_3@t.com', 'Test', 'Test');
INSERT INTO user (username, email, first_name,  surname) VALUES ('user_4', 'test_4@t.com', 'Test', 'Test');
INSERT INTO user (username, email, first_name,  surname) VALUES ('user_5', 'test_5@t.com', 'Test', 'Test');
-- end filling USER Table

--CREATE TABLE TWEET (tweetId long PRIMARY KEY, username varchar(100), content varchar(140), createdDate date);

-- start filling Tweet Table
INSERT INTO tweet (tweet_id, username, content, created_date) VALUES (1, 'user_1', 'Hello, world!', CURRENT_TIMESTAMP);
INSERT INTO tweet (tweet_id, username, content, created_date) VALUES (2, 'user_2', 'Hello, world!', CURRENT_TIMESTAMP);
INSERT INTO tweet (tweet_id, username, content, created_date) VALUES (3, 'user_3', 'Hello, world!', CURRENT_TIMESTAMP);
INSERT INTO tweet (tweet_id, username, content, created_date) VALUES (4, 'user_4', 'Hello, world!', CURRENT_TIMESTAMP);
INSERT INTO tweet (tweet_id, username, content, created_date) VALUES (5, 'user_5', 'Hello, world!', CURRENT_TIMESTAMP);
-- end filling Tweet Table


