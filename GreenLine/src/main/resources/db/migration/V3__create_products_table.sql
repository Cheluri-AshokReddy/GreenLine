CREATE TABLE products (
                          product_id SERIAL PRIMARY KEY,
                          product_name VARCHAR(255) NOT NULL,
                          description TEXT,
                          unit VARCHAR(50),
                          mrp DECIMAL(10,2) NOT NULL,
                          gst DECIMAL(5,2) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          seller_id INT NOT NULL,
                          CONSTRAINT fk_products_seller FOREIGN KEY (seller_id) REFERENCES sellers(seller_id)
);

  