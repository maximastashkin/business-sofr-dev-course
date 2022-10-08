CREATE TABLE IF NOT EXISTS work_orders(
    id IDENTITY PRIMARY KEY,
    car_manufacturer VARCHAR(32),
    car_model VARCHAR(32),
    manufacturing_year INT,
    client_name VARCHAR(32),
    cc_number CHAR(16),
    cc_expiration CHAR(5),
    cc_CVV CHAR(3)
);

CREATE TABLE IF NOT EXISTS order_breakdowns(
    id IDENTITY PRIMARY KEY,
    order_id BIGINT NOT NULL,
    breakdown_type VARCHAR(32),
    FOREIGN KEY (order_id) references work_orders(id)
)