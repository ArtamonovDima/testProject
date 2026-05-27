package api.client;

import api.base.BaseApiClient;
import api.base.ResponseSpecFactory;
import api.model.Film;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class FilmApiClient extends BaseApiClient {

    public Response getAllFilms () {
        return given()
                .spec(requestSpec())
                .when()
                .get("/films")
                .then()
                .spec(ResponseSpecFactory.okResponse())
                .extract()
                .response();
    }

    public List<Film> getFilmsAsObjects (Response response) {
        return response.jsonPath().getList("results", Film.class);
    }
}
