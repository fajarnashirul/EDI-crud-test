-- Create the database
CREATE DATABASE IF NOT EXISTS edi;

-- Use the database
USE edi;

-- Create the user table
CREATE TABLE IF NOT EXISTS user (
    userId INT AUTO_INCREMENT PRIMARY KEY,
    namaLengkap VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    status CHAR(1)
);

-- Insert sample data
INSERT INTO user (namaLengkap, username, password, status) VALUES
    ('John Doe', 'john_doe', 'password123', 'A'),
    ('Jane Smith', 'jane_smith', 'secret321', 'A'),
    ('Bob Johnson', 'bob_johnson', 'pass456', 'I'),

    ('User 4', 'user4', 'pass4', 'A'),
    ('User 5', 'user5', 'pass5', 'I'),
    ('User 6', 'user6', 'pass6', 'A'),
    ('User 7', 'user7', 'pass7', 'I'),
    ('User 8', 'user8', 'pass8', 'A'),
    ('User 9', 'user9', 'pass9', 'I'),
    ('User 10', 'user10', 'pass10', 'A');

-- You can continue adding more records as needed