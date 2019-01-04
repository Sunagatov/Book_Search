package com.zufar.controller;

import com.zufar.domain.Author;
import com.zufar.domain.Book;
import com.zufar.domain.Country;
import com.zufar.domain.Genre;
import com.zufar.dto.BookDTO;
import com.zufar.dto.DateDTO;
import com.zufar.service.AuthorService;
import com.zufar.service.BookService;
import com.zufar.service.CountryService;
import com.zufar.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class BooksController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final CountryService countryService;

    @Autowired
    public BooksController(
            BookService bookService,
            AuthorService authorService,
            GenreService genreService,
            CountryService countryService
    ) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
        this.countryService = countryService;
    }

    @GetMapping("/updateBookView/{id}")
    public String getUpdateBookView(@PathVariable(value = "id") long id, ModelMap modelMap) {
        Book book = bookService.get(id);
        modelMap.addAttribute("book", book);
        modelMap.addAttribute("bookAuthors", book.getAuthors());
        modelMap.addAttribute("authors", authorService.getAll());
        modelMap.addAttribute("countries", countryService.getAll());
        Integer publicationYear = Integer.valueOf(Integer.toString(book.getPublication_date().getYear()).replace(",", ""));
        modelMap.addAttribute("publicationYear", publicationYear);
        return "updateBookView";
    }

    @GetMapping("/getAddBookView")
    public String getAddBookView(ModelMap modelMap) {
        List<Author> authors = authorService.getAll();
        modelMap.addAttribute("authors", authors);
        List<Country> countries = countryService.getAll();
        modelMap.addAttribute("countries", countries);
        List<Genre> genres = genreService.getAll();
        modelMap.addAttribute("genres", genres);
        return "addBookView";
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
        modelMap.addAttribute("authors",  book.getAuthors());
        return "bookProfileView";
    }

    @PostMapping("/addBook")
    public String addBook(
            @RequestParam("title") String title,
            @RequestParam("country") Long country,
            @RequestParam("genres") Long genre,
            @RequestParam("authors") Long author,
            @RequestParam("publicationDay") int publicationDay,
            @RequestParam("publicationMonth") int publicationMonth,
            @RequestParam("publicationYear") int publicationYear,
            @RequestParam("page_count") int page_count,
            ModelMap modelMap
    ) {
        String errorMessage = null;
        if (title == null || title.isEmpty() || country == -1 || genre == -1 || author == -1 ||
                publicationDay == -1 || publicationMonth == -1 || publicationYear == -1 || page_count == -1) {
            errorMessage = "Error! Some of fields are empty. Please fill all fields.";
            modelMap.addAttribute("error", errorMessage);
            return "addBookView";
        }
        DateDTO publicationDate = new DateDTO(publicationYear, publicationMonth, publicationDay);
        Set<Long> genresIds = new HashSet<>();
        genresIds.add(genre);
        List<Long> authorIds = new ArrayList<>();
        authorIds.add(author);
        BookDTO book = new BookDTO(title, authorIds, genresIds, publicationDate, country, page_count);
        bookService.save(book);
        List<Book> books = bookService.getAll();
        modelMap.addAttribute("books", books);
        return "bookListView";
    }

    @PostMapping("/updateBook/{id}")
    public String updateBook(
            @PathVariable(value = "id") long id, ModelMap modelMap,
            @RequestParam("title") String title,
            @RequestParam("country") Long countryId,
            @RequestParam("pageCount") int pageCount,
            @RequestParam("authors") List<Long> authorsIds,
            @RequestParam("publicationDay") int publicationDay,
            @RequestParam("publicationMonth") int publicationMonth,
            @RequestParam("publicationYear") String publicationYear
    ) {
        String errorMessage = null;
        if (title == null || title.isEmpty() ||
                countryId == -1 || authorsIds == null || authorsIds.isEmpty() ||
                publicationDay == -1 || publicationMonth == -1) {
            errorMessage = "Error! Some of fields are empty. Please fill all fields.";
            modelMap.addAttribute("error", errorMessage);
            return "updateAuthorView";
        }
        Book book = bookService.get(id);
        book.setTitle(title);
        List<Author> selectedAuthors = authorService.getAll(authorsIds);
        book.setAuthors(selectedAuthors);
        book.setCountry(countryService.get(countryId));
        book.setPage_count(pageCount);
        int year = Integer.valueOf(publicationYear.replace(",", ""));
        book.setPublication_date(LocalDate.of(year, publicationMonth, publicationDay));
        bookService.update(book);
        modelMap.addAttribute("books", bookService.getAll());
        return "bookListView";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") long id, ModelMap modelMap) {
        Book book = bookService.get(id);
        bookService.delete(book);
        List<Book> books = bookService.getAll();
        modelMap.addAttribute("books", books);
        return "bookListView";
    }
}