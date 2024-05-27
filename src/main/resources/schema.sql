-- Drop existing book table if it exists
DROP TABLE IF EXISTS book;

-- Create new book table
CREATE TABLE book (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      author VARCHAR(255) NOT NULL,
                      edition VARCHAR(255) NOT NULL,
                      publishedYear INT NOT NULL,
                      isbn VARCHAR(255),
                      totalPages INT
);

-- Reset auto-increment counter for id column
ALTER TABLE book ALTER COLUMN id RESTART WITH 1;