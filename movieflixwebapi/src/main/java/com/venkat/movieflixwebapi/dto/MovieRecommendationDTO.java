package com.venkat.movieflixwebapi.dto;

public class MovieRecommendationDTO {
    public String title;
    public String alsoViewedTitle;

    public MovieRecommendationDTO()
    {
    }

    public MovieRecommendationDTO(String title, String alsoViewedTitle)
    {
        this.title = title;
        this.alsoViewedTitle = alsoViewedTitle;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getAlsoViewedTitle()
    {
        return this.alsoViewedTitle;
    }
}
