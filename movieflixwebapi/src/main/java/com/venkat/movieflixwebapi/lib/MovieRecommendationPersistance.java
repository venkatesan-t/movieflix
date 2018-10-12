package com.venkat.movieflixwebapi.lib;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.venkat.movieflixwebapi.dto.MovieDTO;
import com.venkat.movieflixwebapi.dto.MovieRecommendationDTO;

import java.util.*;

public class MovieRecommendationPersistance {
    private final CassandraConnector client = new CassandraConnector();
    private ResultSet moviesFromTitleColumn;

    public MovieRecommendationPersistance(final String host, final int port)
    {
        System.out.println("Connecting to IP Address " + host + ":" + port + "...");
        client.connect(host, port);
    }

    public void persistMovieRecommendation(MovieRecommendationDTO movieRecommendationDTO)
    {
        persistMovie(new MovieDTO(movieRecommendationDTO.getTitle()));
        persistMovie(new MovieDTO(movieRecommendationDTO.getAlsoViewedTitle()));
        client.getSession().execute("UPDATE movieflix.movie_recommendation SET count = count + 1 WHERE title = ? AND also_viewed_title = ?",
                movieRecommendationDTO.getTitle(), movieRecommendationDTO.getAlsoViewedTitle());
    }

    public void persistMovie(MovieDTO movieDTO)
    {
        client.getSession().execute("INSERT INTO movieflix.movie (title) VALUES (?)",
                movieDTO.title);
    }

    public List<MovieRecommendationDTO> getMovieRecommendation(String movieTitle)
    {
        List<MovieRecommendationDTO> movies = new ArrayList<>();
        ResultSet moviesFromTitleColumn = client.getSession().
                execute("SELECT title, also_viewed_title, count FROM movieflix.movie_recommendation WHERE title = ?", movieTitle);
        Iterator<Row> iter = moviesFromTitleColumn.iterator();
        while(iter.hasNext())
        {
            Row row = iter.next();
            movies.add(new MovieRecommendationDTO(row.getString("title"),
                    row.getString("also_viewed_title"),
                    row.getLong("count")));
        }
        Collections.sort(movies);
        return movies;
    }

    public Set<MovieDTO> getAllMovies()
    {
        HashSet<MovieDTO> movies = new HashSet<MovieDTO>();
        ResultSet moviesFromTitleColumn = client.getSession().
                execute("SELECT title FROM movieflix.movie");
        Iterator<Row> iter = moviesFromTitleColumn.iterator();
        while(iter.hasNext())
        {
            Row row = iter.next();
            movies.add(new MovieDTO(row.getString("title")));
        }
        return movies;
    }

    private void close()
    {
        client.close();
    }
}
