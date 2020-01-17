INSERT INTO users(username,password,enabled)
VALUES ('admin','admin', true);
INSERT INTO users(username,password,enabled)
VALUES ('user','user', true);
INSERT INTO user_roles (user_role_id, username, role)
VALUES (1, 'admin', 'ROLE_ADMIN');
INSERT INTO user_roles (user_role_id, username, role)
VALUES (2, 'user', 'ROLE_USER');