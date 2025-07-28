CREATE TABLE driver_submissions (
                                    submission_id SERIAL PRIMARY KEY,
                                    user_id INT NOT NULL,
                                    total_profile_amount DECIMAL(10,2),
                                    amount_received DECIMAL(10,2),
                                    balance_amount DECIMAL(10,2),
                                    travel_charges DECIMAL(10,2),
                                    address TEXT,
                                    mode_of_payment VARCHAR(50),
                                    proof_image_url TEXT,
                                    pending_amount_flag BOOLEAN,
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    CONSTRAINT fk_driver_submissions_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);
