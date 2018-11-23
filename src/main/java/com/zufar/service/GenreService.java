package com.zufar.service;

import com.zufar.domain.Genre;
import com.zufar.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public void delete(Genre genre) {
        genreRepository.delete(genre);
    }

    @Transactional
    public void update(Genre genre) {
        genreRepository.update(genre);
    }

    public Genre get(long id) {
        return genreRepository.get(id);
    }

    @Transactional
    public List<Genre> getAll() {
        return genreRepository.getAll();
    }
}