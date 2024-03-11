package org.example.movie.mgmt.service;

import org.example.movie.mgmt.dto.request.CreateMovieRequestDTO;
import org.example.movie.mgmt.dto.request.PatchMovieRequest;
import org.example.movie.mgmt.dto.response.CreateMovieResponseDTO;
import org.example.movie.mgmt.dto.response.GetMovieResponseDTO;
import org.example.movie.mgmt.dto.response.ListMoviesResponseDTO;
import org.example.movie.mgmt.dto.response.PatchMovieResponseDTO;
import org.example.movie.mgmt.model.Movie;

import java.util.List;

public interface MovieMgmtService {
    CreateMovieResponseDTO createMovie(CreateMovieRequestDTO request);

    PatchMovieResponseDTO updateMovie(PatchMovieRequest request);

    ListMoviesResponseDTO getAllMovies();

    GetMovieResponseDTO getMovieById(Long id);

    void deleteMovie(Long id);
}
