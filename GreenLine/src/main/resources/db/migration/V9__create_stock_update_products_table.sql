-- Create new stock_update_products table
CREATE TABLE stock_update_products (
                                       stock_product_id SERIAL PRIMARY KEY,
                                       product_id INT NOT NULL,
                                       update_id INT NOT NULL,
                                       quantity INT NOT NULL,
                                       mrp DECIMAL(10, 2),
                                       gst DECIMAL(10, 2),
                                       CONSTRAINT fk_su_product FOREIGN KEY (product_id) REFERENCES products(product_id),
                                       CONSTRAINT fk_su_update FOREIGN KEY (update_id) REFERENCES stock_updates(update_id)
);
