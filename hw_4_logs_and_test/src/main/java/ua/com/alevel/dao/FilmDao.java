package ua.com.alevel.dao;

import ua.com.alevel.db.DBFilm;
import ua.com.alevel.entity.Film;


public class FilmDao {
    public void create(Film film) {
        DBFilm.getInstance().create(film);
    }

    public void update(Film film) {
        DBFilm.getInstance().update(film);
    }

    public void delete(String id) {
        DBFilm.getInstance().delete(id);
    }

    public Film findByFilmId(String filmId) {
        return DBFilm.getInstance().findByFilmId(filmId);
    }

    public Film[] findAll() {
        return DBFilm.getInstance().findAllFilms();
    }

    public boolean existByFilmName(String filmName) {
        return DBFilm.getInstance().filmExistByName(filmName);
    }

}
