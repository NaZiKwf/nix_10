package ua.com.alevel.controller;

import ua.com.alevel.entity.Genre;
import ua.com.alevel.service.GenreService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenreController {
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
        System.out.println("Create Genre, please enter 1");
        System.out.println("Update Genre, please enter 2");
        System.out.println("Delete Genre, please enter 3");
        System.out.println("findByGenreId, please enter 4");
        System.out.println("findAllGenres, please enter 5");
        System.out.println("Exit, please enter 0");
        System.out.println();
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
                findByGenreId(reader);
                break;
            case "5":
                findAllGenres();
                break;
        }
        runNavigation();
    }

    private static void create(BufferedReader reader) {
        try {
            System.out.println("Enter Genre name");
            String name = reader.readLine();
            System.out.println("Enter Genre amount");
            String amountString = reader.readLine();
            int amount = Integer.parseInt(amountString);
            Genre genre = new Genre();
            genre.setAmount(amount);
            genre.setGenreName(name);
            GenreService.create(genre);
        } catch (IOException e) {
            System.out.println("Problem: = " + e.getMessage());
        }
    }

    private static void update(BufferedReader reader) {
        try {
            System.out.println("Enter Genre id");
            String genreId = reader.readLine();
            System.out.println("Enter Genre name");
            String name = reader.readLine();
            System.out.println("Enter Genre amount");
            String amountString = reader.readLine();
            int amount = Integer.parseInt(amountString);
            Genre genre = new Genre();
            genre.setGenreId(genreId);
            genre.setAmount(amount);
            genre.setGenreName(name);
            GenreService.update(genre);
        } catch (IOException e) {
            System.out.println("Problem: = " + e.getMessage());
        }
    }

    private static void delete(BufferedReader reader) {
        try {
            System.out.println("Enter Genre id");
            String genreId = reader.readLine();
            GenreService.delete(genreId);
        } catch (IOException e) {
            System.out.println("Problem: = " + e.getMessage());
        }
    }

    private static void findByGenreId(BufferedReader reader) {
        try {
            System.out.println("Enter Genre id");
            String genreId = reader.readLine();
            Genre genre = GenreService.findByGenreId(genreId);
            System.out.println("Genre = " + genre);
        } catch (IOException e) {
            System.out.println("Problem: = " + e.getMessage());
        }
    }

    private static void findAllGenres() {
        Genre[] genres = GenreService.findAll();
        if (genres != null && genres.length != 0) {
            for (Genre genre : genres) {
                System.out.println(genre.toString());
            }
        } else {
            System.out.println("Genres are empty");
        }
    }

}
