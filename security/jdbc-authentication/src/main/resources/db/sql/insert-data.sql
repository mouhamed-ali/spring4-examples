INSERT INTO app_users(username,password,enabled)
VALUES ('admin','admin', true);
INSERT INTO app_users(username,password,enabled)
VALUES ('user','user', true);
INSERT INTO app_user_roles (user_role_id, username, role)
VALUES (1, 'admin', 'ROLE_ADMIN');
INSERT INTO app_user_roles (user_role_id, username, role)
VALUES (2, 'user', 'ROLE_USER');