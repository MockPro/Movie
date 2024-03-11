package org.example.movie.mgmt.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ListMoviesResponseDTO {

    private List<MovieResponse> movies;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class MovieResponse {
        private Long id;

        private String title;

        private String genre;

        private Integer releaseYear;

        private String director;

        private Double ratings;
    }
}
