package ua.com.alevel.controller;

import ua.com.alevel.entity.Film;
import ua.com.alevel.service.FilmService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FilmController {
    public static void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select your option:");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    return;
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("Problem: = " + e.getMessage());
        }
    }

    private static void runNavigation() {
        System.out.println("Create Film, please enter 1");
        System.out.println("Update Film, please enter 2");
        System.out.println("Delete Film, please enter 3");
        System.out.println("findByFilmId, please enter 4");
        System.out.println("findAllFilms, please enter 5");
        System.out.println("Exit, please enter 0");
    }

    private static void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                create(reader);
                break;
            case "2":
                update(reader);
                break;
            case "3":
                delete(reader);
                break;
            case "4":
                findByFilmId(reader);
                break;
            case "5":
                findAll();
                break;
        }
        runNavigation();
    }

    private static void create(BufferedReader reader) {
        try {
            System.out.println("Enter Film name");
            String name = reader.readLine();
            System.out.println("Enter Film duration");
            String durationString = reader.readLine();
            int duration = Integer.parseInt(durationString);
            Film film = new Film();
            film.setDuration(duration);
            film.setName(name);
            FilmService.create(film);
        } catch (IOException e) {
            System.out.println("Problem: = " + e.getMessage());
        }
    }

    private static void update(BufferedReader reader) {
        try {
            System.out.println("Enter Film id");
            String filmId = reader.readLine();
            System.out.println("Enter Film name");
            String name = reader.readLine();
            System.out.println("Enter Film duration");
            String durationString = reader.readLine();
            int duration = Integer.parseInt(durationString);
            Film film = new Film();
            film.setFilmId(filmId);
            film.setDuration(duration);
            film.setName(name);
            FilmService.update(film);
        } catch (IOException e) {
            System.out.println("Problem: = " + e.getMessage());
        }
    }

    private static void delete(BufferedReader reader) {
        try {
            System.out.println("Enter Film id");
            String filmId = reader.readLine();
            FilmService.delete(filmId);
        } catch (IOException e) {
            System.out.println("Problem: = " + e.getMessage());
        }
    }

    private static void findByFilmId(BufferedReader reader) {
        try {
            System.out.println("Enter Film id");
            String filmId = reader.readLine();
            Film film = FilmService.findByFilmId(filmId);
            System.out.println("Film = " + film);
        } catch (IOException e) {
            System.out.println("Problem: = " + e.getMessage());
        }
    }

    private static void findAll() {
        Film[] films = FilmService.findAllFilms();
        if (films != null && films.length != 0) {
            for (Film film : films) {
                System.out.println(film.toString());
            }
        } else {
            System.out.println("Films are empty");
        }
    }
}
