CREATE TABLE artist_language (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 artist_id int NOT NULL,
                                 language_id int NOT NULL,
                                 level ENUM('NATIVE', 'BEGINNER', 'INTERMEDIATE', 'FLUENT') NOT NULL,

                                 FOREIGN KEY (artist_id) REFERENCES artists(id) ON DELETE CASCADE,
                                 FOREIGN KEY (language_id) REFERENCES languages(id) ON DELETE CASCADE,
                                 UNIQUE KEY unique_artist_language (artist_id, language_id)
);