package ua.com.alevel.db;

import ua.com.alevel.entity.Genre;

import java.util.Arrays;
import java.util.UUID;

public class DBGenre {

    private Genre[] genres;
    private static DBGenre instance;

    private DBGenre() {
        genres = new Genre[0];
    }

    public static DBGenre getInstance() {
        if (instance == null) {
            instance = new DBGenre();
        }
        return instance;
    }

    public void create(Genre genre) {
        genre.setGenreId(genGenreId());
        genres = Arrays.copyOf(genres, genres.length + 1);
        genres[genres.length - 1] = genre;
    }

    private String genGenreId() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < genres.length; i++)
            if (id.equals(String.valueOf(genres[i].getGenreId()))) {
                return genGenreId();
            }
        return id;
    }

    public void update(Genre genre) {
        Genre current = findByGenreId(genre.getGenreId());
        current.setGenreName(genre.getGenreName());
        current.setAmount(genre.getAmount());
    }

    public Genre findByGenreId(String genreId) {
        for (int i = 0; i < genres.length; i++) {
            if (genreId.equals(String.valueOf(genres[i].getGenreId()))) return genres[i];
            else throw new RuntimeException("Genre not found");
        }
        return genres[genres.length];
    }

    public Genre[] findAllGenres() {
        return genres;
    }

    public void delete(String genreId) {
        Genre delete = findByGenreId(genreId);
        int temp = -1;
        for (int i = 0; i < genres.length; i++) {
            if (genres[i].getGenreId().equals(String.valueOf(delete.getGenreId()))) {
                genres[i] = null;
                temp = i;
            }
        }
        Genre tempArray[] = new Genre[genres.length - 1];
        for (int i = 0; i < temp; i++) {
            tempArray[i] = genres[i];
        }
        for (int i = temp; i < tempArray.length; i++) {
            tempArray[i] = genres[i + 1];
        }
        genres = Arrays.copyOf(tempArray, genres.length - 1);
    }

    public boolean genreExistByName(String genreName) {
        for (int i = 0; i < genres.length; i++) {
            if (genreName.equals(String.valueOf(genres[i].getGenreId()))) {
                return true;
            }
        }
        return false;
    }

}
