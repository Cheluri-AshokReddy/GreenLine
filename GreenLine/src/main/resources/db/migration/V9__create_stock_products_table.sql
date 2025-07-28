CREATE TABLE stock_products (
                                stock_product_id SERIAL PRIMARY KEY,
                                product_id INT NOT NULL,
                                update_id INT,
                                dispatch_id INT,
                                quantity INT NOT NULL,
                                mrp DECIMAL(10,2),
                                gst DECIMAL(5,2),
                                CONSTRAINT fk_stock_product_product FOREIGN KEY (product_id) REFERENCES products(product_id),
                                CONSTRAINT fk_stock_product_update FOREIGN KEY (update_id) REFERENCES stock_updates(update_id),
                                CONSTRAINT fk_stock_product_dispatch FOREIGN KEY (dispatch_id) REFERENCES stock_dispatches(dispatch_id)
);
