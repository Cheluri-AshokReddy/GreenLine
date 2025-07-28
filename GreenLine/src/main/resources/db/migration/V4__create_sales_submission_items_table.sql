CREATE TABLE sales_submission_items (
                                        item_id SERIAL PRIMARY KEY,
                                        submission_id INTEGER NOT NULL,
                                        product_id INTEGER NOT NULL,
                                        quantity INTEGER NOT NULL,
                                        mrp DECIMAL(10, 2) NOT NULL,
                                        gst DECIMAL(5, 2) NOT NULL,
                                        total_price DECIMAL(10, 2) NOT NULL,

                                        CONSTRAINT fk_submission FOREIGN KEY (submission_id)
                                            REFERENCES sales_submissions (submission_id)
                                            ON DELETE CASCADE,

                                        CONSTRAINT fk_product FOREIGN KEY (product_id)
                                            REFERENCES products (product_id)
                                            ON DELETE CASCADE
);
