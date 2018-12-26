CREATE TABLE USER (
 user_id INT unsigned NOT NULL AUTO_INCREMENT,
 isbn VARCHAR2(64),
 username VARCHAR2(64) NOT NULL,
 password VARCHAR2(64) NOT NULL,
 email VARCHAR2(64) NOT NULL,
 first_name VARCHAR2(64),
 surname VARCHAR2(54),
 active INT,
 PRIMARY KEY (user_id)
);

CREATE TABLE USER_ROLE (
 role_id INT unsigned NOT NULL AUTO_INCREMENT,
 name VARCHAR2(32) NOT NULL,
 PRIMARY KEY (role_id)
);

CREATE TABLE ROLE_MAPPING (
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  PRIMARY KEY(user_id, role_id)
);

CREATE TABLE FOLLOWERS_MAPPING (
 follower_id INT NOT NULL,
 followed_id INT NOT NULL,
 PRIMARY KEY (follower_id, followed_id)
);

CREATE TABLE TWEET (
 tweet_id INT unsigned NOT NULL AUTO_INCREMENT,
 user_id INT NOT NULL,
 content VARCHAR2(140),
 created_date DATE NOT NULL,
 PRIMARY KEY (tweet_id),
 CONSTRAINT user_fk1 FOREIGN KEY (user_id) REFERENCES USER(user_id)
);

CREATE TABLE USER_SETTINGS (
 settings_id INT unsigned NOT NULL AUTO_INCREMENT,
 user_id INT NOT NULL,
 country VARCHAR2(32) NOT NULL,
 timezone VARCHAR2(32),
 language VARCHAR2(32),
 PRIMARY KEY (settings_id),
 CONSTRAINT user_fk2 FOREIGN KEY (user_id) REFERENCES USER(user_id)
);