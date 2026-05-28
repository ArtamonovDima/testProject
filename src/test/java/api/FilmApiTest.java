package api;

import api.service.FilmService;
import api.util.FilmValidator;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
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

    @Test
    public void directTest() {

        var yearForTest = "1977";
        var response =
                given()
                        .spec(new RequestSpecBuilder().setBaseUri("https://swapi.dev/api")
                                .setRelaxedHTTPSValidation()
                                .addHeader("Content-Type", "application/json")
                                .build())
                        .when().get("/films")
                        .then()
                        .spec(new ResponseSpecBuilder().expectStatusCode(200)
                                .build())
                        .extract().response();

        //for 'var' we need to add String.class, in other way it will be the Object type
        var releaseDates = response.jsonPath().getList("results.release_date", String.class);

        assertThat(releaseDates)
                .isNotEmpty()
                .anyMatch(date -> date.contains(yearForTest));
    }
}
