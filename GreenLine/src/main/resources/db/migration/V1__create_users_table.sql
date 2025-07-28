CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       full_name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       mobile_number VARCHAR(15) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       gender VARCHAR(10),
                       date_of_birth DATE,
                       role VARCHAR(50),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
