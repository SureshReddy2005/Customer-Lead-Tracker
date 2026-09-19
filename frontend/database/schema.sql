CREATE DATABASE lead_tracker_db;
USE lead_tracker_db;
CREATE TABLE leads (
    lead_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email_address VARCHAR(100) UNIQUE NOT NULL,
    lead_status VARCHAR(20) DEFAULT 'New',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO leads (full_name, email_address, lead_status) VALUES
('Alex Smith', 'alex.smith@example.com', 'Qualified'),
('Sarah Johnson', 'sarah.j@example.com', 'Contacted');
