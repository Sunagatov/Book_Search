package com.zufar.controller;

import com.zufar.domain.Author;
import com.zufar.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthorsController {

    private final AuthorService authorService;

    @Autowired
    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/authors")
    public String getAuthors(ModelMap modelMap) {
        List<Author> authors = authorService.getAll();
        modelMap.addAttribute("authors", authors);
        return "authorList";
    }

    @GetMapping("/author/${id}")
    public String getAuthors(@PathVariable long id) {
        System.out.println(id);

        return "authorList";
    }
}