package com.venkat.movieflixwebapi.dto;

public class MovieRecommendationDTO implements Comparable<MovieRecommendationDTO> {
    private String title;
    private String alsoViewedTitle;
    private long count;

    public MovieRecommendationDTO()
    {
    }

    public MovieRecommendationDTO(String title, String alsoViewedTitle)
    {
        this.title = title;
        this.alsoViewedTitle = alsoViewedTitle;
    }

    public MovieRecommendationDTO(String title, String alsoViewedTitle, long count)
    {
        this.title = title;
        this.alsoViewedTitle = alsoViewedTitle;
        this.count = count;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getAlsoViewedTitle()
    {
        return this.alsoViewedTitle;
    }

    public long getCount()
    {
        return this.count;
    }

    @Override
    public int compareTo(MovieRecommendationDTO that)
    {
        return -1 * Long.toString(this.count).compareTo(Long.toString(that.count));
    }
}
