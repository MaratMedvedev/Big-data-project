START TRANSACTION;

DROP TABLE IF EXISTS target_price_prediction;
DROP TABLE IF EXISTS property_details;

CREATE TABLE IF NOT EXISTS property_details (
    id INTEGER PRIMARY KEY,
    posted_by VARCHAR(50) NOT NULL,
    under_construction BOOLEAN NOT NULL,
    rera BOOLEAN NOT NULL,
    bhk_no INTEGER NOT NULL,
    bhk_or_rk VARCHAR(50) NOT NULL,
    square_ft NUMERIC(20,10) NOT NULL,
    ready_to_move BOOLEAN NOT NULL,
    resale BOOLEAN NOT NULL,
    address VARCHAR(255) NOT NULL,
    longitude DECIMAL(19,10) NOT NULL,
    latitude DECIMAL(19,10) NOT NULL
);

CREATE TABLE IF NOT EXISTS target_price_prediction (
    property_id INTEGER PRIMARY KEY,
    price_in_lacs DECIMAL(10,1) NOT NULL,
    FOREIGN KEY (property_id) REFERENCES property_details(id)
);

COMMIT;
