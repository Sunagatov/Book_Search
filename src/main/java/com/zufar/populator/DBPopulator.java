package com.zufar.populator;

import com.zufar.domain.*;
import com.zufar.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

@Component
@DependsOn({"dataSource", "sessionFactory", "transactionManager"})
public class DBPopulator {

    private final UserService userService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;
    private final GenreService genreService;

    @Autowired
    public DBPopulator(
            UserService userService,
            AuthorService authorService,
            BookService bookService,
            CountryService countryService,
            GenreService genreService
    ) {
        this.userService = userService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
        this.genreService = genreService;
    }

    @PostConstruct
    public void populateData() {

        Country russia = new Country("Russian Federation");
        Country britishIndia = new Country("British India");
        Country usa = new Country("USA");
        Country uk = new Country("United Kingdom");
        Country brazil = new Country("Brazil");

        Genre genre_dystopian = new Genre("Dystopian");
        Genre genre_politicalSatire = new Genre("Political satire");
        Genre genre_fiction = new Genre("Fiction");

        User zufar = new User();
        zufar.setFirst_name("Zufar");
        zufar.setLast_name("Sunagatov");
        zufar.setPatronymic("Rustamovich");
        zufar.setNick_name("Alice");
        zufar.setLogin("zuf999@mail.ru");
        zufar.setPassword("4815162342");
        zufar.setSex(Sex.MALE);
        zufar.setBirthday(LocalDate.of(1995, 12, 20));
        zufar.setCountry(russia);

        User david = new User();
        david.setFirst_name("David");
        david.setLast_name("Kalachyan");
        david.setPatronymic("Saribegovich");
        david.setNick_name("DavidPotroshitel");
        david.setLogin("kalachand@gmail.com");
        david.setPassword("432652");
        david.setSex(Sex.MALE);
        david.setBirthday(LocalDate.of(1996, 3, 19));
        david.setCountry(russia);

        User ayrat = new User();
        ayrat.setFirst_name("Ayrat");
        ayrat.setLast_name("Gimaev");
        ayrat.setPatronymic("Rafailevich");
        ayrat.setNick_name("AyroBratan");
        ayrat.setLogin("gimaev_1996@mail.ru");
        ayrat.setPassword("52624323");
        ayrat.setSex(Sex.MALE);
        ayrat.setBirthday(LocalDate.of(1996, 2, 26));
        ayrat.setCountry(russia);

        Author orwell = new Author();
        orwell.setFirst_name("Eric");
        orwell.setLast_name("Blair");
        orwell.setPatronymic("Arthur");
        orwell.setNick_name("George Orwell");
        orwell.setSex(Sex.MALE);
        orwell.setBirthday(LocalDate.of(1903, 6, 25));
        orwell.setDeathday(LocalDate.of(1950, 1, 21));
        orwell.setCountry(britishIndia);

        Author coelho = new Author();
        coelho.setFirst_name("Richard");
        coelho.setLast_name("Blair");
        coelho.setPatronymic("Burton");
        coelho.setNick_name("Paulo Coelho");
        coelho.setSex(Sex.MALE);
        coelho.setBirthday(LocalDate.of(1926, 2, 20));
        coelho.setDeathday(LocalDate.of(2013, 6, 23));
        coelho.setCountry(usa);

        Author bradbury = new Author();
        bradbury.setFirst_name("Ray");
        bradbury.setLast_name("Bradbury");
        bradbury.setPatronymic("Douglas");
        bradbury.setNick_name("Ray Bradbury");
        bradbury.setSex(Sex.MALE);
        bradbury.setBirthday(LocalDate.of(1920, 8, 22));
        bradbury.setDeathday(LocalDate.of(2012, 5, 23));
        bradbury.setCountry(usa);

        Author asimov = new Author();
        asimov.setFirst_name("Isaac");
        asimov.setLast_name("Asimov");
        asimov.setNick_name("Isaac Asimov");
        asimov.setSex(Sex.MALE);
        asimov.setPatronymic("123");
        asimov.setBirthday(LocalDate.of(1920, 1, 2));
        asimov.setDeathday(LocalDate.of(1992, 4, 6));
        asimov.setCountry(usa);

        ///////////////////////////////

        Set<Author> authors = new HashSet<>();
        authors.add(orwell);

        Set<Genre> genres = new HashSet<>();
        genres.add(genre_politicalSatire);

        Book book_1984 = new Book();
        book_1984.setTitle("Nineteen Eighty-Four");
        book_1984.setAuthors(authors);
        book_1984.setCountry(uk);
        book_1984.setGenres(genres);
        book_1984.setPage_count(456);
        book_1984.setPublication_date(LocalDate.of(1934, 6, 8));

        Book book_animalFarm = new Book();
        book_animalFarm.setTitle("Animal farm");
        book_animalFarm.setAuthors(authors);
        book_animalFarm.setCountry(uk);
        book_animalFarm.setGenres(genres);
        book_animalFarm.setPage_count(345);
        book_animalFarm.setPublication_date(LocalDate.of(1931, 11, 23));

        Book book_clergymanDaughter = new Book();
        book_clergymanDaughter.setTitle("A Clergyman's Daughter");
        book_clergymanDaughter.setAuthors(authors);
        book_clergymanDaughter.setCountry(uk);
        book_clergymanDaughter.setGenres(genres);
        book_clergymanDaughter.setPage_count(935);
        book_clergymanDaughter.setPublication_date(LocalDate.of(1988, 12, 28));

        authors = new HashSet<>();
        authors.add(coelho);

        Book book_veronica = new Book();
        book_veronica.setTitle("Veronika Decides to Die");
        book_veronica.setAuthors(authors);
        book_veronica.setCountry(brazil);
        book_veronica.setGenres(genres);
        book_veronica.setPage_count(353);
        book_veronica.setPublication_date(LocalDate.of(1967, 4, 5));

        Book book_alquimista = new Book();
        book_alquimista.setTitle("The Alchemist");
        book_alquimista.setAuthors(authors);
        book_alquimista.setCountry(brazil);
        book_alquimista.setGenres(genres);
        book_alquimista.setPage_count(234);
        book_alquimista.setPublication_date(LocalDate.of(1923, 7, 18));

        authors = new HashSet<>();
        authors.add(bradbury);


        Book book_451 = new Book();
        book_451.setTitle("Fahrenheit 451");
        book_451.setAuthors(authors);
        book_451.setCountry(usa);
        book_451.setGenres(genres);
        book_451.setPage_count(456);
        book_451.setPublication_date(LocalDate.of(1944, 8, 1));

        Review review1 = new Review();
        review1.setBook(book_1984);
        review1.setPublication_date(LocalDate.of(1944, 8, 1));
        review1.setUser(zufar);
        review1.setText("A text about a book.");

        Review review2 = new Review();
        review2.setBook(book_451);
        review2.setPublication_date(LocalDate.of(1944, 8, 1));
        review2.setUser(zufar);
        review2.setText("A text about a book.");

        Review review3 = new Review();
        review3.setBook(book_alquimista);
        review3.setPublication_date(LocalDate.of(1944, 8, 1));
        review3.setUser(zufar);
        review3.setText("A text about a book.");

        Review review4 = new Review();
        review4.setBook(book_animalFarm);
        review4.setPublication_date(LocalDate.of(1944, 8, 1));
        review4.setUser(zufar);
        review4.setText("A text about a book.");

        Review review5 = new Review();
        review5.setBook(book_clergymanDaughter);
        review5.setPublication_date(LocalDate.of(1944, 8, 1));
        review5.setUser(david);
        review5.setText("A text about a book.");

        Review review6 = new Review();
        review6.setBook(book_veronica);
        review6.setPublication_date(LocalDate.of(1944, 8, 1));
        review6.setUser(ayrat);
        review6.setText("A text about a book.");


        genreService.save(genre_dystopian);
        genreService.save(genre_politicalSatire);
        genreService.save(genre_fiction);

        userService.save(zufar);
        userService.save(david);
        userService.save(ayrat);

        authorService.save(orwell);
        authorService.save(coelho);
        authorService.save(bradbury);
        authorService.save(asimov);

//        List<Book> books = new ArrayList<>();
//        books.add(book_1984);
//        books.add(book_451);
//        books.add(book_alquimista);
//        books.add(book_animalFarm);
//        books.add(book_veronica);
//        books.add(book_clergymanDaughter);
//        bookService.saveList(books);

        System.out.println("SUCCESSFUL CREATION");
    }
}