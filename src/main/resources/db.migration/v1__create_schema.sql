CREATE TABLE users(
    id serial PRIMARY KEY,
    name varchar(255),
    email varchar(255),
    password varchar(255)
);

CREATE TABLE market_list (
    id serial PRIMARY KEY,
    total_amounth NUMERIC(19,2),
    buy_date DATE,
    current BOOLEAN,
    market_name VARCHAR(255),
    completed BOOLEAN
);

CREATE TABLE market_list_items_list (
    market_list_id serial NOT NULL,
    name VARCHAR(255),
    expected_value NUMERIC(19,2),
    reald_value NUMERIC(19,2),
    added_to_cart BOOLEAN,
    quantity INTEGER,
    checked BOOLEAN,

    CONSTRAINT fk_market_list_items_list FOREIGN KEY (market_list_id)
        REFERENCES market_list (id)
);