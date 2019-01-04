package com.zufar.controller;

import com.zufar.domain.Author;
import com.zufar.domain.Book;
import com.zufar.domain.Country;
import com.zufar.dto.AuthorDTO;
import com.zufar.dto.BookDTO;
import com.zufar.dto.DateDTO;
import com.zufar.service.AuthorService;
import com.zufar.service.BookService;
import com.zufar.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @GetMapping("/addAuthorView")
    public String getAddAuthorView(ModelMap modelMap) {
        List<Book> books = bookService.getAll();
        modelMap.addAttribute("books", books);
        List<Country> countries = countryService.getAll();
        modelMap.addAttribute("countries", countries);
        return "addAuthorView";
    }

    @GetMapping("/updateAuthorView/{id}")
    public String getUpdateAuthorView(@PathVariable(value = "id") long id, ModelMap modelMap) {
        Author author = authorService.get(id);
        modelMap.addAttribute("author", author);
        Integer birthYear = Integer.valueOf(Integer.toString(author.getBirthday().getYear()).replace(",", ""));
        modelMap.addAttribute("birthYear", birthYear);
        Integer deathYear = Integer.valueOf(Integer.toString(author.getDeathday().getYear()).replace(",", ""));
        modelMap.addAttribute("deathYear", deathYear);
        List<Book> books = author.getBooks();
        modelMap.addAttribute("authorBooks", books);
        modelMap.addAttribute("books", bookService.getAll());
        List<Country> countries = countryService.getAll();
        modelMap.addAttribute("countries", countries);
        return "updateAuthorView";
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

    @PostMapping("/addAuthor")
    public String addAuthor(
            @RequestParam("first_name") String first_name,
            @RequestParam("last_name") String last_name,
            @RequestParam("patronymic") String patronymic,
            @RequestParam("nickname") String nick_name,
            @RequestParam("country") Long country,
            @RequestParam("books") Long book,
            @RequestParam("birthDay") int birthDay,
            @RequestParam("birthMonth") int birthMonth,
            @RequestParam("birthYear") int birthYear,
            @RequestParam("deathDay") int deathDay,
            @RequestParam("deathMonth") int deathMonth,
            @RequestParam("deathYear") int deathYear,
            ModelMap modelMap
    ) {
        String errorMessage = null;
        if (first_name == null || first_name.isEmpty() || last_name == null || last_name.isEmpty() ||
                patronymic == null || patronymic.isEmpty() || nick_name == null || nick_name.isEmpty() ||
                country == -1 || book == -1 || birthDay == -1 || birthMonth == -1 || deathDay == -1 || deathMonth == -1) {
            errorMessage = "Error! Some of fields are empty. Please fill all fields.";
            modelMap.addAttribute("error", errorMessage);
            return "addAuthorView";
        }
        DateDTO birth = new DateDTO(birthYear, birthMonth, birthDay);
        DateDTO death = new DateDTO(deathYear, deathMonth, deathDay);
        List<Long> booksIds = new ArrayList<>();
        booksIds.add(book);
        AuthorDTO author = new AuthorDTO(first_name, last_name, patronymic, nick_name, "",
                birth, death, country, booksIds);
        authorService.save(author);
        List<Author> authors = authorService.getAll();
        modelMap.addAttribute("authors", authors);
        return "authorListView";
    }

    @PostMapping("/updateAuthor/{id}")
    public String updateAuthor(
            @PathVariable(value = "id") long id, ModelMap modelMap,
            @RequestParam("first_name") String first_name,
            @RequestParam("last_name") String last_name,
            @RequestParam("patronymic") String patronymic,
            @RequestParam("nickname") String nick_name,
            @RequestParam("country") Long countryId,
            @RequestParam("books") List<Long> booksIds,
            @RequestParam("birthDay") int birthDay,
            @RequestParam("birthMonth") int birthMonth,
            @RequestParam("birthYear") String birthYear,
            @RequestParam("deathDay") int deathDay,
            @RequestParam("deathMonth") int deathMonth,
            @RequestParam("deathYear") String deathYear
    ) {
        String errorMessage = null;
        if (first_name == null || first_name.isEmpty() || last_name == null || last_name.isEmpty() ||
                patronymic == null || patronymic.isEmpty() || nick_name == null || nick_name.isEmpty() ||
                countryId == -1 || booksIds == null || booksIds.isEmpty() ||
                birthDay == -1 || birthMonth == -1 ||
                deathDay == -1 || deathMonth == -1 ) {
            errorMessage = "Error! Some of fields are empty. Please fill all fields.";
            modelMap.addAttribute("error", errorMessage);
            return "updateAuthorView";
        }
        Author author = authorService.get(id);
        Integer byear = Integer.valueOf(Integer.toString(author.getBirthday().getYear()).replace(",", ""));
        author.setBirthday(LocalDate.of(byear, birthMonth, birthDay));
        Integer dyear = Integer.valueOf(Integer.toString(author.getDeathday().getYear()).replace(",", ""));
        author.setDeathday(LocalDate.of(dyear, deathMonth, deathDay));
        author.setBooks(bookService.getAll(booksIds));
        author.setCountry(countryService.get(countryId));
        author.setFirst_name(first_name);
        author.setLast_name(last_name);
        author.setPatronymic(patronymic);
        author.setNick_name(nick_name);
        authorService.update(author);
        List<Author> authors = authorService.getAll();
        modelMap.addAttribute("authors", authors);
        return "authorListView";
    }

    @GetMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable(value = "id") long id, ModelMap modelMap) {
        Author author = authorService.get(id);
        authorService.delete(author);
        List<Author> authors = authorService.getAll();
        modelMap.addAttribute("authors", authors);
        return "authorListView";
    }
}