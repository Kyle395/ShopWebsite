INSERT INTO customers (login, password, email) VALUES ("admin", "admin", "admin@localhost");

INSERT INTO categories (name) VALUES ("Komputery");
INSERT INTO categories (name) VALUES ("Meble");
INSERT INTO categories (name) VALUES ("Telewizory");

INSERT INTO subcategories (category_id, name) VALUES (1, "Stacjonarne");
INSERT INTO subcategories (category_id, name) VALUES (1, "Laptopy");
INSERT INTO subcategories (category_id, name) VALUES (2, "Krzesła");
INSERT INTO subcategories (category_id, name) VALUES (2, "Stoły");
INSERT INTO subcategories (category_id, name) VALUES (3, "4K");
INSERT INTO subcategories (category_id, name) VALUES (3, "OLED");

INSERT INTO products (name, picture, subcategory_id, description) VALUES ("Intel i5 4690", "", 1, "Tani fajny procek");
INSERT INTO products (name, picture, subcategory_id, description) VALUES ("Intel i7 asdf", "", 1, "asdf");
INSERT INTO products (name, picture, subcategory_id, description) VALUES ("Intel i16 asdf", "", 2, "asdfasdf");

INSERT INTO stock (product_id, quantity, price) VALUES (1, 5, 800.49);
INSERT INTO stock (product_id, quantity, price) VALUES (2, 15, 1203.49);
INSERT INTO stock (product_id, quantity, price) VALUES (3, 12, 42042.49);

INSERT INTO orders (created_at, customer_login) VALUES (CURDATE(), "admin");
INSERT INTO order_details (order_id, product_id, quantity) VALUES (1, 1, 3);
INSERT INTO order_details (order_id, product_id, quantity) VALUES (1, 2, 2);
INSERT INTO order_details (order_id, product_id, quantity) VALUES (1, 3, 1);