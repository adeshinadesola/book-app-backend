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
                      totalPages INT,
                      price DOUBLE,
                      imageUrl VARCHAR(255),
                      pdfData LONGBLOB -- Adding the pdfData column to store PDF files
                      pdfUrl VARCHAR(255) -- Adding the pdfUrl column to store the URL of the PDF
);

-- Reset auto-increment counter for id column
ALTER TABLE book ALTER COLUMN id RESTART WITH 1;