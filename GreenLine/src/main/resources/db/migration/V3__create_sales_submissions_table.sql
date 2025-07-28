CREATE TABLE sales_submissions (
                                   submission_id SERIAL PRIMARY KEY,
                                   user_id INTEGER NOT NULL,
                                   customer_name VARCHAR(100) NOT NULL,
                                   customer_contact VARCHAR(15),
                                   delivery_address TEXT NOT NULL,
                                   expected_delivery_date DATE NOT NULL,
                                   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                                   CONSTRAINT fk_sales_user FOREIGN KEY (user_id)
                                       REFERENCES users (user_id)
                                       ON DELETE CASCADE
);
