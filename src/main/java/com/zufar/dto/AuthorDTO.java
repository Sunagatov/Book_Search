package com.zufar.dto;

import java.util.Set;

public class AuthorDTO {

    private Long id;
    private String first_name;
    private String last_name;
    private String patronymic;
    private String nick_name;
    private String biography;
    private DateDTO birthday;
    private DateDTO deathday;
    private Long countryId;
    private Set<Long> booksIds;

    public AuthorDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public DateDTO getBirthday() {
        return birthday;
    }

    public void setBirthday(DateDTO birthday) {
        this.birthday = birthday;
    }

    public DateDTO getDeathday() {
        return deathday;
    }

    public void setDeathday(DateDTO deathday) {
        this.deathday = deathday;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Set<Long> getBooksIds() {
        return booksIds;
    }

    public void setBooksIds(Set<Long> booksIds) {
        this.booksIds = booksIds;
    }
}