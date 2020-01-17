-- schema creation
CREATE TABLE customer (
  id         INTEGER PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  email  VARCHAR(50),
  phone_number VARCHAR(50),
  birth_date VARCHAR(30),
  birth_place VARCHAR(30)
);

CREATE TABLE address (
  id         INTEGER PRIMARY KEY,
  building VARCHAR(30),
  street VARCHAR(30),
  city  VARCHAR(30),
  zip_code VARCHAR(10),
  country VARCHAR(30),
  country_code VARCHAR(30),
  customer_id INTEGER,
  FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE account (
  id         INTEGER PRIMARY KEY,
  balance DOUBLE,
  account_name  VARCHAR(30),
  date_opened VARCHAR(10),
  customer_id INTEGER,
  FOREIGN KEY (customer_id) REFERENCES customer(id)
);