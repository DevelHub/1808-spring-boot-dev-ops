SET SCHEMA 'weapon_store';

CREATE TABLE app_users (
	user_id SERIAL PRIMARY KEY,
    username VARCHAR(10) NOT NULL UNIQUE,
    pass VARCHAR(4) NOT NULL,
	age INTEGER,
	firstname TEXT,
	lastname TEXT
);

CREATE TABLE weapons (
	weapon_id SERIAL PRIMARY KEY,
    number_blades INTEGER CHECK(number_blades >= 0),
    weight NUMERIC(5, 2),
    weapon_type VARCHAR(24),
    user_id INTEGER REFERENCES app_users(user_id)
);

CREATE TABLE cars (
	car_id SERIAL PRIMARY KEY,
    make VARCHAR(10) NOT NULL,
    model VARCHAR(25) NOT NULL,
	color VARCHAR(15) NOT NULL
);

CREATE TABLE users_cars (
	user_id INTEGER references app_users(user_id),
    car_id INTEGER references cars(car_id),
    PRIMARY KEY (user_id, car_id)
);
