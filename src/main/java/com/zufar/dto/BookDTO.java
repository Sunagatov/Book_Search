package com.zufar.dto;

import com.zufar.domain.Country;

import java.util.Set;

public class BookDTO {

    private Long id;
    private String title;
    private Set<Long> authors;
    private Set<Long> reviews;
    private DateDTO publication_date;
    private Long countryId;
    private Set<Long> genresIds;
    private int page_count;

    public BookDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Long> getAuthorsIds() {
        return authors;
    }

    public void setAuthorsIds(Set<Long> authors) {
        this.authors = authors;
    }

    public Set<Long> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Long> reviews) {
        this.reviews = reviews;
    }

    public DateDTO getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(DateDTO publication_date) {
        this.publication_date = publication_date;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Set<Long> getGenresIds() {
        return genresIds;
    }

    public void setGenresIds(Set<Long> genres) {
        this.genresIds = genres;
    }

    public int getPage_count() {
        return page_count;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }
}
