package com.venkat.movieflixwebapi;

import com.venkat.movieflixwebapi.dto.MovieRecommendationDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MovieflixWebapiApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(MovieflixWebapiApplication.class, args);
    }

    @RequestMapping("hello")
    public String sayHello()
    {
        return "Hello from Spring Boot Application...";
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST,
                    consumes = "application/json", produces = "application/json")
    public void addMovieRecommendation(@RequestBody MovieRecommendationDTO movieRecommendation)
    {
    }
}
