CREATE TABLE app_users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));
  
CREATE TABLE app_user_roles (
  user_role_id int(11) NOT NULL,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES app_users (username));
  
-- note that spring uses the; to separate scripts and '-' for comments
-- so we have to adapt our scripts to this behavior otherwise we can configure it for
-- change this behavior