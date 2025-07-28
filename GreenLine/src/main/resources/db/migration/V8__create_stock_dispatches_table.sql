CREATE TABLE stock_dispatches (
                                  dispatch_id SERIAL PRIMARY KEY,
                                  user_id INT NOT NULL,
                                  dispatch_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                  notes TEXT,
                                  CONSTRAINT fk_stock_dispatches_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);
