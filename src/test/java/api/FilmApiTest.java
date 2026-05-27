package api;

import api.service.FilmService;
import api.util.FilmValidator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FilmApiTest {

    private final FilmService filmService = new FilmService();

    @Test
    public void shouldReturnFilmsByYear() {

        var yearForTest = "1977";
        var films = filmService.getFilmByYear(yearForTest);

        assertThat(films)
                .isNotEmpty()
                .allMatch(f -> f.releaseDate().contains(yearForTest));
    }

    @Test
    public void shouldReturnFilmByTitle() {

        var titleForTest = "A New Hope";
        var film = filmService.getFilmByTitle(titleForTest);

        assertThat(film.title()).isEqualTo(titleForTest);
        FilmValidator.validateTitle(film, titleForTest);
    }
}
