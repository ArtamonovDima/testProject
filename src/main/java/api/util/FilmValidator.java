package api.util;

import api.model.Film;

public class FilmValidator {

    public static void validateTitle(Film film, String title) {
        if (!film.title().equals(title)) {
            throw new AssertionError("Wrong title!");
        }
    }
}
