
ALTER TABLE artists
    ADD COLUMN troupe_id int ;

ALTER TABLE artists
    ADD CONSTRAINT fk_artist_troupe
        FOREIGN KEY (troupe_id)
            REFERENCES troupe(id)
            ON UPDATE CASCADE
            ON DELETE RESTRICT;