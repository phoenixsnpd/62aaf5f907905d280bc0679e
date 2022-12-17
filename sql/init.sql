CREATE TABLE Mainland(
    id SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE Country(
    id SERIAL PRIMARY KEY,
    name VARCHAR(30) UNIQUE NOT NULL,
    mainland_id INTEGER NOT NULL REFERENCES Mainland(id) ON DELETE CASCADE
);

CREATE TABLE City(
    id SERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL UNIQUE,
    population DECIMAL CHECK ( population >= 0 ),
    county_id INTEGER NOT NULL REFERENCES Country(id) ON DELETE CASCADE
);