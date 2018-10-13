"# mymovierec application used for my learning of Spring Boot Rest API"

Cassandra_Movieflix_Project.cql
-------------------------------
The Cassandra_Movieflix_Project.cql contains the cassandra script file to create movieflix keyspace, and movie_recommendation and movie tables.

movieflixwebapi
---------------
The movieflixwebapi directory has the spring boot REST API application with Singleton Cassandra connection.
There are three functionalities below have been developed in the application
  Add movie recommendation in the Cassandra movie_recommendation table. While adding to movie_recommendation table, add the movie names in title and also_viewed_title to movie table
  Get recommendation of movies based on a movie title from the Cassandra movie_recommendation table
  Get all the movies in the Cassandra movie table
