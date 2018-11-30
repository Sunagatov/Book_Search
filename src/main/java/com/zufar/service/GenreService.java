package com.zufar.service;

import com.zufar.domain.Genre;
import com.zufar.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public void save(Genre genre){
        genreRepository.save(genre);
    }

    public void delete(Genre genre) {
        genreRepository.delete(genre);
    }

    public void update(Genre genre) {
        genreRepository.update(genre);
    }

    public Genre get(Long id) {
        return genreRepository.get(id);
    }

    public List<Genre> getAll() {
        return genreRepository.getAll();
    }

    public List<Genre> getAll(Set<Long> genresIds) {
        return genreRepository.getAll(genresIds);
    }
}