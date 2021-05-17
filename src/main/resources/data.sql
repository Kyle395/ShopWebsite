INSERT INTO customers (login, password, email) VALUES ("admin", "admin", "admin@localhost")

INSERT INTO categories (name) VALUES ("Komputery")
INSERT INTO categories (name) VALUES ("Meble")
INSERT INTO categories (name) VALUES ("Telewizory")

INSERT INTO subcategories (category_id, name) VALUES (1, "Stacjonarne")
INSERT INTO subcategories (category_id, name) VALUES (1, "Laptopy")
INSERT INTO subcategories (category_id, name) VALUES (2, "Krzesła")
INSERT INTO subcategories (category_id, name) VALUES (2, "Stoły")
INSERT INTO subcategories (category_id, name) VALUES (3, "4K")
INSERT INTO subcategories (category_id, name) VALUES (3, "OLED")
