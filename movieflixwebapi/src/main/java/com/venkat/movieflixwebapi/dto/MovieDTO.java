package com.venkat.movieflixwebapi.dto;

import com.venkat.movieflixwebapi.MovieflixWebapiApplication;

public class MovieDTO {
    public String title;

    public MovieDTO()
    {
        this.title = "";
    }

    public MovieDTO(String title)
    {
        this.title = title;
    }
}
