CREATE TABLE sales_submissions (
                                   submission_id SERIAL PRIMARY KEY,
                                   user_id INT NOT NULL,
                                   customer_name VARCHAR(255) NOT NULL,
                                   customer_contact VARCHAR(50),
                                   delivery_address TEXT,
                                   expected_delivery_date DATE,
                                   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   total_submission_price DOUBLE PRECISION,
                                   CONSTRAINT fk_sales_submissions_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);
