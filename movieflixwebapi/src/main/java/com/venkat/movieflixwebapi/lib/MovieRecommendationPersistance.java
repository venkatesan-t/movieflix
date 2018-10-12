package com.venkat.movieflixwebapi.lib;

import com.venkat.movieflixwebapi.dto.MovieRecommendationDTO;

public class MovieRecommendationPersistance {
    private final CassandraConnector client = new CassandraConnector();

    public MovieRecommendationPersistance(final String host, final int port)
    {
        System.out.println("Connecting to IP Address " + host + ":" + port + "...");
        client.connect(host, port);
    }

    public void persistMovieRecommendation(MovieRecommendationDTO movieRecommendationDTO)
    {
        client.getSession().execute("INSERT INTO ?.movie_recommendation (title, also_viewed_title) VALUES(?, ?)",
                movieRecommendationDTO.title, movieRecommendationDTO.alsoViewedTitle);
    }

    private void close()
    {
        client.close();
    }
}
