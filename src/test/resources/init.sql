CREATE TABLE users (
    user_id INT PRIMARY KEY IDENTITY,
    username NVARCHAR(255) NOT NULL,
    password NVARCHAR(255) NOT NULL,
    email NVARCHAR(255) NOT NULL,
    firstname NVARCHAR(255) NOT NULL,
    lastname NVARCHAR(255) NOT NULL,
);

CREATE TABLE address (
    address_id INT PRIMARY KEY IDENTITY,
    user_id INT,
    street NVARCHAR(255) NOT NULL,
    city NVARCHAR(255) NOT NULL,
    state NVARCHAR(255),
    postal_code NVARCHAR(10) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO users
  (
      [username]
      ,[password]
      ,[email]
      ,[firstname]
      ,[lastname]
  )
VALUES
	('admin','password','admin@gmail.com','admin','admin'),
	('user','password','user@gmail.com','user','user')

INSERT INTO address
  (
      [user_id]
      ,[street]
      ,[city]
      ,[state]
      ,[postal_code]
  )
VALUES
    (1,'lumlukka','lumlukka','lumlukka','1234'),
    (2,'samcok1','samcok2','samcok3','1234')