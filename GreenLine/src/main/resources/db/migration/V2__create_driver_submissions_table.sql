CREATE TABLE driver_submissions (
                                    submission_id SERIAL PRIMARY KEY,
                                    user_id INTEGER NOT NULL,
                                    full_name VARCHAR(100) NOT NULL,
                                    email VARCHAR(100) NOT NULL,
                                    mobile_number VARCHAR(15) NOT NULL,
                                    total_profile_amount NUMERIC(15, 2) NOT NULL,
                                    amount_received NUMERIC(15, 2) NOT NULL,
                                    balance_amount NUMERIC(15, 2) NOT NULL,
                                    pending_amount_flag BOOLEAN NOT NULL,
                                    travel_charges NUMERIC(15, 2) NOT NULL,
                                    proof_image_url VARCHAR(255),
                                    created_at TIMESTAMP NOT NULL,

                                    CONSTRAINT fk_driver_user FOREIGN KEY (user_id)
                                        REFERENCES users(user_id)
                                        ON DELETE CASCADE
);
