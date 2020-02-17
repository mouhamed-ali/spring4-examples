INSERT INTO users(username,password,enabled)
VALUES ('admin','0ef687158bbaf76d606e76c05592bced778f18af34d1596fb2224f075f91d63cec0cbe3275d73a5a', true);
INSERT INTO users(username,password,enabled)
VALUES ('user','0ffe93e8f7ec4cdca7c2da8efc1ca5cbd862691928534b5beac7cc52ac20616eb499f8b3130d18dc', true);
INSERT INTO user_roles (user_role_id, username, role)
VALUES (1, 'admin', 'ROLE_ADMIN');
INSERT INTO user_roles (user_role_id, username, role)
VALUES (2, 'user', 'ROLE_USER');

-- in this example we used the hash to secure passwords
-- the SHA-256 (without salt) the password admin is admin, the password user is user

-- populate the customer table
INSERT INTO customer(id,name,country)
VALUES (1,'Michelin', 'France');

INSERT INTO customer(id,name,country)
VALUES (2,'Decathlon', 'Belgium');

INSERT INTO customer(id,name,country)
VALUES (3,'Pepsi', 'USA');