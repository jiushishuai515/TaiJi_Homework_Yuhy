DROP TABLE IF EXISTS `users`;
CREATE TABLE users ( username varchar_ignorecase ( 50 ) NOT NULL PRIMARY KEY, PASSWORD varchar_ignorecase ( 500 ) NOT NULL, enabled boolean NOT NULL );
CREATE TABLE authorities (
username varchar_ignorecase ( 50 ) NOT NULL,
authority varchar_ignorecase ( 50 ) NOT NULL,
CONSTRAINT fk_authorities_users FOREIGN KEY ( username ) REFERENCES users ( username ) 
);
CREATE UNIQUE INDEX ix_auth_username ON authorities ( username, authority );