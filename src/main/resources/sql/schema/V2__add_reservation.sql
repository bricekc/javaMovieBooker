CREATE TABLE reservation (
                             id UUID PRIMARY KEY,
                             movie_id BIGINT NOT NULL,
                             reservation_date TIMESTAMP NOT NULL,
                             user_id UUID NOT NULL,
                             CONSTRAINT fk_user
                                 FOREIGN KEY (user_id)
                                     REFERENCES users(id)
                                     ON DELETE CASCADE
);