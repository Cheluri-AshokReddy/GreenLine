CREATE TABLE sales_submission_items (
                                        item_id SERIAL PRIMARY KEY,
                                        submission_id INT NOT NULL,
                                        product_id INT NOT NULL,
                                        quantity INT NOT NULL,
                                        mrp DECIMAL(10,2),
                                        gst DECIMAL(5,2),
                                        total_price DECIMAL(12,2),
                                        CONSTRAINT fk_items_submission FOREIGN KEY (submission_id) REFERENCES sales_submissions(submission_id),
                                        CONSTRAINT fk_items_product FOREIGN KEY (product_id) REFERENCES products(product_id)
);
