package ua.com.alevel.db;

import ua.com.alevel.entity.Film;

import java.util.Arrays;
import java.util.UUID;

public class DBFilm {
    private Film[] films;
    private static DBFilm instance;

    private DBFilm() {
        films = new Film[0];
    }

    public static DBFilm getInstance() {
        if (instance == null) {
            instance = new DBFilm();
        }
        return instance;
    }

    public void create(Film film) {
        film.setFilmId(genFilmId());
        films = Arrays.copyOf(films, films.length + 1);
        films[films.length - 1] = film;
    }

    private String genFilmId() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < films.length; i++)
            if (id.equals(String.valueOf(films[i].getFilmId()))) {
                return genFilmId();
            }
        return id;
    }

    public void update(Film film) {
        Film current = findByFilmId(film.getFilmId());
        current.setName(film.getName());
        current.setDuration(film.getDuration());
    }

    public Film findByFilmId(String filmId) {
        for (int i = 0; i < films.length; i++) {
            if (filmId.equals(String.valueOf(films[i].getFilmId()))) return films[i];
            else throw new RuntimeException("Film not found");
        }
        return films[films.length];
    }

    public Film[] findAllFilms() {
        return films;
    }

    public void delete(String id) {
        Film userToDelete = findByFilmId(id);
        int temp = -1;
        for (int i = 0; i < films.length; i++) {
            if (films[i].getFilmId().equals(String.valueOf(userToDelete.getFilmId()))) {
                films[i] = null;
                temp = i;
            }
        }
        Film tempArray[] = new Film[films.length - 1];
        for (int i = 0; i < temp; i++) {
            tempArray[i] = films[i];
        }
        for (int i = temp; i < tempArray.length; i++) {
            tempArray[i] = films[i + 1];
        }
        films = Arrays.copyOf(tempArray, films.length - 1);
    }

    public boolean filmExistByName(String Name) {
        for (int i = 0; i < films.length; i++) {
            if (Name.equals(String.valueOf(films[i].getName()))) {
                return true;
            }
        }
        return false;
    }

}
