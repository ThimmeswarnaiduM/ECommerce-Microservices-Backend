CREATE TABLE IF NOT EXISTS category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    availability_quantity INT NOT NULL,
    price DECIMAL(19,2) NOT NULL,
    category_id BIGINT NOT NULL,
    CONSTRAINT fk_category
        FOREIGN KEY (category_id) REFERENCES category(id)
);
