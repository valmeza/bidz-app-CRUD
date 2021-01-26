CREATE TABLE items
(
    ID               INT PRIMARY KEY NOT NULL,
    NAME             VARCHAR(50)     NOT NULL,
    DESCRIPTION      TEXT            NOT NULL,
    OWNERID          VARCHAR(50),
    BIDDERID         VARCHAR(30),
    PHOTO            TEXT,
    BIDSTARTDATETIME TIMESTAMP,
    BIDENDDATETIME   TIMESTAMP,
    BIDMINIMUMAMOUNT DOUBLE PRECISION,
    BIDINCREMENT     DOUBLE PRECISION,
    BIDAMOUNT        DOUBLE PRECISION
);

INSERT INTO items (ID, NAME, DESCRIPTION, OWNERID, BIDDERID, PHOTO, BIDSTARTDATETIME, BIDENDDATETIME, BIDMINIMUMAMOUNT, BIDINCREMENT, BIDAMOUNT)
VALUES (1, 'car', 'A brand new red car', 'jess@gmail.com', 'Jess', 'car@car.com', '2016-06-22 19:10:25-07', '2021-06-22 19:10:25-07', 20.00, 50.00, 100.00),
       (2, 'Tesla', 'A brand new tesla car', 'tom@gmail.com', 'Tommy', 'car@car.com', '2021-06-22 19:10:25-07', '2022-06-22 19:10:25-07', 40.00, 200.00, 50.00),
       (3, 'CyberTruck', 'A brand truck', 'bibartan@gmail.com', 'Bibartan', 'car@car.com', '2024-06-22 19:10:25-07', '2025-06-22 19:10:25-07', 10.00, 10.00, 20.00);
