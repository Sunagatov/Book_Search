package com.zufar.domain;

import javax.persistence.*;

@Entity
@Table(name = "Genre")
public class Genre {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
