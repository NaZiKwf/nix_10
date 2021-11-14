package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.FilmDao;
import ua.com.alevel.entity.Film;

public class FilmService {

    private static Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private static final FilmDao filmDao = new FilmDao();

    public static void create(Film film) {
        LOGGER_INFO.info("Start create Film");
        if (!filmDao.existByFilmName(film.getName())) {
            filmDao.create(film);
        } else {
            System.out.println("This film already existed");
            LOGGER_WARN.warn("This film already existed");
        }
    }

    public static void update(Film film) {
        LOGGER_INFO.info("Start update film");
        filmDao.update(film);
        LOGGER_INFO.info("Finish update film");
    }

    public static void delete(String filmId) {
        LOGGER_INFO.info("Start delete film");
        filmDao.delete(filmId);
        LOGGER_INFO.info("Finish delete film");
    }

    public static Film findByFilmId(String filmId) {
        LOGGER_INFO.info("Start search film by id");
        return filmDao.findByFilmId(filmId);
    }

    public static Film[] findAllFilms() {
        LOGGER_INFO.info("Start search all films");
        return filmDao.findAll();

    }
}
