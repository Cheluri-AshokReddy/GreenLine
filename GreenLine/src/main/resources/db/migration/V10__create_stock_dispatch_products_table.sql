-- Create new stock_dispatch_products table
CREATE TABLE stock_dispatch_products (
                                         stock_product_id SERIAL PRIMARY KEY,
                                         product_id INT NOT NULL,
                                         dispatch_id INT NOT NULL,
                                         quantity INT NOT NULL,
                                         mrp DECIMAL(10, 2),
                                         gst DECIMAL(10, 2),
                                         CONSTRAINT fk_sd_product FOREIGN KEY (product_id) REFERENCES products(product_id),
                                         CONSTRAINT fk_sd_dispatch FOREIGN KEY (dispatch_id) REFERENCES stock_dispatches(dispatch_id)
);
