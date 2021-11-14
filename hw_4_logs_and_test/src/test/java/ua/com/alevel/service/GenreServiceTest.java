package ua.com.alevel.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.entity.Genre;

public class GenreServiceTest {

    private GenreService genreService = new GenreService();
    private static final String NAME = "name";
    private static final String NAME_UPD = "NAME_UPD";
    private static final String RND_NAME="RND";
    private static final int SIZE = 10;

    @Test
    @Order(1)
    public void shouldBeCreateGenre() {
        Genre[] genres = new Genre[SIZE];
        for (int i = 0; i < genres.length; i++) {
            Genre genre = new Genre();
            genre.setGenreName(NAME + i);
            genre.setAmount(i);
            genres[i] = genre;
        }
        Assertions.assertEquals(genres.length, SIZE);
    }

    @Test
    @Order(2)
    public void shouldBeUpdateGenre() {
        Genre genre = new Genre();
        genre.setGenreName(NAME);
        genre.setAmount(1);
        genreService.create(genre);
        genreService.update(genre);
        genre.setGenreId(genre.getGenreId());
        genre.setGenreName(NAME_UPD);
        genre.setAmount(2);
        Assertions.assertEquals(genre.getGenreName(), NAME_UPD);
        Assertions.assertEquals(genre.getAmount(), 2);
    }

    @Test
    @Order(3)
    public void shouldBeDeleteGenre() {
        Genre genre = generateRandomGenre();
        GenreService.create(genre);
        String genreId = genre.getGenreId();
        GenreService.delete(genreId);
        Genre[] genres = GenreService.findAll();
        Assertions.assertEquals(genres.length, 0);
    }

    private static Genre generateRandomGenre() {
        Genre genre = new Genre();
        genre.setGenreName(NAME);
        genre.setAmount(1);
        return genre;
    }

}


