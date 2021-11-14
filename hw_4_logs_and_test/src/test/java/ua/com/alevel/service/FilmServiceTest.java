package ua.com.alevel.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.alevel.entity.Film;


public class FilmServiceTest {

    private static final String NAME = "name";
    private static final String NAME_UPD = "NAME_UPD";
    private static final String RND_NAME="RND";
    private static final int SIZE = 10;


    @Test
    @Order(1)
    public void shouldBeCreateGenre() {

        Film[] films = new Film[SIZE];
        for (int i = 0; i < films.length; i++) {
            Film film = new Film();
            film.setName(NAME + i);
            film.setDuration(i);
            films[i] = film;
        }
        Assertions.assertEquals(films.length, SIZE);
    }

    @Test
    @Order(2)
    public void shouldBeUpdateGenre() {
        Film film = new Film();
        film.setName(NAME);
        film.setDuration(1);
        FilmService.create(film);
        FilmService.update(film);
        film.setFilmId(film.getFilmId());
        film.setName(NAME_UPD);
        film.setDuration(2);
        Assertions.assertEquals(film.getName(), NAME_UPD);
        Assertions.assertEquals(film.getDuration(), 2);
    }

    @Test
    @Order(3)
    public void shouldBeDeleteFilm() {
        Film film = generateRandomFilm();
        FilmService.create(film);
        String filmId = film.getFilmId();
        FilmService.delete(filmId);
        Film[] films = FilmService.findAllFilms();
        Assertions.assertEquals(films.length, 0);
    }

    private static Film generateRandomFilm() {
        Film film = new Film();
        film.setName(NAME);
        film.setDuration(1);
        return film;
    }


}
