package com.zufar.controller;

import com.zufar.domain.Author;
import com.zufar.domain.Book;
import com.zufar.service.AuthorService;
import com.zufar.service.BookService;
import com.zufar.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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
        return "bookListView";
    }

    @GetMapping("/book/{id}")
    public String getBook(@PathVariable(value = "id") long id, ModelMap modelMap) {
        Book book = bookService.get(id);
        modelMap.addAttribute("book", book);
        List<Author> authors = book.getAuthors();
        modelMap.addAttribute("authors", authors);
        return "bookProfileView";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") long id) {
        Book book = bookService.get(id);
        bookService.delete(book);
        return "bookListView";
    }
}