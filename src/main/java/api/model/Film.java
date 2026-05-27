package api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Film(
        String title,
        String director,
        @JsonProperty("release_date")
        String releaseDate
) {}
