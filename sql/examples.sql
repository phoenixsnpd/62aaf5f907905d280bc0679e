SELECT * FROM country;
SELECT id, name, population FROM city;
SELECT * FROM city WHERE county_id = 1;
SELECT ci.*, c.name FROM city ci JOIN country c ON c.id = 1 WHERE ci.county_id = c.id;
SELECT id, name, population FROM city WHERE population > 1;
DELETE FROM country WHERE country.mainland_id = 4;

SELECT city.name, c.name
FROM city
JOIN country c on c.id = city.county_id;

SELECT name, population FROM city WHERE name = 'Kyiv';

SELECT c.name county, sum(c2.population) population FROM city c2
JOIN country c on c.id = c2.county_id
WHERE county_id = 5
GROUP BY c.name;

SELECT c.name country, avg(c2.population) population FROM city c2
JOIN country c on c.id = c2.county_id
GROUP BY c.name;

SELECT c.name country, count(c2.id) count FROM city c2
JOIN country c on c.id = c2.county_id
GROUP BY c.name;

UPDATE city
SET population = 50 WHERE name = 'Dodoma';
COMMIT;

DELETE FROM city WHERE city.id IN(19, 20, 21, 22, 23, 24);
COMMIT;