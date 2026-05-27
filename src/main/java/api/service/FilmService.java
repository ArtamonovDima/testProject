package api.service;

import api.client.FilmApiClient;
import api.model.Film;

import java.util.List;

public class FilmService {

    private final FilmApiClient filmApiClient = new FilmApiClient();

    public Film getFilmByTitle(String title) {
        return filmApiClient.getFilmsAsObjects(filmApiClient.getAllFilms())
                .stream()
                .filter(f -> f.title().equalsIgnoreCase(title))
                .findFirst()
                .orElseThrow();
    }

    public List<Film> getFilmByYear(String year) {
        return filmApiClient.getFilmsAsObjects(filmApiClient.getAllFilms())
                .stream()
                .filter(f -> f.releaseDate().contains(year))
                .toList();
    }
}
