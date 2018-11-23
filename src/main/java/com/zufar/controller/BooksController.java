package com.zufar.controller;

import com.zufar.domain.Book;
import com.zufar.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BooksController {

    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public String getAuthors(ModelMap modelMap) {
        List<Book> books = bookService.getAll();
        modelMap.addAttribute("books", books);
        return "bookList";
    }


    @PostMapping("/books/${id}")
    public String getBooks(@PathVariable long id) {
        System.out.println(id);
        return "bookList";
    }
}