package org.example.movie.mgmt.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetMovieResponseDTO {
    private Long id;

    private String title;

    private String genre;

    private Integer releaseYear;

    private String director;

    private Double ratings;
}
