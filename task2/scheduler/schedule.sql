create schema schedule
use schedule
CREATE TABLE schedule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    contents VARCHAR(255) NOT NULL,
    writer VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    writeTime DATETIME NOT NULL,
    updateTime DATETIME NOT NULL
);
