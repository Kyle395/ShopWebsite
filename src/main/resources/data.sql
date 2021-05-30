INSERT INTO customers (login, password, email) VALUES ("admin", "admin", "admin@localhost");

INSERT INTO categories (name) VALUES ("Podzespoły komputerowe");
INSERT INTO categories (name) VALUES ("Meble");
INSERT INTO categories (name) VALUES ("Telewizory");

INSERT INTO subcategories (category_id, name) VALUES (1, "CPU");
INSERT INTO subcategories (category_id, name) VALUES (1, "GPU");
INSERT INTO subcategories (category_id, name) VALUES (2, "Krzesła");
INSERT INTO subcategories (category_id, name) VALUES (2, "Stoły");
INSERT INTO subcategories (category_id, name) VALUES (3, "4K");
INSERT INTO subcategories (category_id, name) VALUES (3, "OLED");

INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i3 11300", "productImages\\1.png", 1, "asdfasdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i5 11500", "productImages\\2.png", 1, "Tani fajny procek");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i7 11700", "productImages\\3.png", 1, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i3 10300", "productImages\\4.png", 1, "asdfasdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i5 10500", "productImages\\5.png", 1, "Tani fajny procek");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i7 10700", "productImages\\6.png", 1, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i3 9300", "productImages\\7.png", 1, "asdfasdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i5 9500", "productImages\\8.png", 1, "Tani fajny procek");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i7 9700", "productImages\\9.png", 1, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i3 8300", "productImages\\10.png", 1, "asdfasdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i5 8500", "productImages\\11.png", 1, "Tani fajny procek");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i7 8700", "productImages\\12.png", 1, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i3 7300", "productImages\\13.png", 1, "asdfasdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i5 7500", "productImages\\13.png", 1, "Tani fajny procek");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i7 7700", "productImages\\14.png", 1, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i3 6300", "productImages\\15.png", 1, "asdfasdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i5 6500", "productImages\\16.png", 1, "Tani fajny procek");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Intel i7 6700", "productImages\\17.png", 1, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Ryzen 3 1200", "productImages\\18.png", 1, "asdfasdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Ryzen 3 1400", "productImages\\19.png", 1, "Tani fajny procek");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Ryzen 5 1600", "productImages\\20.png", 1, "Tani fajny procek");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Ryzen 7 1700X", "productImages\\21.png", 1, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Ryzen 3 2200", "productImages\\22.png", 1, "asdfasdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Ryzen 3 2400", "productImages\\23.png", 1, "Tani fajny procek");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Ryzen 5 2600", "productImages\\24.png", 1, "Tani fajny procek");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Ryzen 7 2700", "productImages\\25.png", 1, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Ryzen 3 3200", "productImages\\26.png", 1, "asdfasdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Ryzen 3 3400", "productImages\\27.png", 1, "Tani fajny procek");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Ryzen 5 3600", "productImages\\28.png", 1, "Tani fajny procek");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("Ryzen 7 3700X", "productImages\\29.png", 1, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce GTX 650", "productImages\\30.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce GTX 660", "productImages\\31.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce GTX 670", "productImages\\32.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce GTX 680", "productImages\\33.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce GTX 750", "productImages\\34.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce GTX 760", "productImages\\35.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce GTX 770", "productImages\\36.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce GTX 780", "productImages\\37.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce GTX 950", "productImages\\38.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce GTX 960", "productImages\\39.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce GTX 970", "productImages\\40.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce GTX 980", "productImages\\41.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce GTX 1050", "productImages\\42.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce GTX 1060", "productImages\\43.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce GTX 1070", "productImages\\44.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce GTX 1080", "productImages\\45.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce RTX 2060", "productImages\\46.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce RTX 2070", "productImages\\47.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce RTX 2080", "productImages\\48.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce RTX 2080Ti", "productImages\\49.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce RTX 3060", "productImages\\50.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce RTX 3070", "productImages\\51.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce RTX 3080", "productImages\\52.png", 2, "asdf");
INSERT INTO products (name, picture, subcategory_id, description)
VALUES ("GeForce RTX 3080Ti", "productImages\\53.png", 2, "asdf");

INSERT INTO stock (product_id, quantity, price) VALUES (1, 5, 800.49);
INSERT INTO stock (product_id, quantity, price) VALUES (2, 15, 1203.49);
INSERT INTO stock (product_id, quantity, price) VALUES (3, 12, 42042.49);

INSERT INTO orders (created_at, customer_login) VALUES (CURDATE(), "admin");
INSERT INTO order_details (order_id, product_id, quantity) VALUES (1, 1, 3);
INSERT INTO order_details (order_id, product_id, quantity) VALUES (1, 2, 2);
INSERT INTO order_details (order_id, product_id, quantity) VALUES (1, 3, 1);