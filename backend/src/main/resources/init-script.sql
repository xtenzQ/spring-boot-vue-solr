CREATE DATABASE IF NOT EXISTS search_app_example;

USE search_app_example;

CREATE TABLE IF NOT EXISTS ITEMS (
    itemId INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    dateCreated DATE NOT NULL,
    dateUpdated DATE NOT NULL
);
