CREATE TABLE stock_updates (
                               update_id SERIAL PRIMARY KEY,
                               user_id INT NOT NULL,
                               seller_id INT NOT NULL,
                               update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               notes TEXT,
                               CONSTRAINT fk_stock_updates_user FOREIGN KEY (user_id) REFERENCES users(user_id),
                               CONSTRAINT fk_stock_updates_seller FOREIGN KEY (seller_id) REFERENCES sellers(seller_id)
);
