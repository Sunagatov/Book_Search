package com.zufar.controller;

import com.zufar.domain.Author;
import com.zufar.domain.Book;
import com.zufar.domain.Genre;
import com.zufar.service.AuthorService;
import com.zufar.service.BookService;
import com.zufar.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class BooksController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    @Autowired
    public BooksController(
            BookService bookService,
            AuthorService authorService,
            GenreService genreService
    ) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @GetMapping("/books")
    public String getBooks(ModelMap modelMap) {
        List<Book> books = bookService.getAll();
        modelMap.addAttribute("books", books);
        return "bookList";
    }

    @GetMapping("/book/{id}")
    public String getBook(@PathVariable(value = "id") long id, ModelMap modelMap) {
        Book book = bookService.get(id);
        modelMap.addAttribute("book", book);
        return "bookProfile";
    }
}