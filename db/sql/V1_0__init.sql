USE back;

CREATE TABLE IF NOT EXISTS `back`.`category`(
  id         INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name       VARCHAR(100) NOT NULL,
  created_at DATETIME NOT NULL,
  active     BOOLEAN NOT NULL,
PRIMARY KEY(id)
);

INSERT INTO back.category(name, created_at, active)
VALUES ("Demo Category", NOW(), 1);
