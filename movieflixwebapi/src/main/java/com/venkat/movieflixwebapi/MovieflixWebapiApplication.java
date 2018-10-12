package com.venkat.movieflixwebapi;

import com.venkat.movieflixwebapi.dto.MovieDTO;
import com.venkat.movieflixwebapi.dto.MovieRecommendationDTO;
import com.venkat.movieflixwebapi.lib.MovieRecommendationPersistance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@SpringBootApplication
public class MovieflixWebapiApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(MovieflixWebapiApplication.class, args);
    }

    @RequestMapping("/hello")
    public String sayHello()
    {
        return "Hello from Spring Boot Application...";
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST,
                    consumes = "application/json", produces = "application/json")
    public void addMovieRecommendation(@RequestBody MovieRecommendationDTO movieRecommendationDTO)
    {
        MovieRecommendationPersistance mrRec = new MovieRecommendationPersistance("localhost", 9042);
        mrRec.persistMovieRecommendation(movieRecommendationDTO);
    }

    @RequestMapping("/rec-movies")
    public List<MovieRecommendationDTO> getRecommendation(@RequestParam(defaultValue = "") String movieTitle)
    {
        List<MovieRecommendationDTO> recMovies = new ArrayList<>();
        recMovies.add(new MovieRecommendationDTO("Dark Knight", "Memento"));
        recMovies.add(new MovieRecommendationDTO("The wolf of Wall Street", "The Revenant"));
        return recMovies;
    }

    @RequestMapping("/all-movies")
    public Set<MovieDTO> getAllMovies()
    {
        Set<MovieDTO> movies = new HashSet<>();
        MovieRecommendationPersistance mrRec = new MovieRecommendationPersistance("localhost", 9042);
        return mrRec.getAllMovies();
    }
}
