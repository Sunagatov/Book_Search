package com.zufar.dto;

import com.zufar.domain.Author;

import java.time.LocalDate;
import java.util.List;

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
    private List<Long> booksIds;

    public AuthorDTO() {
    }

    public AuthorDTO(String first_name, String last_name, String patronymic, String nick_name, String biography,
                     DateDTO birthday, DateDTO deathday, Long countryId, List<Long> booksIds) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.nick_name = nick_name;
        this.biography = biography;
        this.birthday = birthday;
        this.deathday = deathday;
        this.countryId = countryId;
        this.booksIds = booksIds;
    }

    public AuthorDTO(Author author) {
        this.first_name = author.getFirst_name();
        this.last_name = author.getLast_name();
        this.patronymic = author.getPatronymic();
        this.nick_name = author.getNick_name();
        this.biography = author.getBiography();
        LocalDate birthday = author.getBirthday();
        Integer birthYear = Integer.valueOf(Integer.toString(birthday.getYear()).replace(",", ""));
        this.birthday = new DateDTO(birthYear, birthday.getMonthValue(), birthday.getDayOfMonth());
        LocalDate deathday = author.getDeathday();
        Integer deathYear = Integer.valueOf(Integer.toString(deathday.getYear()).replace(",", ""));
        this.deathday = new DateDTO(deathYear, deathday.getMonthValue(), deathday.getDayOfMonth());
        this.countryId = countryId;
        this.booksIds = booksIds;
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

    public List<Long> getBooksIds() {
        return booksIds;
    }

    public void setBooksIds(List<Long> booksIds) {
        this.booksIds = booksIds;
    }
}