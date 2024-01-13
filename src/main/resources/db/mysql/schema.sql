CREATE TABLE IF NOT EXISTS questions (
  id            INT(6) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Show_Number   INT NOT NULL,
  Air_Date      DATE NOT NULL,
  Round         VARCHAR(16) NOT NULL,
  Category      VARCHAR(49) NOT NULL,
  Value         VARCHAR(7) NOT NULL,
  Question      VARCHAR(860) NOT NULL,
  Answer        VARCHAR(134)
);