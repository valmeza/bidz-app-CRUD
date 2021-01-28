TRUNCATE TABLE items;

INSERT INTO items (ID, NAME, DESCRIPTION, OWNER_ID, BIDDER_ID, PHOTO, BID_START_DATE_TIME, BID_END_DATE_TIME, BID_MINIMUM_AMOUNT, BID_INCREMENT, BID_AMOUNT)
VALUES (1, 'car', 'A brand new red car', 'jess@gmail.com', 'Jess', 'https://images-na.ssl-images-amazon.com/images/I/71VEtPLgBxL._AC_SX569_.jpg', '2016-06-22 19:10:25-07', '2021-06-22 19:10:25-07', 20.00, 50.00, 100.00),
       (2, 'Tesla', 'A brand new tesla car', 'tom@gmail.com', 'Tommy', 'https://cdn.shopify.com/s/files/1/0173/8204/7844/articles/Tesla-Model-S-Cheeta-Launch-Mode_1200x.jpg?v=1586427473', '2021-06-22 19:10:25-07', '2022-06-22 19:10:25-07', 40.00, 200.00, 50.00),
       (3, 'CyberTruck', 'A brand new q', 'bibartan@gmail.com', 'Bibartan', 'https://i.pinimg.com/originals/cc/00/76/cc007607296f06d969c2dc32bf72b3a3.jpg', '2024-06-22 19:10:25-07', '2025-06-22 19:10:25-07', 10.00, 10.00, 20.00);
