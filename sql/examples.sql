SELECT * FROM country;
SELECT id, name, population FROM city;
SELECT * FROM city WHERE county_id = 1;
SELECT ci.*, c.name FROM city ci JOIN country c ON c.id = 1 WHERE ci.county_id = c.id;
SELECT id, name, population FROM city WHERE population > 1;
DELETE FROM country WHERE country.mainland_id = 4;