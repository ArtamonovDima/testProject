package api.base;

import io.restassured.specification.RequestSpecification;

public class BaseApiClient {

    protected static final String BASE_URL = "https://swapi.dev/api";

    protected RequestSpecification requestSpec() {
        return RequestSpecFactory.defaultSpec(BASE_URL);
    }
}
