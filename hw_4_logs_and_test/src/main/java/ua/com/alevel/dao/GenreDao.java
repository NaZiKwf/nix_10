package ua.com.alevel.dao;

import ua.com.alevel.db.DBGenre;
import ua.com.alevel.entity.Genre;

public class GenreDao {
    public void create(Genre genre) {
        DBGenre.getInstance().create(genre);
    }

    public void update(Genre genre) {
        DBGenre.getInstance().update(genre);
    }

    public void delete(String genreId) {
        DBGenre.getInstance().delete(genreId);
    }

    public Genre findByGenreId(String genreId) {
        return DBGenre.getInstance().findByGenreId(genreId);
    }

    public Genre[] findAll() {
        return DBGenre.getInstance().findAllGenres();
    }

    public boolean existByGenreName(String genreName) {
        return DBGenre.getInstance().genreExistByName(genreName);
    }
}
