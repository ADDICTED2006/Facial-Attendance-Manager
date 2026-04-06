USE finaldetection;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

-- Insert a default admin and teacher
INSERT IGNORE INTO users (username, password, role) VALUES ('admin', 'admin123', 'ADMIN');
INSERT IGNORE INTO users (username, password, role) VALUES ('teacher', 'teacher123', 'TEACHER');


ALTER TABLE face_bio ADD UNIQUE (code);

CREATE TABLE IF NOT EXISTS attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    face_code INT NOT NULL,
    scan_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20),
    FOREIGN KEY (face_code) REFERENCES face_bio(code) ON DELETE CASCADE
);
