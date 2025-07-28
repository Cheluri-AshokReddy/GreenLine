CREATE TABLE sellers (
                         seller_id SERIAL PRIMARY KEY,
                         seller_name VARCHAR(255) NOT NULL,
                         contact_info VARCHAR(255),
                         address TEXT,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
