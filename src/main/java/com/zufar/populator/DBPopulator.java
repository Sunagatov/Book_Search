package com.zufar.populator;

import com.zufar.domain.Book;
import com.zufar.domain.Country;
import com.zufar.domain.Genre;
import com.zufar.dto.AuthorDTO;
import com.zufar.dto.BookDTO;
import com.zufar.dto.DateDTO;
import com.zufar.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
@DependsOn({"dataSource", "sessionFactory", "transactionManager"})
public class DBPopulator {

    private final UserService userService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;
    private final GenreService genreService;
    private final ReviewService reviewService;

    @Autowired
    public DBPopulator(
            UserService userService,
            AuthorService authorService,
            BookService bookService,
            CountryService countryService,
            GenreService genreService,
            ReviewService reviewService
    ) {
        this.userService = userService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
        this.genreService = genreService;
        this.reviewService = reviewService;
    }

    @PostConstruct
    public void populateData() {

        Country russia = new Country("Russian Federation");
        Country britishIndia = new Country("British India");
        Country usa = new Country("USA");
        Country uk = new Country("United Kingdom");
        Country brazil = new Country("Brazil");
        Country japan = new Country("Japan");
        Country canada = new Country("Canada");
        Country germany = new Country("Germany");
        Country france = new Country("France");

        countryService.save(russia);
        countryService.save(britishIndia);
        countryService.save(usa);
        countryService.save(uk);
        countryService.save(brazil);
        countryService.save(japan);
        countryService.save(canada);
        countryService.save(germany);
        countryService.save(france);

        Genre genre_dystopian = new Genre("Dystopian");
        Genre genre_politicalSatire = new Genre("Political satire");
        Genre genre_fiction = new Genre("Fiction");
        Genre genre_comedy = new Genre("Comedy");
        Genre genre_horror = new Genre("Horror");
        Genre genre_thriller = new Genre("Thriller");
        Genre genre_action = new Genre("Action");
        Genre genre_drama = new Genre("Drama");
        Genre genre_biography = new Genre("Biography");

        genreService.save(genre_dystopian);
        genreService.save(genre_politicalSatire);
        genreService.save(genre_fiction);
        genreService.save(genre_comedy);
        genreService.save(genre_horror);
        genreService.save(genre_thriller);
        genreService.save(genre_action);
        genreService.save(genre_drama);
        genreService.save(genre_biography);

//        User zufar = new User();
//        zufar.setFirst_name("Zufar");
//        zufar.setLast_name("Sunagatov");
//        zufar.setPatronymic("Rustamovich");
//        zufar.setNick_name("Alice");
//        zufar.setLogin("zuf999@mail.ru");
//        zufar.setPassword("4815162342");
//        zufar.setSex(Sex.MALE);
//        zufar.setBirthday(LocalDate.of(1995, 12, 20));
//        zufar.setCountryId(russia);
//
//        User david = new User();
//        david.setFirst_name("David");
//        david.setLast_name("Kalachyan");
//        david.setPatronymic("Saribegovich");
//        david.setNick_name("DavidPotroshitel");
//        david.setLogin("kalachand@gmail.com");
//        david.setPassword("432652");
//        david.setSex(Sex.MALE);
//        david.setBirthday(LocalDate.of(1996, 3, 19));
//        david.setCountryId(russia);
//
//        User ayrat = new User();
//        ayrat.setFirst_name("Ayrat");
//        ayrat.setLast_name("Gimaev");
//        ayrat.setPatronymic("Rafailevich");
//        ayrat.setNick_name("AyroBratan");
//        ayrat.setLogin("gimaev_1996@mail.ru");
//        ayrat.setPassword("52624323");
//        ayrat.setSex(Sex.MALE);
//        ayrat.setBirthday(LocalDate.of(1996, 2, 26));
//        ayrat.setCountryId(russia);
//
//        userService.persist(zufar);
//        userService.persist(david);
//        userService.persist(ayrat);


        AuthorDTO orwell = new AuthorDTO();
        orwell.setFirst_name("Eric");
        orwell.setLast_name("Blair");
        orwell.setPatronymic("Arthur");
        orwell.setNick_name("George Orwell");
        orwell.setBirthday(new DateDTO(1903, 6, 25));
        orwell.setDeathday(new DateDTO(1950, 1, 21));
        orwell.setCountryId(britishIndia.getId());

        AuthorDTO coelho = new AuthorDTO();
        coelho.setFirst_name("Richard");
        coelho.setLast_name("Blair");
        coelho.setPatronymic("Burton");
        coelho.setNick_name("Paulo Coelho");
        coelho.setBirthday(new DateDTO(1926, 2, 20));
        coelho.setDeathday(new DateDTO(2013, 6, 23));
        coelho.setCountryId(brazil.getId());

        AuthorDTO bradbury = new AuthorDTO();
        bradbury.setFirst_name("Ray");
        bradbury.setLast_name("Bradbury");
        bradbury.setPatronymic("Douglas");
        bradbury.setNick_name("Ray Bradbury");
        bradbury.setBirthday(new DateDTO(1920, 8, 22));
        bradbury.setDeathday(new DateDTO(2012, 5, 23));
        bradbury.setCountryId(usa.getId());

        AuthorDTO asimov = new AuthorDTO();
        asimov.setFirst_name("Isaac");
        asimov.setLast_name("Asimov");
        asimov.setNick_name("Isaac Asimov");
        asimov.setPatronymic("123");
        asimov.setBirthday(new DateDTO(1920, 1, 2));
        asimov.setDeathday(new DateDTO(1992, 4, 6));
        asimov.setCountryId(usa.getId());

        Long orwelId = authorService.save(orwell);
        Long coelhoId = authorService.save(coelho);
        Long bradburyId = authorService.save(bradbury);
        Long asimovId = authorService.save(asimov);

        Set<Long> authorsIds = new HashSet<>();
        authorsIds.add(orwelId);
        authorsIds.add(coelhoId);
        authorsIds.add(bradburyId);

        Set<Long> genresIds = new HashSet<>();
        genresIds.add(genre_politicalSatire.getId());
        genresIds.add(genre_comedy.getId());
        genresIds.add(genre_dystopian.getId());

        BookDTO book_1984 = new BookDTO();
        book_1984.setTitle("Nineteen Eighty-Four");
        book_1984.setAuthorsIds(authorsIds);
        book_1984.setCountryId(uk.getId());
        book_1984.setGenresIds(genresIds);
        book_1984.setPage_count(456);
        book_1984.setPublication_date(new DateDTO(1934, 6, 8));

        BookDTO book_animalFarm = new BookDTO();
        book_animalFarm.setTitle("Animal farm");
        book_animalFarm.setAuthorsIds(authorsIds);
        book_animalFarm.setCountryId(uk.getId());
        book_animalFarm.setGenresIds(genresIds);
        book_animalFarm.setPage_count(345);
        book_animalFarm.setPublication_date(new DateDTO(1931, 11, 23));

        BookDTO book_clergymanDaughter = new BookDTO();
        book_clergymanDaughter.setTitle("A Clergyman's Daughter");
        book_clergymanDaughter.setAuthorsIds(authorsIds);
        book_clergymanDaughter.setCountryId(uk.getId());
        book_clergymanDaughter.setGenresIds(genresIds);
        book_clergymanDaughter.setPage_count(935);
        book_clergymanDaughter.setPublication_date(new DateDTO(1988, 12, 28));

        authorsIds = new HashSet<>();
        authorsIds.add(coelho.getId());

        BookDTO book_veronica = new BookDTO();
        book_veronica.setTitle("Veronika Decides to Die");
        book_veronica.setAuthorsIds(authorsIds);
        book_veronica.setCountryId(brazil.getId());
        book_veronica.setGenresIds(genresIds);
        book_veronica.setPage_count(353);
        book_veronica.setPublication_date(new DateDTO(1967, 4, 5));

        BookDTO book_alquimista = new BookDTO();
        book_alquimista.setTitle("The Alchemist");
        book_alquimista.setAuthorsIds(authorsIds);
        book_alquimista.setCountryId(brazil.getId());
        book_alquimista.setGenresIds(genresIds);
        book_alquimista.setPage_count(234);
        book_alquimista.setPublication_date(new DateDTO(1923, 7, 18));

        authorsIds = new HashSet<>();
        authorsIds.add(bradbury.getId());

        BookDTO book_451 = new BookDTO();
        book_451.setTitle("Fahrenheit 451");
        book_451.setAuthorsIds(authorsIds);
        book_451.setCountryId(usa.getId());
        book_451.setGenresIds(genresIds);
        book_451.setPage_count(456);
        book_451.setPublication_date(new DateDTO(1944, 8, 1));

        bookService.save(book_1984);
        bookService.save(book_clergymanDaughter);
        bookService.save(book_animalFarm);
        bookService.save(book_alquimista);
        bookService.save(book_veronica);

//        Review review1 = new Review();
//        review1.setBook(book_1984);
//        review1.setPublication_date(LocalDate.of(1944, 8, 1));
//        review1.setUser(zufar);
//        review1.setText("A text about a book.");
//
//        Review review2 = new Review();
//        review2.setBook(book_451);
//        review2.setPublication_date(LocalDate.of(1944, 8, 1));
//        review2.setUser(zufar);
//        review2.setText("A text about a book.");
//
//        Review review3 = new Review();
//        review3.setBook(book_alquimista);
//        review3.setPublication_date(LocalDate.of(1944, 8, 1));
//        review3.setUser(zufar);
//        review3.setText("A text about a book.");
//
//        Review review4 = new Review();
//        review4.setBook(book_animalFarm);
//        review4.setPublication_date(LocalDate.of(1944, 8, 1));
//        review4.setUser(zufar);
//        review4.setText("A text about a book.");
//
//        Review review5 = new Review();
//        review5.setBook(book_clergymanDaughter);
//        review5.setPublication_date(LocalDate.of(1944, 8, 1));
//        review5.setUser(david);
//        review5.setText("A text about a book.");
//
//        Review review6 = new Review();
//        review6.setBook(book_veronica);
//        review6.setPublication_date(LocalDate.of(1944, 8, 1));
//        review6.setUser(ayrat);
//        review6.setText("A text about a book.");

//        reviewService.persist(review1);
//        reviewService.persist(review2);
//        reviewService.persist(review3);
//        reviewService.persist(review4);
//        reviewService.persist(review5);
//        reviewService.persist(review6);

        System.out.println("SUCCESSFUL CREATION");
    }
}