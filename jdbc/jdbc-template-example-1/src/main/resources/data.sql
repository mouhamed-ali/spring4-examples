-- customer
INSERT INTO customer VALUES (1, 'first1', 'last1', 'first1@gmail.com', '+33 6 xx xx xx xx' , '11/11/2011', 'France');
INSERT INTO customer VALUES (2, 'first2', 'last2', 'first2@gmail.com', '+33 6 xx xx xx xx' , '11/11/2011', 'France');
INSERT INTO customer VALUES (3, 'first3', 'last3', 'first3@gmail.com', '+33 6 xx xx xx xx' , '11/11/2011', 'France');

-- address
INSERT INTO address VALUES (11, 'building11', 'street11', 'city11', 'zip_code11' , 'country11', 'FR', 1);
INSERT INTO address VALUES (12, 'building12', 'street12', 'city12', 'zip_code12' , 'country12', 'FR', 2);
INSERT INTO address VALUES (13, 'building13', 'street13', 'city13', 'zip_code13' , 'country13', 'FR', 3);

-- account
INSERT INTO account VALUES (21, 223.5, 'account21', '08/08/2018' , 1);
INSERT INTO account VALUES (22, 224.5, 'account22', '09/08/2018' , 1);
INSERT INTO account VALUES (23, 225.5, 'account23', '10/08/2018' , 1);
INSERT INTO account VALUES (31, 223.5, 'account22', '08/08/2018' , 2);
INSERT INTO account VALUES (41, 223.5, 'account23', '08/08/2018' , 3);