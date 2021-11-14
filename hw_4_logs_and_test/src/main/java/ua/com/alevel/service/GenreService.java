package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.GenreDao;
import ua.com.alevel.entity.Genre;


public class GenreService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private static final GenreDao genreDao = new GenreDao();

    public static void create(Genre genre) {
        LOGGER_INFO.info("Start create Genre");
        if (!genreDao.existByGenreName(genre.getGenreName())) {
            genreDao.create(genre);
            LOGGER_INFO.info("Finish create Genre");
        } else {
            System.out.println("This genre already exists");
            LOGGER_WARN.warn("This genre already exists" + genre.getGenreName());
        }
    }

    public static void update(Genre genre) {
        LOGGER_INFO.info("Start update genre");
        genreDao.update(genre);
        LOGGER_INFO.info("Finish update genre");
    }

    public static void delete(String genreId) {
        LOGGER_INFO.info("Start delete genre");
        genreDao.delete(genreId);
        LOGGER_INFO.info("Finish delete genre");
    }

    public static Genre findByGenreId(String genreId) {
        LOGGER_INFO.info("Start search genre by id");
        return genreDao.findByGenreId(genreId);

    }


    public static Genre[] findAll() {
        LOGGER_INFO.info("Start search all genres");
        return genreDao.findAll();
    }
}
