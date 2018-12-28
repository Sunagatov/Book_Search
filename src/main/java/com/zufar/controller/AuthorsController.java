package com.zufar.controller;

import com.zufar.domain.Author;
import com.zufar.domain.Book;
import com.zufar.domain.Country;
import com.zufar.service.AuthorService;
import com.zufar.service.BookService;
import com.zufar.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class AuthorsController {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;

    @Autowired
    public AuthorsController(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    @GetMapping("/getAddAuthorView")
    public String getAddAuthorView(ModelMap modelMap) {
        List<Book> books = bookService.getAll();
        modelMap.addAttribute("books", books);
        List<Country> countries = countryService.getAll();
        modelMap.addAttribute("countries", countries);
        return "addAuthorView";
    }

    @GetMapping("/getUpdateAuthorView/{id}")
    public String getUpdateAuthorView(@PathVariable(value = "id") long id, ModelMap modelMap) {
        Author author = authorService.get(id);
        modelMap.addAttribute("author", author);
        List<Book> books = author.getBooks();
        modelMap.addAttribute("books", books);
        List<Country> countries = countryService.getAll();
        modelMap.addAttribute("countries", countries);
        return "updateAuthorView";
    }

    @GetMapping("/addAuthor")
    public String addAuthor(
            @RequestParam("first_name") String first_name,
            @RequestParam("last_name") String last_name,
            @RequestParam("patronymic") String patronymic,
            @RequestParam("nickname") String nick_name,
            @RequestParam("country") Long country,
            @RequestParam("day") int day,
            @RequestParam("month") int month,
            @RequestParam("year") int year
    ) {
        String errorMessage = null;
        if (first_name.isEmpty() || last_name.isEmpty() || patronymic.isEmpty() || country != null ||
                day == -1 || month == -1 || year == -1) {
            errorMessage = "Error! Some of fields are empty. Please fill all fields.";
            return "addAuthorView";
        }
        LocalDate birthday = LocalDate.of(year, month, day);
//        UserDTO user = new User(first_name, last_name, patronymic, nick_name, login, password, Sex.valueOf("MALE"), birthday,
//                new Country(country));
//        userService.save(user);

        return "authorListView";
    }

    @GetMapping("/authors")
    public String getAuthors(ModelMap modelMap) {
        List<Author> authors = authorService.getAll();
        modelMap.addAttribute("authors", authors);
        return "authorListView";
    }

    @GetMapping("/author/{id}")
    public String getAuthor(@PathVariable(value = "id") long id, ModelMap modelMap) {
        Author author = authorService.get(id);
        modelMap.addAttribute("author", author);
        List<Book> books = author.getBooks();
        modelMap.addAttribute("books", books);
        return "authorProfileView";
    }

    @GetMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable(value = "id") long id) {
        Author author = authorService.get(id);
        authorService.delete(author);
        return "authorListView";
    }
}