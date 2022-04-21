use sol13;

CREATE TABLE points(
    id INT NOT NULL,
    x INT,
    y INT,
    primary key (id)
);

CREATE TABLE circles(
  id INT NOT NULL AUTO_INCREMENT,
  filled TINYINT,
  color VARCHAR(45),
  radius DOUBLE,
  center INT,
  primary key (id),
  CONSTRAINT fk_center
    FOREIGN KEY (center)
    REFERENCES points(id)
);

CREATE TABLE rectangles(
    id INT NOT NULL AUTO_INCREMENT,
    filled TINYINT,
    color VARCHAR(45),
    width DOUBLE,
    length DOUBLE,
    topLeft INT,
    bottomRight INT,
    primary key (id),
    CONSTRAINT fk_topLeft
        FOREIGN KEY (topLeft)
        REFERENCES points(id),
    CONSTRAINT fk_botRight
        FOREIGN KEY (bottomRight)
        REFERENCES points(id)
);
