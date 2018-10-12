CREATE KEYSPACE movieflix
WITH REPLICATION = { 'class': 'SimpleStrategy', 'replication_factor': '1' } AND
DURABLE_WRITES = true;

USE movieflix;

CREATE TABLE movie(title TEXT, PRIMARY KEY(title));

CREATE TABLE movie_recommendation(title TEXT, also_viewed_title TEXT, count COUNTER, PRIMARY KEY(title, also_viewed_title));

--UPDATE movieflix.movie_recommendation SET count = count + 1 WHERE title = 'Dark Knight' AND also_viewed_title = 'Memento';
